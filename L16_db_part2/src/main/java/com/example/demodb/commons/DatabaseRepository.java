package com.example.demodb.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class DatabaseRepository {
    private static Connection connection = null;

    // jpa and hibernates

    private String url;
    private String username;
    private String password;

    DatabaseRepository(@Value("${db.url}") String url,
                       @Value("${db.username}") String username,
                       @Value("${db.password}") String password){

        this.url = url;
        this.password = password;
        this.username = username;

    }

    public Connection getConnection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(this.url, this.username, this.password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }
}
