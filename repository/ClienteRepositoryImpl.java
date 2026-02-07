package br.com.sistemaPedidos.repository;

import br.com.sistemaPedidos.domain.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository{

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente entidade) {
        clientes.add(entidade);
    }

    @Override
    public Cliente buscarPorId(int id) {
        for(Cliente cliente : clientes){
            if(cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    // Percorre a lista e remove quem tiver o id igual ao do argumento
    @Override
    public void remover(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

}
