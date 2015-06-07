package com.hibernate.chapter3_twoandone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(School.class);
		config.configure("hibernate.cfg.xml");

		//new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		SchoolDetail annsDetail = new SchoolDetail();
		annsDetail.setPublicSchool(false);
		annsDetail.setSchoolAddress("101 washington, DC");
		annsDetail.setStudentCount(300);
		
		School stanns = new School();
		stanns.setShcoolName("St. Anns Schhol");
		stanns.setSchoolDetail(annsDetail);
		
		session.save(stanns);
		session.getTransaction().commit();
	}
}
