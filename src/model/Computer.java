package model;

import java.sql.Date;

public class Computer {

	private int id;
	private String name;
	private Date dateIntroduced;
	private Date dateDiscontinued;
	private int manufacturer;
	
	public Computer(int id, String name, Date dateIntroduced, Date dateDiscontinued, int manufacturer) {
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
	
	@Override
	public String toString() {
		return  name;
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
	
	public Date getDateIntroduced() {
		return this.dateIntroduced;
	}
	
	public void setDateIntroduced(Date d) {
		 this.dateIntroduced = d;
	}
	
	public Date getDateDiscontinued() {
		return this.dateDiscontinued;
	}
	
	public void setDateDiscontinued(Date d) {
		 this.dateDiscontinued = d;
	}
	
	public int getManufacturer() {
		return this.manufacturer;
	}
	
	public void setManufacturer(int n) {
		this.manufacturer = n;
	}
	
	
}
