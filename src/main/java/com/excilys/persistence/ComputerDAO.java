package main.java.com.excilys.persistence;

import java.sql.*;

import main.java.com.excilys.mapper.MapperClass;
import main.java.com.excilys.model.*;
import main.java.com.excilys.service.Service;


public class ComputerDAO {
	
	private ConnexionManager conn;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	private static ComputerDAO INSTANCE = null;
	ListComputer lc = new ListComputer();
 
	
	private String queryListComputer = "SELECT id,name,introduced,discontinued,company_id FROM computer";	    
    private String queryInsertComputer = "INSERT INTO computer (id,name,introduced,discontinued,company_id) VALUES (?,?,?,?,?)";
    private String queryDeleteComputer = "DELETE FROM computer WHERE id=?";	    
    private String queryUpdateComputer = "UPDATE computer SET name=?, introduced=?,discontinued=?, company_id=? WHERE id=?";
	private	String queryComputerInfo = "SELECT name,introduced,discontinued,company_id FROM computer WHERE id=?";	    


	
	private ComputerDAO() throws SQLException {
		conn = conn.getInstance();	
		conn.openConnection();
		lc = selectListComputer();
		conn.closeConnection();
		
	}
	
	public static ComputerDAO getInstance() throws SQLException {
		if(INSTANCE == null) {
			INSTANCE = new ComputerDAO();
		}
		return INSTANCE;
	}


	public ListComputer getLc() {
		return lc;
	}

	public void setLc(ListComputer lc) {
		this.lc = lc;
	}

	public ListComputer selectListComputer() throws SQLException {
		
		ListComputer a;
		System.out.println("-----------Selection de la liste des computers-------");
	    
	    st = conn.getConn().createStatement();	 
	    rs = st.executeQuery(queryListComputer);	    
	   	     		    	   	
        MapperClass m = new MapperClass(rs); 	
        a = m.createObjectListComputer();
	    	 
	    return a;
	}
	
    public Computer selectComputer(int id) throws SQLException {
		
    	Computer c ;
    	System.out.println("----------Info sur un computer-----------");	 
     
	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryComputerInfo);
        ps.setInt(1,id);
	    rs = ps.executeQuery();
        
        MapperClass m = new MapperClass(rs);        
    	c =  m.createObjectComputer(id);         	    	
	    return c; 
	}

    public void createComputer(int id,String name,Timestamp date1,Timestamp date2,int company_id) throws SQLException {
    	
		System.out.println("---------Creation d'un computer------------");	    
	    
	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryInsertComputer);
	    
	    ps.setInt(1,id);
	    ps.setString(2,name);
	    ps.setTimestamp(3,date1);
	    ps.setTimestamp(4,date2);
	    ps.setInt(5, company_id);
	    
	    int status = ps.executeUpdate();
	    
	    System.out.println(status); 
    	
    }
    
    public void deleteComputer(int id) throws SQLException {
		
 		System.out.println("----------Suppression d'un computer-----------");
 	    
 	     st = conn.getConn().createStatement();	 	    
         ps = conn.getConn().prepareStatement(queryDeleteComputer);
 	    
         ps.setInt(1,id);
         int status = ps.executeUpdate();
     	     		    	  	    	
         System.out.println(status);    
 	}
    
    public void UpdateComputer(int id,String newName,Timestamp date1,Timestamp date2,int company_id) throws SQLException {

  		System.out.println("---------Update d'un computer------------");	    
  	    
  	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryUpdateComputer);
        
        ps.setInt(1, id);
        ps.setString(2,newName);
  	    ps.setTimestamp(3,date1);
  	    ps.setTimestamp(4,date2);
  	    ps.setInt(5,company_id);
  	    
  	    
  	    int status = ps.executeUpdate();
  	    
  	    System.out.println(status); 
      	
      }
       
    
    public void closeConnection() throws SQLException {
    	
    	conn.closeConnection();
    }
    
    
	public static void main(String args[]) throws SQLException {
		
		ComputerDAO c = new ComputerDAO();
		c.selectListComputer();

	
}
	
	}

