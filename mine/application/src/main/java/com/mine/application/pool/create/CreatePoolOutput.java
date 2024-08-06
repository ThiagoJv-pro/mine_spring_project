package com.mine.application.pool.create;

import com.mine.domain.pool.Pool;

public record CreatePoolOutput(
    String pool
) {
    public static CreatePoolOutput from(final Pool aPool) {
        return new CreatePoolOutput(aPool.getId().getValue());
    }
}
