package com.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
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
		String s = null;
		// First network check
		try
		{
			URL url = new URL("http://localhost:8080/automate/cxf/rapportservice/rapports/");
			URLConnection connection = url.openConnection();

			connection.setDoInput(true);
			connection.setRequestProperty("Accept", "application/json");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			s=in.readLine();
			if(s == null)
			{
				response.getWriter().append("\n Rapport non trouvé");
				this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
			}
			System.out.println("Success to reach the Rest API");
			in.close();
			//System.out.println("s retrieved is : " +s);
		}
		catch (Exception e)
		{
			System.out.println(e.getClass());
			System.out.println("Fail to reach the Rest API " +e.getMessage());
			this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
			return;
		}
		// Iterating through rapports
		try
		{
			ArrayList<Rapport> rapports = new ArrayList<Rapport>();
			JSONObject json = new JSONObject(s);
			JSONArray array = json.getJSONArray("Rapport");
			Gson gson = new Gson();
			for (int i = 0; i < array.length(); i++) 
			{
				System.out.println(array.getJSONObject(i));
				Object objARapportProduits = null;
				Object objerreurs = null;
				// recovering ARapportProduits if exist and casting them properly
				try
				{
					objARapportProduits = array.getJSONObject(i).get("ARapportProduits");
					if( objARapportProduits != null)
					{
						System.out.println(objARapportProduits);
						if(objARapportProduits instanceof JSONObject)
						{
							System.out.println("Coucou object");
							JSONArray jsonArray = new JSONArray();
							jsonArray.put(objARapportProduits);
							System.out.println("ARapportProduits jsonArray" + jsonArray);
		
							array.getJSONObject(i).remove("ARapportProduits");
							array.getJSONObject(i).put("ARapportProduits", jsonArray);
							System.out.println("array changed" + array.getJSONObject(i));
						}
					}
		
				}
				catch(JSONException e)
				{
					
				}
				// recovering erreurs if exist and casting them properly
				try
				{
					objerreurs = array.getJSONObject(i).get("erreurs");
					if( objerreurs != null)
					{
						System.out.println(objerreurs);
						if(objerreurs instanceof JSONObject)
						{
							JSONArray jsonArray = new JSONArray();
							jsonArray.put(objerreurs);
							System.out.println("erreurs jsonArray" + jsonArray);
		
							array.getJSONObject(i).remove("erreurs");
							array.getJSONObject(i).put("erreurs", jsonArray);
							System.out.println("array changed" + array.getJSONObject(i));
						}
					}
				}
				catch(JSONException e)
				{
					
				}
				// In anycase, now we have the proper attributes (empty or not), we create the report and we add it
				Rapport rapport = gson.fromJson(array.getJSONObject(i).toString(), Rapport.class);
				System.out.println(rapport);
				rapports.add(rapport);
			}
			
			request.setAttribute("temperature", 2);
			request.setAttribute("rapports", rapports);
			this.getServletContext().getRequestDispatcher( "/tableauDeBord.jsp" ).forward( request, response );
			return;
		}
		catch(Exception e)
		{
			this.getServletContext().getRequestDispatcher( "/erreur.jsp" ).forward( request, response );
			return;
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
