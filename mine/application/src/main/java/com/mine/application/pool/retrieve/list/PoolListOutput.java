package com.mine.application.pool.retrieve.list;

import com.mine.domain.pool.Pool;

public record PoolListOutput(
    String id, 
    String[] underlyingTokens,
    Double volumeUsd1d
){

    public static PoolListOutput from(final Pool aPool) {
        return new PoolListOutput(
            aPool.getId().getValue(), 
            aPool.getUnderlyingTokens(), 
            aPool.getVolumeUsd1d()
        );
    }
}
