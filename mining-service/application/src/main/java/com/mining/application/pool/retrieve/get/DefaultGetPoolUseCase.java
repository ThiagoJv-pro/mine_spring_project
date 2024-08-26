package com.mining.application.pool.retrieve.get;

import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolGateway;
import com.mining.domain.pool.PoolId;

public class DefaultGetPoolUseCase extends GetPoolUseCase {

    private final PoolGateway poolGateway;

    public DefaultGetPoolUseCase(
        PoolGateway poolGateway
    ) {
        this.poolGateway = poolGateway;
    }

    @Override
    public GetPoolOutput execute(final GetPoolCommand aCommand) {
        
        final PoolId id = aCommand.id();
        final Pool getPool = this.poolGateway.findById(id);
        return GetPoolOutput.from(getPool);
        
    }
    
}
