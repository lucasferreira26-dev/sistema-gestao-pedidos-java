# 🛒 Sistema de Gestão de Pedidos (Console)

Sistema de gestão de pedidos estilo e-commerce desenvolvido em **Java**, utilizando arquitetura em camadas e princípios de orientação a objetos.

Projeto desenvolvido para fins de estudo e aprimoramento de conceitos como:

- Programação Orientada a Objetos
- Arquitetura em camadas
- Separação de responsabilidades
- Exceptions customizadas
- Enum
- Validações
- Simulação de pagamento

---

## 🏗 Arquitetura do Projeto

O sistema foi estruturado em camadas:

```
br.com.sistemaPedidos
│
├── domain
│   ├── model
│   ├── enums
│   └── exceptions
│
├── repository
│
├── service
│
├── consoleUI
│
└── util
```

### 📌 Responsabilidades

- **Domain** → Entidades e regras de negócio
- **Repository** → Persistência em memória
- **Service** → Regras de negócio e orquestração
- **ConsoleUI** → Interação com o usuário
- **Util** → Validações

---

## ⚙ Funcionalidades

### 👥 Clientes
- Cadastrar cliente
- Listar clientes
- Buscar cliente por ID
- Remover cliente

### 🛍 Produtos
- Cadastrar produto
- Listar produtos
- Buscar produto
- Remover produto
- Alterar preço

### 📦 Pedidos
- Criar pedido
- Adicionar itens
- Remover itens
- Cancelar pedido
- Listar pedidos

### 💳 Pagamento
Simulação de pagamento com:
- PIX
- Cartão de Crédito
- Cartão de Débito
- Boleto

Com validação de dados antes da aprovação.

---

## 💡 Conceitos Aplicados

- Injeção de dependência via construtor
- Encapsulamento
- Enum para estados e tipos
- Exceptions customizadas
- Validação centralizada
- Separação clara de camadas

---

## ▶ Como Executar

1. Clone o repositório
2. Abra no IntelliJ
3. Execute a classe `Main` na pasta "app"
4. Utilize o menu interativo via console

---

## 📚 Objetivo do Projeto

Projeto criado com foco em aprendizado e prática de modelagem de sistemas backend em Java.

---

## 👨‍💻 Autor

Desenvolvido por Pedro Lucas Ferreira de Sousa.
