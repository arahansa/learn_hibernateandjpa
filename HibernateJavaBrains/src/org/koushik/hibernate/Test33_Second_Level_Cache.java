package org.koushik.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Test33_Second_Level_Cache {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println(user);
		session.getTransaction().commit();
		session.close();

		Session session2 = factory.openSession();
		session2.beginTransaction();
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 1);

		session2.getTransaction().commit();
		session2.close();
	}
}
