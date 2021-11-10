package api.ecommerce.grupo3.service;

import java.util.List;
import java.util.Optional;

import api.ecommerce.grupo3.domain.Cliente;

public interface ClienteService {

    List<Cliente> pesquisarTodosClientes();
    Optional<Cliente> pesquisarUmCliente(Long id);
    Cliente inserirCliente(Cliente cliente);
    boolean idExisteCliente(Long id);
    void removerCliente(Long id);

}