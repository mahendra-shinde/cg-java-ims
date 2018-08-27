package com.mahendra;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Creating Spring Context");
		///Use "AbstractApplicationContext" to be able to
		//Invoke "close" method
		AbstractApplicationContext context =
					new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Spring Context has initialized IoC Container");
		System.out.println("Request IoC Container for one bean with ID 'converter'.");
		
		CurrencyConverter converter = context.getBean("converter",CurrencyConverterImpl.class);
		//When PROTOTYPE scope is Set, every call to getBean
		//creates a new object internally!!
		CurrencyConverter converter2 = context.getBean("converter",CurrencyConverterImpl.class);
		
		System.out.println(converter+" , "+converter2);
		
		System.out.println("Invoking method");
		double rupees = converter.dollarToRupees(20);
		System.out.println("Amount in rupees : "+rupees);
		//Close the context and force all beans to be destroyed!
		context.close();
	}

}
