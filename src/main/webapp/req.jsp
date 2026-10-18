<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ESend Data</title>
  </head>
  <body>
    <form method="post" action="${pageContext.request.contextPath}/testRequest">
      <label for="data">Data:</label>
      <input type="text" id="data" name="data" required />
      <button type="submit">Send</button>
    </form>
  </body>
</html>
