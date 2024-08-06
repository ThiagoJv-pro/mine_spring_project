package com.mine.infrastructure.pool.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mine.infrastructure.pool.PoolJpaEntity;


@Repository
public interface PoolRepository extends JpaRepository<PoolJpaEntity, String>{
    
}
