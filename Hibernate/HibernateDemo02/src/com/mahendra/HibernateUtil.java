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

	private static SessionFactory build() {
		//Start Reading/Validating hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		return config.buildSessionFactory();
	}

}
