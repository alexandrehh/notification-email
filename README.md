# 📧 Projeto de Notificações por E-mail

[![Java](https://img.shields.io/badge/Java-11+-orange?logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7.13-green?logo=spring)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue?logo=postgresql)](https://www.postgresql.org/)
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.8+-yellow?logo=rabbitmq)](https://www.rabbitmq.com/)
[![Maven](https://img.shields.io/badge/Maven-3.x+-red?logo=apachemaven)](https://maven.apache.org/)

## 📋 Índice

- [Tecnologias](#tecnologias)
- [Instalação](#instalação)
- [Configuração](#configuração)

---

## 🛠 Tecnologias

- **Java 11** - Linguagem principal
- **Spring Boot** 2.7.13 - Framework backend
- **Spring Data JPA**
- **RabbitMQ** - Mensageria
- **PostgreSQL** - Banco de dados
- **Mockito** - Testes unitários
- **Lombok**
- **Maven**

---

## 🔨 Instalação

### Pré-requisitos

- **Java** 11 ou superior instalado
- **RabbitMQ** em execução
- **PostgreSQL** configurado e rodando
- **Maven** para gerenciar as dependências do projeto
  
## ⚙️ Configuração

### Passos para rodar o projeto localmente

1. Clone o repositório:

   SSH
    ```
    git@github.com:alexandrehh/notification-email.git
    ```
   Http
    ```
    https://github.com/alexandrehh/notification-email.git
    ```

2. Configurar o arquivo `application.properties`

### PostgreSQL

   ```
     spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
   ```

### RabbitMQ

   ```
      spring.rabbitmq.addresses=url_rabbit
      spring.rabbitmq.queue=rabbit_queue
   ```

### SMTP (para envio de e-mails)

   ```
      spring.mail.host=smtp.exemplo.com
      spring.mail.port=587
      spring.mail.username=seu_email
      spring.mail.password=sua_senha
      spring.mail.properties.mail.smtp.auth=true
      spring.mail.properties.mail.smtp.starttls.enable=true
   ```
