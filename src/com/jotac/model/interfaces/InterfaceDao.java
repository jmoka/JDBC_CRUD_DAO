package com.jotac.model.interfaces;

import java.sql.Connection;

public interface InterfaceDao {

	Integer daoInsert(String novoName, Connection conn); // insere um elemento

	Boolean daoDeleteById(Integer id, Connection conn); // deleta a partir do id

}
