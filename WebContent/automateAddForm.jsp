<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="automate" class="com.models.Automate" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Formulaire d'ajout d'automate</title>
</head>
<body>
<form:form method="POST" action="./autoAddService" modelAttribute="automate" >
    <form:label path="numSerie">Numero de serie</form:label>
    <form:input path="numSerie" value="0"/>
    <br/>
    <form:label path="type">Type</form:label>
    <form:input path="type" /> 
    <br/>
    <form:label path="adresse">Adresse</form:label>
    <form:input path="adresse" /> 
    <br/>
    <form:label path="emplacement">Emplacement</form:label>
    <form:input path="emplacement" />
    <br/>
    <form:label path="gps">Coordonnees GPS</form:label>
    <form:input path="gps" />
    <br/>
    <form:label path="dateIntervention">Date de derniere intervention</form:label>
    <form:input path="dateIntervention" required="true"/>
    <br/>
    <form:label path="commentaires">Commentaires</form:label>
    <form:input path="commentaires" /> 
    <br/>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>