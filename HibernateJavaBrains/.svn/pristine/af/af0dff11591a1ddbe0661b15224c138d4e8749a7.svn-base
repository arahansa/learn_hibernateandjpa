package org.javabrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateTest {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setStreeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setStreeringWheel("Porsche Streering Wheel");
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Vehicle.class);
		config.addAnnotatedClass(TwoWheeler.class);
		config.addAnnotatedClass(FourWheeler.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
	}
}
