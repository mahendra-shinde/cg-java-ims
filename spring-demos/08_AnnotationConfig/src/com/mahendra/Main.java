package com.mahendra;

import javax.swing.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.mahendra")
public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		
		System.out.println("Spring Context has initialized IoC Container");
		System.out.println("Request IoC Container for one bean with ID 'converter'.");
		CurrencyConverter converter = context.getBean("converter",CurrencyConverterImpl.class);
		
		System.out.println("Invoking method");
		double rupees = converter.dollarToRupees(20);
		System.out.println("Amount in rupees : "+rupees);
		
	}

}
