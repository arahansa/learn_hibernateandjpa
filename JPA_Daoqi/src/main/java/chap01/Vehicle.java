package chap01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "VEHICLE")
@NamedQuery(name="selectVehicleByMake", query="SELECT v FROM Vehicle v WHERE v.make = ?1")
public class Vehicle {
	@Id
	@Column(name = "VIN")
	protected String vin;

	@Column(name = "MAKE")
	protected String make;

	protected String model;

	@Version
	protected int version;

	@Column(name = "MODEL_YEAR")
	protected int year;

	public Vehicle() { }
	
	public Vehicle(String vin) {
		super();
		this.vin = vin;
	}

	public Vehicle(String vin, String make, String model, int year) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getVin() {
		return this.vin;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int modelYear) {
		this.year = modelYear;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}

