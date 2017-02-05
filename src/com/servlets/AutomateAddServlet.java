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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.models.Automate;

/**
 * Servlet implementation class test
 */
@WebServlet("/autoAddService")
public class AutomateAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutomateAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	System.out.println("Entered doGet test add automate, serving the form...");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher( "/automateAddForm.jsp" ).forward( request, response );
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered doPost test add automate number"+ request.getParameter("num_serie"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed;
		// Reconstruction de l'automate
		Automate automate;
		try 
		{
			parsed = format.parse(request.getParameter("date_intervention"));
			java.sql.Date date_intervention = new java.sql.Date(parsed.getTime());
			automate = new Automate(Integer.parseInt(request.getParameter("num_serie")),
					request.getParameter("type"),
					request.getParameter("adresse"),
					request.getParameter("emplacement"),
					request.getParameter("gps"),
					date_intervention,
					request.getParameter("commentaires")
					);
		} catch (NumberFormatException | ParseException e1) {
			System.out.println(e1.getMessage());
			return;
		}
		System.out.println(automate);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); 
		// Conversion de l'automate en chaine jsonifié
//		String json = "{ \"Automate\":" +gson.toJson(automate)+"}";
		String json = "{ \"Automate\":" +gson.toJson(automate)+"}";
		System.out.println("chaine json dentreee a l'api " + json);
		// Appel à l'API Rest
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
		}
		catch (Exception e)
		{
			System.out.println("Fail to reach the Rest API " +e.getMessage());
		}
		
	}

}
