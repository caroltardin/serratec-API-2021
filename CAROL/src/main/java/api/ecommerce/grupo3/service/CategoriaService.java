package api.ecommerce.grupo3.service;

import java.util.List;
import java.util.Optional;

import api.ecommerce.grupo3.domain.Categoria;

public interface CategoriaService {

    List<Categoria> pesquisarTodos();
    Optional<Categoria> pesquisarUm(Long id);
    Categoria inserir(Categoria categoria);
    boolean idExiste(Long id);
    void remover(Long id);

}