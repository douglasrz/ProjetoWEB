<%@ page import="br.com.ProjetoWEB.entidade.Usuario" %>
<%@	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro</title>
	</head>
	<body>
	<%@ include file="menu.jsp" %><br>
		<%
			Usuario u = (Usuario)request.getAttribute("usuario"); 
		%>
		<form action="usucontroller.do" method="post">
			ID: <input type="number" name="id" value="<%=u.getId()%>"/>
			Nome: <input type="text" name="name" value="<%=u.getName()%>"/>
			Login: <input type="text" name="login" value="<%=u.getLogin()%>"/>
			Senha: <input type="text" name="senha" value="<%=u.getSenha()%>"/>
			
			<input type="submit" name="Salvar"/>
		</form>
	</body>
</html>