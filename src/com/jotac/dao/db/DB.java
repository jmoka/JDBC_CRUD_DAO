package com.jotac.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.jotac.dao.db.data.LoadCpanelProperties;
import com.jotac.dao.db.data.LoadProperties;
import com.jotac.dao.db.data.LoadVariaveisAmbiente;
import com.jotac.dao.db.exceptions.DbException;


public class DB {

	// Criar a Conexção como Banco Usando o Properties
	public static Connection getConectComProperties() {
	
			try {

				Properties props = LoadProperties.dbProperties(); // ler os dados do arquivo properties
				String url = props.getProperty("dburl"); // pegar a url do arquivo properties
				System.out.println("Conectando ao banco de dados: " + url);
				return DriverManager.getConnection(url, props); // armazena a conexão na conn - Conection

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

		

	
	public static Connection getCPNELConectComProperties() {

		
			try {

				Properties props = LoadCpanelProperties.dbProperties(); // ler os dados do arquivo properties
				String url = props.getProperty("dburl"); // pegar a url do arquivo properties
				System.out.println("Conectando ao banco de dados: " + url);
				return DriverManager.getConnection(url, props); // armazena a conexão na conn - Conection

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

	// Criar a Conexção como Banco Usando o Properties
	public static Connection getConectComPropertiesVariaveis() {

	
			try {
				Properties props = LoadVariaveisAmbiente.carregarPropertiesDoAmbiente();
				String url = props.getProperty("dburl");

				System.out.println("Conectando ao banco de dados: " + url);
				return DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException("Erro ao conectar: " + e.getMessage());
			}


		
	}

		
}