package api.ecommerce.grupo3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.domain.Produto;
import api.ecommerce.grupo3.repository.ProdutoRepository;
import api.ecommerce.grupo3.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> pesquisarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> pesquisarUm(Long id) {
        return produtoRepository.findById(id);
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