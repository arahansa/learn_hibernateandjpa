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

public class Test31_ProjectionAndQuery {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(5); // Primary Key kept
		exampleUser.setUserName("User :5");
		
		Example example = Example.create(exampleUser);
		Criteria criteria = session.createCriteria(UserDetails.class).add(example);
		//criteria.setProjection(Projections.property("userId"));
		//addOrder(Order.desc("userId"));
		//
		
	
		List<UserDetails> users = criteria.list();
		
		session.getTransaction().commit();
		session.close();

		System.out.println("Size of List Result = " + users.size());
		for (UserDetails userDetails : users) {
			System.out.println(userDetails);
		}

	}
}
