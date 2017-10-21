package br.com.ProjetoWEB;
import entidade.Usuario;
import persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		testeExcluir();
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
}
