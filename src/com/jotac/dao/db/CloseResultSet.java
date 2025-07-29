package com.jotac.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jotac.dao.db.exceptions.DbException;

public class CloseResultSet {

	public static void close(ResultSet rs) {
		
		if(rs!=null) {		

		try {
			rs.close();
			 System.out.println("ResultSet Desconectado");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e.getMessage());
		}
		}
	}

}
