package api.ecommerce.grupo3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.domain.Produto;
import api.ecommerce.grupo3.dto.ProdutoRequestDTO;
import api.ecommerce.grupo3.dto.ProdutoResponseDTO;
import api.ecommerce.grupo3.repository.ProdutoRepository;
import api.ecommerce.grupo3.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoResponseDTO> pesquisarTodosDTO() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoResponseDTO> produtosDTO = new ArrayList<ProdutoResponseDTO>();
		for (Produto produto : produtos) {
			ProdutoResponseDTO usuarioDTO = new ProdutoResponseDTO(produto);
			produtosDTO.add(usuarioDTO);
		}
		return produtosDTO;
	}
    
    @Override
	public List<Produto> pesquisarTodos() {
		return produtoRepository.findAll();
	}

    @Override
    public Optional<Produto> pesquisarUm(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public ProdutoResponseDTO inserirDTO(ProdutoRequestDTO produtoRequestDTO) {
		Produto produto = new Produto(produtoRequestDTO);
		produtoRepository.save(produto);
		return new ProdutoResponseDTO(produto);
	}
    
    @Override
	public Produto inserir(Produto produto) {
		return produtoRepository.save(produto);
	}

    @Override
    public boolean idExiste(Long id) {
        return produtoRepository.existsById(id);
    }

    @Override
    public void remover(Long id) {
        produtoRepository.deleteById(id);
    }

}