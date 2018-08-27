package com.mahendra;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExchangeServiceImpl implements ExchangeService {

	private Map<String, Double> exchangeRates;
	
	@Override
	public double getExchangeRate(String currency) {
		return exchangeRates.get(currency);
	}


	public Map<String, Double> getExchangeRates() {
		return exchangeRates;
	}

	@PostConstruct
	void init() {
		exchangeRates = new HashMap<>();
		exchangeRates.put("INR", 71.20);
		exchangeRates.put("PKR",124.20);
		exchangeRates.put("JY",2.10);
		exchangeRates.put("SGD",1.20);
	}

}
