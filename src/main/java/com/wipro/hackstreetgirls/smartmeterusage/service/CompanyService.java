package com.wipro.hackstreetgirls.smartmeterusage.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.wipro.hackstreetgirls.smartmeterusage.entity.CompanyEntity;
import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;
import com.wipro.hackstreetgirls.smartmeterusage.exception.CompanyNotFoundException;
import com.wipro.hackstreetgirls.smartmeterusage.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public BigDecimal getWaterCost(CompanyEnum company){
        Optional<CompanyEntity> optionalPrice = companyRepository.findByCompany(company);
        
        if(optionalPrice.isPresent()){
            return optionalPrice.get().getWaterCost();
        }

        else{
            throw new CompanyNotFoundException(company.name());
        }
    }

    public BigDecimal getWastewaterCost(CompanyEnum company){
        Optional<CompanyEntity> optionalPrice = companyRepository.findByCompany(company);
        
        if(optionalPrice.isPresent()){
            return optionalPrice.get().getWastewaterCost();
        }

        else{
            throw new CompanyNotFoundException(company.name());
        }
    }
}
