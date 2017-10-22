<%@ page import="br.com.ProjetoWEB.entidade.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela Principal</title>
</head>
<body>
<%@ include file="menu.jsp" %><br>
<h1>Bem vindo ao menu principal</h1> 
<% Usuario usu = ((Usuario) request.getSession().getAttribute("usuAutenticado")); 
	out.print("<h2>"+usu.getName()+"</h2>");%>


</body>
</html>