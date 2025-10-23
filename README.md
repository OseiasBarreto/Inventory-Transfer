# Inventory Transfer — Desafio Fullstack Integrado

## 🎯 Objetivo
Aplicação fullstack para **gerenciar estoques** e **transferir quantidade entre armazéns**, simulando um **EJB** com versão bugada e **versão corrigida** (validação de saldo, transação e *optimistic locking*).

---

## 🧱 Arquitetura (camadas)
- **DB**: H2 em memória com `schema.sql` + `data.sql` (seed automático).
- **EJB (simulado em Spring)**
    - `InventoryTransferEjbBugado` → *exemplo didático* (não usado pelo controller).
    - `InventoryTransferEjbCorrigido` → usado na API; valida saldo, checa nulos e usa transação/rollback.
- **Backend**: Spring Boot (REST) + Spring Data JPA + Swagger.
- **Frontend**: página estática (HTML/JS) consumindo a API.

---

## 🚀 Como rodar

### 1️⃣ Backend (Spring Boot)
**Requisitos:** JDK 17+ e Maven.

```bash
mvn spring-boot:run
````
API: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui/index.html

H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

User: SA

Password: (vazio)

O banco é populado automaticamente com dois estoques (IDs 1 e 2).

2️⃣ Frontend (lite-server)

Requisitos: Node.js + npm.
````
cd frontend
npm install
npm start
````

Frontend: http://localhost:3000

Página: “Ir para Transferência”

Se der erro de CORS, já está liberado para http://localhost:3000.

Endpoints principais
Transferência
````
POST /api/transfer?origemId={id}&destinoId={id}&quantidade={n}

````
Retornos possíveis:

✅ 200 → “Transferência concluída com sucesso! (OK)”

⚠️ 400 → “Estoque insuficiente” ou “Estoque não encontrado...”

❌ 500 → Erros internos

Estoques
````
GET /api/stocks
POST /api/stocks
````
Bug do EJB e Correção
Versão bugada (InventoryTransferEjbBugado)

Não valida se origem/destino existem.

Não checa saldo antes de transferir.

Sem locking → causa inconsistência em acessos simultâneos.

Versão corrigida (InventoryTransferEjbCorrigido)

Valida existência de origem/destino.

Verifica saldo antes de transferir.

@Transactional garante rollback automático.

@Version em Stock implementa optimistic locking.


🗃️ Estrutura de pastas
````
inventorytransfer/
├─ src/
│  ├─ main/java/inventorytransfer/
│  │  ├─ controller/       # REST controllers
│  │  ├─ ejb/              # EJB bugado + corrigido (simulados como @Service)
│  │  ├─ model/            # Entities (Stock com @Version)
│  │  ├─ repository/       # Spring Data JPA
│  │  └─ config/           # CORS global
│  └─ main/resources/
│     ├─ application.properties
│     ├─ schema.sql
│     └─ data.sql
├─ frontend/
│  └─ src/
│     ├─ index.html
│     └─ app/pages/transfer/{transfer.html, transfer.js}
├─ pom.xml
└─ README.md


🧪 Testes
````
Rodar testes unitários:
``````
mvn test
```````
✅ Transferência válida (saldo atualizado corretamente)
⚠️ Falha por saldo insuficiente (gera rollback)

⚙️ Tecnologias

Java 17+, Spring Boot 3, Spring Data JPA, H2

Swagger (springdoc-openapi)

Node.js, lite-server (frontend simples)

🧪 Exemplos (curl)
````
# Listar estoques
curl http://localhost:8080/api/stocks

# Transferir 10 unidades do estoque 1 para o 2
curl -X POST "http://localhost:8080/api/transfer?origemId=1&destinoId=2&quantidade=10"
````
Decisões de Projeto

O EJB foi simulado com @Service para simplificar a integração no Spring Boot.

Uso de Optimistic Locking para garantir consistência sem travar linhas.

Banco em memória com seed automático para facilitar a avaliação.

✅ Entrega

Backend funcional com EJB corrigido.

Frontend simples integrado (HTML/JS).

Testes unitários e documentação Swagger.

Bug demonstrado na versão “bugada” e corrigido na versão usada.
````
Autor: Oséias Barreto

Entrega: Desafio Fullstack Integrado

Data limite: 24/10/2025
