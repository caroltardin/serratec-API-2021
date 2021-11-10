package api.ecommerce.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ecommerce.grupo3.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}