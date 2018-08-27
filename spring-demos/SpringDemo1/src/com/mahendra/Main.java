package com.mahendra;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Creating Spring Context");
		ApplicationContext context =
					new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Spring Context has initialized IoC Container");
		System.out.println("Request IoC Container for one bean with ID 'converter'.");
		CurrencyConverter converter = context.getBean("converter",CurrencyConverterImpl.class);
		
		System.out.println("Invoking method");
		double rupees = converter.dollarToRupees(20);
		System.out.println("Amount in rupees : "+rupees);
		
		
	}

}
