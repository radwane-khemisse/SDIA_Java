package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    private static Connection connection;

    private SingletonConnexionDB() {}

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecole", "redone", "redone");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
