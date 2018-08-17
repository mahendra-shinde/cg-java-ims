package com.mahendra;

public class Account {
	private double amount;
	private String name;
	
	public Account(double amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	}

	public void deposit(double amt) {
		amount += amt;
	}
	
	public void withdraw(double amt) {
		amount -= amt;
	}
	
	public double getAmount() {
		return amount;
	}
	
}
