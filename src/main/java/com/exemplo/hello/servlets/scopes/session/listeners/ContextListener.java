package com.exemplo.hello.servlets.scopes.session.listeners;

import com.exemplo.hello.servlets.DBConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;


/*
* 21-Oct-2026 21:53:12.184 WARNING [main] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesJdbc The web application [meu-projeto-tomcat] registered the JDBC driver [com.mysql.cj.jdbc.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
21-Oct-2026 21:53:12.184 WARNING [main] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesThreads The web application [meu-projeto-tomcat] appears to have started a thread named [mysql-cj-abandoned-connection-cleanup] but has failed to stop it. This is very likely to create a memory leak. Stack trace of thread:
* */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Hi, Application is Stopped");

        boolean isClosed = DBConnection.closeConnection();
        System.out.println("DB Connection is closed ? ==> " + isClosed);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Hi, Application is Started");

        ServletContext context = sce.getServletContext();

        Connection connection = DBConnection.openConnection();
        context.setAttribute("connection", connection);
        System.out.println("Connection is established!");
    }
}
