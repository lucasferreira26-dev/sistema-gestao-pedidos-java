package br.com.sistemaPedidos.domain.exceptions;

public class NaoEPossivelAltrPedidoException extends RuntimeException {
    public NaoEPossivelAltrPedidoException(String message) {
        super(message);
    }
}
