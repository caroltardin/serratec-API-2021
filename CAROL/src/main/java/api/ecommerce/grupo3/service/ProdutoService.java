package api.ecommerce.grupo3.service;

import java.util.List;
import java.util.Optional;

import api.ecommerce.grupo3.domain.Produto;

public interface ProdutoService {

    List<Produto> pesquisarTodos();
    Optional<Produto> pesquisarUm(Long idProduto);
    Produto inserir(Produto produto);
    boolean idExiste(Long id);
    void remover(Long id);

}