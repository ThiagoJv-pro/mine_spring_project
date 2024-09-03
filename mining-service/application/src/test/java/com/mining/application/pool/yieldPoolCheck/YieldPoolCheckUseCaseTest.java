package com.mining.application.pool.yieldPoolCheck;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolGateway;
import com.mining.domain.pool.Yield;
import com.mining.domain.protocol.ProtocolId;

public class YieldPoolCheckUseCaseTest {
    @Mock
    private PoolGateway poolGateway;

    @InjectMocks
    private DefaultYieldPoolCheckUseCase useCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenAValidParams_whenCallFindAllPools_thenReturnToBestPools(){
        
        final var expectedChain = "ETH";
        final ProtocolId expectedProtocolId = null;
        final var expectedSymbol = "test";
        final Long totalValueLocked = null;
        final String expectedOriginPoolId = "";
        final String[] expectedRewardTokens = {
                "test",
                "test"
        };
        final String[] expectedUnderlyingTokens = {
                "testU",
                "testU"
        };
        final Double expectedVolumeUsd1d = 50_000_000.0;
        final Double expectedAnnualPercentageYieldBase = 15.0;
        final Double expectedAnnualPercentageYieldRewards = 5.0;
        final Double expectedAnnualPercentageYield = 20.0;
        final Double expectedAnnualPercentageVariation1D = 0.5;
        final Double expectedAnnualPercentageVariation7D = 1.0;
        final Double expectedAnnualPercentageVariation30D = 1.5;

        final Double expectedVolumeUsd1dLoss = 10_000.0;
        final Double expectedAnnualPercentageYieldBaseLoss = 2.0;
        final Double expectedAnnualPercentageYieldRewardsLoss = 0.5;
        final Double expectedAnnualPercentageYieldLoss = 2.5;
        final Double expectedAnnualPercentageVariation1DLoss = -5.0;
        final Double expectedAnnualPercentageVariation7DLoss = -10.0;
        final Double expectedAnnualPercentageVariation30DLoss = -20.0;

        final Double expectedVolumeUsd1dModerate = 5_000_000.0;
        final Double expectedAnnualPercentageYieldBaseModerate = 10.0;
        final Double expectedAnnualPercentageYieldRewardsModerate = 2.0;
        final Double expectedAnnualPercentageYieldModerate = 12.0;
        final Double expectedAnnualPercentageVariation1DModerate = 0.3;
        final Double expectedAnnualPercentageVariation7DModerate = 0.6;
        final Double expectedAnnualPercentageVariation30DModerate = 0.9;

        final Double expectedVolumeUsd1dVolatile = 30_000_000.0;
        final Double expectedAnnualPercentageYieldBaseVolatile = 18.0;
        final Double expectedAnnualPercentageYieldRewardsVolatile = 6.0;
        final Double expectedAnnualPercentageYieldVolatile = 24.0;
        final Double expectedAnnualPercentageVariation1DVolatile = 5.0;
        final Double expectedAnnualPercentageVariation7DVolatile = 7.0;
        final Double expectedAnnualPercentageVariation30DVolatile = 10.0;

        final Double expectedVolumeUsd1dRecovery = 15_000_000.0;
        final Double expectedAnnualPercentageYieldBaseRecovery = 8.0;
        final Double expectedAnnualPercentageYieldRewardsRecovery = 3.0;
        final Double expectedAnnualPercentageYieldRecovery = 11.0;
        final Double expectedAnnualPercentageVariation1DRecovery = 0.8;
        final Double expectedAnnualPercentageVariation7DRecovery = 1.2;
        final Double expectedAnnualPercentageVariation30DRecovery = 2.0;

        final var expectedYieldLoss = Yield.createYield(
                expectedAnnualPercentageYieldBaseLoss,
                expectedAnnualPercentageYieldRewardsLoss,
                expectedAnnualPercentageYieldLoss,
                expectedAnnualPercentageVariation1DLoss,
                expectedAnnualPercentageVariation7DLoss,
                expectedAnnualPercentageVariation30DLoss);

        final var expectedYieldGain = Yield.createYield(
                expectedAnnualPercentageYieldBase,
                expectedAnnualPercentageYieldRewards,
                expectedAnnualPercentageYield,
                expectedAnnualPercentageVariation1D,
                expectedAnnualPercentageVariation7D,
                expectedAnnualPercentageVariation30D);

        final var expectedYieldModerate = Yield.createYield(
                expectedAnnualPercentageYieldBaseModerate,
                expectedAnnualPercentageYieldRewardsModerate,
                expectedAnnualPercentageYieldModerate,
                expectedAnnualPercentageVariation1DModerate,
                expectedAnnualPercentageVariation7DModerate,
                expectedAnnualPercentageVariation30DModerate);

        final var expectedYieldVolatile = Yield.createYield(
                expectedAnnualPercentageYieldBaseVolatile,
                expectedAnnualPercentageYieldRewardsVolatile,
                expectedAnnualPercentageYieldVolatile,
                expectedAnnualPercentageVariation1DVolatile,
                expectedAnnualPercentageVariation7DVolatile,
                expectedAnnualPercentageVariation30DVolatile);

        final var expectedYieldRecovery = Yield.createYield(
                expectedAnnualPercentageYieldBaseRecovery,
                expectedAnnualPercentageYieldRewardsRecovery,
                expectedAnnualPercentageYieldRecovery,
                expectedAnnualPercentageVariation1DRecovery,
                expectedAnnualPercentageVariation7DRecovery,
                expectedAnnualPercentageVariation30DRecovery);

        final var poolList = List.of(
                Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                        totalValueLocked, expectedOriginPoolId, null,expectedRewardTokens, expectedUnderlyingTokens,
                        expectedVolumeUsd1d).setYield(expectedYieldGain),
                Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                        totalValueLocked, expectedOriginPoolId, null,expectedRewardTokens, expectedUnderlyingTokens,
                        expectedVolumeUsd1d).setYield(expectedYieldGain),
                Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                        totalValueLocked, expectedOriginPoolId, null,expectedRewardTokens, expectedUnderlyingTokens,
                        expectedVolumeUsd1dLoss).setYield(expectedYieldLoss),
                Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                        totalValueLocked, expectedOriginPoolId, null,expectedRewardTokens, expectedUnderlyingTokens,
                        expectedVolumeUsd1dModerate).setYield(expectedYieldModerate),
                Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                        totalValueLocked, expectedOriginPoolId, null,expectedRewardTokens, expectedUnderlyingTokens,
                        expectedVolumeUsd1dVolatile).setYield(expectedYieldVolatile),
                Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                        totalValueLocked, expectedOriginPoolId, null,expectedRewardTokens, expectedUnderlyingTokens,
                        expectedVolumeUsd1dRecovery).setYield(expectedYieldRecovery));

        when(poolGateway.findAll()).thenReturn(poolList);

        final var returnBestPool = useCase.execute();

        Assertions.assertNotNull(returnBestPool);

        

    }
}
