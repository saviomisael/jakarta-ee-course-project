package com.exemplo.hello.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FeedbackServlet extends HttpServlet {
    private String companyInitParameter = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        companyInitParameter = config.getInitParameter("company-email");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 - read init param
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<h2>Init Param Value is " + companyInitParameter + "</h2>");

        // 2 - read feedback param
        String feedbackParam = req.getParameter("feedbackParam");

        // 34 - send an email
        printWriter.print("<h3> We will send " + feedbackParam + " to " + companyInitParameter + "</h3>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
