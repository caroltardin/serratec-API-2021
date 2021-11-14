package api.ecommerce.grupo3.service;

import java.util.List;
import java.util.Optional;

import api.ecommerce.grupo3.domain.Categoria;
import api.ecommerce.grupo3.dto.CategoriaRequestDTO;
import api.ecommerce.grupo3.dto.CategoriaResponseDTO;

public interface CategoriaService {

    List<CategoriaResponseDTO> pesquisarTodos();
    List<Categoria> buscarTodos();
    Optional<Categoria> pesquisarUm(Long id);
    CategoriaResponseDTO inserirDTO(CategoriaRequestDTO categoria);
    Categoria inserir(Categoria categoria);
    boolean idExiste(Long id);
    void remover(Long id);
	

}