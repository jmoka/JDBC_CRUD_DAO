package com.jotac.model.interfaces;

import java.util.List;

import com.jotac.model.entities.Nivel;

public interface InterfaceNivel {

	List<Nivel> daoQueryAll(); // consulta todos os elementos

	Integer daoInsert(String novoName); // insere um elemento

	Nivel daoUpdateId(Integer id, String novoNome); // atualiza a parir do id

	Boolean daoDeleteId(Integer id); // deleta a partir do id

}
