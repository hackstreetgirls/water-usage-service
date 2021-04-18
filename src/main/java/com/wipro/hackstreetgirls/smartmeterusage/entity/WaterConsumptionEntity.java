package com.wipro.hackstreetgirls.smartmeterusage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "water_consumer")
@Data
public class WaterConsumptionEntity {
    @Id
    @Column(name = "appliance")
    private String appliance;

    @Column(name = "consumption")
    private float consumption;
}
