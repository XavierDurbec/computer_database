package main.java.com.excilys.service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import main.java.com.excilys.model.*;
import main.java.com.excilys.persistence.*;


public class Service {
	
	private ComputerDAO cdao;
	private CompanyDAO company_dao;


	
	public Service() throws SQLException {
		super();
	    
	} 

	public ListComputer getListComputer() throws SQLException {
	    
		cdao = cdao.getInstance();
		ListComputer lc;		
		lc = cdao.selectListComputer();	 
		cdao.closeConnection();
		cdao = null;
		return lc;
	}
	
	public ListCompanies getListCompanies() throws SQLException {
		ListCompanies lc;	
		company_dao =company_dao.getInstance();
		lc = company_dao.selectListCompanies();	 
		company_dao.closeConnection();
		company_dao = null;
		return lc;
	}
	
	public Computer getComputer(int id) throws SQLException {
	    cdao = cdao.getInstance();
		Computer c;		
		c = cdao.selectComputer(id);	
		cdao.closeConnection();
		cdao = null;
		return c;
	}
	
	public Company getCompany(int id) throws SQLException {
		Company c;		
		company_dao =company_dao.getInstance();
		c = company_dao.selectCompany(id);	
		company_dao.closeConnection();
		company_dao = null;
		return c;
	}
	
	public void createComputer(int id,String n,Timestamp d1,Timestamp d2,int c_id) throws SQLException {
		 cdao = cdao.getInstance();
		 cdao.createComputer(id, n, d1, d2, c_id);	
		 cdao.closeConnection();
		 cdao = null;


		
	}
	
	public void updateComputer(int id,String n,Timestamp d1,Timestamp d2,int c_id) throws SQLException {
		 cdao = cdao.getInstance();
		 cdao.UpdateComputer(id, n, d1, d2, c_id);	
		 cdao.closeConnection();
		 cdao = null;


		
	}
	
public void deleteComputer(int id) throws SQLException {
	    cdao = cdao.getInstance();
		cdao.deleteComputer(id);	
		cdao.closeConnection();
		cdao = null;


		
	}
	
	
}
