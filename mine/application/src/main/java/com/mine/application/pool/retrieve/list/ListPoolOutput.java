package com.mine.application.pool.retrieve.list;

import com.mine.domain.pool.Pool;

public record ListPoolOutput(
    String id, 
    String[] underlyingTokens,
    Double volumeUsd1d
){

    public static ListPoolOutput from(final Pool aPool) {
        return new ListPoolOutput(
            aPool.getId().getValue(), 
            aPool.getUnderlyingTokens(), 
            aPool.getVolumeUsd1d()
        );
    }
}
