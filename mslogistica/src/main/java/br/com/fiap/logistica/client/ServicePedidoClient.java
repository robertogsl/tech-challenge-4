package br.com.fiap.logistica.client;

import br.com.fiap.logistica.dto.PedidoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "pedido-service", url = "http://localhost:8082/api/pedidos")
public interface ServicePedidoClient {

    @PutMapping("{id}/status/{status}")
    ResponseEntity putAtualizarStatus(@PathVariable("id") String id, @PathVariable("status") String status);

    @GetMapping("{id}")
    ResponseEntity<PedidoResponse> pedidoById(@PathVariable("id") String id);

    @GetMapping("pagos")
    List<PedidoResponse> getPedidosPagos();
}
