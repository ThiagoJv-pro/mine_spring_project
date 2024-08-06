package com.mine.domain.pool;

import java.util.UUID;

import com.mine.domain.Identifier;

public class PoolId extends Identifier {

    private String id;
    
    
    private PoolId(final String id) {
        this.id = id;
    }

    public static PoolId unique() {
        return new PoolId(UUID.randomUUID().toString());
    }

    public static PoolId from(final String id) {
        return new PoolId(id);
    }

    @Override
    public  String getValue() {
        return id;
    }
    
}
