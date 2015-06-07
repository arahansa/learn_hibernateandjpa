package org.koushik.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sun.security.util.Length;

public class Test29_Criteria {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();



		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.gt("userId", 5));
		criteria.add(Restrictions.like("title", "searchWord", MatchMode.ANYWHERE).ignoreCase());
		criteria.setProjection(Projections.property("title"));


		/*Disjunction any = Restrictions.disjunction();
		any.add(Restrictions.le("playTime", args));
		any.add(Restrictions.like("title", "%A%"));
		criteria.add(any);*/

		List<UserDetails> users = criteria.list();

		session.getTransaction().commit();
		session.close();

		System.out.println("Size of List Result = " + users.size());
		for (UserDetails userDetails : users) {
			System.out.println(userDetails);
		}

	}
}
