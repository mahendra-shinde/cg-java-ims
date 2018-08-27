package com.mahendra;

public class CurrencyConverterImpl implements CurrencyConverter {

	//Before creating parameterized constructor, you must create
	//a default (without parameters) constructor
	public CurrencyConverterImpl() {
		super();
	}

	//Constructor ready for Constructor Injection
	public CurrencyConverterImpl(ExchangeService service) {
		super();
		System.out.println("Using Constructor injection");
		this.service = service;
	}

	//Dependency 
	private ExchangeService service;

	@Override
	public double dollarToRupees(double dollar) {
		// TODO Auto-generated method stub
		return dollar * service.getExchangeRate("INR");
	}

	public void setService(ExchangeService service) {
		this.service = service;
	}

}
