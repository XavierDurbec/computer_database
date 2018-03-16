package ui;

import java.sql.SQLException;
import java.util.Scanner;

import model.Computer;
import model.ListComputer;
import service.Service;

public class CLI_UI {
	
	private Service s = new Service();
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	
	public CLI_UI() throws SQLException  {
		
		  System.out.println("Saisir commande : ");
		  updateComputer();
	// String str = sc.nextLine();
		  String str = "";
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
		ListComputer c = s.getListComputer();
		System.out.println(c);
	}
	
	public void afficherListCompanies() throws SQLException {
	   	
		}
	
    public void showComputer() throws SQLException {
    	int id;
    	ListComputer c ;
    	System.out.println("Selectionner l'id de l'ordinateur à afficher : ");
    	id = sc2.nextInt();
    	System.out.println("Recherche dans la base de donnée ... ");
        c =  s.getComputer(id);
    	System.out.println("affichage du computer : ");
    	System.out.println(c);


   	
	}
	
	public void createComputer() throws SQLException {
	
    	System.out.println("Selectionner l'id de l'ordinateur à creer : ");
    	int id = sc2.nextInt();    
    	System.out.println("creation dans la base de donnée ... ");


    	System.out.println("creation dans la base de donnée ... ");
        s.createComputer(id, "nouvooo", null, null, 5);
    	System.out.println("affichage du computer : ");
    	System.out.println(s.getComputer(id));
	}
	
    public void deleteComputer() throws SQLException {
	   	
	}
    
    public void updateComputer() throws SQLException {
       	System.out.println("Selectionner l'id de l'ordinateur à changer : ");
    	int id = sc2.nextInt();    
    	System.out.println("update dans la base de donnée ... ");
    	System.out.println(s.getComputer(id));
        s.updateComputer(id, "nouvvo22", null, null, 5);
    	System.out.println("affichage du computer : ");
    	System.out.println(s.getComputer(id));
	}

  public static void main(String[] args) throws SQLException{
		
	      CLI_UI ui = new CLI_UI();
	
		
		  
	  }
	
	
}
