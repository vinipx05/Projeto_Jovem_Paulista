# Jovem Paulista

## 📌 Descrição do Projeto

O **Jovem Paulista** é uma plataforma desenvolvida para aproximar jovens do mercado de trabalho, conectando oportunidades, capacitação e desenvolvimento profissional. O projeto foi criado para a disciplina de Back-End da faculdade, aplicando conceitos de APIs, banco de dados e regras de negócio.

---

## 🎯 Objetivo

O projeto busca resolver a dificuldade que muitos jovens enfrentam ao entrar no mercado de trabalho, oferecendo uma plataforma que conecta candidatos a oportunidades profissionais e promove desenvolvimento pessoal e digital.

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- PostgreSQL
- Spring DAta JPA
- Lombok
- Swagger
- SQL
- Maven
- Git e GitHub
- Postman

---

👨‍💻 Integrantes do Grupo
- Vinicius Gabriel
- Felipe Lino
- Bruno Henrique
- Antônio Carlos
- Pedro Melo

---

# 🚀 Como Rodar o Projeto

## Pré-requisitos

Antes de iniciar, você precisa ter instalado:

* Java JDK 25 ou superior
* Maven
* PostgreSQL
* Git
* IDE (IntelliJ IDEA, VS Code ou Eclipse)

---

## 📥 Clonando o Repositório

Clone o projeto para sua máquina:

```bash
git clone https://github.com/vinipx05/Projeto_Jovem_Paulista.git
```

Entre na pasta do projeto:

```bash
cd Projeto_Jovem_Paulista
```

---

## 🗄️ Configurando o Banco de Dados

Crie um banco de dados PostgreSQL chamado:

```sql
CREATE DATABASE jovempaulista;
```

Configure as credenciais do banco no arquivo:

```text
src/main/resources/application.yml
```

Exemplo:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/jovempaulista
    username: postgres
    password: sua_senha

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

> Altere apenas o usuário e a senha conforme sua instalação local do PostgreSQL.

---

## 📦 Instalando as Dependências

Execute o comando abaixo na raiz do projeto:

```bash
mvn clean install
```

---

## ▶️ Executando a Aplicação

Inicie a API com:

```bash
mvn spring-boot:run
```

Ou execute a classe principal:

```text
ApiApplication.java
```

pela sua IDE.

---

## ✅ Verificando se a Aplicação Está Online

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/status
```

Resposta esperada:

```text
Jovem Paulista API está online!
```

---

## 📚 Documentação

A documentação completa dos endpoints está disponível no arquivo:

```text
API_ENDPOINTS.md
```

> ⚠️ Este projeto foi desenvolvido utilizando Java JDK 25. Versões anteriores podem não ser compatíveis.

