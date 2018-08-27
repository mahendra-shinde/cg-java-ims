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

}
