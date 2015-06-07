package org.koushik.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test26_Selec_Page_HQL {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("select userName from UserDetails"); // hibernateQuery
		/*Query query = session.createQuery("select max(userId) from UserDetails"); */
/*		Query query = session.createQuery("select new map(userId, userName) from UserDetails"); // hibernateQuery*/		
		query.setFirstResult(5);
		query.setMaxResults(4);
		List<String>users = query.list();

		session.getTransaction().commit();
		session.close();

		System.out.println("Size of List Result = " + users.size());
		for (String userDetails : users) {
			System.out.println(userDetails);
		}

	}
}
