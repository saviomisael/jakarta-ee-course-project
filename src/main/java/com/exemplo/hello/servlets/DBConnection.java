package com.exemplo.hello.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    public static Connection openConnection() {
        try {
            // Tomcat can't find the Driver when using ContextListener
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db?allowPublicKeyRetrieval=true", "root", "root"); // Creates the connection
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static boolean closeConnection() {
        try {
            connection.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
