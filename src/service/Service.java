package service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import model.Computer;
import model.ListCompanies;
import model.ListComputer;
import persistence.CompanyDAO;
import persistence.ComputerDAO;

public class Service {
	
	private ComputerDAO cdao;
	private CompanyDAO company_dao;


	
	public Service() throws SQLException {
		super();
	    cdao = cdao.getInstance();
	    company_dao =company_dao.getInstance();

	} 

	public ListComputer getListComputer() throws SQLException {
		ListComputer lc;		
		lc = cdao.selectListComputer();	 	
		return lc;
	}
	
	public ListCompanies getListCompanies() throws SQLException {
		ListCompanies lc;		
		lc = company_dao.selectListCompanies();	 	
		return lc;
	}
	
	public Computer getComputer(int id) throws SQLException {
		Computer c;		
		c = cdao.selectComputer(id);		
		return c;
	}
	
	public void createComputer(int id,String n,Timestamp d1,Timestamp d2,int c_id) throws SQLException {
		
		cdao.createComputer(id, n, d1, d2, c_id);	
		
	}
	
	public void updateComputer(int id,String n,Timestamp d1,Timestamp d2,int c_id) throws SQLException {
		
		cdao.UpdateComputer(id, n, d1, d2, c_id);	
		
	}
	
public void deleteComputer(int id) throws SQLException {
		
		cdao.deleteComputer(id);	
		
	}


	
	
	
	
}
