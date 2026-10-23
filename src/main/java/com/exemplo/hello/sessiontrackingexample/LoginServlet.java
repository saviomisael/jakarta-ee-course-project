package com.exemplo.hello.sessiontrackingexample;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        resp.setContentType("text/html;charset=UTF-8");

        Cookie emailCookie = new Cookie("email", email);
        emailCookie.setHttpOnly(true);
        emailCookie.setSecure(req.isSecure());
        emailCookie.setPath(req.getContextPath().isEmpty() ? "/" : req.getContextPath());
        resp.addCookie(emailCookie);

        PrintWriter out = resp.getWriter();
        out.print("<a href=\"" + req.getContextPath() + "/displayCookiesServlet\">Display Cookies</a>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
