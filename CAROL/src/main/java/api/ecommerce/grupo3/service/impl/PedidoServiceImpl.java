package api.ecommerce.grupo3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.domain.Pedido;
import api.ecommerce.grupo3.repository.PedidoRepository;
import api.ecommerce.grupo3.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRespository;

	@Override
	public List<Pedido> listar() {
//		List<Pedido> pedidos = pedidoRespository.findAll();
//
//		for(Pedido pedido: pedidos) {
//		calcularTotalPedido(pedido);
//		}
		
		return pedidoRespository.findAll();
	}

	@Override
	public Optional<Pedido> pesquisarUm(Long idPedido) {
//		Pedido pedido = pedidoRespository.getById(idPedido);
//		
//		calcularTotalPedido(pedido);
		
		return pedidoRespository.findById(idPedido);
	}

	@Override
	public Pedido inserir(Pedido pedido) {
		return pedidoRespository.save(pedido);
	}

	@Override
	public boolean idExiste(Long id) {
		return pedidoRespository.existsById(id);
	}

	@Override
	public void remover(Long id) {
		pedidoRespository.deleteById(id);		
	}

	@Override
	public List<Pedido> inserirVarios(List<Pedido> listaPedido) {
		return pedidoRespository.saveAll(listaPedido);
	}

//	//pode ser void?
//	//pegar quantidade de venda e nao de ESTOQUE
//	@Override
//	public Long calcularTotalPedido(Pedido pedido) {
//		Long valorTotal = (long) 0;
//		
//		//for(Produto produto: pedido.getProdutos()) {
//	//	for(Produto produto: pedido.getPedidoProduto().getProduto()) {
//			valorTotal = valorTotal + pedido.getPedidoProduto().getQtdCompradaPorProduto();//* produto.getValor();
//	//	}
//		
//		pedido.setValorTotalPedido(valorTotal);
//		return valorTotal;
//	}	
	
}
