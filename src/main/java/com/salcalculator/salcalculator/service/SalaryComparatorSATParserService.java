package com.salcalculator.salcalculator.service;

import com.salcalculator.salcalculator.model.SalaryData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class SalaryComparatorSATParserService {
    private RestTemplate restTemplate= new RestTemplateBuilder().build();

    public SalaryData getSatData(String URL, String country, Double grossSalary) throws Exception {

        try {
            Document doc = Jsoup.connect(URL).data("grossSalary", grossSalary.toString()).data("payPeriod", "YEARLY").post();

            String netAmount = doc.select(".sat-calculator-value").get(1).childNodes().get(0).toString().substring(3);
            double netSal = Double.parseDouble((netAmount).replace(" ", ""));
            return SalaryData.builder().netSalary(netSal).countryName(country).grossSalary(grossSalary).build();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error querying numbeo at URL: "+URL);
        }

    }
}
