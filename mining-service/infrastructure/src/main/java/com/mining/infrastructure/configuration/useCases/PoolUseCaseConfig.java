package com.mining.infrastructure.configuration.useCases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mining.application.pool.create.CreatePoolUseCase;
import com.mining.application.pool.create.DefaultCreatePoolUseCase;
import com.mining.application.pool.retrieve.get.DefaultGetPoolUseCase;
import com.mining.application.pool.retrieve.get.GetPoolUseCase;
import com.mining.application.pool.retrieve.list.DefaultListPoolUseCase;
import com.mining.application.pool.retrieve.list.ListPoolUseCase;
import com.mining.application.pool.yieldPoolCheck.DefaultYieldPoolCheckUseCase;
import com.mining.application.pool.yieldPoolCheck.YieldPoolCheckUseCase;
import com.mining.domain.pool.PoolGateway;

@Configuration
public class PoolUseCaseConfig {
    
    private final PoolGateway poolGateway;

    public PoolUseCaseConfig(PoolGateway poolGateway) {
        this.poolGateway = poolGateway;
    }

    @Bean
    public ListPoolUseCase listPool() {
        return new DefaultListPoolUseCase(poolGateway);
    }

    @Bean
    public CreatePoolUseCase createPoolUseCase(){
        return new DefaultCreatePoolUseCase(poolGateway);
    }

    @Bean
    public GetPoolUseCase getPoolUseCase() {
        return new DefaultGetPoolUseCase(poolGateway);
    }

    @Bean
    public YieldPoolCheckUseCase yieldPoolCheckUseCase() {
        return new DefaultYieldPoolCheckUseCase(poolGateway);
    }

}



