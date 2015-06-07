package org.javabrains;

import javax.persistence.Entity;

@Entity
/*@DiscriminatorValue("Car")*/
public class FourWheeler extends Vehicle{

	private String StreeringWheel;

	public String getStreeringWheel() {
		return StreeringWheel;
	}

	public void setStreeringWheel(String streeringWheel) {
		StreeringWheel = streeringWheel;
	}
	
	
	
}
