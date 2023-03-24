package com.example.mavenKlassenbuch.Main;

import com.example.mavenKlassenbuch.Main.Model.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
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
