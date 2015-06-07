package chap02_3.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@OneToOne(cascade=CascadeType.PERSIST, 
			orphanRemoval=true, 
			targetEntity=Address.class)
	//@JoinColumn(referencedColumnName="ADDRESS_ID_PK")
	Address address;
	
	@Id
	@GeneratedValue
	private int id;
	
	

	private String name;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
