package org.javabrains;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{

	private String StreeringHandle;

	public String getStreeringHandle() {
		return StreeringHandle;
	}

	public void setStreeringHandle(String streeringHandle) {
		StreeringHandle = streeringHandle;
	}
	
	
}
