package com.mine.infrastructure.pool;

import com.mine.domain.pool.Pool;
import com.mine.domain.pool.PoolId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String[] rewardTokens;
    private String[] underlyingTokens;
    private Double volumeUsd1d;

    public PoolJpaEntity(String poolId, String chain, String symbol, Long totalValueLocked,
            String[] rewardTokens, String[] underlyingTokens, Double volumeUsd1d) {
        this.id = poolId;
        this.chain = chain;
        this.symbol = symbol;
        this.totalValueLocked = totalValueLocked;
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
            getRewardTokens(),
            getUnderlyingTokens(),
            getVolumeUsd1d()
        );
    }

    
}
