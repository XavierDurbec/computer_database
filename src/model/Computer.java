package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Computer {

	private int id;
	private String name;
	private Timestamp dateIntroduced;
	private Timestamp dateDiscontinued;
	private int manufacturer;
	
	public Computer(int id, String name, Timestamp dateIntroduced, Timestamp dateDiscontinued, int manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.dateIntroduced = dateIntroduced;
		this.dateDiscontinued = dateDiscontinued;
		this.manufacturer = manufacturer;
	}
	public Computer() {
		name = null;
		manufacturer = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getName() {
		return this.name;
	}
	public void setName(String n) {
		this.name = n;
	}	
	public Timestamp getDateIntroduced() {
		return this.dateIntroduced;
	}
	public void setDateIntroduced(Timestamp d) {
		 this.dateIntroduced = d;
	}
	public Timestamp getDateDiscontinued() {
		return this.dateDiscontinued;
	}	
	public void setDateDiscontinued(Timestamp d) {
		 this.dateDiscontinued = d;
	}
	public int getManufacturer() {
		return this.manufacturer;
	}	
	public void setManufacturer(int n) {
		this.manufacturer = n;
	}
	
	@Override
	public String toString() {
		return  name;
	}
	
}
