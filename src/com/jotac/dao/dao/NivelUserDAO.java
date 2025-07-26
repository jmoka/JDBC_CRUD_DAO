package com.jotac.dao.dao;

import java.sql.Connection;
import java.util.List;

import com.jotac.dao.dao.interfaces.InterfaceNivelDAO;
import com.jotac.dao.dao.niveis.DeleteNivel;
import com.jotac.dao.dao.niveis.InsertNivel;
import com.jotac.dao.dao.niveis.QueryNivelUserAll;
import com.jotac.dao.dao.niveis.UpdateNivel;
import com.jotac.dao.entities.Nivel;

public class NivelUserDAO implements InterfaceNivelDAO {
	
	String table = "Tbl_Nivel";
	String nomeNivel = "nomeNivel";

	
	@Override
	public Integer insert(String novoName, Connection conn) {
		return InsertNivel.inserNivel(novoName, table, nomeNivel, conn);

	}

	@Override
	public Boolean daleteNivelId(Integer id, Connection conn) {
		return DeleteNivel.id(table, id, conn);
	}

	@Override
	public Nivel updateNivelId(Integer id, String novoNome, Connection conn) {
		return UpdateNivel.id(table, novoNome, id, conn);
	}

	@Override
	public List<Nivel> queryAll(Connection conn) {
		
		return QueryNivelUserAll.queryUserAll(table, conn);
	}
}
