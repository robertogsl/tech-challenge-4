package br.com.fiap.repository;

import br.com.fiap.model.cliente.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
