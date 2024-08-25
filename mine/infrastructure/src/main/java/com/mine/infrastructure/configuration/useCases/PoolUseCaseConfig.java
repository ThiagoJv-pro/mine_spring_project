package com.mine.infrastructure.configuration.useCases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mine.application.pool.create.CreatePoolUseCase;
import com.mine.application.pool.create.DefaultCreatePoolUseCase;
import com.mine.application.pool.retrieve.get.DefaultGetPoolUseCase;
import com.mine.application.pool.retrieve.get.GetPoolUseCase;
import com.mine.application.pool.retrieve.list.DefaultListPoolUseCase;
import com.mine.application.pool.retrieve.list.ListPoolUseCase;
import com.mine.domain.pool.PoolGateway;

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

}



