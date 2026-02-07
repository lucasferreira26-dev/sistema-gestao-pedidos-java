package br.com.sistemaPedidos.util;

import br.com.sistemaPedidos.domain.enums.TipoPagamento;
import br.com.sistemaPedidos.domain.exceptions.PagamentoInvalidoException;
import br.com.sistemaPedidos.domain.model.DadosDoPagamento;

public final class ValidadorPagamento {

    private ValidadorPagamento() {
    }

    public static void validar(TipoPagamento tipo, DadosDoPagamento dados)
            throws PagamentoInvalidoException {

        if (tipo == null) {
            throw new PagamentoInvalidoException("Tipo de pagamento não informado.");
        }

        switch (tipo) {
            case PIX -> validarPix(dados.getChavePix());

            case CARTAO_CREDITO, CARTAO_DEBITO ->
                    validarCartao(
                            dados.getNumeroCartao(),
                            dados.getNomeCartao(),
                            dados.getValidadeCartao(),
                            dados.getCvv()
                    );

            case BOLETO -> validarBoleto(dados.getCodigoBoleto());
        }
    }

    // ================= PIX =================

    private static void validarPix(String chave)
            throws PagamentoInvalidoException {

        if (chave == null || chave.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Chave PIX inválida.");
        }

        if (chave.trim().length() < 6) {
            throw new PagamentoInvalidoException("Chave PIX muito curta.");
        }
    }

    // ================= CARTÃO =================

    private static void validarCartao(String numero,
                                      String nome,
                                      String validade,
                                      String cvv)
            throws PagamentoInvalidoException {

        if (numero == null || numero.trim().length() != 16) {
            throw new PagamentoInvalidoException(
                    "O número do cartão deve conter 16 dígitos."
            );
        }

        for (int i = 0; i < numero.length(); i++) {
            if (!Character.isDigit(numero.charAt(i))) {
                throw new PagamentoInvalidoException(
                        "O número do cartão deve conter apenas números."
                );
            }
        }

        if (nome == null || nome.trim().length() < 5) {
            throw new PagamentoInvalidoException(
                    "Nome do titular inválido."
            );
        }

        if (validade == null || !validade.matches("\\d{2}/\\d{2}")) {
            throw new PagamentoInvalidoException(
                    "Validade deve estar no formato MM/AA."
            );
        }

        if (cvv == null || !(cvv.length() == 3 || cvv.length() == 4)) {
            throw new PagamentoInvalidoException(
                    "CVV inválido."
            );
        }

        for (int i = 0; i < cvv.length(); i++) {
            if (!Character.isDigit(cvv.charAt(i))) {
                throw new PagamentoInvalidoException(
                        "CVV deve conter apenas números."
                );
            }
        }
    }

    // ================= BOLETO =================

    private static void validarBoleto(String codigo)
            throws PagamentoInvalidoException {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new PagamentoInvalidoException(
                    "Código do boleto inválido."
            );
        }

        if (codigo.length() < 10) {
            throw new PagamentoInvalidoException(
                    "Código do boleto muito curto."
            );
        }
    }
}
