package com.mining.application.pool.retrieve.list;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mining.application.pool.retrieve.list.DefaultListPoolUseCase;
import com.mining.domain.pool.Pool;
import com.mining.domain.pool.PoolGateway;
import com.mining.domain.protocol.ProtocolId;

public class ListPoolUseCaseTest {
    
    @Mock
    private PoolGateway poolGateway;

    @InjectMocks
    private DefaultListPoolUseCase listUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void givenAExecuteCommand_whenACallFindAll_shouldReturnAListOfAllPools() {

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
        final Double expectedVolumeUsd1d = 2.21;

        final var poolList = List.of(
            Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                totalValueLocked, expectedOriginPoolId, expectedRewardTokens, expectedUnderlyingTokens, expectedVolumeUsd1d),
            Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                totalValueLocked,expectedOriginPoolId, expectedRewardTokens, expectedUnderlyingTokens, expectedVolumeUsd1d)
        );
        

        when(poolGateway.findAll()).thenReturn(poolList);

        final var actualReturn = listUseCase.execute();

        Assertions.assertNotNull(actualReturn);
    }



}
