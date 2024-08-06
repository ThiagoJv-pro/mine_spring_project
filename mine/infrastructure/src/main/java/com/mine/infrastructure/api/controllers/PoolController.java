package com.mine.infrastructure.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mine.application.pool.create.CreatePoolCommand;
import com.mine.application.pool.create.CreatePoolOutput;
import com.mine.application.pool.create.CreatePoolUseCase;
import com.mine.application.pool.retrieve.list.PoolListOutput;
import com.mine.application.pool.retrieve.list.PoolListUseCase;
import com.mine.infrastructure.api.PoolApi;
import com.mine.infrastructure.configuration.externalApis.difillamaApi.LlamaApiConfig;
import com.mine.infrastructure.configuration.externalApis.difillamaApi.model.LlamaApiModel;
import com.mine.infrastructure.pool.PoolJpaEntity;
import com.mine.infrastructure.pool.model.GetListPoolModel;


@RestController
public class PoolController implements PoolApi {
    
    private final CreatePoolUseCase createPoolUseCase;
    private final PoolListUseCase poolListUseCase;
    private final LlamaApiConfig api;
    
    public PoolController(
        CreatePoolUseCase createPoolUseCase,
        LlamaApiConfig api,
        PoolListUseCase poolListUseCase
    ) {
        this.createPoolUseCase = createPoolUseCase;
        this.api = api;
        this.poolListUseCase = poolListUseCase;
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
                
                var executeCommand = this.createPoolUseCase.execute(createCommand);
                
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
        final List<PoolListOutput> poolListCase = this.poolListUseCase.execute();
        final List<GetListPoolModel> getPool = new ArrayList<>();

        for(PoolListOutput output : poolListCase) {
            final var findResponse = new GetListPoolModel(
                output.id(),
                output.underlyingTokens(),
                output.volumeUsd1d()
            );

            getPool.add(findResponse);
        }
      
        return getPool;
    }

    // @GetMapping("/teste")
    // public List<LlamaApiModel> api() {
    //     return request;
    // }
    
}
