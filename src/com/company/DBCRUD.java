package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCRUD {
    private Connection connection;

    public void DatabaseManager(){
        // Initialize the connection
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection (replace URL, username, and password with your database credentials)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "abc123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
