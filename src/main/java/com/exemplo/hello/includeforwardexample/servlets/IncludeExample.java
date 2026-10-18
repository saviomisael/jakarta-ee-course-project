package com.exemplo.hello.includeforwardexample.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IncludeExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("Hi from IncludeExample Servlet\n");

        req.setAttribute("attr1", "value1");

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/IncludeExample1");
        dispatcher.include(req, resp);

        out.print("This happens after Include");
    }
}
