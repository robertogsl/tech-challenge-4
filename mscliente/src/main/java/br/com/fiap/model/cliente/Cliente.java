package br.com.fiap.model.cliente;

import br.com.fiap.model.endereco.Endereco;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document
public class Cliente {

    @CPF
    @Id
    private String cpf;

    @Email
    private String email;

    private String telefone;

    private String nome;

    private List<Endereco> enderecos;

    public Cliente(String cpf, String email, String telefone, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nome = nome;
        this.enderecos = new ArrayList<>();
        this.enderecos.add(endereco);
    }

    public void setEnderecos(Endereco endereco) {
        this.enderecos.add(endereco);
    }
}
