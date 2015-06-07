package util;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;

/**
 * @author Deepak Kumar * Web: http://www.roseindia.net 
 * Updated by arahansa@naver.com
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static String configFile = "hibernate.cfg.xml";

	static {
		System.out.println("Hibernate Util Initialized");
		try {
			Configuration cfg = new Configuration().configure(configFile);
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = sb.build();
			sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	// 원래 final 있고 스태틱블록으로 내용이 있었다.
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory(String path) {
		try {
			Configuration cfg = new Configuration().configure(path);
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = sb.build();
			sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
		return sessionFactory;
	}

	//해당 클래스가 있는 위치의 hibernate.cfg.xml파일을 뽑아온다.
	public static SessionFactory getSessionFacWithPackageXml(Class<?> reqClass) {
		return getSessionFactory("/" + reqClass.getPackage().getName().replace('.', '/') + "/" + configFile);
	}

	public static SessionFactory getSessionFacWithPackageXml(Class<?> reqClass, String path) {
		return getSessionFactory("/" + reqClass.getPackage().getName().replace('.', '/') + "/" + path);
	}
	
	public void shutdown(){
		sessionFactory.close();
	}



}