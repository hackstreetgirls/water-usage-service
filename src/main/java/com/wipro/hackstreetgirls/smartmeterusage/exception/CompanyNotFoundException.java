package com.wipro.hackstreetgirls.smartmeterusage.exception;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String companyName){
        super(String.format("Company with name  %s not found", companyName));
    }
}
