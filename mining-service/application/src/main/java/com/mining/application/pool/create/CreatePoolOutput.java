package com.mining.application.pool.create;

import com.mining.domain.pool.Pool;

public record CreatePoolOutput(
    String id
) {
    public static CreatePoolOutput from(final Pool aPool) {
        return new CreatePoolOutput(aPool.getId().getValue());
    }
}
