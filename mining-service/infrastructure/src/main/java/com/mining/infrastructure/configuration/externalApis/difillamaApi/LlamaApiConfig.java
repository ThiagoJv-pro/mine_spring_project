package com.mining.infrastructure.configuration.externalApis.difillamaApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mining.infrastructure.configuration.externalApis.ApiRequest;
import com.mining.infrastructure.configuration.externalApis.difillamaApi.model.LlamaApiModel;
import com.mining.infrastructure.configuration.externalApis.difillamaApi.model.LlamaApiResponse;

@Service
public class LlamaApiConfig implements ApiRequest<LlamaApiModel>{

    @Value("${api.request.data.pool.url}")
    private String url;
    private final ObjectMapper objectMapper;

    public LlamaApiConfig(
        ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
    }

 
    @Override
    public List<LlamaApiModel> request(){
        try {
            final RestTemplate restTemplate = new RestTemplate();
          
            final ResponseEntity<String> content = restTemplate.exchange(
                url, 
                HttpMethod.GET, 
                null, 
                String.class
            );
            
            LlamaApiResponse response = objectMapper.readValue(
                content.getBody(),
                LlamaApiResponse.class
            );

            List<LlamaApiModel> data = response.data();

            return data;
            
        } catch (JsonProcessingException | RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<LlamaApiModel> requestWithParams(String params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestWithParams'");
    }

  
}
