package com.mine.application.pool.retrieve.get;

import com.mine.domain.pool.Pool;
import com.mine.domain.pool.PoolGateway;
import com.mine.domain.pool.PoolId;

public class DefaultGetPoolUseCase extends GetPoolUseCase {

    private final PoolGateway poolGateway;

    public DefaultGetPoolUseCase(
        PoolGateway poolGateway
    ) {
        this.poolGateway = poolGateway;
    }

    @Override
    public GetPoolOutput execute(GetPoolCommand aCommand) {
        
        final PoolId id = aCommand.id();
        final Pool getPool = this.poolGateway.findById(id);
        return GetPoolOutput.from(getPool);
        
    }
    
}
