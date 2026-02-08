package br.com.sistemaPedidos.consoleUI;

import br.com.sistemaPedidos.domain.enums.TipoPagamento;
import br.com.sistemaPedidos.domain.exceptions.*;
import br.com.sistemaPedidos.domain.model.*;
import br.com.sistemaPedidos.service.ClienteService;
import br.com.sistemaPedidos.service.PagamentoService;
import br.com.sistemaPedidos.service.PedidoService;
import br.com.sistemaPedidos.service.ProdutoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private final ClienteService clienteService;
    private final ProdutoService produtoService;
    private final PedidoService pedidoService;
    private final PagamentoService pagamentoService;
    private Scanner scanner;

    public ConsoleUI(ClienteService clienteService, ProdutoService produtoService, PedidoService pedidoService, PagamentoService pagamentoService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.pedidoService = pedidoService;
        this.pagamentoService = pagamentoService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int opcao;

        do {
            menuPrincipal();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    gerenciarClientes();
                    break;
                case 2:
                    gerenciarProdutos();
                    break;
                case 3:
                    gerenciarPedidos();
                    break;
                case 4:
                    pagarPedido();
                    break;
                case 0:
                    sair();
                    break;
                default:
                    opcaoInvalida();
            }

        } while (opcao != 0);
    }

    private void menuPrincipal() {
        System.out.println("""
                ========================================
                           🛒 SISTEMA E-COMMERCE
                ========================================
                1 - GERENCIAR CLIENTES
                2 - GERENCIAR PRODUTOS
                3 - GERENCIAR PEDIDOS
                4 - PAGAMENTO DE PEDIDO
                0 - SAIR
                ========================================
                """);
    }

    private int lerOpcao() {
        while (true) {
            try {
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    private int digitarId(){
        while (true) {
            try {
                System.out.print("Digite o ID buscado(Digite apenas números): ");
                int opcao = scanner.nextInt();
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    private void opcaoInvalida() {
        System.out.println("\n❌ Opção inválida. Tente novamente.");
    }

    private void sair(){
        System.out.println("Saindo...");
    }

    private void gerenciarClientes(){
        int opcao;

        do{
            menuClientes();
            opcao = lerOpcao();
            switch (opcao){
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 0:
                    sair();
                    break;
                default:
                    opcaoInvalida();
            }
        } while (opcao != 0);

    }

    private void menuClientes(){
        System.out.println("""
         ========================================
                 👥 GERENCIAR CLIENTES
         ========================================
         1 - CADASTRAR CLIENTE
         2 - LISTAR CLIENTES
         3 - BUSCAR CLIENTE POR ID
         4 - REMOVER CLIENTE
         0 - VOLTAR
         ========================================
         """);
    }

    private void cadastrarCliente(){
        System.out.println("👤 Cadastro de Cliente");

        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("CPF (Não utilize ponto(.) nem traço( - ): ");
        String cpf = scanner.nextLine();

        try{
            clienteService.cadastrarCliente(nome, email, cpf);
            System.out.println("✅ Cliente cadastrado com sucesso!");
        } catch(ClienteInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    private void listarClientes(){
        System.out.println("✅ Lista de Clientes");

        if(clienteService.listarClientes().isEmpty()){
            System.out.println("❌ Não há clientes cadastrados!");
        } else {
            for(Cliente cliente : clienteService.listarClientes()){
                System.out.println(cliente + "\n");
            }
        }
    }

    private void buscarCliente(){
        System.out.println("\uD83D\uDD0E Buscar Cliente");

        int id = digitarId();
        Cliente cliente = clienteService.buscarCliente(id);

        if(cliente == null){
            System.out.println("❌ Cliente não encontrado.");
        } else{
            System.out.println("✅ Cliente encontrado:");
            System.out.println(cliente);
        }
    }

    private void removerCliente(){
        System.out.println("⛏ Remover Cliente");

        int id = digitarId();
        Cliente cliente = clienteService.buscarCliente(id);

        if(cliente == null){
            System.out.println("❌ Cliente não encontrado.");
        } else{
            System.out.println("✅ Cliente encontrado:");
            System.out.println(cliente);
            System.out.println("Tem certeza que deseja remover o cliente acima?");
            System.out.println("1 - Remover");
            System.out.println("2 - Cancelar");
            int opcao = lerOpcao();

            if (opcao == 1) {
                clienteService.removerCliente(id);
                System.out.println("✅ Cliente removido com sucesso!");
            } else if(opcao == 2){
                System.out.println("Operação cancelada.");
            } else {
                opcaoInvalida();
            }
        }
    }

    private void gerenciarProdutos(){
        int opcao;

        do{
            menuProduto();
            opcao = lerOpcao();
            switch (opcao){
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 5:
                    alterarPreco();
                    break;
                case 0:
                    sair();
                    break;
                default:
                    opcaoInvalida();
            }
        } while (opcao != 0);

    }

    private void menuProduto(){
        System.out.println("""
         ========================================
                 🛍️ GERENCIAR PRODUTOS
         ========================================
         1 - CADASTRAR PRODUTO
         2 - LISTAR PRODUTOS
         3 - BUSCAR PRODUTO POR ID
         4 - REMOVER PRODUTO
         5 - ALTERAR PREÇO DE PRODUTO
         0 - VOLTAR
         ========================================
         """);
    }

    private void cadastrarProduto(){
        System.out.println("\uD83C\uDFF7\uFE0F Cadastro de Produto");

        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade em estoque: ");
        int estoque = scanner.nextInt();

        try{
            produtoService.cadastrarProduto(nome, descricao, preco, estoque);
            System.out.println("✅ Produto cadastrado com sucesso!");
        } catch(ProdutoInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    private void listarProdutos(){
        System.out.println("✅ Lista de Produtos");

        if(produtoService.listarProdutos().isEmpty()){
            System.out.println("❌ Não há produtos cadastrados");
        } else {
            for(Produto produto : produtoService.listarProdutos()){
                System.out.println(produto + "\n");
            }
        }
    }

    private void buscarProduto(){
        System.out.println("\uD83D\uDD0E Buscar Produto");

        int id = digitarId();
        Produto produto = produtoService.buscarProduto(id);

        if(produto == null){
            System.out.println("❌ Produto não encontrado!");
        } else {
            System.out.println("✅ Produto encontrado!");
            System.out.println(produto);
        }
    }

    private void removerProduto(){
        System.out.println("⛏ Remover Produto");

        int id = digitarId();
        Produto produto = produtoService.buscarProduto(id);

        if(produto == null){
            System.out.println("❌ Produto não encontrado!");
        } else {
            System.out.println("✅ Produto encontrado!");
            System.out.println(produto);
            System.out.println("Tem certeza que deseja remover o produto acima?");
            System.out.println("1 - Remover");
            System.out.println("2 - Cancelar");
            int opcao = scanner.nextInt();

            if(opcao == 1){
                produtoService.removerProduto(id);
                System.out.println("✅ Produto removido com sucesso!");
            } else if(opcao == 2){
                System.out.println("Operação cancelada.");
            } else {
                opcaoInvalida();
            }
        }
    }

    private void alterarPreco(){
        System.out.println("🔄 Alterar Preço do Produto");

        int id = digitarId();

        try {
            Produto produto = produtoService.buscarProduto(id);

            if (produto == null) {
                System.out.println("❌ Produto não encontrado!");
                return;
            }

            System.out.println("✅ Produto encontrado:");
            System.out.println(produto);

            System.out.print("Digite o novo preço do produto: ");
            double novoPreco = scanner.nextDouble();

            produtoService.alterarPrecoProduto(id, novoPreco);

            // Busca novamente após alteração
            Produto produtoAtualizado = produtoService.buscarProduto(id);

            System.out.println("✅ Preço alterado com sucesso!");
            System.out.println(produtoAtualizado);

        } catch (PrecoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }


    public void gerenciarPedidos(){
        int opcao;

        do{
            menuPedidos();
            opcao = lerOpcao();
            switch (opcao){
                case 1:
                    criarPedido();
                    break;
                case 2:
                    adicionarItemAoPedido();
                    break;
                case 3:
                    removerItens();
                    break;
                case 4:
                    cancelarPedido();
                    break;
                case 5:
                    listarPedidos();
                    break;
                case 0:
                    sair();
                    break;
                default:
                    opcaoInvalida();
            }
        } while (opcao != 0);

    }

    private void menuPedidos(){
        System.out.println("""
         ========================================
                 📦 GERENCIAR PEDIDOS
         ========================================
         1 - CRIAR PEDIDO
         2 - ADICIONAR ITEM AO PEDIDO
         3 - REMOVER ITENS
         4 - CANCELAR PEDIDO
         5 - LISTAR PEDIDOS
         0 - VOLTAR
         ========================================
         """);
    }

    private void criarPedido(){
        System.out.println("✍\uD83C\uDFFB Criar Pedido");

        System.out.println("Precisamos do Id do cliente para criar o seu pedido");
        int clienteId = digitarId();

        try{
            Pedido pedido = pedidoService.criarPedido(clienteId);
            System.out.println("✅ Pedido criado com sucesso!");
            System.out.println("Id do pedido: " + pedido.getId());
        }catch (EntidadeNãoEncontradaException e){
            System.out.println(e.getMessage());
        }
    }

    private void adicionarItemAoPedido(){
        System.out.println("➕ Adicione itens ao seu pedido");

        try{
            System.out.println("Id do Pedido");
            int pedidoId = digitarId();
            System.out.println("Id do Produto");
            int produtoId = digitarId();
            Pedido pedido = pedidoService.buscarPedido(pedidoId);
            Produto produto = produtoService.buscarProduto(produtoId);
            if(pedido == null || produto == null){
                System.out.println("❌ Não existe pedido ou produto com o id informado");
            } else{
                System.out.println(pedido);
                System.out.println(produto);
                System.out.print("Digite a quantidade de itens: \n");
                int qtdItens = lerOpcao();

                if (qtdItens <= 0) {
                    System.out.println("❌ Quantidade inválida.");
                    return;
                }
                pedidoService.adicionarItem(pedidoId, produtoId, qtdItens);
                System.out.println("✅ A quantidade informada do item foi adicionada ao seu pedido com sucesso!");
                System.out.println("Id do pedido: " + pedido.getId() + " | Quantidade de itens: " + qtdItens + " | Valor total do pedido: R$" + pedido.getValorTotal());
                System.out.println("Fique a vontade para adicionar mais itens ou prossiga para o pagamento.");
            }
        } catch (NaoEPossivelAltrPedidoException | NaoTemEstoqueSuficienteException | QuantidadeInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerItens(){
        System.out.println("❌ Remover itens");

        System.out.println("Precisamos do id do seu pedido");
        int idPedido = digitarId();
        Pedido pedido = pedidoService.buscarPedido(idPedido);
        if(pedido == null){
            System.out.println("❌ Pedido não encontrado");
            return;
        } else {
            System.out.println("✅ Pedido encontrado!");
            System.out.println(pedido);
        }

        System.out.println("Precisamos do id do produto que será removido");
        int idProduto = digitarId();
        Produto produto = produtoService.buscarProduto(idProduto);
        if(produto == null){
            System.out.println("❌ Produto não encontrado");
            return;
        } else {
            System.out.println("✅ Produto encontrado!");
            System.out.println(produto);
        }

        System.out.println("Tem certeza que deseja remover os itens do seu pedido?");
        System.out.println("1 - Remover");
        System.out.println("2 - Cancelar");
        int op = lerOpcao();
        try{
            if(op == 1){
                pedidoService.removerItem(idPedido, idProduto);
                System.out.println("✅ Itens removidos!");
                Pedido atualPedido = pedidoService.buscarPedido(idPedido);
                System.out.println(atualPedido);
                Produto atualProduto = produtoService.buscarProduto(idProduto);
                System.out.println(atualProduto);
            } else if (op == 2) {
                System.out.println("Operação cancelada.");
            } else {
                opcaoInvalida();
            }
        } catch(NaoEPossivelAltrPedidoException e){
            System.out.println(e.getMessage());
        }
    }

    private void cancelarPedido(){
        System.out.println("❌ Cancelar Pedido");

        try{
            System.out.println("Informe o id do pedido");
            int id = digitarId();
            Pedido pedido = pedidoService.buscarPedido(id);

            if(pedido == null){
                System.out.println("❌ Pedido não encontrado");
            } else {
                System.out.println("✅ Pedido localizado!");
                System.out.println(pedido);

                System.out.println("Tem certeza que deseja cancelar o pedido acima? ");
                System.out.println("1 - Cancelar Pedido");
                System.out.println("2 - Encerrar Operação");

                int op = lerOpcao();
                if(op == 1){
                    pedidoService.cancelarPedido(id);
                    System.out.println("✅ Seu pedido foi cancelado!");
                } else if(op == 2){
                    System.out.println("Operação cancelada!");
                } else {
                    opcaoInvalida();
                }
            }
        } catch (NaoEPossivelCancelarPedidoException e){
            System.out.println(e.getMessage());
        }
    }

    private void listarPedidos() {
        System.out.println("✅ Lista de Pedidos");

        if(pedidoService.listarPedidos().isEmpty()){
            System.out.println("❌ Não há pedidos criados");
        } else {
            for(Pedido pedido : pedidoService.listarPedidos()){
                System.out.println(pedido + "\n");
            }
        }
    }
    private TipoPagamento escolherMetodoPagamento() {
        while (true) {
            int op = lerOpcao();

            switch (op) {
                case 1:
                    return TipoPagamento.PIX;
                case 2:
                    return TipoPagamento.CARTAO_CREDITO;
                case 3:
                    return TipoPagamento.CARTAO_DEBITO;
                case 4:
                    return TipoPagamento.BOLETO;
                default:
                    opcaoInvalida();
            }
        }
    }
    private void pagarPedido(){
        System.out.println("💳 Pagamento de Pedido");

        try {
            System.out.println("Informe o id do pedido:");
            int id = digitarId();

            Pedido pedido = pedidoService.buscarPedido(id);

            if (pedido == null) {
                System.out.println("❌ Pedido não encontrado!");
                return;
            }

            System.out.println("Detalhes do pedido:");
            System.out.println(pedido);

            System.out.println("\nEscolha o método de pagamento:");
            System.out.println("1 - PIX");
            System.out.println("2 - Cartão de Crédito");
            System.out.println("3 - Cartão de Débito");
            System.out.println("4 - Boleto");

            TipoPagamento pagamento = escolherMetodoPagamento();

            DadosDoPagamento dados = new DadosDoPagamento();

            if (pagamento == TipoPagamento.PIX) {
                scanner.nextLine();
                System.out.println("Valor total do pedido: " + pedido.getValorTotal());
                System.out.print("Digite a chave PIX: ");
                dados.setChavePix(scanner.nextLine());
            }

            if (pagamento == TipoPagamento.CARTAO_CREDITO
                    || pagamento == TipoPagamento.CARTAO_DEBITO) {

                scanner.nextLine();
                System.out.println("Valor total do pedido: " + pedido.getValorTotal());
                System.out.print("Número do cartão: ");
                dados.setNumeroCartao(scanner.nextLine());

                System.out.print("Nome impresso no cartão: ");
                dados.setNomeCartao(scanner.nextLine());

                System.out.print("Validade (MM/AA): ");
                dados.setValidadeCartao(scanner.nextLine());

                System.out.print("CVV: ");
                dados.setCvv(scanner.nextLine());
            }

            if (pagamento == TipoPagamento.BOLETO) {
                scanner.nextLine();
                System.out.println("Valor total do pedido: R$" + pedido.getValorTotal());
                System.out.print("Digite o código do boleto: ");
                dados.setCodigoBoleto(scanner.nextLine());
            }

            pagamentoService.processarPagamento(id, pagamento, dados);
            System.out.println("✅ Pedido pago com sucesso!");
            System.out.println("Id do pedido: " + pedido.getId() + " | Valor total do pedido: R$" + pedido.getValorTotal());

        } catch (PagamentoInvalidoException | NaoEPossivelPagarPedidoException e){
            System.out.println(e.getMessage());
        }
    }
}
