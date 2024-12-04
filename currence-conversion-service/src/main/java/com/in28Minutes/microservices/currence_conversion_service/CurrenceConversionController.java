package com.in28Minutes.microservices.currence_conversion_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrenceConversionController {
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrenceConversion calculatorCurrenceConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrenceConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
                , CurrenceConversion.class, uriVariables);
        CurrenceConversion currenceConversion  =responseEntity.getBody();
        return new CurrenceConversion(1000L,from, to, quantity, BigDecimal.ONE, BigDecimal.ONE
                , currenceConversion.getEnvironment());
    }
}
