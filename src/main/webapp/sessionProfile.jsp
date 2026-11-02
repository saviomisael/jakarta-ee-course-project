<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- With it, we can access the user profile stored in the session. ID is the variable name that will be available in the jsp. -->
<jsp:useBean
  id="profile"
  class="com.exemplo.hello.sessionpojo.UserProfile"
  scope="session"
/>
<jsp:useBean id="currentDate" class="java.util.Date" />
<jsp:useBean id="random" class="java.util.Random" />
<c:set var="randomAmount" value="${random.nextDouble() * 1000}" />
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <title>Perfil salvo</title>
  </head>
  <body>
    <h1>Perfil salvo na sessão</h1>
    <p>Nome: <c:out value="${profile.name}" /></p>
    <p>Nome: <c:out value="${fn:toLowerCase(profile.name)}" /></p>
    <p>E-mail: <c:out value="${profile.email}" /></p>
    <p>Data atual: <fmt:formatDate value="${currentDate}" pattern="dd/MM/yyyy" /></p>
    <fmt:setLocale value="pt_BR" />
    <p>Valor aleatório: <fmt:formatNumber value="${randomAmount}" type="currency" currencyCode="BRL" /></p>
    <p><%= profile.getName() %></p>
    <p><jsp:getProperty name="profile" property="name" /></p>
    <p>
      <a href="${pageContext.request.contextPath}/session-profile"
        >Editar perfil</a
      >
    </p>
  </body>
</html>
