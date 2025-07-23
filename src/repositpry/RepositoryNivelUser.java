package repositpry;

import java.util.List;

import entities.Nivel;
import repositpry.Niveis.DeleteNivel;
import repositpry.Niveis.InsertNivel;
import repositpry.Niveis.QueryNivelUserAll;
import repositpry.Niveis.UpdateNivel;
import repositpry.interfaces.Crud;

public class RepositoryNivelUser implements Crud {

	@Override
	public List<Nivel> queryAll() {
		return QueryNivelUserAll.queryUserAll("Tbl_Nivel");
	};

	@Override
	public Integer insert(String novoName) {
		return InsertNivel.inserNivel(novoName, "Tbl_Nivel", "nomeNivel");

	}

	@Override
	public Nivel updateNivelId(Integer id, String novoNome) {
		return UpdateNivel.id("Tbl_Nivel", novoNome, id);
	}

	@Override
	public Boolean daleteNivelId(Integer id) {
		return DeleteNivel.id("Tbl_Nivel", id);
	}
}
