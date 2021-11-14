package api.ecommerce.grupo3.service;

import java.util.List;
import java.util.Optional;

import api.ecommerce.grupo3.domain.Cliente;
import api.ecommerce.grupo3.dto.ClienteRequestDTO;
import api.ecommerce.grupo3.dto.ClienteResponseDTO;

public interface ClienteService {


	List<Cliente> pesquisarTodosClientes();


	List<ClienteResponseDTO> pesquisarTodosClientesDTO();


	Optional<Cliente> pesquisarUmCliente(Long id);

	ClienteResponseDTO inserirClienteDTO(ClienteRequestDTO clienteRequestDTO);

	Cliente inserirCliente(Cliente cliente);

	
	boolean idExisteCliente(Long id);


	void removerCliente(Long id);

}