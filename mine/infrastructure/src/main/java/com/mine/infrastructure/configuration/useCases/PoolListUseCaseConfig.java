package com.mine.infrastructure.configuration.useCases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mine.application.pool.retrieve.list.DefaultListPoolUseCase;
import com.mine.application.pool.retrieve.list.ListPoolUseCase;
import com.mine.domain.pool.PoolGateway;

@Configuration
public class PoolListUseCaseConfig {
    
    private final PoolGateway poolGateway;

    public PoolListUseCaseConfig(PoolGateway poolGateway) {
        this.poolGateway = poolGateway;
    }

    @Bean
    public ListPoolUseCase listPool() {
        return new DefaultListPoolUseCase(poolGateway);
    }




}
