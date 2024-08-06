package com.mine.application.pool.retrieve.list;

import java.util.List;

import com.mine.domain.pool.Pool;
import com.mine.domain.pool.PoolGateway;

public class DefaultListPool extends PoolListUseCase {

    private final PoolGateway poolGateway;

    public DefaultListPool(PoolGateway poolGateway) {
        this.poolGateway = poolGateway;
    }


    @Override
    public List<PoolListOutput> execute() {
        final List<Pool> findAllPools = this.poolGateway.findAll();
        List<PoolListOutput> poolList = findAllPools.stream()
            .map(fn -> new PoolListOutput(fn.getId().getValue(), fn.getUnderlyingTokens(), fn.getVolumeUsd1d())
        ).toList();
        return poolList;
    }

    
}
