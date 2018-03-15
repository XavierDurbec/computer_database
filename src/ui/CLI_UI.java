package ui;

import java.sql.SQLException;
import java.util.Scanner;

public class CLI_UI {
	
	Scanner sc = new Scanner(System.in);
	
	public CLI_UI() throws SQLException  {
		
		  System.out.println("Saisir commande : ");
		  String str = sc.nextLine();
		  
		  switch (str) {
		  
		  case "List computers":    afficherListComputer();
		  			             	break;
		  			             	
		  case "List companies":    afficherListCompanies();
		  			             	break;
		  			             
		  case "Show computer":     showComputer();
			                        break;			             	
		  			             	
		  case "Create computer":   createComputer();
		  							break;
		  							
		  case "Delete computer":   deleteComputer();
	                            	break;
	                            	
		  case "Update computer":   updateComputer();
		                        	break;
		  }
		
	}
	
	public void afficherListComputer() throws SQLException {
		TestPagination testView = new TestPagination();
		testView.setVisible(true);
	}
	
	public void afficherListCompanies() throws SQLException {
	   	
		}
	
    public void showComputer() throws SQLException {
    	System.out.println("Selectionner l'id de l'ordinateur à afficher : ");
    	sc.nextLine();
    	
	}
	
	public void createComputer() throws SQLException {
	   	
	}
	
    public void deleteComputer() throws SQLException {
	   	
	}
    
    public void updateComputer() throws SQLException {
	   	
	}

  public static void main(String[] args) throws SQLException{
		
	      CLI_UI ui = new CLI_UI();
	
		
		  
	  }
	
	
}
