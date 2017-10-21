package persistencia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO USUARIO(nome,login,senha) VALUES(?,?,?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, usuario.getName());//Substitui o ? pelo dado do usuario
			preparar.setString(2, usuario.getLogin());
			preparar.setString(3, usuario.getSenha());
			//execurtando o comando sql no banco de dados
			preparar.execute();
			//fechanco a conexao com o banco
			preparar.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario) {
		String sql = "UPDATE usuario set nome=?, login=?, senha=? WHERE id=? ";
		try(PreparedStatement preparar = con.prepareStatement(sql)){
			preparar.setString(1, usuario.getName());//Substitui o ? pelo dado do usuario
			preparar.setString(2, usuario.getLogin());
			preparar.setString(3, usuario.getSenha());
			preparar.setInt(4, usuario.getId());
			//execurtando o comando sql no banco de dados
			preparar.execute();
			
			//Quando coloco o PreparedStatement dentro do try eu nao preciso fechar a conexao, ele fechar automatico
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Excluir um usuario
	 * @param usuario
	 */
	public void excluir(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id=? ";
		try(PreparedStatement preparar = con.prepareStatement(sql)){
			preparar.setInt(1, usuario.getId());
			//execurtando o comando sql no banco de dados
			preparar.execute();			
			//Quando coloco o PreparedStatement dentro do try eu nao preciso fechar a conexao, ele fechar automatico
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * M�todo para alterar ou add, dependendo se ele j� existe pelo id
	 * @param usuario
	 */
	public void salvar(Usuario usuario) {
		if(usuario.getId()!=null) {//Se ele tiver id, significa que j� foi cadastrado
			alterar(usuario);
		}else {
			cadastrar(usuario);
		}
	}
	
	/**
	 * Realiza a busca de um registro com este id
	 * @return Um objeto Usuario
	 */
	public Usuario buscaPorId(Integer id){		
		String sql = "SELECT *FROM usuario WHERE id=?";
		
		try(PreparedStatement preparar = con.prepareStatement(sql)){
			preparar.setInt(1, id);
			
			ResultSet resultado = preparar.executeQuery();//Para retorna os registro
			//Quando for mais de um registro � necessario usar mais next, para percorrer os outros registro
			if(resultado.next()) {//Se tem algum resultadona consulta
				Usuario usuRetorno = new Usuario();
				usuRetorno.setId(id);
				usuRetorno.setName(resultado.getString("nome"));
				usuRetorno.setSenha(resultado.getString("senha"));
				usuRetorno.setLogin(resultado.getString("login"));
				
				return usuRetorno;
			}						
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Realiza a busca de todos os registro da tabela de usuarios
	 * @return Uma lista de objetos Usuario
	 */
	public ArrayList<Usuario> buscaTodos(){		
			ArrayList<Usuario> lista= new ArrayList<Usuario>();	
			String sql = "SELECT *FROM usuario";
			
			try(PreparedStatement preparar = con.prepareStatement(sql)){							
				ResultSet resultado = preparar.executeQuery();//Para retorna os registro				
				//PERCORRE CADA RESGISTRO A CADA LA�O DO WHILE
				while(resultado.next()) {//next vai para o proximo registro e retorna true se existir
					
					Usuario usuRetorno = new Usuario();
					usuRetorno.setId(resultado.getInt("id"));
					usuRetorno.setName(resultado.getString("nome"));
					usuRetorno.setSenha(resultado.getString("senha"));
					usuRetorno.setLogin(resultado.getString("login"));
					
					//Adicionando na lista
					lista.add(usuRetorno);
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return lista;
		}
}
	

