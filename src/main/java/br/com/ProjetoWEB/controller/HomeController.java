package br.com.ProjetoWEB.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home.do")
public class HomeController extends HttpServlet{
	/*  
	 * Está classe é reponsavel apenas para redirecionar para a página principal (index.jsp) ao clicar em Home no menu
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
	}
}
