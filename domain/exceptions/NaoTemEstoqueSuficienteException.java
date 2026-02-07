package br.com.sistemaPedidos.domain.exceptions;

public class NaoTemEstoqueSuficienteException extends RuntimeException{
    public NaoTemEstoqueSuficienteException(String message){
        super(message);
    }
}
