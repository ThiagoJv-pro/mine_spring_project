package com.mine.infrastructure.pool;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "yields")
@NoArgsConstructor
@Getter
@Setter
public class YieldJpaEntity {
    
    @Id
    @Column(name="id", nullable = false)
    private String id;
    private Double annualPercentageYieldBase;
    private Double annualPercentageYieldRewards;
    private Double annualPercentageYield;
    private Double annualPercentageVariation1D;
    private Double annualPercentageVariation7D;
    private Double annualPercentageVariation30D;

    public YieldJpaEntity(String id, Double annualPercentageYieldBase, Double annualPercentageYieldRewards,
            Double annualPercentageYield, Double annualPercentageVariation1D, Double annualPercentageVariation7D,
            Double annualPercentageVariation30D) {
        this.id = id;
        this.annualPercentageYieldBase = annualPercentageYieldBase;
        this.annualPercentageYieldRewards = annualPercentageYieldRewards;
        this.annualPercentageYield = annualPercentageYield;
        this.annualPercentageVariation1D = annualPercentageVariation1D;
        this.annualPercentageVariation7D = annualPercentageVariation7D;
        this.annualPercentageVariation30D = annualPercentageVariation30D;
    }

}
