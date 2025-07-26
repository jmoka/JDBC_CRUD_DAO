package com.jotac.dao.dao.niveis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jotac.dao.db.exceptions.DbException;
import com.jotac.dao.entities.Nivel;

import sql.NivelSql;
import util.closeutils.CloseConnection;
import util.closeutils.CloseResultSet;
import util.closeutils.CloseStatement;

public class QueryNivelUserAll {

	public static List<Nivel> queryUserAll(String nameTAble, Connection conn) {
		//Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Nivel> niveis = new ArrayList<Nivel>();

		try {
			//conn = DB.getConectComProperties();
			st = conn.createStatement();
			rs = st.executeQuery(NivelSql.sqlNivelAll(nameTAble));

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
}
