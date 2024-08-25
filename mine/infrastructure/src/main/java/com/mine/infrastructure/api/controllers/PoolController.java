package com.mine.infrastructure.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mine.application.pool.create.CreatePoolCommand;
import com.mine.application.pool.create.CreatePoolOutput;
import com.mine.application.pool.retrieve.get.GetPoolCommand;
import com.mine.application.pool.retrieve.list.ListPoolOutput;
import com.mine.domain.pool.PoolId;
import com.mine.infrastructure.api.PoolApi;
import com.mine.infrastructure.configuration.externalApis.difillamaApi.LlamaApiConfig;
import com.mine.infrastructure.configuration.externalApis.difillamaApi.model.LlamaApiModel;
import com.mine.infrastructure.configuration.useCases.PoolUseCaseConfig;
import com.mine.infrastructure.pool.model.GetListPoolModel;
import com.mine.infrastructure.pool.model.GetPoolModel;


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

            for(LlamaApiModel data : request) {
                final CreatePoolCommand createCommand =
                    CreatePoolCommand.createPool(
                        data.chain(), 
                        null, 
                        data.symbol(), 
                        data.totalValueLocked(), 
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

        for(ListPoolOutput output : poolListCase) {
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
        final GetPoolModel pool = new GetPoolModel(executeCommand.id().getValue(), executeCommand.underlyingTokens(),executeCommand.volumeUsd1d());
        return ResponseEntity.ok(pool);

    }

}
