<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- With it, we can access the user profile stored in the session. ID is the variable name that will be available in the jsp. -->
<jsp:useBean
  id="profile"
  class="com.exemplo.hello.sessionpojo.UserProfile"
  scope="session"
/>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <title>Perfil salvo</title>
  </head>
  <body>
    <h1>Perfil salvo na sessão</h1>
    <p>Nome: <c:out value="${profile.name}" /></p>
    <p>E-mail: <c:out value="${profile.email}" /></p>
    <p><%= profile.getName() %></p>
    <p><jsp:getProperty name="profile" property="name" /></p>
    <p>
      <a href="${pageContext.request.contextPath}/session-profile"
        >Editar perfil</a
      >
    </p>
  </body>
</html>
