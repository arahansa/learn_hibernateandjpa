package hbguid.chap04;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyTable implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int myTableId;

	private String userId;

	public int getMyTableId() {
		return myTableId;
	}

	public void setMyTableId(int myTableId) {
		this.myTableId = myTableId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


}
