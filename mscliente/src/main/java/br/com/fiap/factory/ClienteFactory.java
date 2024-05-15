package br.com.fiap.factory;

import br.com.fiap.model.cliente.Cliente;

public class ClienteFactory {

    private Cliente cliente;

    public ClienteFactory comTodosArgumentos(String cpf, String email, String telefone, String nome, String cep, Integer numero, String bloco, Integer apartamento) {
        EnderecoFactory enderecoFactory = new EnderecoFactory();

        if (bloco.isBlank() && apartamento.describeConstable().isEmpty()) {
            this.cliente = new Cliente(cpf, email, telefone, nome, enderecoFactory.comCepNumero(cep, numero).criar());
        }
        else if (bloco.isBlank()) {
            this.cliente = new Cliente(cpf, email, telefone, nome, enderecoFactory.comCepNumeroApartamento(cep, numero, apartamento).criar());
        }
        else {
            this.cliente = new Cliente(cpf, email, telefone, nome, enderecoFactory.comTodosArgumentos(cep, numero, bloco, apartamento).criar());
        }
        return this;
    }

    public Cliente criar() {
        return this.cliente;
    }
}
