package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Computer;
import model.ListComputer;
import persistence.ComputerDAO;

public class Service {
	
	private ComputerDAO cdao;

	
	public Service() throws SQLException {
		super();
	    cdao = new ComputerDAO();

	}

	public ListComputer getListComputer() throws SQLException {
		ListComputer lc;		
		lc = cdao.selectListComputer();		
		return lc;
	}
	
	public ListComputer getComputer(int id) throws SQLException {
		ListComputer lc;		
		lc = cdao.selectComputer(id);		
		return lc;
	}
	
	public void createComputer(int id,String n,Date d1,Date d2,int c_id) throws SQLException {
		
		cdao.createComputer(id, n, d1, d2, c_id);	
		
	}


	public ArrayList<Computer> recupListComputer() throws SQLException {
    	ListComputer lc = new ListComputer();
    	ComputerDAO cdao = new ComputerDAO();
    	lc = cdao.selectListComputer();
    	
		return lc.getListComputer();
	}
	
	
	
	
}
