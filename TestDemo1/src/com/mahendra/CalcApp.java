package com.mahendra;

public class CalcApp {
	private CalculatorService service;
	
	public void setCalculatorService(CalculatorService service) {
		this.service = service;
	}
	
	public double doAdd(double n1, double n2) {
		return service.add(n1, n2);
	}
}
