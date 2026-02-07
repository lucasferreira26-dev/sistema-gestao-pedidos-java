package br.com.sistemaPedidos.service;

import br.com.sistemaPedidos.domain.exceptions.EntidadeNãoEncontradaException;
import br.com.sistemaPedidos.domain.model.Cliente;
import br.com.sistemaPedidos.domain.model.Pedido;
import br.com.sistemaPedidos.domain.model.Produto;
import br.com.sistemaPedidos.repository.ClienteRepository;
import br.com.sistemaPedidos.repository.PedidoRepository;
import br.com.sistemaPedidos.repository.ProdutoRepository;

import java.util.List;

public class PedidoService {

   private PedidoRepository pedidoRepository;
   private ProdutoRepository produtoRepository;
   private ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido criarPedido(int clienteId) throws EntidadeNãoEncontradaException {
        Cliente cliente = clienteRepository.buscarPorId(clienteId);

        if(cliente == null){
            throw new EntidadeNãoEncontradaException();
        }

        Pedido pedido = new Pedido(cliente);

        pedidoRepository.salvar(pedido);

        return pedido;
    }

    public void adicionarItem(int pedidoId, int produtoId, int quantidade) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        Produto produto = produtoRepository.buscarPorId(produtoId);

        pedido.adicionarItem(produto, quantidade);
    }

    public void removerItem(int idPedido, int idProduto){
        Pedido pedido = buscarPedido(idPedido);

        pedido.removerItem(idProduto);
    }

    public void cancelarPedido(int pedidoId){
        Pedido pedido  = pedidoRepository.buscarPorId(pedidoId);

        pedido.cancelar();
    }

    public List<Pedido> listarPedidos(){
        return pedidoRepository.listarTodos();
    }

    public Pedido buscarPedido(int id){
        return pedidoRepository.buscarPorId(id);
    }
}
