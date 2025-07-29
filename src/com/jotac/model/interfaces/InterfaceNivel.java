package com.jotac.model.interfaces;

import java.util.List;

import com.jotac.model.entities.Nivel;

public interface InterfaceNivel {

	Integer daoInsert(String novoName); // insere um elemento

	Nivel daoUpdateId(Integer id); // atualiza a parir do id

	Boolean daoDeleteId(Integer id); // deleta a partir do id

	List<Nivel> daoQueryAll();

}
