package com.mining.domain.pool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mining.domain.protocol.ProtocolId;

public class PoolTest {
    
    @Test
    public void givenAValidParams_whenCallCreatePool_thenInstantiatedPool() {
        //Given

        final var aChain = "Polygon";
        final var protocolId = ProtocolId.unique();
        final var aSymbol = "WETH";
        final var aTotalValueLocked = 123;
        final String expectedOriginPoolId = "";
        final var expectedVolumeUsd1d = 41017.60602;
        final String[] underlyingTokens = {
            "0xb0b195aefa3650a6908f15cdac7d92f8a5791b0b",
			"0xff970a61a04b1ca14834a43f5de4533ebddb5cc8"
        };
        //When
        final var newPool = Pool.createPool(
            aChain, 
            protocolId, 
            aSymbol, 
            null,
            expectedOriginPoolId,
            null,
            underlyingTokens,
            expectedVolumeUsd1d
        );

        //then
        Assertions.assertNotNull(newPool);
        Assertions.assertEquals(expectedVolumeUsd1d, newPool.getVolumeUsd1d());
        
    }

    @Test
    public void givenAValidParams_whenCallSetYield_thenInstantiateNewYield() {
        //given

        final var aChain = "Polygon";
        final var protocolId = ProtocolId.unique();
        final var aSymbol = "WETH";
        final var expectedVolumeUsd1d = 41017.60602;
        final String[] underlyingTokens = {
            "0xb0b195aefa3650a6908f15cdac7d92f8a5791b0b",
			"0xff970a61a04b1ca14834a43f5de4533ebddb5cc8"
        };
        final String expectedOriginPoolId = "";


        final var newPool = Pool.createPool(
            aChain, 
            protocolId, 
            aSymbol, 
            null,
            expectedOriginPoolId,
            null,
            underlyingTokens,
            expectedVolumeUsd1d
        );

        final Yield newYield = Yield.createYield(
            null, 
            null,
            null, 
            null, 
            null, 
            null
        );
        
        //when
        final var pool = newPool.setYield(newYield);

        //then
        Assertions.assertNotNull(pool.getYield());
        Assertions.assertEquals(aChain, pool.getChain());

    }

    @Test
    public void givenAValidParams_whenCallCreatePool_thenPopulateTheVariableARewardTokens() {
        
        //given

        final var aChain = "Polygon";
        final var protocolId = ProtocolId.unique();
        final var aSymbol = "WETH";
        final var aTotalValueLocked = 123;
        final String expectedOriginPoolId = "";
        final var expectedVolumeUsd1d = 41017.60602;
        
        final String[] expectedRewardsTokens = {
            "EQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM9c",
            "EQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM9c",
            "EQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM9c",
            "EQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM9c"
        };

        final String[] underlyingTokens = {
            "0xb0b195aefa3650a6908f15cdac7d92f8a5791b0b",
			"0xff970a61a04b1ca14834a43f5de4533ebddb5cc8"
        };

        //when
          final var newPool = Pool.createPool(
            aChain, 
            protocolId, 
            aSymbol, 
            null,
            expectedOriginPoolId,
            expectedRewardsTokens,
            underlyingTokens,
            expectedVolumeUsd1d
        );

        //then

        Assertions.assertEquals(expectedRewardsTokens, newPool.getRewardTokens());

    }   

}
