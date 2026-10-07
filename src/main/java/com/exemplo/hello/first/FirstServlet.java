package com.exemplo.hello.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {
    private ServletConfig config = null;

    @Override
    public void init(ServletConfig conf) throws ServletException {
        // when a servlet is initialized this method is called once
        this.config = conf;
    }

    @Override
    public ServletConfig getServletConfig() {
        // if I have a configuration parameter this method is called
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // in here enters the main code of the servlet
        PrintWriter printWriter = res.getWriter(); // uses text stream
        printWriter.print("<h1>Hello World!</h1>");
        printWriter.print("<h1>Today is " + new Date() + "</h1>");

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        // when a servlet is destroyed this method is called
    }
}
