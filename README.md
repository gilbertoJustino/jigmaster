# 🎣 JigMaster

Sistema de Gerenciamento de Fábrica de Iscas Artificiais Jig

## 📋 Sobre o Projeto

JigMaster é um sistema completo para gerenciar todos os aspectos de uma fábrica de jigs de pesca, incluindo:

- 📦 Controle de produtos (jigs) com modelos, cores e gramaturas
- 👥 Gestão de clientes
- 💰 Registro e análise de vendas
- 🛠️ Controle de materiais e custos de produção
- 📊 Relatórios e dashboards de vendas

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Maven**
- **PostgreSQL**
- **Lombok**

## 📁 Estrutura do Projeto

```
com.jigmaster
├── controller/      # Controladores REST
├── service/         # Lógica de negócio
├── repository/      # Repositórios JPA
├── model/           # Entidades do banco
├── dto/             # Data Transfer Objects
├── enums/           # Enumerações
└── exception/       # Tratamento de exceções
```

## 🗂️ Entidades Principais

- **Jig**: Produtos fabricados (modelo, cor, gramatura, preço)
- **Cliente**: Cadastro de compradores
- **Venda**: Transações de vendas
- **ItemVenda**: Itens de cada venda
- **Material**: Insumos de produção
- **CompraMaterial**: Registro de compras de materiais

## ⚙️ Pré-requisitos

Antes de começar, você precisa ter instalado:

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [PostgreSQL 14+](https://www.postgresql.org/download/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (recomendado)

## 🔧 Configuração do Ambiente

### 1. Clone o repositório

```bash
git clone https://github.com/gilbertoJustino/jigmaster.git
cd jigmaster
```

### 2. Configure o banco de dados

Crie um banco de dados PostgreSQL:

```sql
CREATE DATABASE jigmaster_db;
```

### 3. Configure o arquivo `application.properties`

Edite `src/main/resources/application.properties`:

```properties
# Application
spring.application.name=jigmaster
server.port=8080

# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/jigmaster_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 4. Execute o projeto

```bash
mvn spring-boot:run
```

Ou pelo IntelliJ: clique com botão direito em `JigMasterApplication.java` → Run

## 📡 Endpoints da API

### Jigs
- `GET /api/jigs` - Listar todos os jigs
- `POST /api/jigs` - Cadastrar novo jig
- `GET /api/jigs/{id}` - Buscar jig por ID
- `PUT /api/jigs/{id}` - Atualizar jig
- `DELETE /api/jigs/{id}` - Excluir jig

### Clientes
- `GET /api/clientes` - Listar todos os clientes
- `POST /api/clientes` - Cadastrar novo cliente
- `GET /api/clientes/{id}` - Buscar cliente por ID
- `PUT /api/clientes/{id}` - Atualizar cliente
- `DELETE /api/clientes/{id}` - Excluir cliente

### Vendas
- `GET /api/vendas` - Listar todas as vendas
- `POST /api/vendas` - Registrar nova venda
- `GET /api/vendas/{id}` - Buscar venda por ID

### Relatórios
- `GET /api/relatorios/jigs-mais-vendidos` - Jigs mais vendidos
- `GET /api/relatorios/clientes-top` - Clientes que mais compraram
- `GET /api/relatorios/faturamento` - Receitas e gastos

*(Documentação completa em desenvolvimento)*

## 📊 Funcionalidades

- [x] Configuração inicial do projeto
- [ ] CRUD de Jigs
- [ ] CRUD de Clientes
- [ ] Sistema de Vendas
- [ ] Controle de Materiais
- [ ] Relatórios de Vendas
- [ ] Análise de Lucratividade
- [ ] Dashboard de Métricas

## 📝 Licença

Este projeto é de uso pessoal para gerenciamento de fábrica de iscas artificiais.

## 👤 Autor

Desenvolvido por **Gilberto Justino**

- GitHub: [@gilbertoJustino](https://github.com/gilbertoJustino)

---

⭐ Feito com dedicação para otimizar a produção de jigs!