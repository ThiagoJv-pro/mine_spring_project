package com.mining.infrastructure.pool;

import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolId;
import com.mining.domain.pool.Yield;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pools")
@Getter
@Setter
@NoArgsConstructor
public class PoolJpaEntity {
    
    @Id
    @Column(name="id", nullable = false)
    private String id;
    private String chain;
    private String symbol;
    private Long totalValueLocked;
    private String originalPoolId;
    @OneToOne
    @JoinColumn(name = "yield_id") // Nome da coluna que armazena o ID do yield
    private YieldJpaEntity yield;
    private String[] rewardTokens;
    private String[] underlyingTokens;
    private Double volumeUsd1d;

    public PoolJpaEntity(String poolId, String chain, String symbol, Long totalValueLocked,
            String originalPoolId,YieldJpaEntity yield,
            String[] rewardTokens, String[] underlyingTokens, Double volumeUsd1d) {
        this.id = poolId;
        this.chain = chain;
        this.symbol = symbol;
        this.totalValueLocked = totalValueLocked;
        this.originalPoolId = originalPoolId;
        this.yield = yield;
        this.rewardTokens = rewardTokens;
        this.underlyingTokens = underlyingTokens;
        this.volumeUsd1d = volumeUsd1d;
    }


    public Pool toAggregate() {
        return Pool.with(
            PoolId.from(getId()),
            getChain(),
            getSymbol(),
            getTotalValueLocked(),
            getOriginalPoolId(),
            null,
            getRewardTokens(),
            getUnderlyingTokens(),
            getVolumeUsd1d()
        );
    }

    
}
