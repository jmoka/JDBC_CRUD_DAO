package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import db.Exceptions.DbException;
import db.data.LoadCpanelProperties;

public class DB {

	// 1) estaciar uma variável do tipo Conection
	// 2) criar um metodo statico que retorna um Properties. Para ler o os dados do
	// arquivo properties
	// 3) criar um metodo statico que retorna um Conection (conn) e armazena a
	// conexao na variavel conn
	// usando o arquivo properties
	// usando as variáveis de ambiante
	// 4) criar um metodo para fechar o banco

	// variavel de conexão
	public static Connection conn = null;

	// Criar a Conexção como Banco Usando o Properties
	public static Connection getConectComProperties() {

		if (conn == null) { // testa se a conexão esta ativa , se tiver pula o if e retorna a conexao (
							// conn)
							// caso contrario aber uma conexao nova
			try {

				//Properties props = LoadProperties.dbProperties(); // ler os dados do arquivo properties
				Properties props = LoadCpanelProperties.dbProperties(); // ler os dados do arquivo properties
				String url = props.getProperty("dburl"); // pegar a url do arquivo properties
				System.out.println("Conectando ao banco de dados: " + url);
				conn = DriverManager.getConnection(url, props); // armazena a conexão na conn - Conection
				 System.out.println("Banco de dados Conectado");

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

		// caso a conexão não for nume retorna a conexão existente
		return conn;

	}
	
	

		
}
