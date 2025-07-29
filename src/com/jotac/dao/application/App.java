package com.jotac.dao.application;

import com.jotac.dao.db.ConnectionManager;
import com.jotac.model.dao.impl.NivelJDBC;


public class App {

	public static void main(String[] args) {
		
		
		
		
		NivelJDBC nivel = new NivelJDBC(ConnectionManager.getConnection(), "Tbl_Nivel", "nomeNivel");
		
		nivel.daoInsert("fdfdddddddllfggggdfd");
		nivel.daoUpdateId(4, "legals");
		nivel.daoQueryAll();
		nivel.daoDeleteId(6);
	   System.out.println(nivel.daoQueryAll());
		
	   ConnectionManager.close();
		
	}
}