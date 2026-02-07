package br.com.sistemaPedidos.domain.exceptions;

public class NaoEPossivelPagarPedidoException extends RuntimeException {
    public NaoEPossivelPagarPedidoException(String message) {
        super(message);
    }
}
