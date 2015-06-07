package org.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest_CRUD_21 {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(UserDetails.class);
		config.configure("hibernate.cfg.xml");

		//new SchemaExport(config).create(true, true);
		//session = factory.opensession();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		/*for(int i=0;i<10;i++){
			UserDetails user = new UserDetails();
			user.setUserName("User "+i);
			session.save(user);
		}*/

		UserDetails user =  (UserDetails) session.get(UserDetails.class, 5);
		user.setUserName("Updated User");
		session.update(user);

		/*session.delete(user);*/



		session.getTransaction().commit();

	}
}
