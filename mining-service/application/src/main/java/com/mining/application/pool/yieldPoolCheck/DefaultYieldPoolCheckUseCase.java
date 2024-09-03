package com.mining.application.pool.yieldPoolCheck;

import java.util.List;
import java.util.Objects;

import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolGateway;

public class DefaultYieldPoolCheckUseCase extends YieldPoolCheckUseCase {

    private final PoolGateway poolGateway;

    public DefaultYieldPoolCheckUseCase (
        PoolGateway poolGateway
    ){
        this.poolGateway = poolGateway;
    }

    @Override
    public List<YieldCheckOutput> execute() {
        final List<Pool> getAllPools = this.poolGateway.findAll();
        final List<YieldCheckOutput> checkYield = getAllPools.stream()
            .map(Pool::checkVolatilityYieldPool)
            .filter(object -> Objects.nonNull(object))
            .map(fn -> YieldCheckOutput.from(fn))
            .toList();

        return checkYield;
    }
}
