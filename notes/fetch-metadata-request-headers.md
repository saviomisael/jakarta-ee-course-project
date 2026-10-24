Anotações de cabeçalhos da tela do HttpSevletRequestExample

Sec-Fetch-Site: same-origin
: O que significa: Indica a relação entre a origem que fez a requisição e o servidor que está hospedando o recurso.

Sec-Fetch-Mode: navigate
: O que significa: Indica o "modo" ou a intenção da requisição.

Sec-Fetch-User: ?1
: O que significa: Indica se a requisição foi ou não iniciada diretamente por uma ação do usuário (um clique, um toque ou um pressionamento de tecla).

Sec-Fetch-Dest: document
: O que significa: Indica o destino da requisição — ou seja, o que o navegador planeja fazer com o resultado que vai receber.

Resumo do Cenário:
: O conjunto desses quatro cabeçalhos diz ao seu servidor (ou Servlet Java):
"Uma pessoa real clicou em um link (Sec-Fetch-User: ?1 e Sec-Fetch-Mode: navigate) dentro do nosso próprio site (Sec-Fetch-Site: same-origin) para abrir uma nova página HTML completa (Sec-Fetch-Dest: document)."

Fontes:
- https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/Sec-Fetch-Site
- https://http.dev/sec-fetch-user
- https://www.w3.org/TR/fetch-metadata/
