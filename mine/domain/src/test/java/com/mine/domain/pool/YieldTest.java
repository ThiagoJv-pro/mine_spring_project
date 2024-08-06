package com.mine.domain.pool;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YieldTest {
    
    @Test
    public void givenAValidParams_whenCallNewYield_thenInstantiateAYield() {
        
        final Double aAnnualPercentageYieldBase = 0.1;
        final Double aAnnualPercentageYieldRewards = 21.32;
        final Double aAnnualPercentageYield = 9.49587;
        final Double aAnnualPercentageVariation1D = null;
        final Double aAnnualPercentageVariation7D = null;
        final Double aAnnualPercentageVariation30D = -0.51511;

        final var newYield = Yield.createYield(
            aAnnualPercentageYieldBase, 
            aAnnualPercentageYieldRewards, 
            aAnnualPercentageYield, 
            aAnnualPercentageVariation1D, 
            aAnnualPercentageVariation7D, 
            aAnnualPercentageVariation30D
        );

        Assertions.assertNotNull(newYield);
    }
}
