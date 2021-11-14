package api.ecommerce.grupo3.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import api.ecommerce.grupo3.domain.Pedido;
import api.ecommerce.grupo3.dto.PedidoRequestDTO;
import api.ecommerce.grupo3.dto.PedidoResponseDTO;
import api.ecommerce.grupo3.service.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os pedidos", notes = "Listagem com todos os pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
	})
	public ResponseEntity<List<Pedido>> listar(){
		List<Pedido> pedidos = pedidoService.listar();
		return ResponseEntity.ok(pedidos);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Lista o pedido pelo código", notes = "Listagem de 1 pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o pedido pelo código"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
	})
	public ResponseEntity<Pedido> pesquisarUm(@PathVariable Long id){
		Pedido pedido = pedidoService.pesquisarUm(id);
//		if(pedido.isPresent()) {
//			return ResponseEntity.ok(pedido.get());
//		}
//		return ResponseEntity.notFound().build();

		return ResponseEntity.ok(pedido);
 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere um novo pedido", notes = "inserção de um novo pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Pedido inserido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
	})
	public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoRequestDTO pedidoRequestDTO) {	
	
			PedidoResponseDTO pedidoDTO = pedidoService.inserirPedidoDTO(pedidoRequestDTO);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(pedidoDTO.getId_pedido()).toUri();
			return ResponseEntity.created(uri).body(pedidoDTO);
		
	}
	
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar pedido", notes = "atualizar um pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
	})
	public ResponseEntity<Pedido> atualizar(@Valid @RequestBody Pedido pedido, @PathVariable Long id) {
		if (!pedidoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		pedido.setId_pedido(id);
		pedido = pedidoService.inserir(pedido);
		return ResponseEntity.ok(pedido);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remover Pedido", notes = "remoção de um pedido")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido removido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
	})
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!pedidoService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		pedidoService.remover(id);
		return ResponseEntity.noContent().build();
	}

}