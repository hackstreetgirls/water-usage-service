package com.wipro.hackstreetgirls.smartmeterusage.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "water_consumer")
@Data
public class WaterConsumer {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "consumption_per_use")
    private float consumption;
}
