package br.com.fiap;

import br.com.fiap.dto.ClienteDto;
import br.com.fiap.model.cliente.Cliente;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.service.ClienteService;
import com.mongodb.internal.authentication.AwsCredentialHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void cadastrarCliente(){
        ClienteDto clienteDto = new ClienteDto("cpf", "email", "1234", "teste", "12324", 12, "casa 1", 5);
        when(clienteRepository.save(clienteDto.toModel())).thenReturn(clienteDto.toModel());
        ResponseEntity<ClienteDto> salvar = clienteService.salvar(clienteDto);
        assertEquals("cpf",salvar.getBody().cpf());
    }

    @Test
    void buscarCliente(){
        ClienteDto clienteDto = new ClienteDto("cpf", "email", "1234", "teste", "12324", 12, "casa 1", 5);
        when(clienteRepository.findById(anyString())).thenReturn(Optional.of(clienteDto.toModel()));
        ResponseEntity<Cliente> responseEntity = clienteService.buscar("1234");
        assertEquals("cpf",responseEntity.getBody().getCpf());
    }

    @Test
    void atualizarCliente(){
        ClienteDto clienteDto = new ClienteDto("cpf", "email", "1234", "teste", "12324", 12, "casa 1", 5);
        when(clienteRepository.save(clienteDto.toModel())).thenReturn(clienteDto.toModel());
        ResponseEntity<Cliente> responseEntity = clienteService.atualizar("1234", clienteDto.toModel());
        assertEquals("cpf",responseEntity.getBody().getCpf());
    }

    @Test
    void deletarCliente(){
        ResponseEntity<Cliente> responseEntity = clienteService.deletar("1234");
        assertNotNull(responseEntity);
    }

    @Test
    void existeCliente(){
        ClienteDto clienteDto = new ClienteDto("cpf", "email", "1234", "teste", "12324", 12, "casa 1", 5);
        when(clienteRepository.findById(anyString())).thenReturn(Optional.of(clienteDto.toModel()));
        Boolean responseEntity = clienteService.existeCliente("1234");
        assertTrue(responseEntity);
    }

}
