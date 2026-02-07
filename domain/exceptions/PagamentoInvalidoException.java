package br.com.sistemaPedidos.domain.exceptions;

public class PagamentoInvalidoException extends Exception{
    public PagamentoInvalidoException(String message) {
        super(message);
    }
}
