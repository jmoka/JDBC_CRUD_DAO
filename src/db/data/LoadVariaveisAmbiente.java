package db.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadVariaveisAmbiente {


	public static Connection getConectVariaveisAmbiente(Connection conn ) {

		if (conn == null) {
			try {
				String host = System.getenv("DB_HOST");
				String port = System.getenv("DB_PORT");
				String user = System.getenv("DB_USER");
				String password = System.getenv("DB_PASSWORD");
				String dbName = System.getenv("DB_NAME");

				String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

				System.out.println("Conectando ao banco de dados: " + url);

				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage(), e);
				// ou: throw new DbException(e.getMessage()); se você tiver essa classe
			}
		}

		return conn;
	}

	
}
