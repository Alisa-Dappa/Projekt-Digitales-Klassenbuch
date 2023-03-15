package com.example.maventest.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                //Verbinden
                String url = "jdbc:postgresql://mouse.db.elephantsql.com/fsoypwho";
                String user = "fsoypwho";
                String password = "6WN1ECo6__Z6frAjXrPcnmkYiYIDpIqg";

                connection = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
