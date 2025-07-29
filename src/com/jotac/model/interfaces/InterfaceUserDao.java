package com.jotac.model.interfaces;

import java.sql.Connection;
import java.util.List;

import com.jotac.model.entities.User;

public interface InterfaceUserDao {
	
	
	
	//=====================================================================

	List<User> daoQueryAll(Connection conn); // consulta todos os elementos

	Integer daoInsert(String novoName, Connection conn); // insere um elemento

	User daoUpdateId(Integer id, String novoNome, Connection conn); // atualiza a parir do id

	Boolean daoDeleteId(Integer id, Connection conn); // deleta a partir do id

}
