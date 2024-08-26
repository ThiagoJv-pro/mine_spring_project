package com.mining.infrastructure.configuration.externalApis;

import java.util.List;
import java.util.Optional;


public interface ApiRequest<API> {
    
    List<API> request();

    Optional<API> requestWithParams(String params); 
}
