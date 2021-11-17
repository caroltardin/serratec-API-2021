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

import api.ecommerce.grupo3.domain.Categoria;
import api.ecommerce.grupo3.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {
		
		@Autowired
		private CategoriaService categoriaService;
		
		@GetMapping
		@ApiOperation(value = "Lista todas as categorias", notes = "Listagem com todas as categorias")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Retorna todas as categorias"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<List<Categoria>> pesquisarTodos() {
			List<Categoria> listaCategorias = categoriaService.pesquisarTodos();
			return ResponseEntity.ok(listaCategorias);
		}
		
		@GetMapping("/{id}")
		@ApiOperation(value = "Lista 1 categoria", notes = "Listagem de 1 categoria")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Categoria retornada"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<Categoria> pesquisarUm(@PathVariable Long id) {
			Optional<Categoria> categoria = categoriaService.pesquisarUm(id);
			if (categoria.isPresent()) {
				return ResponseEntity.ok(categoria.get());
			}
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping
		@ApiOperation(value = "Insere uma nova categoria", notes = "inserção de uma nova categoria")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Categoria inserido"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria, UriComponentsBuilder b) {
			UriComponents uriComponents = b.path("/categoria/{id}").buildAndExpand(categoria.getId_categoria());
			return ResponseEntity.created(uriComponents.toUri()).body(categoriaService.inserir(categoria));
		}
		
		@PutMapping("/{id}")
		@ApiOperation(value = "Atualizar categoria", notes = "atualizar uma categoria")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Categoria atualizado"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu alguma excessão")
		})
		public ResponseEntity<Categoria> atualizar(@Valid @RequestBody Categoria categoria, @PathVariable Long id) {
			if (!categoriaService.idExiste(id)) {
				return ResponseEntity.notFound().build();
			}
			categoria.setId_categoria(id);
			categoria = categoriaService.inserir(categoria);
			return ResponseEntity.ok(categoria);
		}
		
		@DeleteMapping("/{id}")
		@ApiOperation(value = "Remover categoria", notes = "remoção de uma categoria")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Categoria removida"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
		})
		public ResponseEntity<Void> remover(@PathVariable Long id) {
			if (!categoriaService.idExiste(id)) {
				return ResponseEntity.notFound().build();
			}
			categoriaService.remover(id);
			return ResponseEntity.noContent().build();
		}
		
}