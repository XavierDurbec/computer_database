package main.java.com.excilys.DTO;

import java.sql.Timestamp;

import main.java.com.excilys.model.Computer;

public class ComputerDTO {

	private int id; 
	private String name;
	private String dateIntroduced;
	private String dateDiscontinued;
	private String company;
	
	public ComputerDTO(Computer c) {
		super();
		this.id = c.getId();
		this.name = c.getName();
		this.dateIntroduced = "";
		this.dateDiscontinued = "";
		this.company ="" ;
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
	public String getDateIntroduced() {
		return this.dateIntroduced;
	}
	public void setDateIntroduced(String d) {
		 this.dateIntroduced = d;
	}
	public String getDateDiscontinued() {
		return this.dateDiscontinued;
	}	
	public void setDateDiscontinued(String d) {
		 this.dateDiscontinued = d;
	}
	public String getManufacturer() {
		return this.company;
	}	
	public void setManufacturer(String n) {
		this.company = n;
	}
	
	@Override
	public String toString() {
		
		String str =  "Computer : id = " + id + " | name = " + name;
		
		return  str;
	}
	
}