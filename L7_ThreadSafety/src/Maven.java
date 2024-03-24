import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Maven {

    /**
     * Maven is not a programming language, it's a project management software / tool which makes your life easier
     *           by managing your source code installation, code run ...
     */

    public static void main(String[] args) throws SQLException {
        // Connect to a DB and create a table

        // JDBC is a protocol to connect java application with relational dbs
        // FTP --> File transfer
        // SMTP --> Simple mail transfer protocol

        // Any relational / sql databases {MySQL, Postgres, Oracle, SQL server, db2, h2, ....}
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
        Statement statement = connection.createStatement();
        statement.execute("create table jbdl (id int, count int)");

        // dependencies --> library / source code
    }
}
