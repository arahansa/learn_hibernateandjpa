package com.hibernate.manytomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TaskEvent {
public static void main(String[] args) {
	AnnotationConfiguration config = new AnnotationConfiguration();
	config.addAnnotatedClass(Delegate.class);
	config.addAnnotatedClass(Event.class);
	config.configure("hibernate.cfg.xml");
	
	new SchemaExport(config).create(true, true);
	
	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	
	Delegate delegate1 = new Delegate();
	delegate1.setDelegateName("Alex Rod");
	Delegate delegate2 = new Delegate();
	delegate2.setDelegateName("Linda Berry");
	Delegate delegate3 = new Delegate();
	delegate3.setDelegateName("James Dean");
	Delegate delegate4 = new Delegate();
	delegate4.setDelegateName("choi");
	
	Event java101 = new Event();
	Event cplus101 = new Event();
	Event math101 = new Event();
	java101.setEventName("Java - 101");
	cplus101.setEventName("C++ - 101");
	math101.setEventName("Math - 101");
	
	java101.getDelegates().add(delegate1);
	java101.getDelegates().add(delegate2);
	java101.getDelegates().add(delegate3);
	
	cplus101.getDelegates().add(delegate2);
	cplus101.getDelegates().add(delegate3);
	math101.getDelegates().add(delegate4);
	
	session.save(delegate1);
	session.save(delegate2);
	session.save(delegate3);
	session.save(delegate4);
	session.save(java101);
	session.save(cplus101);
	session.save(math101);
	session.getTransaction().commit();
}
}
