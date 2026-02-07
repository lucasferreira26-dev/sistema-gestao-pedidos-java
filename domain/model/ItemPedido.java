package br.com.sistemaPedidos.domain.model;

import br.com.sistemaPedidos.domain.exceptions.QuantidadeInvalidaException;

public class ItemPedido {
    private final Produto produto;
    private int quantidade;
    private final double precoUnitario;

    public ItemPedido(Produto produto, int quantidade) throws QuantidadeInvalidaException{
        if(quantidade <= 0){
            throw new QuantidadeInvalidaException("Quantidade inválida!");
        }
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getSubTotal(){
        return quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemPedido: " +
                "produto = " + produto.getNome() +
                " | quantidade = " + quantidade +
                " | precoUnitario = R$" + precoUnitario;
    }
}
