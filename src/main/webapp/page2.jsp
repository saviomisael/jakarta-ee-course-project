<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>Hi, I am Page 2</body>
  <!-- This forward is a server redirect, so it doesn't change the URL in the browser -->
  <jsp:forward page="page3.jsp">
    <jsp:param name="param1" value="value1" />
  </jsp:forward>
</html>
