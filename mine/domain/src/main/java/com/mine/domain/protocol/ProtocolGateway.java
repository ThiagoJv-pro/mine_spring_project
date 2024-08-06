package com.mine.domain.protocol;

public interface ProtocolGateway {
    
    public Protocol addProtocol(Protocol protocol);
    
    public Protocol updateProtocol(Protocol protocol);

    public void removeProtocol(ProtocolId protocolId);
    
}
