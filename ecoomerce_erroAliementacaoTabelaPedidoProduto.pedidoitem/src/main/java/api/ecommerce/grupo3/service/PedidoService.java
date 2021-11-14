package api.ecommerce.grupo3.service;

import java.util.List;

import api.ecommerce.grupo3.domain.Pedido;
import api.ecommerce.grupo3.dto.PedidoRequestDTO;
import api.ecommerce.grupo3.dto.PedidoResponseDTO;

public interface PedidoService {
	List<Pedido> listar();
	Pedido pesquisarUm(Long id_pedido);
	Pedido inserir (Pedido pedido);
	boolean idExiste(Long id);
	void remover(Long id);
	PedidoResponseDTO inserirPedidoDTO(PedidoRequestDTO pedidoRequestDTO);
	
	void calcularTotalPedido(Pedido pedido);
}
