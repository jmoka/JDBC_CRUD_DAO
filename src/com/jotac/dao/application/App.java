package com.jotac.dao.application;

import java.sql.Connection;
import java.util.List;

import com.jotac.dao.db.CloseConnection;
import com.jotac.dao.db.DB;
import com.jotac.model.entities.Nivel;
import com.jotac.model.factory.Factory;

public class App {

	public static void main(String[] args) {

		// para teste de conexção
		// escolher dentre três tipos de conexão
		// 1 = MYSQL CONEXÃO LOCAL COM USO DAS PROPERTIES
		// 2 = MYSQL CONEXÃO CPANEL COM USO DAS PROPERTIES
		// 3 = MYSQL CONEXÃO LOCAL COM USO DAS VARIAVEIS DE AMBIENTE DO WINDOWS
		
		Connection conn = null;
		String nameTable = "Tbl_Nivel";
		String nameColl = "nomeNivel";
		
		Integer i = 1; // testar conexão aqui
		
		switch (i) {
		case 1:
			conn = DB.getConectComProperties();
			break;
		case 2:
			conn = DB.getCPNELConectComProperties();
			break;
		case 3:
			conn = DB.getConectComPropertiesVariaveis();
			break;
		}

		//  Factory.NivelPadrao().daoInsert("tetdete");		
		//  Factory.Nivel(nameTable, nameColl, conn).daoInsert("Terere");
		
		//  List<Nivel> n = Factory.NivelPadrao().daoQueryAll();
		//  System.out.println(n);
		// List<Nivel> nn = Factory.Nivel(nameTable, nameColl, conn).daoQueryAll();
		//  System.out.println(nn);
		
		//  for(Nivel n : nn) {
		//	Integer cod = n.getIdNivel();
		//	String nome = n.getNomeNivel();
		//	System.out.println("Cod : " + cod);
		//	System.out.println("Nome : " + nome);
			
		//	System.out.println(n.getNomeNivel());
			
		//	if(n.getIdNivel() == 13) {
		//		System.out.println("Nome do código Escolhido");
		//		System.out.println(n.getNomeNivel());
				
		//	   }
	    //	}
		
		
		//  Factory.NivelPadrao().daoDeleteId(4);
		//  Factory.Nivel(nameTable, nameColl, conn).daoDeleteId(8);
		  
		//  Factory.NivelPadrao().daoUpdateId(9);
		//  Factory.Nivel(nameTable, nameColl, conn).daoUpdateId(9);
		
		
		CloseConnection.close();

	}
}
