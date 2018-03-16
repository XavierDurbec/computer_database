package persistence;

import java.sql.*;

import mapper.MapperClass;
import model.*;
import service.Service;


public class ComputerDAO {
	
	private ConnexionManager conn;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	
	private String queryListComputer = "SELECT * FROM computer";	    
    private String queryInsertComputer = "INSERT INTO computer (id,name,introduced,discontinued,company_id) VALUES (?,?,?,?,?)";
    private String queryDeleteComputer = "DELETE FROM computer WHERE id=?";	    
    private String queryUpdateComputer = "UPDATE computer SET name=?, introduced=?,discontinued=?, company_id=? WHERE id=?";
	private	String queryComputerInfo = "SELECT * FROM computer WHERE id=?";	    


	
	public ComputerDAO() throws SQLException {
		conn = new ConnexionManager();	
	}

	public ListComputer selectListComputer() throws SQLException {
		
		ListComputer a;
		System.out.println("-----------Selection de la liste des computers-------");
	    
	    st = conn.getConn().createStatement();	 
	    rs = st.executeQuery(queryListComputer);	   
	   	     		    	   	
        MapperClass m = new MapperClass(rs); 	
        a = m.createObjectListComputer();
    	System.out.println(a);	
	    	 
	    return a;
	}
	
    public ListComputer selectComputer(int id) throws SQLException {
		
    	ListComputer c ;
    	System.out.println("----------Info sur un computer-----------");	
     
	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryComputerInfo);
        ps.setInt(1,id);
	    rs = ps.executeQuery();
        
        MapperClass m = new MapperClass(rs);        
    	c =  m.createObjectListComputer();         	    	
	    return c; 
	}

    public void createComputer(int id,String n,Date d1,Date d2,int c_id) throws SQLException {
    	
		System.out.println("---------Creation d'un computer------------");	    
	    
	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryInsertComputer);
	    
	    ps.setInt(1,id);
	    ps.setString(2,n);
	    ps.setDate(3,d1);
	    ps.setDate(4,d2);
	    ps.setInt(5, c_id);
	    
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
    
    public void UpdateComputer(int id,String newName,Date d1,Date d2,int c_id) throws SQLException {

  		System.out.println("---------Update d'un computer------------");	    
  	    
  	    st = conn.getConn().createStatement();	 	    
        ps = conn.getConn().prepareStatement(queryUpdateComputer);
        
        ps.setString(1,newName);
  	    ps.setDate(2,d1);
  	    ps.setDate(3,d2);
  	    ps.setInt(4,c_id);
  	    ps.setInt(5, id);
  	    
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

