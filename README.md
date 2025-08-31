# Projeto de Notificações por E-mail

## Índice

- [Tecnologias](#tecnologias)
- [Instalação](#instalação)
- [Configuração](#configuração)

---

## Tecnologias

- Java 11 - Linguagem principal
- Spring Boot 2.7.13 - Framework backend
- Spring Data JPA
- RabbitMQ - Mensageria
- PostgreSQL - Banco de dados
- Mockito - Testes unitários
- Lombok

---

## Instalação

### Pré-requisitos

- Java 11 ou superior instalado
- RabbitMQ em execução
- PostgreSQL configurado e rodando

## Configuração

### Passos para rodar o projeto localmente

1. Clone o repositório:

```SSH
git@github.com:alexandrehh/PROJETO.git

```HTTP
https://github.com/alexandrehh/PROJETO.git

2. Configurar application.properties

### PostgreSQL

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

### RabbitMQ

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=usuario_rabbit
spring.rabbitmq.password=senha_rabbit

### SMTP (para envio de e-mails)

```properties
spring.mail.host=smtp.exemplo.com
spring.mail.port=587
spring.mail.username=seu_email
spring.mail.password=sua_senha
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
