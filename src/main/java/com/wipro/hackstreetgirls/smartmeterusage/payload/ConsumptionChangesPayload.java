package com.wipro.hackstreetgirls.smartmeterusage.payload;

import java.util.List;

import com.wipro.hackstreetgirls.smartmeterusage.entity.WaterUsageEntity;
import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsumptionChangesPayload {
    private CompanyEnum company;
    private float monthlyUsage;
    private List<WaterUsageEntity> appliances;
}
