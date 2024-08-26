package com.mining.application.pool.retrieve.get;

import com.mining.domain.pool.PoolId;

public record GetPoolCommand (
    PoolId id
) {
}
