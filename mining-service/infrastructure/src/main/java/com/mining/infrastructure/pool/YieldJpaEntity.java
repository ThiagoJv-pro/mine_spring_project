package com.mining.infrastructure.pool;

import java.util.Objects;

import com.mining.domain.pool.Yield;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    public static YieldJpaEntity toJpa(Yield yieldJpaEntity) {
        if(Objects.nonNull(yieldJpaEntity)) {
            return new YieldJpaEntity(
                yieldJpaEntity.getId(), 
                yieldJpaEntity.getAnnualPercentageYieldBase(), 
                yieldJpaEntity.getAnnualPercentageYieldRewards(), 
                yieldJpaEntity.getAnnualPercentageYield(), 
                yieldJpaEntity.getAnnualPercentageVariation1D(), 
                yieldJpaEntity.getAnnualPercentageVariation7D(), 
                yieldJpaEntity.getAnnualPercentageVariation30D()
            );
        }
      return null;
    }

    public static Yield toAggregate(YieldJpaEntity yieldJpaEntity) {
        if(Objects.nonNull(yieldJpaEntity)) {
            return Yield.with(
                yieldJpaEntity.getId(), 
                yieldJpaEntity.getAnnualPercentageYieldBase(), 
                yieldJpaEntity.getAnnualPercentageYieldRewards(), 
                yieldJpaEntity.getAnnualPercentageYield(), 
                yieldJpaEntity.getAnnualPercentageVariation1D(), 
                yieldJpaEntity.getAnnualPercentageVariation7D(), 
                yieldJpaEntity.getAnnualPercentageVariation30D()
            );
        }

        return null;
    }
}
