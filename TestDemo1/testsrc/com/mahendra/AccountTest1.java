package com.mahendra;
//Import ALL classes and interfaces from junit package
import org.junit.*;
//Import ALL Static members of Assert class
import static org.junit.Assert.*;

public class AccountTest1 {
	//Sample INPUT
	private Account account= null;

	@Before
	public void init() {
		System.out.println("Before each TEST");
		account = new Account(2000, "Babu bhai");
	}
	
	@After
	public void destory() {
		System.out.println("After EACH test!");
		account = null;
	}
	
	
	@Test 
	public void test1() {
		//Invoking the code under TEST
		account.withdraw(1000);
		//Sample (Expected) Output
		assertEquals(1000, account.getAmount(),0.01);
	}
	
	@Test
	public void test2() {
		account.deposit(1000);
		assertEquals(3000, account.getAmount(),0.01);
	}
}
