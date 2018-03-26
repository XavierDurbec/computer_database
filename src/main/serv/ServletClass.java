package main.serv;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import main.java.com.excilys.model.Computer;
import main.java.com.excilys.model.ListComputer;
import main.java.com.excilys.service.Service;
import main.java.com.excilys.service.ServiceDB;


public class ServletClass extends HttpServlet {
	
	Service s = new Service();	
	ListComputer lc = s.getListComputer();
    

    ArrayList<Computer> list = lc.getListComputer();

	public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException {
		Service s = new Service();	

		int numcomputer = lc.getListComputer().size();
		request.setAttribute("list",list);	

	request.setAttribute("numComputer",numcomputer);	
    this.getServletContext().getRequestDispatcher( "/WEB-INF/dashboardJSP.jsp" ).forward( request, response );
    
	}

}