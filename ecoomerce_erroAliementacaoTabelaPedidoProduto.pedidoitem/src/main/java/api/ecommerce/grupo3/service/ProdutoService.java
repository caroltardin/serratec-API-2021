package api.ecommerce.grupo3.service;

import java.util.List;
import java.util.Optional;

import api.ecommerce.grupo3.domain.Produto;
import api.ecommerce.grupo3.dto.ProdutoRequestDTO;
import api.ecommerce.grupo3.dto.ProdutoResponseDTO;

public interface ProdutoService {

    List<ProdutoResponseDTO> pesquisarTodosDTO();
    List<Produto> pesquisarTodos();
    Optional<Produto> pesquisarUm(Long idProduto);
    ProdutoResponseDTO inserirDTO(ProdutoRequestDTO produto);
    Produto inserir(Produto produto);
    boolean idExiste(Long id);
    void remover(Long id);

}