package chap02_3.onetoone;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.DaoCommon;

public class TestOneToOne {

	DaoCommon<Address> daoAddress = new DaoCommon<Address>(Address.class, true);
	DaoCommon<Customer> daoCustomer = new DaoCommon<Customer>(Customer.class, true);
	Address address;
	Customer customer;
	@Before
	public void setUp() throws Exception {
		daoAddress.deleteAllSetTable();
		daoCustomer.deleteAllSetTable();
		address  =  new Address();
		address.setStreet("남구 스트리트");
		address.setZip("444-999");
		
		customer = new Customer();
		customer.setAddress(address);
		customer.setName("arahansa");
	}

	//@Test
	public void 일반검사() {
		daoAddress.insert(address);
		daoCustomer.insert(customer);
		assertEquals(daoCustomer.count(), 1);
		
		daoCustomer.delete(daoCustomer.selectByNum(1));
		assertEquals(daoCustomer.count(), 0);
		//커스터머 부터 지워줘야 한다. 
		daoAddress.delete(daoAddress.selectByNum(1));
		assertEquals(0, daoAddress.count());
	}
	
	@Test
	public void 연관관계검사() throws Exception {
		address.setCustomer(customer);
		customer.setAddress(address);
		daoAddress.insert(address);
		daoCustomer.insert(customer);
		assertEquals(daoAddress.count(), 1);
		assertEquals(daoCustomer.count(), 1);
	}
	
	@Test
	public void 고아삭제검사() throws Exception {
		daoAddress.insert(address);
		daoCustomer.insert(customer);
		
		daoCustomer.delete(daoCustomer.selectByNum(1));
		assertEquals(daoAddress.count(), 0);
		assertEquals(daoCustomer.count(), 0);
	}

}
