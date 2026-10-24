<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Example</title>
</head>
<body>
  <!-- This is a declaration -->
  <%!
    public String sayHello() {
      return "Hello from JSP";
    }
  %>

  <br/>

  <%= sayHello() %>

  <br/>

    <!-- When you use the PrintWriter from the response, it shows the content before all html -->
  <%
    out.print(sayHello());
    out.println("<br/>");
    response.getWriter().println(sayHello());
  %>
</body>
</html>