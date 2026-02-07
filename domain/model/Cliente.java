package br.com.sistemaPedidos.domain.model;

public class Cliente {
    private static int contador = 0;

    private final int id;
    private String nome;
    private String email;
    private final String cpf;

    public Cliente(String nome, String email, String cpf){
        this.id = ++contador;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void atualizarEmail(String email){
        this.email = email;
    }

    public void atualizarNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "id = " + id +
                " | nome = '" + nome + '\'' +
                " | email = '" + email + '\'' +
                " | cpf = '" + cpf + '\'';
    }
}
