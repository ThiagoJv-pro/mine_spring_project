package com.mine.infrastructure.pool.model;


public record GetListPoolModel(
    String id,
    String[] underlyingTokens,
    Double volumeUsd1d
) {
    
}
