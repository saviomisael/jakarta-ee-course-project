package com.exemplo.hello.httpservletresponse;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class BinaryStreamExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        // Binary Stream
        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            try (InputStream inputStream = getServletContext().getResourceAsStream("/images/200.jpg")) {
                byte[] imageBytes = new byte[inputStream.available()];
                inputStream.read(imageBytes);

                outputStream.write(imageBytes);
                outputStream.flush();
            }
        }
    }
}
