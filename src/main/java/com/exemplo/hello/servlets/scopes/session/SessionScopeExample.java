package com.exemplo.hello.servlets.scopes.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionScopeExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getCookies();// cookies are saved on the browser and session on the server

        PrintWriter printWriter = resp.getWriter().append("Served at: ").append(req.getContextPath());

        HttpSession httpSession = req.getSession();

        Object sessionObj = httpSession.getAttribute("isVisited");

        if(sessionObj == null) {
            httpSession.setAttribute("isVisited", true);
            printWriter.print("\nThanks for visiting our application");
        } else {
            printWriter.print("\nWelcome back");
        }
    }
}
