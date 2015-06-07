package com.hibernate.compoundkey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestAccount {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Accounts.class);
		config.configure("hibernate.cfg.xml");

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		CompoundKey key1 = new CompoundKey(100, 10001);
		Accounts savings = new Accounts();
		savings.setCompoundKey(key1);
		savings.setAccountBalance(8500);
		
		
		CompoundKey key2 = new CompoundKey(100, 20001);
		Accounts checking = new Accounts();
		checking.setCompoundKey(key2);
		checking.setAccountBalance(2500);
		
		session.save(savings);
		session.save(checking);
		session.getTransaction().commit();
	}
}
