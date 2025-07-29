package com.jotac.model.factory;


import java.sql.Connection;

import com.jotac.model.interfaces.InterfaceNivel;

public class Factory {
	/*
	public static InterfaceNivelDao NivelDao() {
		return new NivelDaoJDBC();
	}
	*/
	public static InterfaceNivel NivelPadrao() {
		return new FactoryNivel();
	}
	public static InterfaceNivel Nivel(String nameTabela, String nomeColuna, Connection conn) {
		return new FactoryNivel(nameTabela, nomeColuna, conn);
	}

}
