package com.exemplo.hello.httpservletresponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ResponseHeaderExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setIntHeader("Refresh", 5);
        resp.setContentType("text/plain;charset=UTF-8");

        resp.setStatus(500); // It doesn't work as the course. On the browser shows the content with status 500 instead of showing "The website cannot display the page"

        // Text Stream
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(new Date());
    }
}
