package api.ecommerce.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ecommerce.grupo3.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}