package com.exemplo.hello.finalproject.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // Never uses allowPublicKeyRetrieval=true in production because this can be unsecure
    private static final String dbURL = "jdbc:mysql://localhost:3306/employee_db?allowPublicKeyRetrieval=true";
    private static final String dbUserName = "root";
    private static final String dbPassword = "root";
    private static Connection connection = null;

    public static Connection getConnection() {
        System.out.println("Start getConnection"); // Log4j
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

            System.out.println("Connected");
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return connection;
    }
}
