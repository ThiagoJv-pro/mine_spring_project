package com.mine.infrastructure.pool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreatePoolRequest (
        @JsonProperty("chain") String chain,
        @JsonProperty("symbol") String symbol,
        @JsonProperty("tvlUsd") Long totalValueLocked,
        @JsonProperty("rewardTokens") String[] rewardTokens,
        @JsonProperty("underlyingTokens") String[] underlyingTokens,
        @JsonProperty("volumeUsd1d") String volumeUsd1d,
        @JsonProperty("apyBase") Double annualPercentageYieldBase,
        @JsonProperty("apyReward") Double annualPercentageYieldRewards,
        @JsonProperty("apy") Double annualPercentageYield,
        @JsonProperty("apyPct1D") Double annualPercentageVariation1D,
        @JsonProperty("apyPct7D") Double annualPercentageVariation7D,
        @JsonProperty("apyPct30D") Double annualPercentageVariation30D
) {
}
