package com.wipro.hackstreetgirls.smartmeterusage.entity;

import com.wipro.hackstreetgirls.smartmeterusage.enums.TimeUnitEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplianceLimits {
    private String appliance;
    private int maximumLimit;
    private TimeUnitEnum timeUnit;
}
