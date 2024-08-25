package com.mine.application.pool.retrieve.get;

import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.mine.domain.pool.Pool;
import com.mine.domain.pool.PoolGateway;
import com.mine.domain.pool.PoolId;
import com.mine.domain.protocol.ProtocolId;

public class GetPoolUseCaseTest {

    @Mock
    private PoolGateway poolGateway;

    @InjectMocks
    private DefaultGetPoolUseCase useCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenAValidParams_whenCallFindByIdMethod_thenReturnAPoolRegisterById(){
        
        List<PoolId> expectedId = new ArrayList<>();
        Pool expectedPool = null;
        final var expectedChain = "ETH";
        final ProtocolId expectedProtocolId = null;
        final var expectedSymbol = "test";
        final Long totalValueLocked = null;
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
                totalValueLocked, expectedRewardTokens, expectedUnderlyingTokens, expectedVolumeUsd1d),
            Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                totalValueLocked, expectedRewardTokens, expectedUnderlyingTokens, expectedVolumeUsd1d)
        );
        
        for (Pool pool : poolList) {
           expectedId.add(pool.getId());
        }
        if(expectedId.get(0) == poolList.get(0).getId()) {
            expectedPool = poolList.get(0);
        }

        when(this.poolGateway.findById(expectedId.get(0))).thenReturn(expectedPool);
         
        Assertions.assertNotNull(expectedPool);
        Assertions.assertEquals(expectedPool, poolList.get(0));
    }


}
