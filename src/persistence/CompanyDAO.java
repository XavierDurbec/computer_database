package persistence;

import java.sql.*;

import mapper.MapperClass;
import model.*;
import service.Service;


public class CompanyDAO {
	
	private ConnexionManager conn;
	private Statement st = null;
	private ResultSet rs = null; 
	private PreparedStatement ps = null;
	
	private static CompanyDAO INSTANCE = null;

	
	private String queryListCompanies = "SELECT id,name FROM company";	    
    private String queryInsertCompany = "INSERT INTO comapny (id,name) VALUES (?,?)";
    private String queryDeleteCompany = "DELETE FROM comapany WHERE id=?";	    
    private String queryUpdateCompany = "UPDATE company SET name=? WHERE id=?";
	private	String queryCompanyInfo = "SELECT id,name FROM company WHERE id=?";	    


	
	private CompanyDAO() throws SQLException {
		conn = conn.getInstance();	
	}
	
	public static CompanyDAO getInstance() throws SQLException {
		if(INSTANCE == null) {
			INSTANCE = new CompanyDAO();
		}
		return INSTANCE;
	}


	public ListCompanies selectListCompanies() throws SQLException {
		
		ListCompanies a;
		System.out.println("-----------Selection de la liste des companies-------");
	    
	    st = conn.getConn().createStatement();	 
	    rs = st.executeQuery(queryListCompanies);	   
	   	     		    	   	
        MapperClass m = new MapperClass(rs); 	
        a = m.createObjectListCompanies();
	    	 
	    return a;
	}
	
    public ListCompanies selectComapnies(int id) throws SQLException {
		
    	ListCompanies c ;
    	System.out.println("----------Info sur un Company-----------");	 
     
	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryCompanyInfo);
        ps.setInt(1,id);
	    rs = ps.executeQuery();
        
        MapperClass m = new MapperClass(rs);        
    	c =  m.createObjectListCompanies();    
    	
	    return c; 
	}

    public void createCompany(int id,String name) throws SQLException {
    	
		System.out.println("---------Creation d'un company------------");	    
	    
	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryInsertCompany);
	    
	    ps.setInt(1,id);
	    ps.setString(2,name);
		    
	    int status = ps.executeUpdate();
    
	    System.out.println(status); 
    	
    }
    
    public void deleteCompany(int id) throws SQLException {
		
 		System.out.println("----------Suppression d'un comapany-----------");
 	    
 	     st = conn.getConn().createStatement();	 	    
         ps = conn.getConn().prepareStatement(queryDeleteCompany);
 	    
         ps.setInt(1,id);
       
         int status = ps.executeUpdate();
     	     		    	  	    	
         System.out.println(status);    
 	}
    
    public void UpdateCompany(int id,String newName) throws SQLException {

  		System.out.println("---------Update d'un company------------");	    
  	    
  	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryUpdateCompany);
        
        ps.setInt(1, id);
        ps.setString(2,newName);
   
  	    int status = ps.executeUpdate();
  	    
  	    System.out.println(status); 
      	
      }
       
    
    public void closeConnection() throws SQLException {
    	
    	conn.closeConnection();
    }
    
    
	public static void main(String args[]) throws SQLException {
		
		CompanyDAO c = new CompanyDAO();
	
		System.out.println(c.selectListCompanies());

	
}
	
	}


