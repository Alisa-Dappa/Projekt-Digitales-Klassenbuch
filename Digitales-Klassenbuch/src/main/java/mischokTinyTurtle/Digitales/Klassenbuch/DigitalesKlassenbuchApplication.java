package mischokTinyTurtle.Digitales.Klassenbuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class DigitalesKlassenbuchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalesKlassenbuchApplication.class, args);

		try {
			Connection connection = Controller.getConnection();
			Statement st = 	connection.createStatement();

			//Tabellen erstellen
			String sqlcreateSchultage = "CREATE TABLE IF NOT EXISTS SCHULTAGE (DATUM VARCHAR(50) PRIMARY KEY," +
										" WOCHENTAG VARCHAR(50));";
			st.execute(sqlcreateSchultage);

			String sqlcreateModule = "CREATE TABLE IF NOT EXISTS MODULE (ID INTEGER PRIMARY KEY, DATUM VARCHAR(50), " +
								     "NAME VARCHAR(50), STUNDENANZAHL INTEGER);";
			st.execute(sqlcreateModule);

			String sqlcreateThemen = "CREATE TABLE IF NOT EXISTS THEMEN (ID INTEGER PRIMARY KEY, MODUL_ID INTEGER," +
									 " BEZEICHNUNG VARCHAR(50));";
			st.execute(sqlcreateThemen);

			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
