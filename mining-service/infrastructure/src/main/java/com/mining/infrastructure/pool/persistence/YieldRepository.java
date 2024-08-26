package com.mining.infrastructure.pool.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mining.infrastructure.pool.YieldJpaEntity;

@Repository
public interface YieldRepository extends JpaRepository<YieldJpaEntity, String>{
    
}
