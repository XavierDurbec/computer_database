package com.excilys.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.excilys.model.*;
import com.excilys.service.Service;

public class CLI_UI {
	
	private Service s = new Service();
	Scanner scCommande = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	
	public CLI_UI() throws SQLException  {
		
		  System.out.println("Saisir commande : ");
		  showComputer();
		  int i;
		  i = scCommande.nextInt();
		 // afficherListCompanies();
		//  createComputer(); 
		//  deleteComputer();
		  String str = "";
		  switch (i) {
		  
		  case 1:    afficherListComputer();
		  			             	break;
		  			             	
		  case 2:    afficherListCompanies();
		  			             	break;
		  			             
		  case 3:     showComputer();
			                        break;			             	
		  			             	
		  case 4:      createComputer();
		  							break;
		  							
		  case 5:   deleteComputer();
	                            	break;
	                            	
		  case 6:   updateComputer();
		                        	break;
		  }
		
	}
	 
	public void afficherListComputer() throws SQLException {
		ListComputer c = s.getListComputer();
		System.out.println(c);
	}
	
	public void afficherListCompanies() throws SQLException {
		ListCompanies c = s.getListCompanies();
		System.out.println(c);
		}
	
    public void showComputer() throws SQLException {
    	int id;
    	Computer c ;
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
        s.createComputer(id, "nouvooo", null, null, 5);
        
    	System.out.println("affichage du computer : ");
    	System.out.println(s.getComputer(id));
	}
	
    public void deleteComputer() throws SQLException {
    	System.out.println("Selectionner l'id de l'ordinateur à supprimer : ");
    	int id = sc2.nextInt();    
    	System.out.println(s.getComputer(id));
    	System.out.println("suppression dans la base de donnée ... ");
        s.deleteComputer(id);
    	System.out.println("affichage du computer : ");
    	System.out.println(s.getComputer(id));
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
