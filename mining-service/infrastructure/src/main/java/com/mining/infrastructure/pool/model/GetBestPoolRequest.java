package com.mining.infrastructure.pool.model;

public record GetBestPoolRequest(
    String id,
    String[] underlyingTokens,
    Double volumeUsd1d
) {
    
}
