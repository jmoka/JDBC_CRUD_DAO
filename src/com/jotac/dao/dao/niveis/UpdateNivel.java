package com.jotac.dao.dao.niveis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jotac.dao.db.exceptions.DbException;
import com.jotac.dao.entities.Nivel;

import sql.NivelSql;
import util.closeutils.CloseConnection;
import util.closeutils.ClosePrepareStatement;

public class UpdateNivel {

	public static Nivel id (String nameTabela, String novoNome, Integer id, Connection conn) {

		//Connection conn = null;
		PreparedStatement ps = null;
		Nivel nivel = new Nivel();

		try {

			//conn = DB.getConectComProperties();
			ps = conn.prepareStatement(NivelSql.sqlUpdateNivelId(nameTabela), 
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, novoNome);
			ps.setInt(2, id);

			Integer rowAffected = ps.executeUpdate();

			System.out.println("Linhas Afetadas " + rowAffected);
			
			nivel.setIdNivel(id);
			nivel.setNomeNivel(novoNome);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			throw new DbException("Id Inexistente, não consta no banco de dados");

		} finally {
			ClosePrepareStatement.close(ps);
			CloseConnection.close(conn);
		}
		return nivel;
		
	} 

}
