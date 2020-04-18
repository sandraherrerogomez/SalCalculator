package com.salcalculator.salcalculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salcalculator.salcalculator.model.CountriesAPI;
import com.salcalculator.salcalculator.model.CountryAPIInfo;
import com.salcalculator.salcalculator.model.SalaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Service
public class SalaryCalculatorServiceByAPI implements SalaryCalculatorService {

    @Autowired
    private SalaryComparatorSATParserService salaryAfterTService;

    public CountriesAPI getCountries() throws IOException {
        Resource resource = new ClassPathResource("countriesAPIS.json");

        InputStream file = resource.getInputStream();
        ObjectMapper objMapper=new ObjectMapper();
        return objMapper.readValue(file, CountriesAPI.class);
    }

    @Override
    public SalaryData calculateNetSalary(String userCountryRequest, double salary) throws Exception {

        Resource resource = new ClassPathResource("countriesAPIS.json");

        File file = resource.getFile();
        ObjectMapper objMapper=new ObjectMapper();
        CountriesAPI APIData = objMapper.readValue(file, CountriesAPI.class);

        Optional<CountryAPIInfo> opcionalEntry = APIData.getCountries().stream().filter(c -> c.getName().equalsIgnoreCase(userCountryRequest)).findFirst();

        if(opcionalEntry.isPresent()){
            return salaryAfterTService.getSatData(opcionalEntry.get().getAPI(), userCountryRequest, salary);

        } else {
            throw new IOException();
        }
    }
}
