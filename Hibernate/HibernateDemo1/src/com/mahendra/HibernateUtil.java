package com.mahendra;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

import org.hibernate.*;

public class HibernateUtil {

	private static SessionFactory factory = build();
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getFactory();
		
		//Connects to Database, Creates Primary Cache
		Session session = factory.openSession();
		// Using HQL to Filter data using Class name instead of Table name
		List<Country> countries = session.createQuery("from Country c").list();
		
		session.clear();
		
		System.out.println("Found countries: "+countries.size());
		/// Use GET method to find by Primary key
		Country country = (Country) session.load(Country.class, "IN");
		System.out.println("Found : "+country.getName());
		
		session.close();
		
	}




	private static SessionFactory build() {
		//Start Reading/Validating hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		return config.buildSessionFactory();
	}

}
