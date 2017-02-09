package com.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controllers.AutomateController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.models.Automate;

/**
 * Servlet implementation class test
 */
@WebServlet("/autoListAndUpdateService")
public class AutomateListAndUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 AutomateController controller = new AutomateController();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomateListAndUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
    	System.out.println("Entered doGet list one automate");
    	System.out.println(request.getParameter("id"));
    	if (request.getParameter("id") == null)
    	{
			this.getServletContext().getRequestDispatcher( "/automateListAndUpdate.jsp" ).forward( request, response );
    	}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		try
		{
			URL url = new URL("http://localhost:8080/automate/cxf/automateservice/automates/"+request.getParameter("id"));
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
				return;
			}
			System.out.println("Success to reach the Rest API");
			in.close();
			System.out.println("s is : " +s);
			s = s.substring(12, s.length()-1);
			System.out.println("s trimed is : " +s);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			Automate automate = gson.fromJson(s, Automate.class);
			System.out.println("object that is going to be set" + automate);
			request.setAttribute("automate", automate);
			this.getServletContext().getRequestDispatcher( "/automateListAndUpdate.jsp" ).forward( request, response );
		}
		catch (Exception e)
		{
			System.out.println("Fail to reach the Rest API " +e.getMessage());
			this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
		}
		
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered doPost list one automate"+ request.getParameter("numSerie"));
		System.out.println(request.getParameter("dateIntervention"));
		Automate automate;
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
		Date parsed;
		// Rebuilding automate from parameters
		try 
		{
			parsed = format.parse(request.getParameter("dateIntervention"));
			java.sql.Date date_intervention = new java.sql.Date(parsed.getTime());
			automate = new Automate(Integer.parseInt(request.getParameter("numSerie")),
					request.getParameter("type"),
					request.getParameter("adresse"),
					request.getParameter("emplacement"),
					request.getParameter("gps"),
					date_intervention,
					request.getParameter("commentaires")
					);
		} catch (NumberFormatException | ParseException e1) {
			e1.printStackTrace();
			System.out.println("first fail " + e1.getMessage());
			return;
		}
		System.out.println("ready to update : " +automate);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); 
		// Conversion en string jsonifie
		String json = "{ \"Automate\":" +gson.toJson(automate)+"}";
		// Appel à l'API Rest pour mettre à jour
		
		// We could also might have build the json String manually...
		try
		{
			URL url = new URL("http://localhost:8080/automate/cxf/automateservice/automates/add");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-type", "application/json");
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(json);
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while (in.readLine() != null){}
			System.out.println("Success to reach the Rest API");
			in.close();
			this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
		}
		catch (Exception e)
		{
			System.out.println("Fail to reach the Rest API " +e.getMessage());
			this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
		} 

	}
}
