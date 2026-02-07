package br.com.sistemaPedidos.service;

import br.com.sistemaPedidos.domain.enums.TipoPagamento;
import br.com.sistemaPedidos.domain.exceptions.*;
import br.com.sistemaPedidos.domain.model.DadosDoPagamento;
import br.com.sistemaPedidos.domain.model.Pagamento;
import br.com.sistemaPedidos.domain.model.Pedido;
import br.com.sistemaPedidos.repository.PedidoRepository;
import br.com.sistemaPedidos.util.ValidadorPagamento;

public class PagamentoService {

    private final PedidoRepository pedidoRepository;

    public PagamentoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void processarPagamento(
            int pedidoId,
            TipoPagamento tipo,
            DadosDoPagamento dados
    ) throws PagamentoInvalidoException {

        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);

        if(pedido.getItens() == null || pedido.getValorTotal() == 0){
            throw new PagamentoInvalidoException("ERROR! não é possivel processar pagamento, pois o seu pedido está vázio");
        }

        // 1️⃣ Validar dados conforme tipo
        ValidadorPagamento.validar(tipo, dados);

        // 2️⃣ Criar pagamento
        Pagamento pagamento = new Pagamento(pedido, tipo, dados);

        // 3️⃣ Processar
        boolean aprovado = pagamento.processarPagamento();

        if (!aprovado) {
            throw new PagamentoInvalidoException("Pagamento recusado.");
        }
    }
}

