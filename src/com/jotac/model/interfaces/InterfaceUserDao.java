package com.jotac.model.interfaces;

import java.sql.Connection;
import java.util.List;

import com.jotac.model.entities.Nivel;

public interface InterfaceUserDao {

	List<Nivel> daoQueryAll(Connection conn); // consulta todos os elementos

	//Integer daoInsert(String novoName, Connection conn); // insere um elemento

	Nivel daoUpdateById(Integer id, String novoNome, Connection conn); // atualiza a parir do id

	//Boolean daoDeleteById(Integer id, Connection conn); // deleta a partir do id

}
