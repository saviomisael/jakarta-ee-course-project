package com.exemplo.hello.includeforwardexample.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ForwardExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("Hi from ForwardExample Servlet\n");

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/ForwardExample1");
        dispatcher.forward(req, resp);
    }
}
