package com.jotac.dao.db;

import java.sql.SQLException;
import java.sql.Statement;

import com.jotac.dao.db.exceptions.DbException;

public class CloseStatement {

	public static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
				System.out.println("Statement Desconectado");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(e.getMessage());
			}

		}
	}
}
