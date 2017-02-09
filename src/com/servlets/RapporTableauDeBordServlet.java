package com.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.models.Rapport;

/**
 * Servlet implementation class test
 */
@WebServlet("/tableauDeBord")
public class RapporTableauDeBordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RapporTableauDeBordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	System.out.println("Entered doGet Tableau de Bord...");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");

		// Appel à l'API Rest pour récupérer tous les rapports
		try
		{
			URL url = new URL("http://localhost:8080/automate/cxf/rapportservice/rapports/");
			URLConnection connection = url.openConnection();

			connection.setDoInput(true);
			connection.setRequestProperty("Accept", "application/json");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String s;
			s=in.readLine();
			if(s == null)
			{
				response.getWriter().append("\n Rapport non trouvé");
				this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
			}
			System.out.println("Success to reach the Rest API");
			in.close();
			System.out.println("s retrieved is : " +s);
			s = s.substring(12, s.length()-1);
			System.out.println("s trimed is : " +s);
			ObjectMapper mapper = new ObjectMapper();
			Rapport r = mapper.readValue(s, Rapport.class);
			System.out.println(r);
			//request.setAttribute("rapports", s);
			//this.getServletContext().getRequestDispatcher( "/tableauDeBord.jsp" ).forward( request, response );
		    this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
		}
		catch (Exception e)
		{
			System.out.println("Fail to reach the Rest API " +e.getMessage());
			this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Entered doPost Tableau de Bord");		
	}

}
