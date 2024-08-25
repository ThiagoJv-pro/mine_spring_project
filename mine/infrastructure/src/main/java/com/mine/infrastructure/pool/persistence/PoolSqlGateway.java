package com.mine.infrastructure.pool.persistence;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
            .map(PoolJpaEntity::toAggregate)
            .toList();
        
        return responseFind;        
    }

    @Override
    public Pool findById(PoolId aPoolId) {
        
        final Optional<PoolJpaEntity> result = this.poolRepository.findById(aPoolId.getValue());
        final Pool getPool = result.stream().map(PoolJpaEntity::toAggregate).findFirst().orElseThrow();

        return getPool;

    }


    
}
