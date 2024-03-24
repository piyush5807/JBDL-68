package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "");
        Statement statement = connection.createStatement();
        statement.execute("create table jbdl (id int, count int)");

        /**
         * Pom.xml
         * Repositories
         * Phases / lifecycle of maven
         * Plugins
         * Target folder
         * Comparison with other languages (node.js,ROR etc.)
         * Setting.xml (deploy) {Optional}
         */
    }
}