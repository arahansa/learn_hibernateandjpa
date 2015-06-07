package chap02_2.secondarytable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Properties;

import javassist.expr.NewArray;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpaTestPU");

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); 
		em.persist(new Book("hello".getBytes()));
		em.getTransaction().commit(); 
		em.close(); 
		
		
		
		assertEquals(1, 1);
	}

}
