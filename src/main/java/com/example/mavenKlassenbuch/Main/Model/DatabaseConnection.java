package com.example.mavenKlassenbuch.Main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String url = "jdbc:postgresql://mouse.db.elephantsql.com/fsoypwho";
    private static final String user = "fsoypwho";
    private static final String password = "6WN1ECo6__Z6frAjXrPcnmkYiYIDpIqg";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the database.");
            } catch (SQLException e) {
                System.out.println("Failed to connect to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection to the database closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close connection to the database.");
                e.printStackTrace();
            }
        }
    }

    public static void createTables() {
        try (Statement statement = DatabaseConnection.connection.createStatement()) {
            // Erstellt Modul Tabelle
            String createModuleTable = "CREATE TABLE IF NOT EXISTS module ("
                    + "id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "startdatum VARCHAR(255),"
                    + "enddatum VARCHAR(255),"
                    + "farbe VARCHAR(255),"
                    + "jsID VARCHAR(255))";
            statement.executeUpdate(createModuleTable);

            // Erstellt Thema Tabelle
            String createThemaTable = "CREATE TABLE IF NOT EXISTS thema ("
                    + "id SERIAL PRIMARY KEY,"
                    + "bezeichnung VARCHAR(255) NOT NULL,"
                    + "module_id INTEGER REFERENCES module(id))";
            statement.executeUpdate(createThemaTable);

            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create tables.");
            e.printStackTrace();
        }
    }
}
