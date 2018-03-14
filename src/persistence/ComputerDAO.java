package persistence;

import java.sql.*;

import mapper.MapperClass;
import model.ListComputer;
import service.Service;


public class ComputerDAO {
	
	private Connection conn;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private ListComputer lc;


	public ComputerDAO() throws SQLException {
		
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} 
		catch ( ClassNotFoundException e ) 
		{

		}
		
		String url = "jdbc:mysql://localhost:3306/computer-database-db";
		String utilisateur = "admincdb";
		String mdp = "qwerty1234";
			
	    conn = DriverManager.getConnection( url,utilisateur,mdp); 
	   doTest();
	    conn.close();		
	}
		
	public ListComputer getLc() {
		return lc;
	}

	public void setLc(ListComputer lc) {
		this.lc = lc;
	}

	private void doTest() throws SQLException {
		
		
	//	selectListComputer();
		
		//createComputer(64,"MonOrdiKiTU",null,null,5);
	//	selectComputer(64);
	//	UpdateComputer(64,"NouvoOrdiKItu2",null,null,6);
	//	selectComputer(64);
		
		lc = selectListComputer();
		
		if (rs != null) {
			rs.close();
		}
		
		if (st != null) {
			st.close();
		}
					
	}
	
	public ListComputer selectListComputer() throws SQLException {
		
	//	System.out.println("-----------Selection de la liste des computers-------");
	    String queryListComputer = "SELECT * FROM computer";	    
	    
	    st = conn.createStatement();	 
	    rs = st.executeQuery(queryListComputer);	   
	   	     		    	   	
        MapperClass m = new MapperClass(rs); 	    	
	  //  System.out.println(m.createObjectListComputer());   
	    return m.createObjectListComputer();
	}
	
    private void selectComputer(int id) throws SQLException {
		
		System.out.println("----------Info sur un computer-----------");
		String queryComputerInfo = "SELECT * FROM computer WHERE id=?";	    
	    
	    st = conn.createStatement();	 	    
        ps = conn.prepareStatement(queryComputerInfo);
	    
	    ps.setInt(1,id);
	    rs = ps.executeQuery();
    	     		    	   	
        MapperClass m = new MapperClass(rs); 	    	
	    System.out.println(m.createObjectListComputer());    
	}

    private void createComputer(int id,String n,Date d1,Date d2,int c_id) throws SQLException {
    	
		System.out.println("---------Creation d'un computer------------");	    
	    String queryInsertComputer = "INSERT INTO computer (id,name,introduced,discontinued,company_id) VALUES (?,?,?,?,?)";
	    
	    st = conn.createStatement();	 	    
        ps = conn.prepareStatement(queryInsertComputer);
	    
	    ps.setInt(1,id);
	    ps.setString(2,n);
	    ps.setDate(3,d1);
	    ps.setDate(4,d2);
	    ps.setInt(5, c_id);
	    
	    int status = ps.executeUpdate();
	    
	    System.out.println(status); 
    	
    }
    
    private void deleteComputer(int id) throws SQLException {
		
 		System.out.println("----------Suppression d'un computer-----------");
 		String queryDeleteComputer = "DELETE FROM computer WHERE id=?";	    
 	    
 	     st = conn.createStatement();	 	    
         ps = conn.prepareStatement(queryDeleteComputer);
 	    
         ps.setInt(1,id);
         int status = ps.executeUpdate();
     	     		    	  	    	
         System.out.println(status);    
 	}
    
    private void UpdateComputer(int id,String newName,Date d1,Date d2,int c_id) throws SQLException {
    	
  		System.out.println("---------Update d'un computer------------");	    
  	    String queryInsertComputer = "UPDATE computer SET name=?, introduced=?,discontinued=?, company_id=? WHERE id=?";
  	    
  	    st = conn.createStatement();	 	    
        ps = conn.prepareStatement(queryInsertComputer);
        
        ps.setString(1,newName);
  	    ps.setDate(2,d1);
  	    ps.setDate(3,d2);
  	    ps.setInt(4,c_id);
  	    ps.setInt(5, id);
  	    
  	    int status = ps.executeUpdate();
  	    
  	    System.out.println(status); 
      	
      }
    
    
	public static void main(String args[]) throws SQLException {
		
		new ComputerDAO();
	
}
	
	}

