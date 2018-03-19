package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnexionManager {

	private Connection conn;
	private String url = "jdbc:mysql://localhost:3306/computer-database-db";
	private String utilisateur = "admincdb";
	private String mdp = "qwerty1234";
	
	private static ConnexionManager INSTANCE = null;
	
	private ConnexionManager() throws SQLException {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} 
		catch ( ClassNotFoundException e ) 
		{
 
		}	
	
	}
	
	public static ConnexionManager getInstance() throws SQLException {
		if(INSTANCE == null) {
			INSTANCE = new ConnexionManager();
		}
		return INSTANCE;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	public void Connection() throws SQLException {
		conn = DriverManager.getConnection( url,utilisateur,mdp); 
	}
	
	public void closeConnection() throws SQLException {
		this.conn.close();
	}
	
	public void openConnection() throws SQLException {
		conn = DriverManager.getConnection( url,utilisateur,mdp); 
	}
}
