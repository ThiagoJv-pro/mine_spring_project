package com.mine.infrastructure.pool.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mine.domain.pool.Pool;
import com.mine.domain.pool.PoolGateway;
import com.mine.domain.pool.PoolId;
import com.mine.infrastructure.pool.PoolJpaEntity;

@Service
public class PoolSqlGateway implements PoolGateway {

    private final PoolRepository poolRepository;
    
    public PoolSqlGateway(PoolRepository poolRepository) {
        this.poolRepository = poolRepository;
    }

    @Override
    public Pool create(Pool aCreateCommand) {
        PoolJpaEntity poolJpaEntity = new PoolJpaEntity(
            aCreateCommand.getId().getValue(),
            aCreateCommand.getChain(),
            aCreateCommand.getSymbol(),
            aCreateCommand.getTotalValueLocked(),
            aCreateCommand.getRewardTokens(),
            aCreateCommand.getUnderlyingTokens(),
            aCreateCommand.getVolumeUsd1d()
        );
        this.poolRepository.save(poolJpaEntity);
        return aCreateCommand;
    }

    @Override
    public void deleteById(PoolId aPoolId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Pool> findAll() {
        final List<PoolJpaEntity> result = this.poolRepository.findAll();
        final List<Pool> responseFind = result.stream()
            .map(fn -> Pool.with(
                PoolId.from(fn.getId()), 
                fn.getChain(), 
                fn.getSymbol(), 
                fn.getTotalValueLocked(),
                fn.getRewardTokens(), 
                fn.getUnderlyingTokens(),
                fn.getVolumeUsd1d()
            )
        ).toList();
        
        return responseFind;        
    }


    
}
