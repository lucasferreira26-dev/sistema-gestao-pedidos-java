package br.com.sistemaPedidos.domain.model;

public class DadosDoPagamento {

    private String chavePix;

    private String numeroCartao;
    private String nomeCartao;
    private String validadeCartao;
    private String cvv;

    private String codigoBoleto;

    // ===== PIX =====
    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    // ===== CARTÃO =====
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    // ===== BOLETO =====
    public String getCodigoBoleto() {
        return codigoBoleto;
    }

    public void setCodigoBoleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public String toString() {
        return "DadosDoPagamento: " +
                "chavePix = '" + chavePix + '\'' +
                " | nomeCartao = '" + nomeCartao + '\'' +
                " | Código do boleto = '" + codigoBoleto;
    }
}

