package br.com.sistemaPedidos.domain.model;

import br.com.sistemaPedidos.domain.exceptions.NaoTemEstoqueSuficienteException;
import br.com.sistemaPedidos.domain.exceptions.PrecoInvalidoException;
import br.com.sistemaPedidos.domain.exceptions.ProdutoInvalidoException;
import br.com.sistemaPedidos.domain.exceptions.QuantidadeInvalidaException;

public class Produto {
    private static int contador = 0;

    private final int id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(String nome, String descricao, double preco, int estoque){
        this.id = ++contador;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque; // Cada produto quando criado recebe 10 unidades como padrão. Seu estoque é controlado pelo uso dos métodos abaixo.
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void alterarPreco(double preco) {
        this.preco = preco;
    }

    public void reduzirEstoque(int qtd) throws QuantidadeInvalidaException, NaoTemEstoqueSuficienteException {
        if (qtd <= 0) {
            throw new QuantidadeInvalidaException("Quantidade inválida.");
        }

        if (!temEstoqueSuficiente(qtd)) {
            throw new NaoTemEstoqueSuficienteException("Estoque insuficiente.");
        }
        estoque -= qtd;
    }

    public void aumentarEstoque(int qtd){
         estoque += qtd;
    }

    public boolean temEstoqueSuficiente(int qtdSolicitada){
        if(this.estoque >= qtdSolicitada){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Produto: " +
                "id = " + id +
                " | nome = " + nome + '\'' +
                " | descricao = " + descricao + '\'' +
                " | preco = R$" + preco +
                " | estoque = " + estoque;
    }
}
