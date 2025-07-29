package com.jotac.model.factory;


import com.jotac.model.dao.impl.NivelJDBC;
import com.jotac.model.interfaces.InterfaceNivel;

public class DaoFactory {
	/*
	public static InterfaceNivelDao NivelDao() {
		return new NivelDaoJDBC();
	}
	*/
	public static InterfaceNivel Nivel() {
		return new NivelJDBC();
	}

}
