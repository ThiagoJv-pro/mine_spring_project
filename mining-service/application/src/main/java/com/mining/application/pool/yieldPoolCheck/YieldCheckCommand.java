package com.mining.application.pool.yieldPoolCheck;

import java.util.List;

import com.mining.domain.pool.Pool;

public record YieldCheckCommand(
    List<Pool> pool
) {
}
