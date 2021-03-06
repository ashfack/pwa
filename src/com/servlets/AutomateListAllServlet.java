package com.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controllers.AutomateController;


/**
 * Servlet implementation class test
 */
@WebServlet("/autoListService")
public class AutomateListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 AutomateController controller = new AutomateController();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomateListAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	System.out.println("Entered doGet list all automates");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		// Appel à l'API Rest pour récupérer tous les automates
		try
		{
			URL url = new URL("http://localhost:8080/automate/cxf/automateservice/automates/");
			URLConnection connection = url.openConnection();
			//connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Accept", "application/json");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String s;
			s=in.readLine();
			if(s == null)
			{
				response.getWriter().append("\n Automate non trouvé");
				this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
			}
			System.out.println("Success to reach the Rest API");
			in.close();
			System.out.println("s retrieved is : " +s);
			s = s.substring(12, s.length()-1);
			System.out.println("s trimed is : " +s);
			request.setAttribute("automates", s);
			this.getServletContext().getRequestDispatcher( "/automateListAll.jsp" ).forward( request, response );
			return;
		}
		catch (Exception e)
		{
			System.out.println("Fail to reach the Rest API " +e.getMessage());
			this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
			return;
		}
		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// To delete automate... need to separate (later)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered doPost list all automates");
		System.out.println(request.getParameter("numSerie"));
		try
		{
			URL url = new URL("http://localhost:8080/automate/cxf/automateservice/automates/delete/"+request.getParameter("numSerie"));
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			// Required in order for this to be a POST Method
			out.write("");
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while (in.readLine() != null){}
			System.out.println("Success to reach the Rest API");
			in.close();
			this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
			return;
		}
		catch (Exception e)
		{
			System.out.println("Fail to reach the Rest API " +e.getMessage());
			this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
			return;
		}
	}
}
