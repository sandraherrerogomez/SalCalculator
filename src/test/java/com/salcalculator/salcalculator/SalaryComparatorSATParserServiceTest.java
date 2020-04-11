package com.salcalculator.salcalculator;

import com.salcalculator.salcalculator.model.CountriesAPI;
import com.salcalculator.salcalculator.model.SalaryData;
import com.salcalculator.salcalculator.service.SalaryCalculatorServiceByAPI;
import com.salcalculator.salcalculator.service.SalaryComparatorSATParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URL;

@SpringBootTest
public class SalaryComparatorSATParserServiceTest {

        @Autowired
        SalaryComparatorSATParserService svc;
        @Test
        public void testGetSatData() throws Exception {
            String myUrl="https://salaryaftertax.com/es/salary-calculator";

            double grossSalary = 40000.0;

            SalaryData result = svc.getSatData(myUrl, "Spain", grossSalary);
            assert(result.getNetSalary() > 0);
            assert(result.getNetSalary() < result.getGrossSalary());
            assert(result.getGrossSalary() == grossSalary);


        }


}
