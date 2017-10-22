package br.com.ProjetoWEB.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Esta classe é responsavel pelo filtro de autenticação, assim algumas páginas só serao acessadas se o usuario estivar autenticado
 */

@WebFilter(dispatcherTypes= {DispatcherType.REQUEST}, urlPatterns="/*")
public class FiltroAutenticacao implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAutenticacao() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	//PARA IR PARA QUALQUER PÁGINA É NECESSÁRIO PASSAR ANTES POR LOGIN
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//Pegando o ServletRequest como Http, pois poderia ser em outros protocolos
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String uri = httpRequest.getRequestURI();
		
		HttpSession sessao = httpRequest.getSession(false);
		
		/*Se for -1 significa que não existe a string no URL
		 * Verifico aqui se já existe uma sessao ou o usuario está tentando acessar o login
		 * ou o autenticador
		 */
		if(sessao!=null || uri.lastIndexOf("login.html")!=-1 || uri.lastIndexOf("logincontroller.do")!=-1) {
			chain.doFilter(request, response);
		}else {
			httpResponse.sendRedirect("login.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
