package br.com.fiap.logistica.service;

import br.com.fiap.logistica.client.ServicePedidoClient;
import br.com.fiap.logistica.dto.PedidoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticaService {

    private final ServicePedidoClient servicePedidoClient;

    public LogisticaService(ServicePedidoClient servicePedidoClient) {
        this.servicePedidoClient = servicePedidoClient;
    }

    public ResponseEntity attStatus(String id, String status) {
        if (servicePedidoClient.pedidoById(id).getBody().status().equals(status)) {
            return ResponseEntity.badRequest().build();
        }
        servicePedidoClient.putAtualizarStatus(id, status);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<PedidoResponse>> getPedidosPagosPorCodigoCEP() {
        return ResponseEntity.ok().body(servicePedidoClient.getPedidosPagos());
    }
}
