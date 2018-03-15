package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Computer;
import model.ListComputer;
import persistence.ComputerDAO;

public class Service {
	
	private ListComputer currentListComputer;
	private Computer currentComputer;
	
	public Service() throws SQLException {
		super();
		ComputerDAO cdao = new ComputerDAO();
		currentListComputer = cdao.getLc();
		cdao = null;
	}
	
	public Service(int id) throws SQLException {
		super();
		ComputerDAO cdao = new ComputerDAO();
		setCurrentComputer(id);
		currentListComputer = cdao.getLc();
		cdao = null;
	}

	public ListComputer getCurrentListComputer() {
		return currentListComputer;
	}
	public void setCurrentListComputer(ListComputer lc) {
		this.currentListComputer = lc;
	}
	
	public Computer getCurrentComputer() {
		return currentComputer;
	}

	public void setCurrentComputer(int id) throws SQLException {
		Computer c;
		ComputerDAO cdao = new ComputerDAO(id);
		c = cdao.getC();
		cdao = null;
		this.currentComputer = c;
	}

	public ArrayList<Computer> recupListComputer() throws SQLException {
    	ListComputer lc = new ListComputer();
    	ComputerDAO cdao = new ComputerDAO();
    	lc = cdao.selectListComputer();
    	
		return lc.getListComputer();
	}
	
	
	
	
}
