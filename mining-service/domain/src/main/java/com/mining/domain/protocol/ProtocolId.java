package com.mining.domain.protocol;

import java.util.UUID;

import com.mining.domain.Identifier;

public class ProtocolId extends Identifier {

    private final String id;
    
    
    private ProtocolId(final String id) {
        this.id = id;
    }

    public static ProtocolId unique() {
        return new ProtocolId(UUID.randomUUID().toString());
    }

    @Override
    public String getValue() {
        return id;
    }
    
}
