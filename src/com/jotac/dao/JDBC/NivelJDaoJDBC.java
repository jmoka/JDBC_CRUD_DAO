package com.jotac.dao.JDBC;

import java.sql.Connection;
import java.util.List;

import com.jotac.dao.JDBC.Niveis.FactoryNIvel;
import com.jotac.model.entities.Nivel;
import com.jotac.model.interfaces.InterfaceDao;
import com.jotac.model.interfaces.InterfaceNivelDao;

public class NivelJDaoJDBC implements InterfaceNivelDao, InterfaceDao {
	
	String nameTabela = "Tbl_Nivel";
	String nameColuna = "nomeNivel";
	
	
	// CONSULTAR
	@Override
	public List<Nivel> daoQueryAll(Connection conn) {
		
		return FactoryNIvel.QueryNivelAll(nameTabela, conn);
	}
	
	// INSERIR
	@Override
	public Integer daoInsert(String novoName, Connection conn) {
		
		return FactoryNIvel.insertNivel(novoName, nameTabela, nameColuna, conn);
	}
	
	// ATUALIZAR
	@Override
	public Nivel daoUpdateById(Integer id, String novoNome, Connection conn) {
		
		return FactoryNIvel.updateNivelById(nameTabela, nameColuna, id, conn);
	}
	
	// DELETAR
	@Override
	public Boolean daoDeleteById(Integer id, Connection conn) {
		
		return FactoryNIvel.deleteById(nameTabela, id, conn);
	}
	
	
	
	
}
	
	