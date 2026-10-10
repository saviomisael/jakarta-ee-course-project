package com.exemplo.hello.first;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FirstHttpServlet extends HttpServlet {
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        PrintWriter printWriter = res.getWriter(); // uses text stream
//        printWriter.print("<h1>Hello World from Http Servlet!</h1>");
//        printWriter.print("<h1>Today is " + new Date() + "</h1>");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doRequest(req, res, HttpVerb.GET);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doRequest(req, res, HttpVerb.POST);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse res, HttpVerb verb) throws ServletException, IOException {
        var method = verb.equals(HttpVerb.GET) ? "(doGet)" : "(doPost)";

        PrintWriter printWriter = res.getWriter(); // uses text stream
        printWriter.print("<h1>Hello World from Http Servlet " + method + "!</h1>");
        printWriter.print("<h1>Today is " + new Date() + "</h1>");
    }
}
