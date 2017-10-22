package br.com.ProjetoWEB;
import java.util.ArrayList;

import br.com.ProjetoWEB.entidade.Usuario;
import br.com.ProjetoWEB.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		testeAutenticacao();
	}
	public static void testCadastrar() {
		//Criando o usuario
		Usuario usuario = new Usuario();
		usuario.setName("Doougazao");
		usuario.setLogin("douglasro");
		usuario.setSenha("123");
		
		//Cadastrando no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrar(usuario);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	public static void testeAlterar() {
		//Alterarndo o usuario
				
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setName("dinarte");
		usuario.setLogin("mito");
		usuario.setSenha("asad");
		
		//Alterando no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterar(usuario);
				
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testeExcluir() {
				
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		//Excluindo no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);
				
		System.out.println("Excluído com sucesso!");
	}
	//SALVO, PODENDO SER ALTERADO OU CADASTRADO
	public static void testeSalvar() {
		
		Usuario usuario = new Usuario();
		//usuario.setId(2);
		usuario.setName("maria");
		usuario.setLogin("marria12");
		usuario.setSenha("12341");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		
		System.out.println("Salvo com sucesso!");
	}
	
	public static void testeBuscaID() {
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuario = usuDAO.buscaPorId(2);
		
		System.out.println(usuario);
		
	}
	
	public static void testeBuscaTodos() {
			UsuarioDAO usuDAO = new UsuarioDAO();
			ArrayList<Usuario> lista= usuDAO.buscaTodos();
			for(Usuario u:lista) {//percorrendo todo o vetor
				System.out.println(u);
			}
	}
	
	public static void testeAutenticacao() {
		 UsuarioDAO usuDAO = new UsuarioDAO();
		 Usuario usuario = new Usuario();
		 usuario.setLogin("douglasro");
		 usuario.setSenha("123");
		 
		 Usuario usuRetorno = usuDAO.autenticar(usuario);
		 System.out.println(usuRetorno);
	}
}
