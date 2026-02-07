package br.com.sistemaPedidos.service;

import br.com.sistemaPedidos.domain.model.Produto;
import br.com.sistemaPedidos.repository.ProdutoRepository;
import br.com.sistemaPedidos.util.ValidadorProduto;

import java.util.List;

public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(String nome, String descricao, double preco, int estoque){

        ValidadorProduto.validar(nome, descricao, preco, estoque);

        Produto produto = new Produto(nome, descricao, preco, estoque);
        produtoRepository.salvar(produto);
    }

    public Produto buscarProduto(int id){
        return produtoRepository.buscarPorId(id);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.listarTodos();
    }

    public void removerProduto(int id){
        produtoRepository.remover(id);
    }

    public void alterarPrecoProduto(int idProduto, double novoPreco){
        Produto produto = produtoRepository.buscarPorId(idProduto);

        ValidadorProduto.validarNovoPreco(novoPreco);

        produto.alterarPreco(novoPreco);
    }
}
