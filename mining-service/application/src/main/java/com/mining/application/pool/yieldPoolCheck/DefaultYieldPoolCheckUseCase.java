package com.mining.application.pool.yieldPoolCheck;

import java.util.List;

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
    public YieldCheckOutput execute() {
        List<Pool> pools = this.poolGateway.findAll();
        List<Pool> checkYield = pools.stream().map(Pool::checkVolatilityYieldPool).toList();

        return new YieldCheckOutput(checkYield, "message");
    }



    
}
