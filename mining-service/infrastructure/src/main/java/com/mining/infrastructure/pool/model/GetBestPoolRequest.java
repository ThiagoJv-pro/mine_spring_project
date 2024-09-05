package com.mining.infrastructure.pool.model;

import com.mining.domain.pool.Yield;

public record GetBestPoolRequest(
    String pool_id, 
    String chain,
    String symbol,
    Long totalValueLocked,
    String[] rewardTokens,
    String[] underlyingTokens,
    Double volumeUsd1d,
    Yield yield
) {
}
