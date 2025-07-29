package com.jotac.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.jotac.dao.db.DB;
import com.jotac.model.entities.Nivel;
import com.jotac.model.interfaces.InterfaceNivel;

public class NivelJDBC implements InterfaceNivel {

	private String nomeTabela;
	private String nomeColuna;
	private Connection conn;
	Connection con = DB.getConectComProperties();

	public NivelJDBC() {

	}

	public NivelJDBC(Connection conn) {
		this.conn = conn;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public String getNomeColuna() {
		return nomeColuna;
	}

	public void setNomeColuna(String nomeColuna) {
		this.nomeColuna = nomeColuna;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public NivelJDBC(Connection conn, String nomeTabela, String nomeColuna) {
		this.conn = conn;
		this.nomeTabela = nomeTabela;
		this.nomeColuna = nomeColuna;
	}

	// CONSULTAR
	@Override
	public List<Nivel> daoQueryAll() {

		return ImplementNivel.QueryNivelAll(nomeTabela, conn);
	}

	// INSERIR
	@Override
	public Integer daoInsert(String novoName) {

		return ImplementNivel.insertNivel(novoName, nomeTabela, nomeColuna, conn);
	}

	// ATUALIZAR
	@Override
	public Nivel daoUpdateId(Integer id, String novoNome) {

		return ImplementNivel.updateNivelById(nomeTabela, novoNome, id, conn);
	}

	// DELETAR
	@Override
	public Boolean daoDeleteId(Integer id) {

		return ImplementNivel.deleteById(nomeTabela, id, conn);
	}

}
