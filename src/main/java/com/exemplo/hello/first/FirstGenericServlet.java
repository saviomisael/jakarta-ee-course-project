package com.exemplo.hello.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstGenericServlet extends GenericServlet {
    // Java 25 documentation
    // The lookup method returns the ObjectStreamClass descriptor for the specified
    // class in the virtual machine. If the class has defined serialVersionUID it is
    // retrieved from the class. If the serialVersionUID is not defined by the
    // class, it is computed from the definition of the class in the virtual
    // machine. If the specified class is not serializable or externalizable, null
    // is returned.
    // Link:
    // https://docs.oracle.com/en/java/javase/25/docs/specs/serialization/class.html

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter printWriter = res.getWriter(); // uses text stream
        printWriter.print("<h1>Hello World from Generic Servlet!</h1>");
        printWriter.print("<h1>Today is " + new Date() + "</h1>");
    }
}
