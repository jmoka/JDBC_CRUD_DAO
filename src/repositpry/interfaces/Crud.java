package repositpry.interfaces;

import java.util.List;

import entities.Nivel;

public interface Crud {
	
	List<?> queryAll (); // consulta todos os elementos
	Integer insert(String novoName); // insere um elemento
	Nivel updateNivelId(Integer id, String novoNome); // atualiza a parir do id
	Boolean daleteNivelId(Integer id); // deleta a partir do id
	
	

}
