package br.com.sistemaPedidos.domain.model;

import br.com.sistemaPedidos.domain.enums.StatusPagamento;
import br.com.sistemaPedidos.domain.enums.TipoPagamento;

import java.time.LocalDate;

public class Pagamento {
    private static int contador = 0;

    private int id;
    private Pedido pedido;
    private double valorPago;
    private StatusPagamento status;
    private TipoPagamento tipoPagamento;
    private LocalDate dataPagamento;
    private DadosDoPagamento dadosDoPagamento;

    public Pagamento(Pedido pedido,TipoPagamento tipoPagamento, DadosDoPagamento dadosDoPagamento) {
        this.id = ++contador;
        this.pedido = pedido;
        this.valorPago = pedido.getValorTotal();
        this.tipoPagamento = tipoPagamento;
        this.status = StatusPagamento.PENDENTE;
        this.dataPagamento = LocalDate.now();
        this.dadosDoPagamento = dadosDoPagamento;
    }

    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double getValorPago() {
        return valorPago;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public boolean processarPagamento(){

        if (valorPago != pedido.getValorTotal()) {
            status = StatusPagamento.RECUSADO;
            return false;
        }

        // Regra exemplo: boleto não aprova instantaneamente
        if (tipoPagamento == TipoPagamento.BOLETO) {
            status = StatusPagamento.PENDENTE;
            return false;
        }

        status = StatusPagamento.APROVADO;
        pedido.pagar();
        return true;
    }

    public DadosDoPagamento getDadosDoPagamento() {
        return dadosDoPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento: " +
                "id = " + id +
                " | pedido = " + pedido.getId() +
                " | valorPago = R$" + valorPago +
                " | status = " + status +
                " | tipoPagamento = " + tipoPagamento +
                " | Data do Pagamento = " + dataPagamento +
                " | Dados do pagamento = " + dadosDoPagamento;
    }
}
