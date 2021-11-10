package api.ecommerce.grupo3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.domain.Cliente;
import api.ecommerce.grupo3.repository.ClienteRepository;
import api.ecommerce.grupo3.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> pesquisarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> pesquisarUmCliente(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente inserirCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public boolean idExisteCliente(Long id) {
        return clienteRepository.existsById(id);
    }

    @Override
    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}