package br.com.sistemaPedidos.util;

import br.com.sistemaPedidos.domain.exceptions.PrecoInvalidoException;
import br.com.sistemaPedidos.domain.exceptions.ProdutoInvalidoException;

public final class ValidadorProduto {

    private ValidadorProduto() {
    }

    public static void validar(String nome, String descricao, double preco, int estoque) {

        validarNome(nome);
        validarDescricao(descricao);
        validarPreco(preco);
        validarEstoque(estoque);
    }

    private static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ProdutoInvalidoException("Nome do produto não pode ser vazio.");
        }

        if (nome.trim().length() < 3) {
            throw new ProdutoInvalidoException("Nome do produto deve ter pelo menos 3 caracteres.");
        }
    }

    private static void validarDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new ProdutoInvalidoException("Descrição não pode ser vazia.");
        }

        if (descricao.trim().length() < 5) {
            throw new ProdutoInvalidoException("Descrição deve ter pelo menos 5 caracteres.");
        }
    }

    private static void validarPreco(double preco) {
        if (preco <= 0) {
            throw new ProdutoInvalidoException("Preço deve ser maior que zero.");
        }
    }

    private static void validarEstoque(int estoque) {
        if (estoque < 0) {
            throw new ProdutoInvalidoException("Estoque não pode ser negativo.");
        }
    }

    public static void validarNovoPreco(double novoPreco){
        if(novoPreco <= 0){
            throw new PrecoInvalidoException("Preço inválido, verifique e tente novamente...");
        }
    }
}

