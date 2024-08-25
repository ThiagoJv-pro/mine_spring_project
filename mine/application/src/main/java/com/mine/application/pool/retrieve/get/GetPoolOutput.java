package com.mine.application.pool.retrieve.get;

import com.mine.domain.pool.Pool;
import com.mine.domain.pool.PoolId;

public record GetPoolOutput(
    PoolId id,
    String[] underlyingTokens,
    Double volumeUsd1d

) {

    public static GetPoolOutput from(Pool pool) {
        return new GetPoolOutput(
            pool.getId(), 
            pool.getUnderlyingTokens(), 
            pool.getVolumeUsd1d()
        );
    }
    
}
