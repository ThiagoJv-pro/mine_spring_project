package com.mining.infrastructure.pool.persistence;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolGateway;
import com.mining.domain.pool.PoolId;
import com.mining.domain.pool.Yield;
import com.mining.infrastructure.pool.PoolJpaEntity;
import com.mining.infrastructure.pool.YieldJpaEntity;

@Service
public class PoolSqlGateway implements PoolGateway {

    private final PoolRepository poolRepository;
    private final YieldRepository yieldRepository;
    public PoolSqlGateway(PoolRepository poolRepository, YieldRepository yieldRepository) {
        this.poolRepository = poolRepository;
        this.yieldRepository = yieldRepository;
    }

    @Override
    public Pool create(Pool aCreateCommand) {
        YieldJpaEntity yieldJpaEntity = YieldJpaEntity.toJpa(aCreateCommand.getYield());
        PoolJpaEntity poolJpaEntity = new PoolJpaEntity(
            aCreateCommand.getId().getValue(),
            aCreateCommand.getChain(),
            aCreateCommand.getSymbol(),
            aCreateCommand.getTotalValueLocked(),
            aCreateCommand.getOriginPoolId(),
            yieldJpaEntity,
            aCreateCommand.getRewardTokens(),
            aCreateCommand.getUnderlyingTokens(),
            aCreateCommand.getVolumeUsd1d()
        );
        this.poolRepository.save(poolJpaEntity);
        if(Objects.nonNull(yieldJpaEntity)) {
          this.yieldRepository.save(yieldJpaEntity);
        }
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
