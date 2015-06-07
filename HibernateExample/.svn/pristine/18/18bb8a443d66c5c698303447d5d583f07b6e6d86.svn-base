package com.hibernate.chapter1_basic;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity

@Table(name = "EmployeeInfo")
public class Employee {
	// Bean Rule. 1. private, get&set 2.no constructor
	private int empId;
	private String empName;

	private String empPassword;
	private String empEmailAddress;
	private boolean isPermanent;
	private Calendar empJoinDate; //Date 로 들어간다.
	private Date empLogintime; //TimeStamp

	@Transient
	// 이건 안하겠다는 거군.
	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Column(nullable = false)
	public String getEmpEmailAddress() {
		return empEmailAddress;
	}

	public void setEmpEmailAddress(String empEmailAddress) {
		this.empEmailAddress = empEmailAddress;
	}


	// TODD . Basic 알아야 한다.
	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getEmpJoinDate() {
		return empJoinDate;
	}

	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEmpLogintime() {
		return empLogintime;
	}

	public void setEmpLogintime(Date empLogintime) {
		this.empLogintime = empLogintime;
	}

	@Id
	// Primary Key
	@TableGenerator(name = "empid", table = "emppktb", pkColumnName = "empkey", pkColumnValue = "empvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "empid")
	@Column(name = "EmployeeId")
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
