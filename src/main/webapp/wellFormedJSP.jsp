<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
  <jsp:directive.page import="java.util.Date" />
	<html>
		<head>
			<title>JSP bem formado</title>
		</head>
		<body>
			<jsp:expression>new Date()</jsp:expression>
		</body>
	</html>
</jsp:root>
