package com.salcalculator.salcalculator.controller;

import com.salcalculator.salcalculator.model.CountriesAPI;
import com.salcalculator.salcalculator.model.SalaryData;
import com.salcalculator.salcalculator.service.SalaryCalculatorService;
import com.salcalculator.salcalculator.service.SalaryCalculatorServiceByAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SalaryCalculatorController {
    @Autowired
    private SalaryCalculatorServiceByAPI svc;

    @GetMapping("salary")
    public SalaryData getNetSalaryByCountry(@RequestParam String countryName, @RequestParam double grossSalary) throws Exception {
        return svc.calculateNetSalary(countryName, grossSalary);
    }

    @GetMapping("countries")
    public CountriesAPI getCountries() throws Exception {
        return svc.getCountries();

    }

}
