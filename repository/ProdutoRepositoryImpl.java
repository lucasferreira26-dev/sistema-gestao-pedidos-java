package br.com.sistemaPedidos.repository;

import br.com.sistemaPedidos.domain.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepository{

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvar(Produto entidade) {
        produtos.add(entidade);
    }

    @Override
    public Produto buscarPorId(int id) {
        for(Produto produto : produtos){
            if(produto.getId() == id){
                return produto;
            }
        }
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    @Override
    public void remover(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }
}
