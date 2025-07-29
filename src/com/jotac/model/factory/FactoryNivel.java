package com.jotac.model.factory;

import java.sql.Connection;
import java.util.List;

import com.jotac.dao.db.DB;
import com.jotac.model.dao.impl.ImplementNivel;
import com.jotac.model.entities.Nivel;
import com.jotac.model.interfaces.InterfaceNivel;

public class FactoryNivel implements InterfaceNivel {	
	
	String nameTabela;
	String nameColuna;
	Connection conn;
	
	
	
	public FactoryNivel(String nameTabela, String nameColuna, Connection conn) {
		super();
		this.nameTabela = nameTabela;
		this.nameColuna = nameColuna;
		this.conn = conn;
	}


	// USANDO A CONEXÃO PADRÃO
	public FactoryNivel() {
		this.conn = DB.getConectComProperties();
		this.nameTabela = "tbl_nivel";
		this.nameColuna = "nomeNivel";
		
	}	
		

	@Override
	public Integer daoInsert(String novoName) {		
		return ImplementNivel.insertNivel(novoName, nameTabela, nameColuna, conn);
	}

	@Override
	public Nivel daoUpdateId(Integer id) {
		return ImplementNivel.updateNivelById(nameTabela, nameColuna, id, conn);
	}

	@Override
	public Boolean daoDeleteId(Integer id) {
		return ImplementNivel.deleteById(nameTabela, id, conn);
	}

	@Override
	public List<Nivel> daoQueryAll() {
		return ImplementNivel.QueryNivelAll(nameTabela, conn);
	}

	
}
