package br.com.sistemaPedidos.domain.exceptions;

public class NaoEPossivelCancelarPedidoException extends RuntimeException {
    public NaoEPossivelCancelarPedidoException(String message) {
        super(message);
    }
}
