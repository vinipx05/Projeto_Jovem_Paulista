# 📖 Documentação da API — Jovem Paulista

Base URL: `http://localhost:8080`

---

## 🟢 Status

### GET /status
Verifica se a API está online.

**Resposta:**
```
Jovem Paulista API está online!
```

---

## 👤 Usuários — /usuarios

### GET /usuarios
Lista todos os usuários.

**Resposta 200:**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com",
    "senhaHash": "123456",
    "tipo": "JOVEM",
    "telefone": "81999999999",
    "dataCadastro": "2026-06-02",
    "ativo": true
  }
]
```

---

### GET /usuarios/{id}
Busca um usuário por ID.

**Parâmetro:** `id` (Long) — ID do usuário

**Resposta 200:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "senhaHash": "123456",
  "tipo": "JOVEM",
  "telefone": "81999999999",
  "dataCadastro": "2026-06-02",
  "ativo": true
}
```

---

### POST /usuarios
Cria um novo usuário.

**Body:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senhaHash": "123456",
  "tipo": "JOVEM",
  "telefone": "81999999999",
  "dataCadastro": "2026-06-02",
  "ativo": true
}
```

**Resposta 200:** Objeto do usuário criado com `id` gerado.

---

### PUT /usuarios/{id}
Atualiza um usuário existente.

**Parâmetro:** `id` (Long) — ID do usuário

**Body:**
```json
{
  "nome": "João Silva Atualizado",
  "email": "joao.novo@email.com",
  "telefone": "81988888888"
}
```

**Resposta 200:** Objeto do usuário atualizado.

---

### DELETE /usuarios/{id}
Deleta um usuário.

**Parâmetro:** `id` (Long) — ID do usuário

**Resposta 200:** Sem corpo.

---

## 🧑 Jovens — /jovens

### GET /jovens
Lista todos os jovens cadastrados.

**Resposta 200:**
```json
[
  {
    "id": 1,
    "usuario": { "id": 1, "nome": "João Silva" }, 
    "cpf": "123.456.789-00",
    "dataNascimento": "2005-03-15",
    "cidade": "Paulista",
    "estado": "PE",
    "escolaridade": "Ensino Médio",
    "resumo": "Interesse em desenvolvimento web"
  }
]
```

---

### GET /jovens/{id}
Busca um jovem por ID.

**Parâmetro:** `id` (Long) — ID do jovem

---

### POST /jovens
Cadastra um novo jovem.

**Body:**
```json
{
  "usuario": { "id": 1 },
  "cpf": "123.456.789-00",
  "dataNascimento": "2005-03-15",
  "cidade": "Paulista",
  "estado": "PE",
  "escolaridade": "Ensino Médio",
  "resumo": "Interesse em desenvolvimento web"
}
```

> ⚠️ O campo `usuario.id` deve referenciar um usuário existente com `tipo: "JOVEM"` que ainda não esteja vinculado a outro jovem.

---

### PUT /jovens/{id}
Atualiza dados de um jovem.

**Body:**
```json
{
  "cidade": "Recife",
  "estado": "PE",
  "escolaridade": "Ensino Superior",
  "resumo": "Desenvolvedor Java Júnior"
}
```

---

### DELETE /jovens/{id}
Remove um jovem pelo ID.

---

## 🏢 Empresas — /empresas

### GET /empresas
Lista todas as empresas.

### GET /empresas/{id}
Busca uma empresa por ID.

### POST /empresas
Cadastra uma nova empresa.

**Body:**
```json
{
  "usuario": { "id": 2 },
  "cnpj": "12.345.678/0001-99",
  "razaoSocial": "Tech Paulista LTDA",
  "setor": "Tecnologia",
  "cidade": "Paulista",
  "estado": "PE",
  "descricao": "Empresa de desenvolvimento de software"
}
```

### PUT /empresas/{id}
Atualiza dados de uma empresa.

**Body:**
```json
{
  "razaoSocial": "Tech Paulista LTDA",
  "setor": "Tecnologia",
  "cidade": "Paulista",
  "estado": "PE",
  "descricao": "Descrição atualizada"
}
```

### DELETE /empresas/{id}
Remove uma empresa pelo ID.

---

## 💼 Vagas — /vagas

### GET /vagas
Lista todas as vagas.

### GET /vagas/ativas
Lista somente as vagas ativas.

### GET /vagas/{id}
Busca uma vaga por ID.

### POST /vagas
Cria uma nova vaga.

**Body:**
```json
{
  "empresa": { "id": 1 },
  "titulo": "Desenvolvedor Java Júnior",
  "descricao": "Vaga para desenvolvedor backend com conhecimento em Java e Spring Boot",
  "tipo": "CLT",
  "modalidade": "Híbrido",
  "cidade": "Paulista",
  "estado": "PE",
  "salario": 2500.00,
  "dataPublicacao": "2026-06-02",
  "dataEncerramento": "2026-07-02",
  "ativa": true
}
```

> Tipos disponíveis: `CLT`, `PJ`, `Estágio`
> Modalidades disponíveis: `Presencial`, `Remoto`, `Híbrido`

### PUT /vagas/{id}
Atualiza uma vaga existente.

**Body:**
```json
{
  "titulo": "Desenvolvedor Java Pleno",
  "descricao": "Descrição atualizada",
  "tipo": "CLT",
  "modalidade": "Remoto",
  "cidade": "Recife",
  "salario": 4000.00,
  "dataEncerramento": "2026-08-02"
}
```

### DELETE /vagas/{id}
Remove uma vaga pelo ID.

---

## 📋 Candidaturas — /candidaturas

### GET /candidaturas
Lista todas as candidaturas.

### GET /candidaturas/{id}
Busca uma candidatura por ID.

### GET /candidaturas/jovem/{jovemId}
Lista todas as candidaturas de um jovem específico.

**Parâmetro:** `jovemId` (Long) — ID do jovem

### GET /candidaturas/vaga/{vagaId}
Lista todas as candidaturas de uma vaga específica.

**Parâmetro:** `vagaId` (Long) — ID da vaga

### POST /candidaturas
Registra uma candidatura de um jovem a uma vaga.

**Body:**
```json
{
  "jovem": { "id": 1 },
  "vaga": { "id": 1 }
}
```

> O status é definido automaticamente como `PENDENTE` e a data como a data atual.

### PATCH /candidaturas/{id}/status
Atualiza o status de uma candidatura.

**Parâmetro:** `id` (Long) — ID da candidatura

**Query param:** `status` — novo status

**Exemplo:**
```
PATCH /candidaturas/1/status?status=APROVADO
```

> Status disponíveis: `PENDENTE`, `APROVADO`, `REPROVADO`

### DELETE /candidaturas/{id}
Remove uma candidatura pelo ID.

---

## 🛠️ Habilidades — /habilidades

### GET /habilidades
Lista todas as habilidades cadastradas.

### GET /habilidades/{id}
Busca uma habilidade por ID.

### POST /habilidades
Cadastra uma nova habilidade.

**Body:**
```json
{
  "nome": "Java",
  "categoria": "Backend"
}
```

> Categorias sugeridas: `Backend`, `Frontend`, `Mobile`, `Banco de Dados`, `DevOps`

### DELETE /habilidades/{id}
Remove uma habilidade pelo ID.

---

## ⚠️ Códigos de Resposta

| Código | Descrição |
|--------|-----------|
| `200` | Sucesso |
| `400` | Bad Request — dados inválidos ou faltando |
| `404` | Not Found — recurso não encontrado |
| `405` | Method Not Allowed — método HTTP incorreto |
| `500` | Internal Server Error — erro no servidor |

---

## 🔗 Ordem recomendada para testes

1. `POST /usuarios` — criar usuário
2. `POST /jovens` — criar jovem (precisa do id do usuário)
3. `POST /empresas` — criar empresa (precisa de outro usuário com tipo EMPRESA)
4. `POST /habilidades` — criar habilidades
5. `POST /vagas` — criar vaga (precisa do id da empresa)
6. `POST /candidaturas` — candidatar jovem à vaga
7. `PATCH /candidaturas/{id}/status` — atualizar status da candidatura
