package org.serratec.java2backend.exercicio2.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.java2backend.exercicio2.domain.Produto;
import org.serratec.java2backend.exercicio2.repository.ProdutoRepository;
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
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

@RestController
@RequestMapping("/produtos")
public class ProdutoController extends RequestMappingInfoHandlerMethodMappingNamingStrategy {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		List<Produto> lista = produtoRepository.findAll();
		return ResponseEntity.ok(lista); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> pesquisar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto produto, @PathVariable Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
