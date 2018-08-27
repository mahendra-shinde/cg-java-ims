package com.mahendra;

import java.util.Map;

public class ExchangeServiceImpl implements ExchangeService {

	private Map<String, Double> exchangeRates;
	
	@Override
	public double getExchangeRate(String currency) {
		return exchangeRates.get(currency);
	}


	public Map<String, Double> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(Map<String, Double> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}
	//Custom lifecycle method must be VOID and takes ZERO arguments
	void setup() {
		System.out.println("Custom Init Method");
	}
	
	void tearDown() {
		System.out.println("Custom destroy method!");
	}

}
