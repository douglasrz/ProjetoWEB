package persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		try {
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoWEBBD", "postgres","fdro196245");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
