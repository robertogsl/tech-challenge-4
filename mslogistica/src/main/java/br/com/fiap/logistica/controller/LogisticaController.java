package br.com.fiap.logistica.controller;

import br.com.fiap.logistica.dto.PedidoResponse;
import br.com.fiap.logistica.model.Pedido;
import br.com.fiap.logistica.service.LogisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/logistica")
public class LogisticaController {

    private final LogisticaService logisticaService;

    public LogisticaController(LogisticaService logisticaService) {
        this.logisticaService = logisticaService;
    }

    @RequestMapping("{id}/status/{status}")
    public ResponseEntity atualizarStatus(@PathVariable String id, @PathVariable String status) {
        return logisticaService.attStatus(id, status);
    }

    @GetMapping("pagos")
    public ResponseEntity<List<PedidoResponse>> buscarPedidosPagosPorCodigoCEP() {
        return logisticaService.getPedidosPagosPorCodigoCEP();
    }
}
