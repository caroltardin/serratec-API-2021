package api.ecommerce.grupo3.service;

import java.util.List;
import java.util.Optional;

import api.ecommerce.grupo3.domain.Pedido;

public interface PedidoService {
	List<Pedido> listar();
	Optional<Pedido> pesquisarUm(Long id_pedido);
	Pedido inserir (Pedido pedido);
	boolean idExiste(Long id);
	void remover(Long id);
	List<Pedido> inserirVarios(List<Pedido> listaPedido);
	
}
