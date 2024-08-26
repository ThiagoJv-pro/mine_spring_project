package com.mining.domain;

public abstract class Entity<ID extends Identifier> {
    
    protected final ID id;

    public Entity(final ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

}
