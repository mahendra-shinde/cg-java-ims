package com.mahendra;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

public class Main {

	public static void main(String[] args) {
		System.out.println("Creating Spring Context");
		ApplicationContext context =
					new ClassPathXmlApplicationContext("spring.xml");
		
		MessageSource source = (MessageSource)context.getBean("bundle");
		Locale current = Locale.FRANCE;
		String msg = source.getMessage("greet", new String[]{"mahendra"}, current);
		System.out.println("Message from france: "+msg);
	}

}
