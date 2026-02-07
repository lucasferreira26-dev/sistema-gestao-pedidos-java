import br.com.sistemaPedidos.consoleUI.ConsoleUI;
import br.com.sistemaPedidos.repository.*;
import br.com.sistemaPedidos.service.ClienteService;
import br.com.sistemaPedidos.service.PagamentoService;
import br.com.sistemaPedidos.service.PedidoService;
import br.com.sistemaPedidos.service.ProdutoService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {

    ClienteRepository clienteRepository = new ClienteRepositoryImpl();
    ProdutoRepository produtoRepository = new ProdutoRepositoryImpl();
    PedidoRepository pedidoRepository = new PedidoRepositoryImpl();

    ClienteService clienteService = new ClienteService(clienteRepository);
    ProdutoService produtoService = new ProdutoService(produtoRepository);
    PedidoService pedidoService = new PedidoService(pedidoRepository, clienteRepository, produtoRepository);
    PagamentoService pagamentoService = new PagamentoService(pedidoRepository);

    ConsoleUI ui = new ConsoleUI(clienteService, produtoService, pedidoService, pagamentoService);
    ui.start();
}
