package api.ecommerce.grupo3.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import api.ecommerce.grupo3.domain.Cliente;
import api.ecommerce.grupo3.dto.ClienteRequestDTO;
import api.ecommerce.grupo3.dto.ClienteResponseDTO;
import api.ecommerce.grupo3.exception.EmailException;
import api.ecommerce.grupo3.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@ApiOperation(value = "Lista todos os clientes", notes = "Listagem com todos os clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão") })
	public ResponseEntity<List<Cliente>> pesquisarTodosClientes() {
		List<Cliente> listaClientes = clienteService.pesquisarTodosClientes();
		return ResponseEntity.ok(listaClientes);
	}

	@GetMapping("/dto")
	@ApiOperation(value = "Lista clientes com filtro de dados", notes = "Listagem com todos os clientes com filtro de dados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientescom filtro de dados"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão") })
	public ResponseEntity<List<ClienteResponseDTO>> pesquisarTodosClientesDTO() {
		List<ClienteResponseDTO> listaClientes = clienteService.pesquisarTodosClientesDTO();
		return ResponseEntity.ok(listaClientes);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Lista 1 cliente por ID", notes = "Listagem de 1 cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente retornado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão") })
	public ResponseEntity<Cliente> pesquisarClienteId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.pesquisarUmCliente(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere um novo cliente", notes = "inserção de um novo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão") })
	public ResponseEntity<Object> inserirClienteDTO(@RequestBody ClienteRequestDTO clienteRequestDTO) {
		try {
			ClienteResponseDTO clienteDTO = clienteService.inserirClienteDTO(clienteRequestDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(clienteDTO.getId_cliente()).toUri();
			return ResponseEntity.created(uri).body(clienteDTO);
		} catch (EmailException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar cliente", notes = "atualizar um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão") })
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		if (!clienteService.idExisteCliente(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId_cliente(id);
		cliente = clienteService.inserirCliente(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remover cliente", notes = "remoção de um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente removido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão") })
	public ResponseEntity<Cliente> removerCliente(@PathVariable Long id) {
		if (!clienteService.idExisteCliente(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteService.removerCliente(id);
		return ResponseEntity.noContent().build();
	}

}