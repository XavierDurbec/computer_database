package model;

import java.util.ArrayList;

public class ListCompanies {
	
	private static int companiesNumber;
	private ArrayList<Company> listCompanies;
	
	public ListCompanies() {
		super();
		this.companiesNumber = 0;
		listCompanies = new ArrayList<Company>();
	}
	public ListCompanies(ArrayList<Company> listCompanies) {
		super();
		this.companiesNumber = listCompanies.size();
		this.listCompanies = listCompanies;
	}

	public int getCompaniesNumber() {
		return companiesNumber;
	}
	public ArrayList<Company> getListCompanies() {
		return listCompanies;
	}
	public void setLisiCompanies(ArrayList<Company> listCompanies) {
		this.listCompanies = listCompanies;
	}
	
	public void add(Company c) {
		listCompanies.add(c);
	}
	@Override
	public String toString() {
		return "ListCompanies [companiesNumber=" + companiesNumber + ", lisCompanies=" + listCompanies + "]";
	}

	
}
