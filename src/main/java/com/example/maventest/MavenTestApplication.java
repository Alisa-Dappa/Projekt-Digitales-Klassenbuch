package com.example.maventest;

import com.example.maventest.Model.Modul;
import com.example.maventest.Model.Themen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class MavenTestApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(MavenTestApplication.class, args);

		//Treiber einbinden
		try {
			Class.forName("org.postgresql.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		//Verbinden
		String url = "jdbc:postgresql://mouse.db.elephantsql.com/fsoypwho";
		String user = "fsoypwho";
		String password = "6WN1ECo6__Z6frAjXrPcnmkYiYIDpIqg";
		Connection connection;
		connection = DriverManager.getConnection(url, user, password);

		Modul modul = new Modul();
		Themen themen = new Themen();

		//Erstellung der Tabellen in ElephantSQL
		Statement st = connection.createStatement();
		ResultSet rs = null;

		st.execute("CREATE TABLE IF NOT EXISTS MODUL (ID SERIAL PRIMARY KEY, NAME VARCHAR(50))");
		st.execute("CREATE TABLE IF NOT EXISTS THEMEN (ID SERIAL PRIMARY KEY, MODUL_ID INTEGER, BEZEICHNUNG VARCHAR(50))");
		}
	}
