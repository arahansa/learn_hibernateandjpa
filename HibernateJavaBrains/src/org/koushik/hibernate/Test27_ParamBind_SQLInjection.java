package org.koushik.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test27_ParamBind_SQLInjection {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

/*		int minUserId  = 5;*/
		/*String minUserId  = " 5 or 1=1";*/
		String minUserId = "5";
		String userName = "User :9";
/*		Query query = session.createQuery("from UserDetails where userId > ? and userName = ?");*/
		/*query.setInteger(0, Integer.parseInt(minUserId)).setString(1, userName);*/
		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName");
		query.setInteger("userId", Integer.parseInt(minUserId)).setString("userName", userName);
		
		
		List<UserDetails> users = query.list();

		session.getTransaction().commit();
		session.close();

		System.out.println("Size of List Result = " + users.size());
		for (UserDetails userDetails : users) {
			System.out.println(userDetails);
		}

	}
}
