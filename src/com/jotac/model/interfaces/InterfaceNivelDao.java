package com.jotac.model.interfaces;

import java.util.List;

import com.jotac.model.entities.Nivel;

public interface InterfaceNivelDao {

	List<Nivel> daoFindAll(); // consulta todos os objetos gurdados no banco
	
	Nivel daoFindById(Integer id); //retorna o objeto refernte ao id passado
	
	void daoDeleteById(Integer id); // deleta o objeto a partir do id
	
	void daoUpdate(Nivel obs); // atualiza o objeto a parir do id
	
	void daoInsertObj(Nivel obs); // insere um objeto 
		

	

}
