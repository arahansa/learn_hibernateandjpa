package com.hibernate.chapter3_twoandone;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class School {

	private int schoolId;
	private String shcoolName;
	private SchoolDetail schoolDetail;
	
	@Embedded
	public SchoolDetail getSchoolDetail() {
		return schoolDetail;
	}
	public void setSchoolDetail(SchoolDetail schoolDetail) {
		this.schoolDetail = schoolDetail;
	}
	@Id
	@GeneratedValue
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getShcoolName() {
		return shcoolName;
	}
	public void setShcoolName(String shcoolName) {
		this.shcoolName = shcoolName;
	}
	
	
	
}
