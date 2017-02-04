<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="automate" class="com.models.Automate" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lister et Modifier automate (eventuellement)</title>
</head>
<body>
	Sample Bean: <%= automate %>
<form:form method="POST" action="./autoListAndUpdateService" modelAttribute="automate">
    <form:label path="num_serie">Numero de serie</form:label>
    <form:input path="num_serie" />
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
    <form:label path="date_intervention">Date de derniere intervention</form:label>
    <form:input path="date_intervention" />
    <br/>
    <form:label path="commentaires">Commentaires</form:label>
    <form:input path="commentaires" /> 
    <br/>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>