package br.com.ProjetoWEB.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ProjetoWEB.entidade.Usuario;
import br.com.ProjetoWEB.persistencia.jdbc.UsuarioDAO;

@WebServlet("/logincontroller.do")
public class LoginController extends HttpServlet {
	/*
	 * Esta classe � responsavel pela autentica��o do usuario, criando a sessao para o mesmo pelo m�todo Post e redirecionan para o index,
	 *  e quando chamo pelo m�todo get ele sair da sess�o redirecianando para a p�gina de login
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//cria a sessao
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuAutenticado = usuDAO.autenticar(usu);
		
		if(usuAutenticado!=null) {
			HttpSession sessao = req.getSession(); //criando a sessao
			sessao.setAttribute("usuAutenticado", usuAutenticado);//add o usuario a sessao
			
			sessao.setMaxInactiveInterval(60*10);
			//Direcionando para a p�gina principal
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);;
		}else {
			resp.getWriter().print("<script> window.alert('Usuario n�o encontrado'); location.href='login.html';</script>");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Destroi a sessao
		HttpSession sessao = req.getSession(false);
		//Quando n�o tem a sessao (FALSE), n�o faz nada
		if(sessao!=null) {
			sessao.invalidate();
		}
		resp.sendRedirect("login.html");
	}
	
}
