package com.jotac.dao.JDBC.Niveis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jotac.dao.db.exceptions.DbException;
import com.jotac.model.entities.Nivel;

import sql.NivelSql;
import util.closeutils.CloseConnection;
import util.closeutils.ClosePrepareStatement;
import util.closeutils.CloseResultSet;
import util.closeutils.CloseStatement;

public class FactoryNIvel {
	
	
	// INSERIR
	public static Integer insertNivel(String novoName, String nameTabela, String nameColuna, Connection conn) {

		//Connection conn = null;
		PreparedStatement ps = null;
		Nivel novoNivel = new Nivel(novoName);
		
		

		try {

			//conn = DB.getConectComProperties();
			//conn = DB.getConectComPropertiesVariaveis();
			ps = conn.prepareStatement(NivelSql.sqlNivelInsert(nameTabela, nameColuna),
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, novoNivel.getNomeNivel());

			Integer rowAffected = ps.executeUpdate();

			System.out.println("Linhas Afetadas " + rowAffected);

			if (rowAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while (rs.next()) {
					Integer id = rs.getInt(1);	
					System.out.println(id);
					return id;
					
				}

			}

		} catch (SQLException e) {

			e.getMessage();
			throw new DbException("Já exiete o mesmo nome no banco de dados ou o Banco de dados não Exiete");

		} finally {
			//ClosePrepareStatement.close(ps);
			//CloseConection.close(conn);
		}
		 return (Integer) null;
	}
	
	
	// ATUALIZAR POR ID
	public static Nivel updateNivelById (String nameTabela, String novoNome, Integer id, Connection conn) {

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
	
	
	// CONSULTAR TODOS OS NIVEIS
	public static List<Nivel> QueryNivelAll(String nameTabela, Connection conn) {
			//Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			List<Nivel> niveis = new ArrayList<Nivel>();

			try {
				//conn = DB.getConectComProperties();
				st = conn.createStatement();
				rs = st.executeQuery(NivelSql.sqlNivelAll(nameTabela));

				while (rs.next()) {
					niveis.add(new Nivel(rs.getInt("idNivel"), rs.getString("nomeNivel")));
				}

			} catch (SQLException e) {
				e.getMessage();
				throw new DbException("Verifique se o parâmetros de idNIvel e nomeNive estão corretos 32-QueryNivelUserAll");
			} finally {

				CloseResultSet.close(rs);

				CloseStatement.close(st);

				CloseConnection.close(conn);

			}
			return niveis;
		}
	
	
	
	// DELETE POR ID
	public static Boolean deleteById (String nameTabela, Integer id, Connection conn) {

		//Connection conn = null;
		PreparedStatement ps = null;
		Boolean resultado = false;
		

		try {

			//conn = DB.getConectComProperties();
			ps = conn.prepareStatement(NivelSql.sqlDeleteNivelId(nameTabela), 
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);

			Integer rowAffected = ps.executeUpdate();

			System.out.println("Linhas Afetadas " + rowAffected);	
			
			if(rowAffected > 0 ) {
				resultado = true;
			}
			

		} catch (SQLException e) {

			e.getMessage();
			throw new DbException("Id Inexistente, não consta no banco de dados" );

		} finally {
			ClosePrepareStatement.close(ps);
			CloseConnection.close(conn);
		}
		return resultado;
		
	} 

}
