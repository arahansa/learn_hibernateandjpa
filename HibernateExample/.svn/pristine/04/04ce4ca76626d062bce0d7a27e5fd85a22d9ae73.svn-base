package com.hibernate.onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.sql.Select;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import util.HibernateUtil;

public class TestStudent {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFacWithPackageXml(TestStudent.class);
		Session session = factory.getCurrentSession();
		session.beginTransaction();


		
		
		College college1 = new College();
		college1.setCollegeName("NewYork College");
		College college2 = new College();
		college2.setCollegeName("HyupSung");
		
		
		Student student1 = new Student();
		student1.setStudentName("Alex Rod");
		Student student2 = new Student();
		student2.setStudentName("Linda Berry");

		student1.setCollege(college1);
		student2.setCollege(college1);

		
		session.save(college1);
		session.save(college2);
		session.save(student1);
		session.save(student2);


		session.getTransaction().commit();
		
		Session session2 = factory.getCurrentSession();
		session2.beginTransaction();
		List<Student> students = (List<Student>) session2.createQuery("from Student").list();
		for (Student student : students) {
			System.out.println(student);
		}
		session2.getTransaction().commit();
		
		
	}
}
