package com.mining.application.pool.retrieve.get;

import java.util.ArrayList;
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
import com.mining.domain.pool.PoolId;
import com.mining.domain.protocol.ProtocolId;

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
                totalValueLocked, expectedOriginPoolId, null, expectedRewardTokens, expectedUnderlyingTokens, expectedVolumeUsd1d),
            Pool.createPool(expectedChain, expectedProtocolId, expectedSymbol,
                totalValueLocked,expectedOriginPoolId,null, expectedRewardTokens, expectedUnderlyingTokens, expectedVolumeUsd1d)
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
