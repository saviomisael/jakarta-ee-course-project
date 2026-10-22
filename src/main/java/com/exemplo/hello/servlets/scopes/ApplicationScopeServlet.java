package com.exemplo.hello.servlets.scopes;

import com.exemplo.hello.servlets.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class ApplicationScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        try {
            // Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
            // The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
            //Class.forName("com.mysql.jdbc.Driver"); // load the driver
            // Security Implications
            // Setting allowPublicKeyRetrieval=true introduces a security risk:
            // Man-in-the-Middle (MitM) Attacks: If you connect to an untrusted or compromised database server over an unencrypted connection, a malicious actor could intercept the connection, pretend to be the MySQL server, and trick your application into sending your clear-text password encrypted with a key they control.
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db?allowPublicKeyRetrieval=true", "root", "root"); // Creates the connection

            Connection connection = (Connection) getServletContext().getAttribute("connection");

            printWriter.print("<h2> Employee DB Connection Object : " + connection + "</h2>");

            getServletContext().setAttribute("employee-connection-db", connection);
        } catch(Exception ex) {
            ex.printStackTrace();
            printWriter.print("<h2> Exception in opening connection to Employee DB : " + ex.getMessage() + "</h2>");
        }
    }
}
