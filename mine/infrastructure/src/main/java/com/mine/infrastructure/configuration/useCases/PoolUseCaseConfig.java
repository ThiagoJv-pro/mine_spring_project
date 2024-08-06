package com.mine.infrastructure.configuration.useCases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mine.application.pool.create.CreatePoolUseCase;
import com.mine.application.pool.create.DefaultCreatePoolUseCase;
import com.mine.domain.pool.PoolGateway;

@Configuration
public class PoolUseCaseConfig {

    public final PoolGateway poolGateway;

    public PoolUseCaseConfig(PoolGateway poolGateway){
        this.poolGateway = poolGateway;
    }

    @Bean
    public CreatePoolUseCase createPoolUseCase(){
        return new DefaultCreatePoolUseCase(poolGateway);
    }
}
