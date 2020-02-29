package com.salcalculator.salcalculator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalaryData {
    private String countryName;
    private double grossSalary;
    private double netSalary;
}
