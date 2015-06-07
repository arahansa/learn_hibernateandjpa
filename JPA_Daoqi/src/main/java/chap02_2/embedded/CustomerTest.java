package chap02_2.embedded;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.DaoCommonJpa;

public class CustomerTest {

	DaoCommonJpa<Customer> daoCommonJpa = DaoCommonJpa.newInstance(Customer.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		BankInfo bankInfo = new BankInfo();
		bankInfo.setAccoutNumber("1234");
		bankInfo.setBankName("shinhan");
		bankInfo.setRoutingNumber("1111");
		
		Customer customer = new Customer();
		customer.setBank(bankInfo);
		
		daoCommonJpa.save(customer);
		Customer customer2 = daoCommonJpa.find(0);
		System.out.println(customer2);
		assertEquals(1, 1);
		
		
	}

}
