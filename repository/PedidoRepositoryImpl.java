package br.com.sistemaPedidos.repository;

import br.com.sistemaPedidos.domain.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepositoryImpl implements PedidoRepository{

    private List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido entidade) {
        pedidos.add(entidade);
    }

    @Override
    public Pedido buscarPorId(int id) {
        for(Pedido pedido : pedidos){
            if(pedido.getId() == id){
                return pedido;
            }
        }
        return null;
    }

    @Override
    public List<Pedido> listarTodos() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public void remover(int id) {
        pedidos.removeIf(pedido -> pedido.getId() == id);
    }
}
