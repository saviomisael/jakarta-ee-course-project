package com.exemplo.hello.httprequest.example;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class HttpServletRequestExample extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Dados da Request</title></head><body>");
        out.println("<h1>Informações Completas da HttpServletRequest</h1>");

        // 1. Informações Básicas e de Conexão
        out.println("<h2>1. Informações Gerais</h2>");
        out.println("<ul>");
        out.println("<li><b>Método HTTP:</b> " + req.getMethod() + "</li>");
        out.println("<li><b>URI da Requisição:</b> " + req.getRequestURI() + "</li>");
        out.println("<li><b>URL da Requisição:</b> " + req.getRequestURL().toString() + "</li>");
        out.println("<li><b>Context Path:</b> " + req.getContextPath() + "</li>");
        out.println("<li><b>Servlet Path:</b> " + req.getServletPath() + "</li>");
        out.println("<li><b>Query String:</b> " + req.getQueryString() + "</li>");
        out.println("<li><b>Protocolo:</b> " + req.getProtocol() + "</li>");
        out.println("<li><b>Esquema (Scheme):</b> " + req.getScheme() + "</li>");
        out.println("<li><b>Servidor (Server Name):</b> " + req.getServerName() + "</li>");
        out.println("<li><b>Porta do Servidor:</b> " + req.getServerPort() + "</li>");
        out.println("<li><b>Endereço Remoto (IP do Cliente):</b> " + req.getRemoteAddr() + "</li>");
        out.println("<li><b>Nome Remoto do Cliente:</b> " + req.getRemoteHost() + "</li>");
        out.println("<li><b>Porta Remota:</b> " + req.getRemotePort() + "</li>");
        out.println("<li><b>Locale:</b> " + req.getLocale().toString() + "</li>");
        out.println("<li><b>Content Length:</b> " + req.getContentLength() + "</li>");
        out.println("<li><b>Content Type:</b> " + req.getContentType() + "</li>");
        out.println("</ul>");

        // 2. Cabeçalhos (Headers)
        out.println("<h2>2. Cabeçalhos (Headers)</h2>");
        out.println("<table border='1' cellpadding='5'><tr><th>Header</th><th>Valor</th></tr>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<tr><td>" + headerName + "</td><td>" + req.getHeader(headerName) + "</td></tr>");
        }
        out.println("</table>");

        // 3. Parâmetros da Requisição (Query String ou Corpo POST)
        out.println("<h2>3. Parâmetros</h2>");
        out.println("<table border='1' cellpadding='5'><tr><th>Parâmetro</th><th>Valor(es)</th></tr>");
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();
            out.println("<tr><td>" + paramName + "</td><td>" + String.join(", ", paramValues) + "</td></tr>");
        }
        out.println("</table>");

        // 4. Atributos da Request
        out.println("<h2>4. Atributos da Request</h2>");
        out.println("<table border='1' cellpadding='5'><tr><th>Atributo</th><th>Valor</th></tr>");
        Enumeration<String> attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attrName = attributeNames.nextElement();
            out.println("<tr><td>" + attrName + "</td><td>" + req.getAttribute(attrName) + "</td></tr>");
        }

        // 5. Cookies e suas propriedades detalhadas
        out.println("<h2>5. Cookies Detalhados</h2>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr>" +
                "<th>Nome</th>" +
                "<th>Valor</th>" +
                "<th>Max Age (s)</th>" +
                "<th>Domínio</th>" +
                "<th>Caminho</th>" +
                "<th>Secure</th>" +
                "<th>HttpOnly</th>" +
                "<th>Versão</th>" +
                "</tr>");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<tr>");
                out.println("<td>" + cookie.getName() + "</td>");
                out.println("<td>" + cookie.getValue() + "</td>");
                out.println("<td>" + cookie.getMaxAge() + "</td>");
                out.println("<td>" + (cookie.getDomain() != null ? cookie.getDomain() : "Padrão") + "</td>");
                out.println("<td>" + (cookie.getPath() != null ? cookie.getPath() : "Padrão") + "</td>");
                out.println("<td>" + cookie.getSecure() + "</td>");
                out.println("<td>" + cookie.isHttpOnly() + "</td>");
                out.println("<td>" + cookie.getVersion() + "</td>");
                out.println("</tr>");
            }
        } else {
            out.println("<tr><td colspan='8'>Nenhum cookie enviado.</td></tr>");
        }
        out.println("</table>");

        out.println("</body></html>");
    }
}
