package br.com.sistemaPedidos.util;

import br.com.sistemaPedidos.domain.exceptions.ClienteInvalidoException;

public final class ValidadorCliente {

    // Impede instanciar a classe
    private ValidadorCliente() {
    }

    public static void validar(String nome, String email, String cpf) {

        validarNome(nome);
        validarEmail(email);
        validarCpf(cpf);
    }

    private static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ClienteInvalidoException("Nome não pode ser vazio.");
        }

        if (nome.trim().length() < 3) {
            throw new ClienteInvalidoException("Nome deve ter pelo menos 3 caracteres.");
        }
    }

    private static void validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new ClienteInvalidoException("Email não pode ser vazio.");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new ClienteInvalidoException("Email inválido.");
        }
    }

    private static void validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new ClienteInvalidoException("CPF não pode ser vazio.");
        }

        if (cpf.length() != 11) {
            throw new ClienteInvalidoException("CPF deve ter 11 dígitos.");
        }

        for (int i = 0; i < cpf.length(); i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
                throw new ClienteInvalidoException("CPF deve conter apenas números.");
            }
        }
    }
}
