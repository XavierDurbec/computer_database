package com.excilys.model;

import java.sql.Timestamp;

public class Computer {

	private int id; 
	private String name;
	private Timestamp dateIntroduced;
	private Timestamp dateDiscontinued;
	private Company company;
	
	public Computer(int id, String name, Timestamp dateIntroduced, Timestamp dateDiscontinued, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.dateIntroduced = dateIntroduced;
		this.dateDiscontinued = dateDiscontinued;
		this.company = company;
	}
	
	public Computer(int id, String name, Timestamp dateIntroduced, Timestamp dateDiscontinued, int company_id) {
		super();
		this.id = id;
		this.name = name;
		this.dateIntroduced = dateIntroduced;
		this.dateDiscontinued = dateDiscontinued;
		
		Company company = new Company(company_id,"");
		
		this.company = company;
	}
	
	public Computer() {

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
	public Company getManufacturer() {
		return this.company;
	}	
	public void setManufacturer(Company n) {
		this.company = n;
	}
	
	@Override
	public String toString() {
		
		String str =  "Computer : id = " + id + " | name = " + name;
		
		return  str;
	}
	
}
