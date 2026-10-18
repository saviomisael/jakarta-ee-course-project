<!-- You need this directive to indicate to tomcat that this is using UTF-8 -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Erro Geral</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
            margin: 0;
            padding: 40px 20px;
            text-align: center;
        }
        .container {
            max-width: 700px;
            margin: 0 auto;
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 30px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }
        h1 {
            color: #c0392b;
            margin-bottom: 20px;
        }
        p {
            font-size: 16px;
            line-height: 1.6;
        }
        .details {
            background: #f9f9f9;
            border-left: 4px solid #c0392b;
            padding: 15px;
            margin-top: 20px;
            text-align: left;
            word-break: break-word;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #2980b9;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Ops! Ocorreu um erro.</h1>
        <p>Desculpe, mas houve um problema ao processar sua solicitação.</p>
        <p>Status da resposta: <%= response.getStatus() %></p>

        <% if (exception != null) { %>
            <div class="details">
                <strong>Detalhes:</strong><br>
                <%= exception.getClass().getName() %><br>
                <%= exception.getMessage() %>
            </div>
        <% } else { %>
            <div class="details">
                <strong>Detalhes:</strong><br>
                Nenhuma exceção foi informada para esta página.
            </div>
        <% } %>

        <a href="/">Voltar para a página inicial</a>
    </div>
</body>
</html>
