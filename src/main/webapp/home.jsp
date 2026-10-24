<%@ page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Example</title>
  </head>
  <body>
    <%
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
        throw new Exception(); // This will trigger the error page, but the error page from web.xml will be used instead of the error.jsp page because the error page from web.xml has a higher priority.
      } else {
        out.println("Welcome, " + username + "!");
      }
     %>
  </body>
</html>
