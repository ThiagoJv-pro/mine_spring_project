package com.mine.domain.protocol;

import com.mine.domain.AggregateRoot;

public class Protocol extends AggregateRoot<ProtocolId> {

    private  String name;
    private  String description;
    private  String type;
   
    protected Protocol(
        final ProtocolId id,
        final String name,
        final String description,
        final String type
    ) {
        super(id);
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public static Protocol addProtocol( //Factory Protocol class
        final String name,
        final String description,
        final String type
    ){

        return new Protocol(ProtocolId.unique(), name, description, type);
    }

    public Protocol updateProtocol(
        final String name, 
        final String description, 
        final String type
    ){
        this.name = name;
        this.description = description;
        this.type = type;
 
        return this;
    }
 
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }


}
