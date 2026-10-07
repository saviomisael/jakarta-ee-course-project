# Meu Projeto Tomcat

Aplicação web Java empacotada como WAR com Maven.

## Pré-requisitos

- JDK 25
- Maven
- Apache Tomcat 9

O projeto usa a API `javax.servlet` 4.0.1. Por isso, use Tomcat 9; Tomcat 10 ou superior usa `jakarta.servlet` e não é compatível com este projeto sem alterações.

Confira as versões instaladas:

```bash
java -version
mvn -version
```

## Compilar

Na pasta raiz do projeto, execute:

```bash
mvn clean package
```

O WAR gerado ficará em:

```text
target/meu-projeto-tomcat.war
```

## Implantar no Tomcat

Copie o WAR para a pasta `webapps` da instalação do Tomcat. No Linux, se `CATALINA_HOME` apontar para a pasta do Tomcat:

```bash
cp target/meu-projeto-tomcat.war "$CATALINA_HOME/webapps/"
"$CATALINA_HOME/bin/startup.sh"
```

O Tomcat implantará o WAR automaticamente. Acesse:

```text
http://localhost:8080/meu-projeto-tomcat/hello
```

Para parar o Tomcat:

```bash
"$CATALINA_HOME/bin/shutdown.sh"
```
