package com.in28Minutes.microservices.currence_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currence-exchange", url= "localhost:8000")
//@FeignClient(name = "currence-exchange")
public interface CurrenceExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrenceConversion retrieveExchangeValue(
			@PathVariable("from") String from,
			@PathVariable("to") String to);
}
