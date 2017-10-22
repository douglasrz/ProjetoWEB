package br.com.ProjetoWEB.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ProjetoWEB.entidade.Usuario;
import br.com.ProjetoWEB.persistencia.jdbc.UsuarioDAO;

//http://localhost:8080/ProjetoWEB/usucontroller.do	
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet{
	/*
	 * Este método é responsavel pelas ação do usuario com o método get, e cadastro com o método post	
	 */
	//SE EU FOR USAR O LOG, POSSO USAR O MÉTODO INIT
	/*@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		//resp.setContentType("text/html");//INDICANDO O TIPO QUE SERÁ A RESPOSTA
		
		if(acao.equals("excluir")) {
			Usuario usu = new Usuario();
			String id = req.getParameter("id");
			if(id!=null) {//VERIFICANDO PARA NAO DÁ ERRO NA CONVERSÃO ABAIXO
				usu.setId(Integer.parseInt(id));
			}
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.excluir(usu);
			
			resp.sendRedirect("usucontroller.do?acao=listagem");//redirecionando (nova requisicao no browser) 
			
		}else if(acao.equals("listagem")) {
			UsuarioDAO usuDAO = new UsuarioDAO();
			ArrayList<Usuario> lista = usuDAO.buscaTodos();
			
			//Adicionando o resultado (list) na requisição para enviar ao JSP
			req.setAttribute("lista", lista);//(chave,objeto)
			RequestDispatcher dispacher = req.getRequestDispatcher("WEB-INF/listagem.jsp");
			dispacher.forward(req, resp);//nova requisição no servidor
			
		}else if(acao.equals("alterar")){
			
			int id = Integer.parseInt(req.getParameter("id"));
			UsuarioDAO usuDAO = new UsuarioDAO();
			Usuario usu = usuDAO.buscaPorId(id);
			req.setAttribute("usuario", usu);			
			RequestDispatcher dispachar = req.getRequestDispatcher("WEB-INF/cadastroo.jsp");		
			dispachar.forward(req, resp);
		}else if(acao.equals("cadastro")) {
			
			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setLogin("");
			usu.setName("");
			usu.setSenha("");
			req.setAttribute("usuario", usu);			
			RequestDispatcher dispachar = req.getRequestDispatcher("WEB-INF/cadastroo.jsp");		
			dispachar.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usu = new Usuario();
		Integer id = Integer.parseInt(req.getParameter("id"));
		usu.setId(id);
		usu.setName(req.getParameter("name"));
		usu.setLogin(req.getParameter("login"));
		usu.setSenha(req.getParameter("senha"));
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		
		resp.getWriter().print("SALVO COM SUCESSO!");
		System.out.println("Salvo com sucesso");
	}
	
	//Fecha a conexão
	/*@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}*/
}
