<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Perfil na sessão</title>
</head>
<body>
    <h1>Salvar perfil na sessão</h1>
    <c:if test="${not empty errorMessage}">
        <p role="alert"><c:out value="${errorMessage}" /></p>
    </c:if>
    <form action="${pageContext.request.contextPath}/session-profile" method="post">
        <label for="name">Nome:</label>
        <input id="name" name="name" type="text" required>

        <label for="email">E-mail:</label>
        <input id="email" name="email" type="email" required>

        <button type="submit">Salvar</button>
    </form>
</body>
</html>
