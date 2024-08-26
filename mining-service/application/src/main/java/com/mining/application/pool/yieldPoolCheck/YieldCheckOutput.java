package com.mining.application.pool.yieldPoolCheck;

import java.util.List;

import com.mining.domain.pool.Pool;

public record YieldCheckOutput (
    List<Pool> pool,
    String message
) {
    public YieldCheckOutput from(List<Pool> pool) {
        return new YieldCheckOutput(pool, message);
    }
}
