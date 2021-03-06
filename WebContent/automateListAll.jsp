<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="com.google.common.reflect.TypeToken"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"
	import="com.models.Automate,com.google.gson.Gson"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:useBean id="automate" class="com.models.Automate" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	<link href="./css/automate_custom_template.css" rel="stylesheet">
	<title>Liste de tous les automates</title>
</head>
<body>
	<%@include file="./header.jsp" %>
	<%-- Sample Bean: <%= automate %>
	<%= request.getAttribute("automates") %> --%>
	<h1 style="text-align:center"> Liste de tous les automates</h1>
	<% 
		Gson gson = new Gson();
		List<Automate> liste = gson.fromJson((String)request.getAttribute("automates"), 
				new TypeToken<List<Automate>>(){}.getType());
		for(int i = 0; i < liste.size(); i++)
		{
			System.out.println("ho ho ho" + liste.get(i));
			//Automate a = liste.get(i);
		%>
		<form method="POST" action="./autoListService">
			<table>
				<tr>
					<td>Num série : <%=liste.get(i).getNumSerie()%></td>
				</tr>
				<tr>
					<td>Type : <%=StringEscapeUtils.escapeXml(((String)liste.get(i).getType()))%></td>
				</tr>
				<tr>
					<td>Adresse : <%=StringEscapeUtils.escapeXml(((String)liste.get(i).getAdresse()))%></td>
				</tr>
				<tr>
					<td>Emplacement : <%=StringEscapeUtils.escapeXml(((String)liste.get(i).getEmplacement()))%></td>
				</tr>
				<tr>
					<td>Coordonnees GPS : <%=liste.get(i).getGps()%></td>
				</tr>
				<tr>
					<td>Date de derniere intervention : <%=liste.get(i).getDateIntervention()%></td>
				</tr>
				<tr>
					<td>Commentaires : <%=StringEscapeUtils.escapeXml(((String)liste.get(i).getCommentaires()))%></td>
				</tr>
				<tr>
					<td><input type="hidden" value=<%=liste.get(i).getNumSerie() %>
						name="numSerie"></td>
				</tr>
				<tr>
					<td><input class="btn btn-danger" type="submit" value="Supprimer cet automate"></td>
				</tr>
			</table>
		</form>
		<%
		}
		%>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>