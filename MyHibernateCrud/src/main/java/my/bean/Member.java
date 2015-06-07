package my.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	@GeneratedValue
	private int numMember;

	private String id;
	private String password;
	private Date dateJoin;

	public Member() {
	}

	public int getNumMember() {
		return numMember;
	}
	public void setNumMember(int numMember) {
		this.numMember = numMember;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateJoin() {
		return dateJoin;
	}
	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}
	public Member(String id, String password, Date dateJoin) {
		super();
		this.id = id;
		this.password = password;
		this.dateJoin = dateJoin;
	}
	@Override
	public String toString() {
		return "Member [numMember=" + numMember + ", id=" + id + ", password=" + password + ", dateJoin=" + dateJoin + "]";
	}







}
