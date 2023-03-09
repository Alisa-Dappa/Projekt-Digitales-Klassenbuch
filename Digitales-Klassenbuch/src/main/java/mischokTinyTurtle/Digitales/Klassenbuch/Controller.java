package mischokTinyTurtle.Digitales.Klassenbuch;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
public class Controller {

    public static Connection getConnection() throws SQLException, ClassNotFoundException, SQLException {
        Class.forName("jdbc:postgresql:database");
        Connection connection = DriverManager.getConnection("postgres://fsoypwho:6WN1ECo6__Z6frAjXrPcnmkYiYIDpIqg@mouse.db.elephantsql.com/fsoypwho",
                "fsoypwho", "6WN1ECo6__Z6frAjXrPcnmkYiYIDpIqg");

        return connection;
    }
}
