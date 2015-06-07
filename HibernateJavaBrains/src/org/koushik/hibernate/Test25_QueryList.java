package org.koushik.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test25_QueryList {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails where userId > 5"); // hibernateQuery
		List<UserDetails> users = query.list();

		session.getTransaction().commit();
		session.close();

		System.out.println("Size of List Result = " + users.size());
		for (UserDetails userDetails : users) {
			System.out.println(userDetails);
		}

	}
}
