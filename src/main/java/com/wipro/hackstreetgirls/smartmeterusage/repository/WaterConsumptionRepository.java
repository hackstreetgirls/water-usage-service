package com.wipro.hackstreetgirls.smartmeterusage.repository;

import java.util.Optional;

import com.wipro.hackstreetgirls.smartmeterusage.entity.WaterConsumptionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterConsumptionRepository extends JpaRepository<WaterConsumptionEntity, String>{

    public Optional<WaterConsumptionEntity> findConsumptionByAppliance(String appliance);
    
}
