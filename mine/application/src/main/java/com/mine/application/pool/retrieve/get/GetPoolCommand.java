package com.mine.application.pool.retrieve.get;

import com.mine.domain.pool.PoolId;

public record GetPoolCommand (
    PoolId id
) {
    public GetPoolCommand find(PoolId id) {
        return new GetPoolCommand(id);
    }
}
