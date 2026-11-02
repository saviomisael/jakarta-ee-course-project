<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>Hi, I am page 1</h1>
    <!-- This is a include action. This affect the performance -->
    <!-- <jsp:include page="page2.jsp" /> -->

    <!-- This is a directive and it is more performant -->
    <%@ include file="page2.jsp" %>
  </body>
</html>
