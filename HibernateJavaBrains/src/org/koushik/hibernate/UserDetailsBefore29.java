package org.koushik.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.OnDelete;

@Entity
@NamedQuery(name="UserDetails.byId", query="from UserDetails where userId = ?")
@NamedNativeQuery(name="UserDetails.byName", query="select * from TESTSCHEMA2.USERDETAILS where userName= ?", resultClass=UserDetailsBefore29.class)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetailsBefore29 {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
	
	
	
}
