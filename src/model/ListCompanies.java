package model;

import java.util.ArrayList;

public class ListCompanies {
	
	private int companiesNumber;
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

	public void add(Company c) {
		listCompanies.add(c);
	}

	@Override
	public String toString() {
		return "ListCompanies [companiesNumber=" + companiesNumber + ", lisCompanies=" + listCompanies + "]";
	}

	public int getCompaniesNumber() {
		return companiesNumber;
	}

	public void setCompaniesNumber(int companiesNumber) {
		this.companiesNumber = companiesNumber;
	}

	public ArrayList<Company> getLisCompanies() {
		return listCompanies;
	}

	public void setLisCompanies(ArrayList<Company> listCompanies) {
		this.listCompanies = listCompanies;
	}





	
	

}
