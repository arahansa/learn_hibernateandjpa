package org.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateTest24 {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = factory.openSession();
		session.beginTransaction();

		
		session.createQuery("from UserDetails");		
		
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
	}
}
