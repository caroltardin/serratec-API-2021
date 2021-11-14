package api.ecommerce.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ecommerce.grupo3.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
