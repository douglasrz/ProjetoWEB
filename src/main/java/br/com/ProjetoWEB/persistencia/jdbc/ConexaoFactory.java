package br.com.ProjetoWEB.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Classe responsavel pela conecção com o banco
 */
public class ConexaoFactory {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");//Forçando a inicializacao do drive
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoWEBBD", "postgres","fdro196245");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
