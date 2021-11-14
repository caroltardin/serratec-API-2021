package api.ecommerce.grupo3.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import api.ecommerce.grupo3.domain.Produto;
import api.ecommerce.grupo3.dto.ProdutoRequestDTO;
import api.ecommerce.grupo3.dto.ProdutoResponseDTO;
import api.ecommerce.grupo3.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
		
		@Autowired
		private ProdutoService produtoService;
		
		@GetMapping
		@ApiOperation(value = "Listar todos os produtos", notes = "Listagem com todos os produtos")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Retorna todos os produtos"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<List<ProdutoResponseDTO>> pesquisarTodosDTO() {
			List<ProdutoResponseDTO> listaProdutos = produtoService.pesquisarTodosDTO();
			return ResponseEntity.ok(listaProdutos);
		}
		
		@GetMapping("/{id}")
		@ApiOperation(value = "Lista 1 produto", notes = "Listagem de 1 produto")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Produto retornado"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<Produto> pesquisarUm(@PathVariable Long id) {
			Optional<Produto> produto = produtoService.pesquisarUm(id);
			if (produto.isPresent()) {
				return ResponseEntity.ok(produto.get());
			}
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping
		@ApiOperation(value = "Insere um novo produto", notes = "inserção de um novo produto")
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "Produto inserido"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<ProdutoResponseDTO> inserirDTO(@Valid @RequestBody ProdutoRequestDTO produto, UriComponentsBuilder b) {
			ProdutoResponseDTO produtoDTO = produtoService.inserirDTO(produto);
			UriComponents uriComponents = b.path("/produtos/{id}").buildAndExpand(produtoDTO.getIdProduto());
			return ResponseEntity.created(uriComponents.toUri()).body(produtoDTO);
		}
		
		@PutMapping("/{id}")
		@ApiOperation(value = "Atualizar produto", notes = "atualizar um produto")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Produto atualizado"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto produto, @PathVariable Long id) {
			if (!produtoService.idExiste(id)) {
				return ResponseEntity.notFound().build();
			}
			produto.setIdProduto(id);
			produto = produtoService.inserir(produto);
			return ResponseEntity.ok(produto);
		}
		
		@DeleteMapping("/{id}")
		@ApiOperation(value = "Remover produto", notes = "remoção de um produto")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Produto removido"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<Void> remover(@PathVariable Long id) {
			if (!produtoService.idExiste(id)) {
				return ResponseEntity.notFound().build();
			}
			produtoService.remover(id);
			return ResponseEntity.noContent().build();
		}
		
}
