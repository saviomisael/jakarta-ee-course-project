<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Página não encontrada</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            color: #333;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        .container {
            text-align: center;
            background: #fff;
            padding: 40px 60px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 6rem;
            margin: 0;
            color: #d32f2f;
        }

        h2 {
            margin: 10px 0 20px;
            font-size: 2rem;
        }

        p {
            margin: 0 0 20px;
            font-size: 1.1rem;
        }

        a {
            display: inline-block;
            text-decoration: none;
            background: #1976d2;
            color: #fff;
            padding: 12px 24px;
            border-radius: 8px;
            font-weight: bold;
        }

        a:hover {
            background: #1565c0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>404</h1>
        <h2>Página não encontrada</h2>
        <p>Desculpe, a página que você tentou acessar não existe ou foi removida.</p>
        <a href="/">Voltar para a página inicial</a>
    </div>
</body>
</html>
