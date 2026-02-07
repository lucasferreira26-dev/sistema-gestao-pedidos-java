package br.com.sistemaPedidos.domain.model;

import br.com.sistemaPedidos.domain.enums.StatusPedido;
import br.com.sistemaPedidos.domain.exceptions.NaoEPossivelAltrPedidoException;
import br.com.sistemaPedidos.domain.exceptions.NaoEPossivelCancelarPedidoException;
import br.com.sistemaPedidos.domain.exceptions.NaoEPossivelPagarPedidoException;
import br.com.sistemaPedidos.domain.exceptions.NaoTemEstoqueSuficienteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int contador = 0;

    private final int id;
    private final Cliente cliente;
    private final LocalDate dataCriacao;
    private StatusPedido status;
    private final List<ItemPedido> itens;

    public Pedido(Cliente cliente) {
        this.id = ++contador;
        this.cliente = cliente;
        this.dataCriacao = LocalDate.now();
        this.status = StatusPedido.CRIADO;
        this.itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    // ==============================
    // REGRAS DE NEGÓCIO
    // ==============================

    public void adicionarItem(Produto produto, int quantidade) throws NaoEPossivelAltrPedidoException, NaoTemEstoqueSuficienteException {

        if (status != StatusPedido.CRIADO) {
            throw new NaoEPossivelAltrPedidoException("Não é possível alterar um pedido que não está criado.");
        }

        if (!produto.temEstoqueSuficiente(quantidade)) {
            throw new NaoTemEstoqueSuficienteException("Estoque insuficiente.");
        }

        produto.reduzirEstoque(quantidade);

        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    public void removerItem(int produtoId) throws NaoEPossivelAltrPedidoException {

        if (status != StatusPedido.CRIADO) {
            throw new NaoEPossivelAltrPedidoException("ERROR! O pedido já foi pago/cancelado ou não existe");
        }

        for (ItemPedido item : itens) {
            if (item.getProduto().getId() == produtoId) {
                item.getProduto().aumentarEstoque(item.getQuantidade());
                itens.remove(item);
                break;
            }
        }
    }


    public double getValorTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.getSubTotal();
        }

        return total;
    }


    public void pagar() throws NaoEPossivelPagarPedidoException {

        if (status != StatusPedido.CRIADO) {
            throw new NaoEPossivelPagarPedidoException("Pedido não pode ser pago.");
        }

        this.status = StatusPedido.PAGO;
    }

    public void cancelar() throws NaoEPossivelCancelarPedidoException {

        if (status == StatusPedido.PAGO) {
            throw new NaoEPossivelCancelarPedidoException("Pedido já foi pago e não pode ser cancelado.");
        }

        this.status = StatusPedido.CANCELADO;

        // devolve estoque
        for (ItemPedido item : itens) {
            item.getProduto().aumentarEstoque(item.getQuantidade());
        }
    }

    @Override
    public String toString() {
        return "Pedido: " +
                "id = " + id +
                " | cliente = " + cliente.getNome() +
                " | dataCriacao = " + dataCriacao +
                " | status = " + status +
                " | itens = " + itens;
    }
}
