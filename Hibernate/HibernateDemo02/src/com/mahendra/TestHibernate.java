package com.mahendra;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHibernate {
SessionFactory factory;
Country country;
	@Before
	public void setUp() throws Exception {
		factory = HibernateUtil.getFactory();
		country = new Country();
		country.setCode("ZT");
		country.setName("Jhumritalaiyya");
		country.setRegionId(3); //Transient
	}

	@After
	public void tearDown() throws Exception {
		factory.close();
	}

	@Test
	public void test() {
		Session session = factory.openSession();
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			//Save the new Country!!
			session.save(country); //Persistent
			tn.commit();
		}catch(HibernateException ex) {
			ex.printStackTrace();
			if(tn!=null) {
				tn.rollback();
			}
		}
		session.clear();
		Country temp = (Country) session.get(Country.class, "ZT");
		assertEquals(country.getName(), temp.getName());
		session.close(); //Detached
	}

}
