package com.excilys.model;

import java.util.ArrayList;

public class ListComputer {
	
	private static int computerNumber;
	private ArrayList<Computer> listComputer;
	
	public ListComputer() {
		computerNumber = 0;
		listComputer = new ArrayList<Computer>();
	}
	public ListComputer(ArrayList<Computer> listComputer) {
		super();
		int computerNumber = listComputer.size();
		this.computerNumber = computerNumber;
		this.listComputer = listComputer;
	}

	public int getComputerNumber() {
		return computerNumber;
	}
	public ArrayList<Computer> getListComputer() {
		return listComputer;
	}
	public void setListComputer(ArrayList<Computer> listComputer) {
		this.listComputer = listComputer;
	}
	
	public void add(Computer c) {
		computerNumber++;
		listComputer.add(c); 
	}
	
	@Override
	public String toString() {
		
		String str = ""; 
		
		for(int i = 0 ;i< this.getListComputer().size();i++) {
			str = str.concat( this.getListComputer().get(i).toString() );
			str = str.concat("\n");
		}
		
		return str;
				
				

		
	}

}
