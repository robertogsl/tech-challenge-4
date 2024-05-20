package br.com.fiap;

import br.com.fiap.dto.ClienteDto;
import br.com.fiap.model.cliente.Cliente;
import br.com.fiap.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void criarCliente() throws Exception {
        ClienteDto clienteDto = new ClienteDto("cpf", "email", "1234", "teste", "12324", 12, "casa 1", 5);
        ResponseEntity<ClienteDto> responseEntity = ResponseEntity.ok(clienteDto);
        given(clienteService.salvar(any(ClienteDto.class))).willReturn(responseEntity);
        mockMvc.perform(post("/api/v1/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(clienteDto)))
                .andExpect(status().isOk());
    }

    @Test
    void pesquisaClientePorCpf() throws Exception {
        ClienteDto clienteDto = new ClienteDto("cpf", "email", "1234", "teste", "12324", 12, "casa 1", 5);
        ResponseEntity<Cliente> responseEntity = ResponseEntity.ok(clienteDto.toModel());
        given(clienteService.buscar(anyString())).willReturn(responseEntity);
        mockMvc.perform(get("/api/v1/cliente/123333")
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk());
    }

    @Test
    void atualizarCliente() throws Exception {
        ClienteDto clienteDto = new ClienteDto("cpf", "email", "1234", "teste", "12324", 12, "casa 1", 5);
        ResponseEntity<Cliente> responseEntity = ResponseEntity.ok(clienteDto.toModel());
        given(clienteService.atualizar(anyString(),any(Cliente.class))).willReturn(responseEntity);
        mockMvc.perform(put("/api/v1/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(clienteDto)))
                .andExpect(status().isOk());
    }

    @Test
    void deletarCliente() throws Exception {
        ResponseEntity<Cliente> responseEntity = ResponseEntity.ok().build();
        given(clienteService.deletar(anyString())).willReturn(responseEntity);
        mockMvc.perform(delete("/api/v1/cliente/123333")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }



}
