package com.hibernate.chapter1_basic;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmploy {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");

		// first arg is Write Log? second is return ?
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		{
			Employee alex = new Employee();
			// alex.setEmpId(100);
			alex.setEmpName("Alex Berry");
			alex.setEmpEmailAddress("alex@hibernate.com");
			alex.setEmpJoinDate(new GregorianCalendar(2009, 05, 26));
			alex.setEmpLogintime(Date.valueOf("2010-06-05"));

			session.save(alex);
		}
		{
			Employee linda = new Employee();
			linda.setEmpName("Linda Chase");
			linda.setEmpEmailAddress("linda@hibernate.com");
			linda.setEmpPassword("lindapass");
			linda.setPermanent(true);
			linda.setEmpJoinDate(new GregorianCalendar(2008, 04, 20));
			linda.setEmpLogintime(new java.util.Date());
			session.save(linda);
		}
		{
			Employee john = new Employee();
			john.setEmpName("john");
			john.setEmpEmailAddress("john@hibernate.com");
			john.setEmpPassword("johnpass");
			john.setPermanent(false);
			john.setEmpJoinDate(new GregorianCalendar(2008, 05, 12));
			john.setEmpLogintime(Date.valueOf("2014-02-02"));
			session.save(john);
		}
		session.getTransaction().commit();
	}
}
