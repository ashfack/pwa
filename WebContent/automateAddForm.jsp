<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="automate" class="com.models.Automate" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Formulaire d'ajout d'automate</title>
	<link href="./css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="./header.jsp" %>
	<h1 style="text-align:center"> Ajout d'un automate</h1>
	<form:form method="POST" action="./autoAddService" modelAttribute="automate" >
		<div class="row">
		    <br/>
		    <form:label class="col-md-2" path="numSerie">Numero de serie</form:label>
		    <form:input class="col-md-2" path="numSerie" value="0"/>
	    </div>
	    <div class="row">
		    <form:label class="col-md-2" path="type">Type</form:label>
		    <form:input class="col-md-2" path="type" /> 
	    </div>
	    <div class="row">
		    <form:label class="col-md-2" path="adresse">Adresse</form:label>
		    <form:input class="col-md-2" path="adresse" />
	    </div> 
	    <div class="row">
		    <form:label class="col-md-2" path="emplacement">Emplacement</form:label>
		    <form:input class="col-md-2" path="emplacement" />
	    </div>
	    <div class="row">
		    <form:label class="col-md-2" path="gps">Coordonnees GPS</form:label>
		    <form:input class="col-md-2" path="gps" />
	    </div>
	    <div class="row">
		    <form:label class="col-md-2" path="dateIntervention">Date de dernière intervention</form:label>
		    <form:input class="col-md-2" path="dateIntervention" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" 
		    required="true" placeholder="yyyy-MM-dd"/>
	    </div>
	    <div class="row">
		    <form:label class="col-md-2" path="commentaires">Commentaires</form:label>
		    <form:input class="col-md-2" path="commentaires" />
	    </div> 
	    <div class="row">
	    	<input class="btn btn-default col-md-2 col-md-push-1" type="submit" value="Submit" />
	    </div>
	</form:form>
	<script src="./js/jquery.min.js"></script>    
	<script src="./js/bootstrap.min.js"></script>
</body>

</html>