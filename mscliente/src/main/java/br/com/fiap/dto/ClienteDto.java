package br.com.fiap.dto;

import br.com.fiap.model.cliente.Cliente;
import br.com.fiap.model.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(@NotBlank String cpf, @NotBlank String email, @NotNull String telefone, @NotBlank String nome, @NotNull String cep, @NotNull Integer numero, String bloco, Integer apartamento) {
    public Cliente toModel() {
        return new Cliente(
                cpf,
                email,
                telefone,
                nome,
                new Endereco(cep, numero, bloco, apartamento)
        );
    }
}
