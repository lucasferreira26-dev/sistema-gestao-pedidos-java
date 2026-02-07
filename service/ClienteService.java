package br.com.sistemaPedidos.service;

import br.com.sistemaPedidos.domain.model.Cliente;
import br.com.sistemaPedidos.repository.ClienteRepository;
import br.com.sistemaPedidos.util.ValidadorCliente;

import java.util.List;

public class ClienteService {

   private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrarCliente(String nome, String email, String cpf) {

        ValidadorCliente.validar(nome, email, cpf);

        Cliente cliente = new Cliente(nome, email, cpf);
        clienteRepository.salvar(cliente);
    }


    public Cliente buscarCliente(int id){
        return clienteRepository.buscarPorId(id);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.listarTodos();
    }

    public void removerCliente(int id){
        clienteRepository.remover(id);
    }
}
