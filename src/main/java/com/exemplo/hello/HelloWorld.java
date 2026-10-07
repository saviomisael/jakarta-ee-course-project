package com.exemplo.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This annotation maps the servlet to the URL pattern "/hello" replacing the web.xml configuration
@WebServlet("/hello")
public class HelloWorld extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("mensagem", "Mensagem enviada pelo controller");
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }
}
