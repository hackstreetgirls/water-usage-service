package com.wipro.hackstreetgirls.smartmeterusage.service;

import java.math.BigDecimal;
import java.util.List;

import com.wipro.hackstreetgirls.smartmeterusage.entity.ApplianceLimits;
import com.wipro.hackstreetgirls.smartmeterusage.entity.Savings;
import com.wipro.hackstreetgirls.smartmeterusage.entity.WaterUsageEntity;
import com.wipro.hackstreetgirls.smartmeterusage.enums.TimeUnitEnum;
import com.wipro.hackstreetgirls.smartmeterusage.payload.ConsumptionChangesPayload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private WaterConsumptionService waterConsumptionService;

    public Savings calculateSavings(ConsumptionChangesPayload payload){
        //Get the total litres saved by multiplying the consumption of each appliance by the change
        //Multiply this by the water price to get the total savings.
        float totalLitres = 0;
        BigDecimal waterPrice = companyService.getWaterCost(payload.getCompany());
        BigDecimal wasteWaterPrice = companyService.getWastewaterCost(payload.getCompany());

        for (WaterUsageEntity waterUser : payload.getAppliances()) {
            float totalConsumption = waterConsumptionService.getTotalConsumption(waterUser);
            switch(waterUser.getUnit()){
            case DAY:
                totalConsumption *= 30;
                break;
            case MONTH:
                totalConsumption *= 1;
                break;
            case WEEK:
                totalConsumption *= 4;
                break;
            default:
                break;
            }
            totalLitres += totalConsumption;
        }

        BigDecimal totalWaterPrice = getCubicMetrePrice(waterPrice, totalLitres);
        BigDecimal totalWastewaterPrice = getCubicMetrePrice(wasteWaterPrice, totalLitres);
        BigDecimal totalSavings = totalWaterPrice.add(totalWastewaterPrice);
        return new Savings(totalSavings, (int)totalLitres);
    }

    public List<ApplianceLimits> calculateLimits(List<ApplianceLimits> applianceLimits){
        for (ApplianceLimits applianceLimit : applianceLimits) {
            if(applianceLimit.getMaximumLimit() == 1){
                switch(applianceLimit.getTimeUnit()){
                case DAY:
                applianceLimit.setMaximumLimit(6);
                applianceLimit.setTimeUnit(TimeUnitEnum.WEEK);
                    break;
                case MONTH:
                applianceLimit.setMaximumLimit(0);
                    break;
                case WEEK:
                applianceLimit.setMaximumLimit(3);
                applianceLimit.setTimeUnit(TimeUnitEnum.MONTH);
                    break;
                default:
                    break;
                    
                }
            }
        }

        return applianceLimits;
    }

    private BigDecimal getCubicMetrePrice(BigDecimal price, float totalLitres){
        float cubicMetres = totalLitres / 1000;
        return price.multiply(new BigDecimal(Float.toString(cubicMetres)));
    }
}
