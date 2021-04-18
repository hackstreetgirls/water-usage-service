package com.wipro.hackstreetgirls.smartmeterusage.service;

import java.util.Optional;

import com.wipro.hackstreetgirls.smartmeterusage.entity.WaterConsumptionEntity;
import com.wipro.hackstreetgirls.smartmeterusage.entity.WaterUsageEntity;
import com.wipro.hackstreetgirls.smartmeterusage.exception.ApplianceNotFoundException;
import com.wipro.hackstreetgirls.smartmeterusage.repository.WaterConsumptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterConsumptionService {
    @Autowired
    private WaterConsumptionRepository waterConsumptionRepository;

    public float getTotalConsumption(WaterUsageEntity waterUsageEntity){
        float total = 0;

        Optional<WaterConsumptionEntity> optional = waterConsumptionRepository.findConsumptionByAppliance(waterUsageEntity.getAppliance());
        if(optional.isPresent())
        {
            WaterConsumptionEntity consumptionEntity = optional.get();
            float consumption = consumptionEntity.getConsumption();
            int averageMinutes = waterUsageEntity.getAverageMinutes();
            int uses = waterUsageEntity.getUses();
            total = waterUsageEntity.getAverageMinutes() != 0 ? (consumption * averageMinutes * uses) : (consumption * uses);
        }

        else{
            throw new ApplianceNotFoundException(waterUsageEntity.getAppliance());
        }

        return total;
    }
}
