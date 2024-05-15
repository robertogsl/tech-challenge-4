package br.com.fiap.model.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Document
public class Endereco {

    private String cep;

    private Integer numero;

    private String bloco;

    private Integer apartamento;

    public Endereco(String cep, Integer numero) {
        this.cep = cep;
        this.numero = numero;
    }

    public Endereco(String cep, Integer numero, Integer apartamento) {
        this.cep = cep;
        this.numero = numero;
        this.apartamento = apartamento;
    }
}
