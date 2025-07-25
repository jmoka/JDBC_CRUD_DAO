package apication;

import repositpry.RepositoryNivelUser;

public class app {

	public static void main(String[] args) {

		RepositoryNivelUser nivelUser = new RepositoryNivelUser();

		/* INSERIR */
		// nivelUser.insert("ZECA", DB.getConectComPropertiesVariaveis() );
		// nivelUser.insert("LEPRA", DB.getConectComProperties());
		// nivelUser.insert("luiz", DB.getCPNELConectComProperties());

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