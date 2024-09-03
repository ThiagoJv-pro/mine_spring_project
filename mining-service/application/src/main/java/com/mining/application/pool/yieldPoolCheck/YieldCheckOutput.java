package com.mining.application.pool.yieldPoolCheck;

import com.mining.domain.pool.Pool;

public record YieldCheckOutput (
    Pool pool
) {
    public static YieldCheckOutput from(Pool pools) {
        return new YieldCheckOutput(pools);
    }
}
