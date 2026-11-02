package com.exemplo.hello.sessionpojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/session-profile")
public class SessionProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/sessionProfileForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (name == null || name.isBlank() || email == null || email.isBlank()) {
            request.setAttribute("errorMessage", "Informe seu nome e e-mail.");
            request.getRequestDispatcher("/sessionProfileForm.jsp").forward(request, response);
            return;
        }

        UserProfile profile = new UserProfile(name.trim(), email.trim());
        request.getSession().setAttribute("profile", profile);
        request.getRequestDispatcher("/sessionProfile.jsp").forward(request, response);
    }
}
