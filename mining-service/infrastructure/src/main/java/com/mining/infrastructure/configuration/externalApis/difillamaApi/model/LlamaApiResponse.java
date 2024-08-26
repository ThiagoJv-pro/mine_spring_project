package com.mining.infrastructure.configuration.externalApis.difillamaApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LlamaApiResponse (
    @JsonProperty("data") List<LlamaApiModel> data
) {  
}
