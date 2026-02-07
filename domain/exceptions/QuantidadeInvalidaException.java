package br.com.sistemaPedidos.domain.exceptions;

public class QuantidadeInvalidaException extends RuntimeException {
    public QuantidadeInvalidaException(String message) {
        super(message);
    }
}
