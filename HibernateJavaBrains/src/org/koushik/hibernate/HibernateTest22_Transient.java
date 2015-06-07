package org.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest22_Transient {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Test User");


		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		user.setUserName("Updated User");
		user.setUserName("Updated User Again");
		session.getTransaction().commit();
		session.close();

	}
}
