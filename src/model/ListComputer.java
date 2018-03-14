package model;

import java.util.ArrayList;

public class ListComputer {
	
	private int computerNumber;
	private ArrayList<Computer> listComputer;
	
	public ListComputer() {
		computerNumber = 0;
		listComputer = new ArrayList<Computer>();
	}

	
	
	@Override
	public String toString() {
		return "ListComputer [computerNumber=" + computerNumber + ", listComputer=" + listComputer + "]";
	}



	public ListComputer(ArrayList<Computer> listComputer) {
		super();
		int computerNumber = listComputer.size();
		this.computerNumber = computerNumber;
		this.listComputer = listComputer;
	}

	public void add(Computer c) {
		computerNumber++;
		listComputer.add(c);
	}

	public int getComputerNumber() {
		return computerNumber;
	}

	public void setComputerNumber(int computerNumber) {
		this.computerNumber = computerNumber;
	}

	public ArrayList<Computer> getListComputer() {
		return listComputer;
	}

	public void setListComputer(ArrayList<Computer> listComputer) {
		this.listComputer = listComputer;
	}
	
	
	

}
