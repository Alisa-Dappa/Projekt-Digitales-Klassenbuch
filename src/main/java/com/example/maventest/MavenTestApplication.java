package com.example.maventest;

import com.example.maventest.Model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

	@SpringBootApplication
	public class MavenTestApplication {

		public static void main(String[] args) throws SQLException {
			SpringApplication.run(MavenTestApplication.class, args);

			//Datenbankverbindung herstellen
			DatabaseConnection connection = new DatabaseConnection();
			Connection dbConnection = connection.getConnection();

			//Erstellen der Tabellen mithilfe der Entity Klassen und Repository Interfaces
			ModuleRepository moduleRepository = new ModuleRepositoryImpl(dbConnection);
			ThemaRepository themaRepository = new ThemaRepositoryImpl(dbConnection);

			moduleRepository.crateTable();
			themaRepository.crateTable();

		}
    }
