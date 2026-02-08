# 🛒 Sistema de Gestão de Pedidos (Console)

Sistema de gestão de pedidos estilo e-commerce desenvolvido em **Java**, utilizando arquitetura em camadas e princípios de orientação a objetos(projeto ainda em estágio inicial).

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

### 🖥 Demonstração
- 📸 Menu Principal
  
  <img width="717" height="393" alt="menu" src="https://github.com/user-attachments/assets/96a0c7b3-db60-4a88-b663-b80f337facbd" />

- 📸 Fluxo de Pedido

  <img width="658" height="578" alt="criando_pedido" src="https://github.com/user-attachments/assets/ae05c2c8-a2f2-432f-981a-3a841b80520d" />

  <img width="1582" height="723" alt="adicionando_itens_ao_pedido" src="https://github.com/user-attachments/assets/c4305762-0ed4-413f-a552-4feec9f994be" />

- 📸 Pagamento

  <img width="1687" height="835" alt="pagamento" src="https://github.com/user-attachments/assets/c6ec776d-3274-4eb8-85d1-8a1d965fc298" />

  <img width="1768" height="444" alt="status_do_pedido_pago" src="https://github.com/user-attachments/assets/c7fe23b3-0bc9-4b36-a9ea-a359db4986bb" />

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

## 🚀 Possíveis Melhorias Futuras

- Persistência em banco de dados

- Interface gráfica (JavaFX ou Web)

- Testes automatizados (JUnit)

- Aplicação do padrão Factory para pagamentos

- Melhor tratamento de estados de pedido

- Logs estruturados

---

## 👨‍💻 Autor

Desenvolvido por Pedro Lucas Ferreira de Sousa.
