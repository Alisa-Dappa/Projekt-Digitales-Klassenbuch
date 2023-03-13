package com.example.maventest;

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
		}catch (java.lang.ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		//Verbinden
			String url = "jdbc:postgresql://mouse.db.elephantsql.com/fsoypwho";
			String user = "fsoypwho";
			String password = "6WN1ECo6__Z6frAjXrPcnmkYiYIDpIqg";
			Connection connection;
			connection = DriverManager.getConnection(url, user, password);
		}
	}
