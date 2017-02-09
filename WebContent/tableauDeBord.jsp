<%@page import="com.models.Erreur"%>
<%@page import="com.models.ARapportProduit"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" import="com.models.Rapport,com.google.gson.Gson" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="rapport" class="com.models.Rapport" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tableau de bord</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/portfolio-item.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
	<%@include file="./header.jsp" %>
   
    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Automates hors service</h3>
            </div>

			<%
	
		Gson gson = new Gson();
		List<Rapport> liste = (List<Rapport>) request.getAttribute("rapports");
		ArrayList<Rapport> automateHS=new ArrayList<Rapport>();
		ArrayList<Rapport> automateESetErreur=new ArrayList<Rapport>();
		ArrayList<Rapport> automateAR=new ArrayList<Rapport>();
		
		Rapport r;
		ARapportProduit aR;
		
		int temperature=(int)request.getAttribute("temperature");
		int seuilJourBoissonChaudes=10, seuilJourBoissonFraiches=10, seuilJourAutre=10;
		if(temperature < 5)
			seuilJourBoissonChaudes*=3;
		else if(temperature>25)
			seuilJourBoissonFraiches*=3;
		//System.out.println("temperature: "+temperature+", seuilBC : "+seuilJourBoissonChaudes+" seuilBF : "+seuilJourBoissonFraiches+", seuilautre: "+seuilJourAutre);
		for(int i = 0; i < liste.size(); i++)
		{
			r=liste.get(i);
			ARapportProduit[] listAR = (ARapportProduit[])r.getARapportProduits().toArray(new ARapportProduit[r.getARapportProduits().size()]);
			for(int j=0;j<listAR.length;j++)
			{
				aR=listAR[j];
			    //System.out.println("produit : "+aR.getProduit().getNom()+" quantite : "+aR.getQuantite());
				if(aR.getProduit().getType().equals("Boisson_chaude") && aR.getQuantite()<seuilJourBoissonChaudes)
				{
					automateAR.add(r);
					break;
				}
				else if(aR.getProduit().getType().equals("Boisson_froide") && aR.getQuantite()<seuilJourBoissonFraiches)
				{
					automateAR.add(r);
					break;
				}
				else if(aR.getQuantite()<seuilJourAutre)
				{
					automateAR.add(r);
					break;
				}
			}
			if(r.getStatutFonctionnement().equals("HS"))
				automateHS.add(r);
			else
			{
				if(!r.getEtat().equals("OK"))
					automateESetErreur.add(r);
			}
		}
		//System.out.println("HS : "+automateHS.size()+" ESERR :"+automateESetErreur.size()+" AR :"+automateAR.size());
		for(int i=0;i<automateHS.size();i++)
		{
		%>	
      
            <div class="col-md-6 col-xs-6">
            		Rapport id : <%=automateHS.get(i).getId().getRapportId()  %> <br/>
           			Numéro de  automate : <%=automateHS.get(i).getAutomate().getNumSerie()  %> <br/>
           			Adresse: <%=automateHS.get(i).getAutomate().getAdresse()  %> <br/>
        			Statut de fonctionnement: <%=automateHS.get(i).getStatutFonctionnement()  %> <br/>
           			Etat :  <%=automateHS.get(i).getEtat()  %> <br/>
           		
		<%
		Erreur[] listER = (Erreur[])automateHS.get(i).getErreurs().toArray(new Erreur[automateHS.get(i).getErreurs().size()]);
			for(int j=0;j<listER.length;j++)
			{
				
		%>
					Erreur <%= j+1%> : <%=listER[j]%>
		<% 
			}
		%>
			</div>
		<%
		}
		%>
        </div>
		<div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Automates en service mais nécessisant une attention particulière</h3>
            </div>
	<%
		for(int i=0;i<automateESetErreur.size();i++)
		{
	%>
			<div class="col-md-6 col-xs-6">
            		Rapport id : <%=automateESetErreur.get(i).getId().getRapportId()  %> <br/>
           			Numéro de  automate : <%=automateESetErreur.get(i).getAutomate().getNumSerie()  %> <br/>
           			Adresse: <%=automateESetErreur.get(i).getAutomate().getAdresse()  %> <br/>
           			Statut de fonctionnement: <%=automateESetErreur.get(i).getStatutFonctionnement()  %> <br/>
           			Etat :  <%=automateESetErreur.get(i).getEtat()  %>
		<%
		Erreur[] listER = (Erreur[])automateESetErreur.get(i).getErreurs().toArray(new Erreur[automateESetErreur.get(i).getErreurs().size()]);
			for(int j=0;j<listER.length;j++)
			{
				
		%>
					Erreur <%= j+1%> : <%=listER[j]%>
		<% 
			}
		%>
			</div>
		<%
		}
		%>
		</div>
		<div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Automates à réapprovisionner</h3>
            </div>
	<%
		for(int i=0;i<automateAR.size();i++)
		{
	%>
			<div class="col-md-6 col-xs-6">
            		Rapport id : <%=automateAR.get(i).getId().getRapportId()  %> <br/>
           			Numéro de  automate : <%=automateAR.get(i).getAutomate().getNumSerie()  %> <br/>
           			Adresse: <%=automateAR.get(i).getAutomate().getAdresse()  %> <br/>
           			Météo: <%= temperature %>°C <br/>
           			Seuil du jour: Boissons chaudes (<%=seuilJourBoissonChaudes %>), Boissons fraiches(<%=seuilJourBoissonFraiches %>), Autre(<%=seuilJourAutre%>) <br/>
        			
		<%
		ARapportProduit[] listAR = (ARapportProduit[])automateAR.get(i).getARapportProduits().toArray(new ARapportProduit[automateAR.get(i).getARapportProduits().size()]);
			for(int j=0;j<listAR.length;j++)
			{
				
		%>
					Produit <%= j+1%> : <%=listAR[j]%>
		<% 
			}
		%>
			</div>
		<%
		}
		%>
		 </div>
        <hr>


    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>