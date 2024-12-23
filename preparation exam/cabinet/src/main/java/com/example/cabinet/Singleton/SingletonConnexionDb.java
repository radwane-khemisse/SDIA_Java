package com.example.cabinet.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDb {
    private static Connection connection;
    public SingletonConnexionDb(){}

    public static Connection getConnexion(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinique", "redone", "redone");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}