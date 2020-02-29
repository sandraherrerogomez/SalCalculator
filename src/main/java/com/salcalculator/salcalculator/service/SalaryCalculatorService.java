package com.salcalculator.salcalculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salcalculator.salcalculator.model.CountriesAPI;
import com.salcalculator.salcalculator.model.SalaryData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public interface SalaryCalculatorService {
    SalaryData calculateNetSalary(String countryName, double grossAmount) throws Exception;
    List<String> supportedCountries = new ArrayList<>();


}
