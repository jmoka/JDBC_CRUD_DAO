package com.jotac.dao.application;

import com.jotac.dao.dao.NivelUserDAO;
import com.jotac.dao.db.DB;

public class App {

	public static void main(String[] args) {

		NivelUserDAO nivelUser = new NivelUserDAO();

		/* INSERIR */
		 //nivelUser.insert("ZECAo", DB.getConectComPropertiesVariaveis() );
		nivelUser.insert("LEPgRA", DB.getConectComProperties());
		//nivelUser.insert("luizoo", DB.getCPNELConectComProperties());

		/* DELETAR */
		// nivelUser.daleteNivelId(1, DB.getConectComPropertiesVariaveis() );
		// nivelUser.daleteNivelId(2, DB.getConectComProperties());
	    // nivelUser.daleteNivelId(69, DB.getCPNELConectComProperties());
		
		/* ATUALILZAR */
		//nivelUser.updateNivelId(3, "hhh", DB.getConectComPropertiesVariaveis());
		//nivelUser.updateNivelId(4, "lhhhhl", DB.getConectComProperties());		
	    //nivelUser.updateNivelId(67,"ke", DB.getCPNELConectComProperties());
		
		/*CONSULTAR*/
		//List<Nivel> list = nivelUser.queryAll(DB.getConectComPropertiesVariaveis());
		//List<Nivel> list = nivelUser.queryAll(DB.getConectComProperties());
		//List<Nivel> list = nivelUser.queryAll(DB.getCPNELConectComProperties());
		
		/*LISTAR*/
		
		/*
		System.out.println("=============");
		for(Nivel n : list) {		
			System.out.println("Codigo : " + n.getIdNivel() );
			System.out.println("Nome : " + n.getNomeNivel());
			System.out.println("=============");
		}
		*/

	}
}