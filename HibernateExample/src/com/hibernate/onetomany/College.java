package com.hibernate.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {

	
	private int colledId;
	private String collegeName;
	
	private List<Student> students;
	@Id
	@GeneratedValue
	public int getColledId() {
		return colledId;
	}

	public void setColledId(int colledId) {
		this.colledId = colledId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@OneToMany(targetEntity=Student.class, mappedBy="college", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "College [colledId=" + colledId + ", collegeName=" + collegeName
				+ ", students=" + students + "]";
	}
	
	

	
	

	
	
	
}
