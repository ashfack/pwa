<%@page import="com.models.Erreur"%>
<%@page import="com.models.ARapportProduit"%>
<%@page import="java.util.List"%>
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

        <!-- Portfolio Item Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Portfolio Item
                    <small>Item Subheading</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Item Row -->
        <div class="row">

            <div class="col-md-8">
                <img class="img-responsive" src="http://placehold.it/750x500" alt="">
            </div>

            <div class="col-md-4">
                <h3>Project Description</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae. Sed dui lorem, adipiscing in adipiscing et, interdum nec metus. Mauris ultricies, justo eu convallis placerat, felis enim.</p>
                <h3>Project Details</h3>
                <ul>
                    <li>Lorem Ipsum</li>
                    <li>Dolor Sit Amet</li>
                    <li>Consectetur</li>
                    <li>Adipiscing Elit</li>
                </ul>
            </div>

        </div>
        <!-- /.row -->

		
        <!-- Related Projects Row -->
        <div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Related Projects</h3>
            </div>

			<%
			System.out.print("hey 1");
		Gson gson = new Gson();
		List<Rapport> liste = (List<Rapport>) request.getAttribute("rapports");
		System.out.print("hey 2");
		for(int i = 0; i < liste.size(); i++)
		{
			System.out.println("ho ho ho" + i);
		%>	
            <div class="col-sm-3 col-xs-6">
            <%
                if(liste.get(i).getARapportProduits().toArray().length != 0)
           		{
                	System.out.println("I in in A rapport Produits" + i + liste.get(i).getARapportProduits().toArray());
           		%>
           		
                <p><%=((ARapportProduit)liste.get(i).getARapportProduits().toArray()[0]).getQuantite()%></p>
                <%	
           		}
                %>
            </div>
            <div class="col-sm-3 col-xs-6">
                <%
                if(liste.get(i).getErreurs().toArray().length != 0)
           		{
                	System.out.println("I in in Erreurs" + i + liste.get(i).getErreurs().toArray());
           		%>
           			<%= ((Erreur)(liste.get(i).getErreurs().toArray()[0])).getDescription() %>
           		<%	
           		}
                %>
            </div>

	<%
		}
		%>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; PWA - G2</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>