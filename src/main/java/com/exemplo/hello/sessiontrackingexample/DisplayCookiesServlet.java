package com.exemplo.hello.sessiontrackingexample;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        for(int i = 0; i < cookies.length; i++) {
            out.print("<h3>Cookie " + (i + 1) + " : " + cookies[i].getName() + " = " + cookies[i].getValue() + "</h3>");
        }
    }
}
