package model;

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
		return "ListComputer [computerNumber=" + computerNumber + ", listComputer=" + listComputer + "]";
	}

}
