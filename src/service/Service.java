package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Computer;
import model.ListComputer;
import persistence.ComputerDAO;

public class Service {
	
	private ListComputer lc;
	
	
	
	public Service() throws SQLException {
		super();
		ComputerDAO cdao = new ComputerDAO();
		lc = cdao.getLc();
	}

	public ListComputer getLc() {
		return lc;
	}
	public void setLc(ListComputer lc) {
		this.lc = lc;
	}


	public ArrayList<Computer> recupListComputer() throws SQLException {
    	ListComputer lc = new ListComputer();
    	ComputerDAO cdao = new ComputerDAO();
    	lc = cdao.selectListComputer();
 
		return lc.getListComputer();
	}
	
	
	
	
}
