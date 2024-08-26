package com.mining.application.pool.create;

import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolGateway;

public class DefaultCreatePoolUseCase extends CreatePoolUseCase{

    final PoolGateway poolGateway;

    public DefaultCreatePoolUseCase(
        PoolGateway aPoolGateway
    ){
        this.poolGateway = aPoolGateway;
    }

    @Override
    public CreatePoolOutput execute(final CreatePoolCommand aCommand) {
        return CreatePoolOutput.from(create(aCommand));
    }

    public Pool create(final CreatePoolCommand aCommand) {
        
        final var aChain = aCommand.chain();
        final var aProtocolId = aCommand.protocolId();
        final var aSymbol = aCommand.symbol();
        final var aTotalValueLocked = aCommand.totalValueLocked();
        final var aOriginPoolId = aCommand.originPoolId();
        final var aRewardTokens = aCommand.rewardTokens();
        final var aVolumeUsd1d = aCommand.volumeUsd1d();
        final var aUnderlyingTokens = aCommand.underlyingTokens();

        final var aYield = aCommand.getYield().orElse(null);
        
        final var aCreateCommand = Pool.createPool(
            aChain, 
            aProtocolId, 
            aSymbol, 
            aTotalValueLocked,
            aOriginPoolId,
            aRewardTokens, 
            aUnderlyingTokens,
            aVolumeUsd1d
        );

        final var aPool = this.poolGateway.create(aCreateCommand).setYield(aYield);
        return aPool;
    }
    
}
