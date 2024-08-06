package com.mine.application.pool.create;

import java.util.Optional;

import com.mine.domain.pool.Yield;
import com.mine.domain.protocol.ProtocolId;

public record CreatePoolCommand(
        String chain,
        ProtocolId protocolId,
        String symbol,
        Long totalValueLocked,
        String[] rewardTokens,
        String[] underlyingTokens,
        Double volumeUsd1d,
        Double annualPercentageYieldBase,
        Double annualPercentageYieldRewards,
        Double annualPercentageYield,
        Double annualPercentageVariation1D,
        Double annualPercentageVariation7D,
        Double annualPercentageVariation30D
    ) {

    public Optional<Double> getAnnualPercentageYieldBase() {
        return Optional.ofNullable(annualPercentageYieldBase);
    }

    public Optional<Double> getAnnualPercentageYieldRewards() {
        return Optional.ofNullable(annualPercentageYieldRewards);
    }

    public Optional<Double> getAnnualPercentageYield() {
        return Optional.ofNullable(annualPercentageYield);
    }

    public Optional<Double> getAnnualPercentageVariation1D() {
        return Optional.ofNullable(annualPercentageVariation1D);
    }

    public Optional<Double> getAnnualPercentageVariation7D() {
        return Optional.ofNullable(annualPercentageVariation7D);
    }

    public Optional<Double> getAnnualPercentageVariation30D() {
        return Optional.ofNullable(annualPercentageVariation30D);
    }

    public Optional<Yield> getYield() {
        return getAnnualPercentageYieldBase()
                .flatMap(base -> getAnnualPercentageYieldRewards()
                        .flatMap(rewards -> getAnnualPercentageYield()
                                .flatMap(pYield -> getAnnualPercentageVariation1D()
                                        .flatMap(var1D -> getAnnualPercentageVariation7D()
                                                .flatMap(var7D -> getAnnualPercentageVariation30D()
                                                        .map(var30D -> Yield.createYield(base, rewards, pYield, var1D,
                                                                var7D, var30D)))))));
    }

    public static CreatePoolCommand createPool(
            String chain,
            ProtocolId protocolId,
            String symbol,
            Long totalValueLocked,
            String[] rewardTokens,
            String[] underlyingTokens,
            Double volumeUsd1d,
            Double annualPercentageYieldBase,
            Double annualPercentageYieldRewards,
            Double annualPercentageYield,
            Double annualPercentageVariation1D,
            Double annualPercentageVariation7D,
            Double annualPercentageVariation30D
        ) {
        return new CreatePoolCommand(
                chain,
                protocolId,
                symbol,
                totalValueLocked,
                rewardTokens,
                underlyingTokens,
                volumeUsd1d, 
                annualPercentageYieldBase,
                annualPercentageYieldRewards,
                annualPercentageYield,
                annualPercentageVariation1D,
                annualPercentageVariation7D,
                annualPercentageVariation30D
            );
    }

}
