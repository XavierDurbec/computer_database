package model;

public class Company {
	
	private int id;
	private String name;
	
	
	public Company(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {

String str =  "Company : id = " + id + " | name = " + name;

return  str;	}



}
