package com.mining.infrastructure.pool.model;

public record GetPoolModel (  
    String id,
    String[] underlyingTokens,
    Double volumeUsd1d
){}