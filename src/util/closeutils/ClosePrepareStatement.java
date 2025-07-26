package util.closeutils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jotac.dao.db.exceptions.DbException;

public class ClosePrepareStatement {

	public static void close(PreparedStatement ps) {

		if (ps != null) {
			try {
				ps.close();
				System.out.println("PreparedStement Desconectado");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(e.getMessage());
			}
		}

	}
}
