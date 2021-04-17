package com.wipro.hackstreetgirls.smartmeterusage.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.wipro.hackstreetgirls.smartmeterusage.entity.CompanyEntity;
import com.wipro.hackstreetgirls.smartmeterusage.enums.CompanyEnum;
import com.wipro.hackstreetgirls.smartmeterusage.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public BigDecimal getPrice(CompanyEnum company){
        Optional<CompanyEntity> optionalCompany = companyRepository.findByCompany(company);
        if(optionalCompany.isPresent()){
            return optionalCompany.get().getPrice();
        }

        else{
            return new BigDecimal("1.00");
        }
    }
}
