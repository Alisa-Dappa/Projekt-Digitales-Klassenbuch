package com.example.mavenKlassenbuch.Main;

import com.example.mavenKlassenbuch.Main.Model.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.*;

	@SpringBootApplication
	@ComponentScan({"com.example.mavenKlassenbuch.Main.Model.ModuleRepository.java"})
	@ComponentScan({"com.example.mavenKlassenbuch.Main.Model.ThemaRepository.java"})
	public class MavenKlassenbuchApplication {

		public static void main(String[] args) throws SQLException {
			SpringApplication.run(MavenKlassenbuchApplication.class, args);

			Connection connection = DatabaseConnection.getConnection();

			//Erstellen der Tabellen aufrufen
			DatabaseConnection.createTables();

			//Verbindung zur Datenbank schließen
			DatabaseConnection.closeConnection();
		}
    }
