package api.ecommerce.grupo3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.domain.Categoria;
import api.ecommerce.grupo3.repository.CategoriaRepository;
import api.ecommerce.grupo3.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> pesquisarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> pesquisarUm(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria inserir(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public boolean idExiste(Long id) {
        return categoriaRepository.existsById(id);
    }

    @Override
    public void remover(Long id) {
        categoriaRepository.deleteById(id);
    }

}