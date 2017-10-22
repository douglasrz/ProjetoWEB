<%@ page import="br.com.ProjetoWEB.entidade.Usuario" %>
<%@ page import="java.util.ArrayList"%>
<%@	page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listagem de Usuarios</title>
		
		<script type="text/javascript">
			function confirmaExclusao(id){
				if(window.confirm("Tem certeza que deseja excluir?")){
					location.href="usucontroller.do?acao=excluir&id="+id;
				}
			}
			function novo(){
				location.href='usucontroller.do?acao=cadastro';
			}
		</script>
	</head>
	<body>
		<%@ include file="menu.jsp" %><br>
		<table border=1>
			<tr>
				<th>ID</th><th>NOME</th><th>AÇÃO</th><th>AÇÃO</th>
			</tr>
			<%
		 	ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("lista");
		 	for(Usuario u: lista){
		 		out.print("<tr>");
		 		out.print("<td>"+u.getId()+"</td> <td>"+u.getName()+"</td>");
		 		out.print("<td> <a href=javascript:confirmaExclusao("+u.getId()+")> excluir </a></td>");
		 		out.print("<td> <a href=usucontroller.do?acao=alterar&id="+u.getId()+"> editar </a></td>");
		 		out.print("</tr>");
		 	}		 
		 	%>
		</table>
		<input type="button" value="Novo" onclick="javascript:novo()"/>
		 
	</body>
</html>