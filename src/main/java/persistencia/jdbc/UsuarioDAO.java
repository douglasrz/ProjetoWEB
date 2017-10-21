package persistencia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
	

