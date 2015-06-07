package com.hibernate.chapter2_oneandtwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure("hibernate.cfg.xml");

		// first arg is Write Log? second is return ?
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		
		Customer alex = new Customer();
		alex.setCustomerName("Alex Rod");
		alex.setCreditScore(780);
		alex.setRewardPoints(12000);
		alex.setCustomerAddress("101 washington st, DC");
		
		session.save(alex);
		session.getTransaction().commit();
	}
}
