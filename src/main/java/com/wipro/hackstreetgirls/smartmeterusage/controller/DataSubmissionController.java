package com.wipro.hackstreetgirls.smartmeterusage.controller;

import java.util.ArrayList;
import java.util.List;

import com.wipro.hackstreetgirls.smartmeterusage.entity.ApplianceLimits;
import com.wipro.hackstreetgirls.smartmeterusage.entity.Savings;
import com.wipro.hackstreetgirls.smartmeterusage.entity.WaterUsageEntity;
import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;
import com.wipro.hackstreetgirls.smartmeterusage.enums.TimeUnitEnum;
import com.wipro.hackstreetgirls.smartmeterusage.payload.ConsumptionChangesPayload;
import com.wipro.hackstreetgirls.smartmeterusage.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSubmissionController {

    @Autowired
    private CalculatorService calculatorService;

   @GetMapping(value = "/payload")
    public ResponseEntity<ConsumptionChangesPayload> test(){
        List<WaterUsageEntity> waterUsageEntities = new ArrayList<WaterUsageEntity>();
        waterUsageEntities.add(new WaterUsageEntity("Washing machine", 2, TimeUnitEnum.WEEK));
        waterUsageEntities.add(new WaterUsageEntity("Dishwasher", 4, TimeUnitEnum.WEEK));
        waterUsageEntities.add(new WaterUsageEntity("Handwashing dishes", 2, TimeUnitEnum.WEEK, 10));
        waterUsageEntities.add(new WaterUsageEntity("Kettle", 2, TimeUnitEnum.DAY));
        waterUsageEntities.add(new WaterUsageEntity("Handwashing food - bowl", 5, TimeUnitEnum.WEEK, 5));
        waterUsageEntities.add(new WaterUsageEntity("Bath - full", 0, TimeUnitEnum.WEEK));
        waterUsageEntities.add(new WaterUsageEntity("Tap running - teeth", 1, TimeUnitEnum.DAY));
        waterUsageEntities.add(new WaterUsageEntity("Tap running - shaving", 0, TimeUnitEnum.DAY));
        waterUsageEntities.add(new WaterUsageEntity("Shower", 1, TimeUnitEnum.DAY, 10));
        waterUsageEntities.add(new WaterUsageEntity("Toilet", 5, TimeUnitEnum.DAY));
        waterUsageEntities.add(new WaterUsageEntity("Garden hose", 4, TimeUnitEnum.MONTH, 20));
        waterUsageEntities.add(new WaterUsageEntity("Car wash", 1, TimeUnitEnum.MONTH, 40));

        return new ResponseEntity<ConsumptionChangesPayload>(new ConsumptionChangesPayload(CompanyEnum.THAMES_WATER, 4470, waterUsageEntities), HttpStatus.OK);
    }

    @PostMapping(value = "/savings",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Savings> calculateSavings(@RequestBody ConsumptionChangesPayload payload){
        Savings savings = calculatorService.calculateSavings(payload);

        return new ResponseEntity<Savings>(savings, HttpStatus.OK);
    }

    @GetMapping(value = "/limits", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApplianceLimits>> applyLimits(@RequestBody List<ApplianceLimits> applianceLimits){
        return new ResponseEntity<List<ApplianceLimits>>(calculatorService.calculateLimits(applianceLimits), HttpStatus.OK);
    }

    @GetMapping("/sample-limits")
    public ResponseEntity<List<ApplianceLimits>> getLimits(){
        List<ApplianceLimits> applianceLimits = new ArrayList<ApplianceLimits>();
        applianceLimits.add(new ApplianceLimits("Washing machine", 2, TimeUnitEnum.WEEK));
        applianceLimits.add(new ApplianceLimits("Dishwasher", 4, TimeUnitEnum.WEEK));
        applianceLimits.add(new ApplianceLimits("Handwashing dishes", 2, TimeUnitEnum.WEEK));
        applianceLimits.add(new ApplianceLimits("Kettle", 2, TimeUnitEnum.DAY));
        applianceLimits.add(new ApplianceLimits("Handwashing food - bowl", 5, TimeUnitEnum.WEEK));
        applianceLimits.add(new ApplianceLimits("Bath - full", 0, TimeUnitEnum.WEEK));
        applianceLimits.add(new ApplianceLimits("Tap running - teeth", 1, TimeUnitEnum.DAY));
        applianceLimits.add(new ApplianceLimits("Tap running - shaving", 0, TimeUnitEnum.DAY));
        applianceLimits.add(new ApplianceLimits("Shower", 1, TimeUnitEnum.DAY));
        applianceLimits.add(new ApplianceLimits("Toilet", 5, TimeUnitEnum.DAY));
        applianceLimits.add(new ApplianceLimits("Garden hose", 4, TimeUnitEnum.MONTH));
        applianceLimits.add(new ApplianceLimits("Car wash", 1, TimeUnitEnum.MONTH));
        return new ResponseEntity<List<ApplianceLimits>>(applianceLimits, HttpStatus.OK);
    }
}
