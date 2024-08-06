package com.mine.domain.pool;

import java.util.Objects;
import java.util.UUID;

import com.mine.domain.ValueObject;

public class Yield extends ValueObject {
    
    private final String id;
    private final Double annualPercentageYieldBase;
    private final Double annualPercentageYieldRewards;
    private final Double annualPercentageYield;
    private final Double annualPercentageVariation1D;
    private final Double annualPercentageVariation7D;
    private final Double annualPercentageVariation30D;

    private Yield(
        String id,
        Double annualPercentageYieldBase,
        Double annualPercentageYieldRewards,
        Double annualPercentageYield,
        Double annualPercentageVariation1D,
        Double annualPercentageVariation7D,
        Double annualPercentageVariation30D
    ){
        this.id = id;
        this.annualPercentageYieldBase = annualPercentageYieldBase;
        this.annualPercentageYieldRewards = annualPercentageYieldRewards;
        this.annualPercentageYield = annualPercentageYield;
        this.annualPercentageVariation1D = annualPercentageVariation1D;
        this.annualPercentageVariation7D = annualPercentageVariation7D;
        this.annualPercentageVariation30D = annualPercentageVariation30D;
    }
    
    // Factory Method
    public static Yield createYield(
        Double aAnnualPercentageYieldBase,
        Double aAnnualPercentageYieldRewards,
        Double aAnnualPercentageYield,
        Double aAnnualPercentageVariation1D,
        Double aAnnualPercentageVariation7D,
        Double aAnnualPercentageVariation30D
    ){
        final String tId = UUID.randomUUID().toString();
        final Double tAnnualPercentageYieldBase = Objects.requireNonNullElse(aAnnualPercentageYieldBase, 0.0);
        final Double tAnnualPercentageYieldRewards = Objects.requireNonNullElse(aAnnualPercentageYieldRewards, 0.0);
        final Double tAnnualPercentageVariation1D = Objects.requireNonNullElse(aAnnualPercentageVariation1D, 0.0);
        final Double tAnnualPercentageVariation7D = Objects.requireNonNullElse(aAnnualPercentageVariation7D, 0.0);
        final Double tAnnualPercentageVariation30D = Objects.requireNonNullElse(aAnnualPercentageVariation30D, 0.0);

        return new Yield(
            tId,
            tAnnualPercentageYieldBase,
            tAnnualPercentageYieldRewards,
            aAnnualPercentageYield,
            tAnnualPercentageVariation1D,
            tAnnualPercentageVariation7D,
            tAnnualPercentageVariation30D
        );
    }

    public Double getAnnualPercentageYieldBase() {
        return annualPercentageYieldBase;
    }

    public Double getAnnualPercentageYieldRewards() {
        return annualPercentageYieldRewards;
    }

    public Double getAnnualPercentageYield() {
        return annualPercentageYield;
    }

    public Double getAnnualPercentageVariation1D() {
        return annualPercentageVariation1D;
    }

    public Double getAnnualPercentageVariation7D() {
        return annualPercentageVariation7D;
    }

    public Double getAnnualPercentageVariation30D() {
        return annualPercentageVariation30D;
    }

    public String getId() {
        return id;
    }


}
