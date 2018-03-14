package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class MapperClass {
	
	private ResultSet rs;
	
	public MapperClass(ResultSet rs) {
		super();
		this.rs = rs;
	}
	
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	
	
	public Computer createObjectComputer() throws SQLException {
		
		int id = rs.getInt("id");
    	String name =  rs.getString("name");
    	Date introduced =  rs.getDate("introduced");
    	Date discontinued =  rs.getDate("discontinued");
    	int company_id = rs.getInt("company_id");
    	
    	Computer c = new Computer(id,name,introduced,discontinued,company_id);	   
    	
    	return c; 
	}
	
	public Company createObjectCompany() throws SQLException {
		
		int id = rs.getInt("id");
    	String name =  rs.getString("name"); 	
    	Company c = new Company(id,name);	   
    	
    	return c; 
	}
	
	public ListComputer createObjectListComputer () throws SQLException {
				
		ListComputer lc = new ListComputer();
		
		  while (rs.next()) {
			  
			 Computer c = createObjectComputer();
			 lc.add(c);			  
			  
		  }
		
		return lc;
		
		
	}
	
	public ListCompanies createObjectListCompanies () throws SQLException {
		
		ListCompanies lc = new ListCompanies();
		
		  while (rs.next()) {
			  
			 Company c = createObjectCompany();
			 lc.add(c);
			  
			  
		  }
		
		return lc;
		
		
	}

	public 	ArrayList<String> createListCompanies() throws SQLException{
		ArrayList<String> list = new ArrayList<String>();
		
		 while (rs.next()) {
			 String name =  rs.getString("name");
			 list.add(name);
		 }
		return list;

	};

}
