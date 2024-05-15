package br.com.fiap.controller;

import br.com.fiap.dto.ClienteDto;
import br.com.fiap.model.cliente.Cliente;
import br.com.fiap.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDto> criarCliente(@Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.salvar(clienteDto);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> retornarCliente(@Valid @PathVariable String cpf) {
        return clienteService.buscar(cpf);
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.atualizar(clienteDto.cpf(), clienteDto.toModel());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deleteCliente(@Valid @PathVariable String cpf) {
        return clienteService.deletar(cpf);
    }

}
