package com.salcalculator.salcalculator;

import com.salcalculator.salcalculator.model.CountriesAPI;
import com.salcalculator.salcalculator.model.SalaryData;
import com.salcalculator.salcalculator.service.SalaryCalculatorServiceByAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class SalaryCalculatorServiceByAPITest {
    @Autowired
    SalaryCalculatorServiceByAPI svc;
    @Test
    public void testGetCountries() throws IOException {

        CountriesAPI result = svc.getCountries();
        assert(result.getCountries().size() > 0);
        assert(result.getCountries().get(0).getName().equalsIgnoreCase("Spain"));
    }

    @Test
    //Test existing cities with enough data
    public void testCalculateNetSalary() throws Exception {

        double grossSalary = 40000.0;
        SalaryData result = svc.calculateNetSalary("Spain", 40000);

        assert(result.getNetSalary() > 0);
        assert(result.getNetSalary() < result.getGrossSalary());
        assert(result.getGrossSalary() == grossSalary);
    }
}
