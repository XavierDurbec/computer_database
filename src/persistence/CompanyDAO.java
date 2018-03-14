package persistence;

import java.sql.*;

import mapper.MapperClass;

public class CompanyDAO {
	
	private Connection conn;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public CompanyDAO() throws SQLException {
		
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
		
	private void doTest() throws SQLException {
		
		selectListCompany();
		
		if (rs != null) {
			rs.close();
		}
		
		if (st != null) {
			st.close();
		}
					
	}
	
	private void selectListCompany() throws SQLException {
		
		System.out.println("---------Selection de la liste des companies------------");	    
	    String queryListCompany = "SELECT DISTINCT name FROM company";
	        
	    st = conn.createStatement();	 
	    rs = st.executeQuery(queryListCompany);
	    
	    MapperClass m = new MapperClass(rs); 
	    System.out.println(m.createListCompanies());    
	    
	    
	        
	}
		
	public static void main(String args[]) throws SQLException {
		
		new CompanyDAO();
	
}
	
	}
