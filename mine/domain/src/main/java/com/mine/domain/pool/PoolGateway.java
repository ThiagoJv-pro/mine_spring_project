package com.mine.domain.pool;

import java.util.List;


public interface PoolGateway {
    
    Pool create(Pool aCreateCommand);

    void deleteById(PoolId aPoolId);
    
    List<Pool> findAll();

}
