package com.mine.infrastructure.pool.model;

public record GetPoolModel (  
    String id,
    String[] underlyingTokens,
    Double volumeUsd1d
){}