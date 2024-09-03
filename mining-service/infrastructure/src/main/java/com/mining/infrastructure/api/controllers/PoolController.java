package com.mining.infrastructure.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mining.application.pool.create.CreatePoolCommand;
import com.mining.application.pool.create.CreatePoolOutput;
import com.mining.application.pool.retrieve.get.GetPoolCommand;
import com.mining.application.pool.retrieve.list.ListPoolOutput;
import com.mining.application.pool.yieldPoolCheck.YieldCheckOutput;
import com.mining.domain.pool.PoolId;
import com.mining.infrastructure.api.PoolApi;
import com.mining.infrastructure.configuration.externalApis.difillamaApi.LlamaApiConfig;
import com.mining.infrastructure.configuration.externalApis.difillamaApi.model.LlamaApiModel;
import com.mining.infrastructure.configuration.useCases.PoolUseCaseConfig;
import com.mining.infrastructure.pool.PoolJpaEntity;
import com.mining.infrastructure.pool.model.GetBestPoolRequest;
import com.mining.infrastructure.pool.model.GetListPoolModel;
import com.mining.infrastructure.pool.model.GetPoolModel;

@RestController
public class PoolController implements PoolApi {

    private final PoolUseCaseConfig poolUseCaseConfig;
    private final LlamaApiConfig api;

    public PoolController(
            PoolUseCaseConfig poolUseCaseConfig,
            LlamaApiConfig api
    ) {
        this.poolUseCaseConfig = poolUseCaseConfig;
        this.api = api;
    }

    @Override
    public ResponseEntity<?> createPool() {
        try {
            final List<LlamaApiModel> request = api.request();
            final List<CreatePoolOutput> idPoolProcessing = new ArrayList<>();

            for (LlamaApiModel data : request) {
                final CreatePoolCommand createCommand
                        = CreatePoolCommand.createPool(
                                data.chain(),
                                null,
                                data.symbol(),
                                data.totalValueLocked(),
                                data.originalPoolId(),
                                data.rewardTokens(),
                                data.underlyingTokens(),
                                1.2,
                                data.annualPercentageYieldBase(),
                                data.annualPercentageYieldRewards(),
                                data.annualPercentageYield(),
                                data.annualPercentageVariation1D(),
                                data.annualPercentageVariation7D(),
                                data.annualPercentageVariation30D()
                        );

                var executeCommand = this.poolUseCaseConfig.createPoolUseCase().execute(createCommand);

                idPoolProcessing.add(executeCommand);
            }

            return ResponseEntity.ok(idPoolProcessing);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GetListPoolModel> getPools() {
        final List<ListPoolOutput> poolListCase = this.poolUseCaseConfig.listPool().execute();
        final List<GetListPoolModel> getPool = new ArrayList<>();

        for (ListPoolOutput output : poolListCase) {
            final var findResponse = new GetListPoolModel(
                    output.id(),
                    output.underlyingTokens(),
                    output.volumeUsd1d()
            );

            getPool.add(findResponse);
        }

        return getPool;
    }

    @Override
    public ResponseEntity<GetPoolModel> getPool(String id) {

        final GetPoolCommand aCommand = new GetPoolCommand(PoolId.from(id));
        final var executeCommand = this.poolUseCaseConfig.getPoolUseCase().execute(aCommand);
        final GetPoolModel pool = new GetPoolModel(
            executeCommand.id().getValue(), 
            executeCommand.underlyingTokens(), 
            executeCommand.volumeUsd1d()
        );
        return ResponseEntity.ok(pool);

    }

    @Override
    public ResponseEntity<List<GetBestPoolRequest>> getBestPools() {
        final List<YieldCheckOutput> bestPools = this.poolUseCaseConfig.yieldPoolCheckUseCase().execute();
        final List<GetBestPoolRequest> request = bestPools.stream()
            .map(fn -> new GetBestPoolRequest(
                fn.pool().getId().getValue(),
                fn.pool().getChain(),
                fn.pool().getSymbol(),
                fn.pool().getTotalValueLocked(),
                fn.pool().getRewardTokens(),
                fn.pool().getUnderlyingTokens(),
                fn.pool().getVolumeUsd1d(),
                fn.pool().getYield()
            )
        ).toList();
        
        return ResponseEntity.ok(request);
    }

}
