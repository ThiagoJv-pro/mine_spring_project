package com.mine.domain.pool;

import com.mine.domain.AggregateRoot;
import com.mine.domain.protocol.ProtocolId;

public class Pool extends AggregateRoot<PoolId> {
    
    private final String chain;
    private final ProtocolId protocolId;
    private final String symbol;
    private final Long totalValueLocked;
    private Yield yield;
    private final String[] rewardTokens;
    private final String[] underlyingTokens;
    private final Double volumeUsd1d;

    public Double getVolumeUsd1d() {
        return volumeUsd1d;
    }

    protected Pool(
       final PoolId id, 
       final String chain, 
       final ProtocolId protocolId,
       final String symbol,
       final Long totalValueLocked,
       final Yield yield,
       final String[] rewardTokens,
       final String[] underlyingTokens,
       final Double volumeUsd1d
    ) {
        super(id);
        this.chain = chain;
        this.protocolId = protocolId;
        this.symbol = symbol;
        this.totalValueLocked = totalValueLocked;
        this.yield = yield;
        this.rewardTokens = rewardTokens;
        this.underlyingTokens = underlyingTokens;
        this.volumeUsd1d = volumeUsd1d;
    }

    public static Pool createPool(
        String aChain,
        ProtocolId aProtocolId,
        String aSymbol,
        Long aTotalValueLocked,
        String[] aRewardTokens,
        String[] aUnderlyingTokens,
        Double aVolumeUsd1d
    ){
        return new Pool(
            PoolId.unique(),
            aChain, 
            aProtocolId, 
            aSymbol, 
            aTotalValueLocked,
            null, 
            aRewardTokens,
            aUnderlyingTokens,
            aVolumeUsd1d
        );
    }

    public static Pool with(
            final PoolId anId,
            final String aChain,
            final String aSymbol,
            final Long aTotalValueLocked,
            final  String[] aRewardTokens,
            final String[] aUnderlyingTokens,
            final Double aVolumeUsd1d
    ) {
        return new Pool(
            anId,
            aChain,
            null, 
            aSymbol, 
            aTotalValueLocked,
            null, 
            aRewardTokens,
            aUnderlyingTokens,
            aVolumeUsd1d
        );
    }

    public String getChain() {
        return chain;
    }

    public ProtocolId getProtocolId() {
        return protocolId;
    }

    public String getSymbol() {
        return symbol;
    }

    public Long getTotalValueLocked() {
        return totalValueLocked;
    }

    public String[] getRewardTokens() {
        return rewardTokens;
    }
    
    public Yield getYield() {
        return yield;
    }

    public Pool setYield(final Yield yield){
        this.yield = yield;
        return this;
    }

    public String[] getUnderlyingTokens() {
        return underlyingTokens;
    }

}
