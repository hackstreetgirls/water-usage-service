package com.wipro.hackstreetgirls.smartmeterusage.exception;

public class ApplianceNotFoundException extends RuntimeException{
    public ApplianceNotFoundException(String applianceName){
        super(String.format("Appliance with name %s not found", applianceName));
    }
}
