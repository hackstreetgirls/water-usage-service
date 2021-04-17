package com.wipro.hackstreetgirls.smartmeterusage.payload;

import java.math.BigDecimal;

import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;

import lombok.Data;
import lombok.NonNull;

@Data
public class DataSubmissionPayload {
    @NonNull
    private BigDecimal monthlyUsage;
    @NonNull
    private CompanyEnum company;
}
