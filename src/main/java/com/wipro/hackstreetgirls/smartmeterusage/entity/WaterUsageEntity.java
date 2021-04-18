package com.wipro.hackstreetgirls.smartmeterusage.entity;

import javax.persistence.Id;

import com.wipro.hackstreetgirls.smartmeterusage.enums.TimeUnitEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class WaterUsageEntity {

    @Id
    @NonNull
    private String appliance;
    @NonNull
    private int uses;
    @NonNull
    private TimeUnitEnum unit;
    private int averageMinutes;
}
