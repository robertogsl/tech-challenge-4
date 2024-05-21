package br.com.fiap.logistica.dto;

import br.com.fiap.logistica.model.Itens;
import br.com.fiap.logistica.model.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public record PedidoResponse(@JsonProperty("pedido_id") String id, @JsonProperty("cliente_id") String idCliente, List<Itens> itens, String status){
    public PedidoResponse(Pedido pedido) {
        this(pedido.getId(), pedido.getIdCliente(),pedido.getItens(), pedido.getStatus());
    }
}
