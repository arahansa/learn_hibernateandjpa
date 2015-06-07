package com.hibernate.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {


	private int personId;
	private String personName;


	private PersonDetail pDetail;


	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="pDetail_FK")
	public PersonDetail getpDetail() {
		return pDetail;
	}
	public void setpDetail(PersonDetail pDetail) {
		this.pDetail = pDetail;
	}

	@Id
	@GeneratedValue
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}


}
