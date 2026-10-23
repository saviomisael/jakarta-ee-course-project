<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Entrar</title>
	<style>
		* { box-sizing: border-box; }
		body {
			min-height: 100vh;
			margin: 0;
			display: grid;
			place-items: center;
			padding: 24px;
			background: #f3f4f6;
			color: #1f2937;
			font-family: Arial, sans-serif;
		}
		.login-card {
			width: min(100%, 400px);
			padding: 36px;
			background: #fff;
			border-radius: 12px;
			box-shadow: 0 12px 32px rgba(0, 0, 0, .08);
		}
		h1 { margin: 0 0 8px; font-size: 1.75rem; }
		.subtitle { margin: 0 0 28px; color: #6b7280; }
		.field { margin-bottom: 18px; }
		label { display: block; margin-bottom: 7px; font-weight: 600; }
		input[type="email"], input[type="password"] {
			width: 100%;
			padding: 12px 14px;
			border: 1px solid #d1d5db;
			border-radius: 7px;
			font: inherit;
		}
		input:focus { outline: 2px solid #2563eb; outline-offset: 1px; }
		button {
			width: 100%;
			padding: 12px;
			border: 0;
			border-radius: 7px;
			background: #2563eb;
			color: #fff;
			font: inherit;
			font-weight: 700;
			cursor: pointer;
		}
		button:hover { background: #1d4ed8; }
		.signup { margin: 22px 0 0; text-align: center; color: #6b7280; }
		a { color: #2563eb; text-decoration: none; }
		a:hover { text-decoration: underline; }
	</style>
</head>
<body>
	<main class="login-card">
		<h1>Bem-vindo de volta</h1>
		<p class="subtitle">Entre na sua conta para continuar.</p>
		<form action="loginServlet" method="post">
			<div class="field">
				<label for="email">E-mail</label>
				<input id="email" name="email" type="email" autocomplete="username" required>
			</div>
			<div class="field">
				<label for="password">Senha</label>
				<input id="password" name="password" type="password" autocomplete="current-password" required>
			</div>
			<button name="login" type="submit">Entrar</button>
		</form>
		<p class="signup">Ainda não tem uma conta? <a href="cadastro.jsp">Cadastre-se</a></p>
	</main>
</body>
</html>
