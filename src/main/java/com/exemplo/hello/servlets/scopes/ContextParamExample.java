package com.exemplo.hello.servlets.scopes;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ContextParamExample extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        config.getServletContext(); // 3
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        ServletContext servletContext = getServletContext();

        printWriter.print("<h2> Context Parameters </h2><br/>");
        printWriter.print("<h3> DB IP Param : " + servletContext.getInitParameter("db-ip") + "</h3>");
        printWriter.print("<h3> DB Port : " + servletContext.getInitParameter("db-port") + "</h3>");

        Enumeration<String> enumeration = servletContext.getInitParameterNames();

        printWriter.print("<ul>");

        while(enumeration.hasMoreElements()) {
            String item = enumeration.nextElement();
            printWriter.print("<li> " + item + "</li>");
        }

        printWriter.print("</ul>");

        /*req.getServletContext(); // 1
        getServletContext(); // 2*/
    }
}
