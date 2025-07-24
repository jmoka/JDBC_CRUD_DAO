package apication;


import java.sql.Connection;

import db.DB;
import entities.Nivel;
import repositpry.RepositoryNivelUser;

public class app {

	public static void main(String[] args) {
		
		RepositoryNivelUser nivelUser = new RepositoryNivelUser();
		//Connection conn = DB.getConectComProperties();
		Connection conn = DB.getConectComPropertiesVariaveis();
		if(conn != null) {
			System.out.println("conectado");
		}
	
		
		
		// Listar Buscar Nivel
		
		// RETORNA UMA LISTA
		
		/*
				List<Nivel> niveis =  nivelUser.queryAll();		
				for(Nivel n : niveis) {
					System.out.println("Código: "+ n.getIdNivel());
					System.out.println("Nome: " + n.getNomeNivel());
					System.out.println();
				}
		*/
		
		
		
		// Inserir Nivel e Retornar o Id Inserido	
		// RETORNA UM INT CODIGO QUE FOI INSERIDO
		 //System.out.println(nivelUser.insert("jooddccdv"));
		
		
		
	//	int idNivel = 62;
		
		
		// Update Id
		
	//String nomeNivel = "Lika";
	//Nivel n = (Nivel) nivelUser.updateNivelId(idNivel, nomeNivel);
	//System.out.println("Código: "+n.getIdNivel());
	//System.out.println("Nome: "+n.getNomeNivel());
		
	
		//Boolean resposta = nivelUser.daleteNivelId(idNivel);
		//System.out.println(resposta);
			
	

	
	
	}

}
