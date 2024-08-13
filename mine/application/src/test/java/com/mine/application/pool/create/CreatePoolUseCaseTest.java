package com.mine.application.pool.create;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
 
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

import org.mockito.Mockito;

import com.mine.domain.pool.PoolGateway;
import com.mine.domain.protocol.ProtocolId;

public class CreatePoolUseCaseTest {
    
    @InjectMocks
    private DefaultCreatePoolUseCase poolUseCase;

    @Mock
    private PoolGateway poolGateway;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void givenAValidParams_whenCallingTheExecuteMethodOfTheGateway_shouldReturnPoolId() {

        //Given 
        final var expectedChain = "ETH";
        final ProtocolId expectedProtocolId = null;
        final var expectedSymbol = "teste";
        final Long totalValueLocked = null;
        final String[] expectedRewardTokens = {
            "teste",
            "teste"
        };
        final String[] expectedUnderlyingTokens = {
            "testeU",
            "testeU"
        };
        final Double expectedVolumeUsd1d = 2.21;
        final Double expectedAnnualPercentageYieldBase = 12.4;
        final Double expectedAnnualPercentageYieldRewards = 12.4;
        final Double expectedAnnualPercentageYield = 12.4;
        final Double expectedAnnualPercentageVariation1D = 12.4;
        final Double expectedAnnualPercentageVariation7D = 12.4;
        final Double expectedAnnualPercentageVariation30D = 12.4;

        //When
        final var aCommand = 
                CreatePoolCommand.createPool(expectedChain, expectedProtocolId, expectedSymbol, totalValueLocked,
                        expectedRewardTokens, expectedUnderlyingTokens, expectedVolumeUsd1d,
                        expectedAnnualPercentageYieldBase, expectedAnnualPercentageYieldRewards,
                        expectedAnnualPercentageYield, expectedAnnualPercentageVariation1D,
                        expectedAnnualPercentageVariation7D, expectedAnnualPercentageVariation30D);

        //Define the Behavior of the poolGateway interface with mockito when() method
        when(poolGateway.create(any())).thenAnswer(returnsFirstArg());

        final var actualOutput = poolUseCase.execute(aCommand);

        //Then
        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        //check how many times the create method was called
        Mockito.verify(poolGateway, times(1)).create(any());
    }
}
