package com.wipro.hackstreetgirls.smartmeterusage.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;

import lombok.Data;

@Entity
@Table(name = "company_data")
@Data
public class CompanyEntity {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "company")
    private CompanyEnum company;

    @Column(name = "pence_per_meter")
    private BigDecimal price;
}
