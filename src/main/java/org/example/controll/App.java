package org.example.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {

    private final String url = "jdbc:postgresql://localhost/sampledb";
    private final String user = "postgres";
    private final String password = "bajs";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null){
                System.out.println("Connected to the PostgreSQL server successfully.");
            }
            else System.out.println("Connection failed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}