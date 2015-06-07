package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 참조 http://www.objectdb.com/java/jpa/tool
 * @author arahansa
 * @param <T>
 */
public class DaoCommonJpa<T> {

	EntityManagerFactory emf;
	Class<?> clazz;
	
	public static <T> DaoCommonJpa<T> newInstance(Class<?> clazz){
		return new DaoCommonJpa<T>(clazz);
	}
	
	public DaoCommonJpa(Class<?> clazz) {
		this.clazz= clazz;
		emf= Persistence.createEntityManagerFactory("jpaTestPU");
	}
	
	public void save(T member){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); 
		em.persist(member);
		em.getTransaction().commit(); 
		em.close(); 
	}
	
	public T find(int i){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); 
		T member = (T) em.find(clazz, i);
		// Lazy Version -> em.getReference(Employee.class, 1);
		em.getTransaction().commit(); 
		em.close();
		return member; 
	}
	
	
	
}
