package com.mine.domain.protocol;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProtocolTest {
    
    @Test
    public void givenAValidParams_whenCallNewProtocol_thenInstantiateAProtocol() {

        ProtocolId id = ProtocolId.unique();
        final var description = "Teste description";
        final var name = "Test name";
        final var type = "test type";

        final var inProtocol = Protocol.addProtocol(name, description, type);
        Assertions.assertNotNull(inProtocol);
        Assertions.assertNotNull(inProtocol.getId());

    }
}
