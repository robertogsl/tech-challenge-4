package br.com.fiap.model.cliente;

import lombok.Getter;

@Getter
public class Email {

    private String endereco;

    public Email(String endereco) {
        if (endereco == null ||
                !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail invalido!");
        }

        this.endereco = endereco;
    }
}
