<%@page import="com.google.common.reflect.TypeToken"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Page d'accueil</title>
<link href="./css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 style="text-align:center">Accueil</h1>
	<nav class="navbar navbar-default">
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="./autoAddService"> Ajouter un automate</a></li>
				<li><a href="./autoListAndUpdateService"> Trouver et éditer un automate</a></li>
				<li><a href="./autoListService"> Lister tous les automates (et éventuellement supprimer)</a></li>
				<li><a href="./tableauDeBord"> Accéder à l'espace de gestion (maintenance)</a></li>
			</ul>
		</div>
	</nav>
<script src="./js/jquery.min.js"></script>    
<script src="./js/bootstrap.min.js"></script>			
</body>
</html>