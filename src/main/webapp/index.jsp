<%@page import="java.util.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>

<!DOCTYPE html>
<html>
<head>
  <title>Hello World!</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>Hello World!</h2>
<p>${mensagem}</p>
<p><%= new Date() %></p>
<p><%= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()) %></p>
</body>
</html>
