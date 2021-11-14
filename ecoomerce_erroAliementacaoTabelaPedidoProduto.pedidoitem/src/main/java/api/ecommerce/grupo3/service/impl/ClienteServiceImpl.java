package api.ecommerce.grupo3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.config.EmailConfig;
import api.ecommerce.grupo3.domain.Cliente;
import api.ecommerce.grupo3.dto.ClienteRequestDTO;
import api.ecommerce.grupo3.dto.ClienteResponseDTO;
import api.ecommerce.grupo3.exception.EmailException;
import api.ecommerce.grupo3.repository.ClienteRepository;
import api.ecommerce.grupo3.service.ClienteService;
import api.ecommerce.grupo3.service.EnderecoService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EmailConfig mail;

	@Autowired
	private EnderecoService enderecoService;

	@Override
	public List<Cliente> pesquisarTodosClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public List<ClienteResponseDTO> pesquisarTodosClientesDTO() {
		List<Cliente> cliente = clienteRepository.findAll();
		List<ClienteResponseDTO> clientDTO = new ArrayList<ClienteResponseDTO>();
		for (Cliente client : cliente) {
			ClienteResponseDTO clienteDTO = new ClienteResponseDTO(client);
			clientDTO.add(clienteDTO);
		}
		return clientDTO;
	}

	@Override
	public Optional<Cliente> pesquisarUmCliente(Long id) {
		return clienteRepository.findById(id);
	}
	
	@Override
	public ClienteResponseDTO inserirClienteDTO(ClienteRequestDTO clienteRequestDTO) throws EmailException {
		if (clienteRepository.findByEmail(clienteRequestDTO.getEmail()) != null) {
			throw new EmailException("Email já existente!");
		}
		Cliente cliente = new Cliente();
		cliente.setNome(clienteRequestDTO.getNome());
		cliente.setEmail(clienteRequestDTO.getEmail());
		cliente.setCpf(clienteRequestDTO.getCpf());
		cliente.setEndereco(enderecoService.buscarCep(clienteRequestDTO.getCep()));
		cliente.getEndereco().setComplemento(clienteRequestDTO.getComplemento());
		cliente.getEndereco().setNumero((clienteRequestDTO.getNumero()));
		clienteRepository.save(cliente);

		mail.sendEmail(cliente.getEmail(), "Usuário cadastrado",
				"Você foi cadastrado com usuário " + cliente.getNome() + " e e-mail " + cliente.getEmail());
		return new ClienteResponseDTO(cliente);
	}

	@Override
	public Cliente inserirCliente(Cliente cliente) {
		mail.sendEmail(cliente.getEmail(), "Usuário Atualizado", "Seus dados foram atualizados " + cliente.getNome()
				+ " e e-mail " + cliente.getEmail() + cliente.getEndereco().toString());
		clienteRepository.save(cliente);
		return cliente;
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