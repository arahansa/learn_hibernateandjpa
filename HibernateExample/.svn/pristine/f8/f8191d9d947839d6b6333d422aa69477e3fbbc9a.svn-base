package com.hibernate.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		PersonDetail alexDetail = new PersonDetail();
		alexDetail.setZipCode("20815");
		alexDetail.setJob("Accountant");
		alexDetail.setIncome(67245.56);


		Person alex = new Person();
		alex.setPersonName("Alex Berry");
		alex.setpDetail(alexDetail);
		alexDetail.setPerson(alex);
		session.save(alex);

		// no need if we set cascadeType
		//session.save(alexDetail);

		session.getTransaction().commit();
	}
}
