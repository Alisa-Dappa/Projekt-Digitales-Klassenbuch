package mischokTinyTurtle.Digitales.Klassenbuch;

    import java.sql.*;

    public class Postgres {

        public static void main(String[] args) {
            try {
                Class.forName("org.postgresql.Driver");
            }
            catch (java.lang.ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            String url = "postgres://fsoypwho:6WN1ECo6__Z6frAjXrPcnmkYiYIDpIqg@mouse.db.elephantsql.com/fsoypwho";
            String username = "database";
            String password = "password";

            try {
                Connection db = DriverManager.getConnection(url, username, password);
                Statement st = db.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM people");
                while (rs.next()) {
                    System.out.print("Column 1 returned ");
                    System.out.println(rs.getString(2));
                    System.out.print("Column 2 returned ");
                    System.out.println(rs.getString(3));
                }
                rs.close();
                st.close();
            }
            catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

