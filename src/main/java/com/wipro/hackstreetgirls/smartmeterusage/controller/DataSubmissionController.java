package com.wipro.hackstreetgirls.smartmeterusage.controller;

import java.math.BigDecimal;

import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;
import com.wipro.hackstreetgirls.smartmeterusage.payload.CalculatedDataPayload;
import com.wipro.hackstreetgirls.smartmeterusage.payload.DataSubmissionPayload;
import com.wipro.hackstreetgirls.smartmeterusage.service.CompanyService;

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
    private CompanyService companyService;

   @GetMapping("/test")
    public DataSubmissionPayload test(){
        return new DataSubmissionPayload(new BigDecimal("12.31"), CompanyEnum.THAMES_WATER);
    }

    @PostMapping(value = "/submit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculatedDataPayload> submitForm(@RequestBody DataSubmissionPayload data){
       
        BigDecimal price = companyService.getPrice(data.getCompany());
        CalculatedDataPayload newData = new CalculatedDataPayload(price);

        return new ResponseEntity<CalculatedDataPayload>(newData, HttpStatus.OK);
    }

}
