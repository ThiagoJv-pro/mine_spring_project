package com.mining.application.pool.retrieve.list;

import java.util.List;

import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolGateway;

public class DefaultListPoolUseCase extends ListPoolUseCase {

    private final PoolGateway poolGateway;

    public DefaultListPoolUseCase(PoolGateway poolGateway) {
        this.poolGateway = poolGateway;
    }


    @Override
    public List<ListPoolOutput> execute() {
        final List<Pool> findAllPools = this.poolGateway.findAll();
        final List<ListPoolOutput> poolList = findAllPools.stream()
            .map(fn -> new ListPoolOutput(fn.getId().getValue(), fn.getUnderlyingTokens(), fn.getVolumeUsd1d())
        ).toList();
        return poolList;
    }

    
}
