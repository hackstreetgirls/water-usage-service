package com.wipro.hackstreetgirls.smartmeterusage.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Savings {
    private BigDecimal moneySaved;
    private int waterSaved;
}
