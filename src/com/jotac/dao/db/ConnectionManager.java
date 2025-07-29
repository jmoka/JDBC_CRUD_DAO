package com.jotac.dao.db;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            conn = DB.getConectComProperties();
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Conexão encerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
