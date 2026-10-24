<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Example</title>
  </head>
  <body>
    <form action="/meu-projeto-tomcat/home.jsp">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required />
      <br />
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required />
      <br />
      <input type="submit" value="Login" />
    </form>
  </body>
</html>
