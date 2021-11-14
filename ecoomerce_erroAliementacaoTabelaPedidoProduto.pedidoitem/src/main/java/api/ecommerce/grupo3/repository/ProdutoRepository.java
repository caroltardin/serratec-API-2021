package api.ecommerce.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ecommerce.grupo3.domain.Produto;
import api.ecommerce.grupo3.dto.ProdutoRequestDTO;
import api.ecommerce.grupo3.dto.ProdutoResponseDTO;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	ProdutoResponseDTO save(ProdutoRequestDTO produto);

}