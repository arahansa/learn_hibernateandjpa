package hbguid.chap04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyTableTest {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;


	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(MyTable.class);
		config.configure("hibernate.cfg.xml");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		MyTable table = new MyTable();

		session.save(table);
		session.getTransaction().commit();
	}
}
