package com.mahendra;

public class CurrencyConverterImpl implements CurrencyConverter {

	//Before creating parameterized constructor, you must create
	//a default (without parameters) constructor
	public CurrencyConverterImpl() {
		super();
	}

	//Constructor ready for Constructor Injection
	public CurrencyConverterImpl(double exchangeRate) {
		super();
		System.out.println("Using Constructor injection");
		this.exchangeRate = exchangeRate;
	}

	//Dependency 
	private double exchangeRate;
	
	@Override
	public double dollarToRupees(double dollar) {
		return dollar*exchangeRate;
	}


	public double getExchangeRate() {
		return exchangeRate;
	}

	//Setter Injection
	public void setExchangeRate(double exchangeRate) {
		System.out.println("Setter method invoked for assigning exchange rate");
		this.exchangeRate = exchangeRate;
	}

}
