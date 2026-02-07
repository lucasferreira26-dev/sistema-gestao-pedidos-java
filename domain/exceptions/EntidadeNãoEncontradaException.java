package br.com.sistemaPedidos.domain.exceptions;

public class EntidadeNãoEncontradaException extends Exception{
    public EntidadeNãoEncontradaException() {
        super("Não encontramos o id que você busca");
    }
}
