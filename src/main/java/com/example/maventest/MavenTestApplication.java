package com.example.maventest;

import com.example.maventest.Model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

	@SpringBootApplication
	public class MavenTestApplication {

		public static void main(String[] args) throws SQLException {
			SpringApplication.run(MavenTestApplication.class, args);

			Connection connection = DatabaseConnection.getConnection();

			//Erstellen der Tabellen aufrufen
			DatabaseConnection.createTables();

			//Verbindung zur Datenbank schließen
			DatabaseConnection.closeConnection();
		}
    }
