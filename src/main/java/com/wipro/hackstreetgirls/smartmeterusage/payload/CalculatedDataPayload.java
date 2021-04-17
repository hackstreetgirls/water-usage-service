package com.wipro.hackstreetgirls.smartmeterusage.payload;

import com.wipro.hackstreetgirls.smartmeterusage.entity.WaterConsumer;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class CalculatedDataPayload {
    @NonNull
    private BigDecimal price;
    private List<WaterConsumer> waterConusmer;
    
}
