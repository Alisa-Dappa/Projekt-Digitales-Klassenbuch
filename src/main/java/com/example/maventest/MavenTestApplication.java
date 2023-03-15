package com.example.maventest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

	@SpringBootApplication
	public class MavenTestApplication {

		public static void main(String[] args) throws SQLException {
			SpringApplication.run(MavenTestApplication.class, args);

		/*	Connection connection;



			//Erstellung der Tabellen in ElephantSQL
			Statement st = connection.createStatement();
			ResultSet rs = null;

			st.execute("CREATE TABLE IF NOT EXISTS MODUL (ID SERIAL PRIMARY KEY, NAME VARCHAR(50))");
			st.execute("CREATE TABLE IF NOT EXISTS THEMEN (ID SERIAL PRIMARY KEY, MODUL_ID INTEGER, BEZEICHNUNG VARCHAR(50))");

			connection.close();*/
			}
		}
