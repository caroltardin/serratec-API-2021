package api.ecommerce.grupo3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.grupo3.domain.Pedido;
import api.ecommerce.grupo3.domain.PedidoProduto;
import api.ecommerce.grupo3.domain.Produto;
import api.ecommerce.grupo3.dto.PedidoRequestDTO;
import api.ecommerce.grupo3.dto.PedidoResponseDTO;
import api.ecommerce.grupo3.repository.PedidoRepository;
import api.ecommerce.grupo3.service.PedidoService;
import api.ecommerce.grupo3.service.ProdutoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRespository;

	@Autowired
	private ProdutoService produtoService;

	@Override
	public List<Pedido> listar() {
		List<Pedido> pedidos = pedidoRespository.findAll();

		for (Pedido pedido : pedidos) {
			calcularTotalPedido(pedido);
		}

		return pedidos;
	}

	@Override
	public Pedido pesquisarUm(Long idPedido) {
		Pedido pedido = pedidoRespository.getById(idPedido);

		calcularTotalPedido(pedido);

		return pedido;
	}

	@Override
	public Pedido inserir(Pedido pedido) {
//		Pedido p = new Pedido();
//		p.setCliente(pedido.getCliente());
//		p.setDataPedido(pedido.getDataPedido());
//		p.setStatus(pedido.getStatus());

//		for(PedidoProduto pedidoProduto: pedido.getPedidoProdutos()) {
//			Produto produto = new Produto();
//			pedidoProduto.setPedido(pedido);
// 			pedidoProduto.setProduto(produto);
//			//pedidoProduto.setProduto(produtoService.buscar(pedidoProduto.getProduto().getId_produto()));
//			pedidoProduto.setQtdCompradaPorProduto(pedidoProduto.getQtdCompradaPorProduto());
//		}


		return pedidoRespository.saveAndFlush(pedido);
	}

	//Novo, inserir por DTO
	@Override
	public PedidoResponseDTO inserirPedidoDTO(PedidoRequestDTO pedidoRequestDTO) {
		Pedido pedido = new Pedido();
		pedido.setCliente(pedidoRequestDTO.getCliente());
		pedido.setDataPedido(pedidoRequestDTO.getDataPedido());
		pedido.setStatus(pedidoRequestDTO.getStatus());
		
		calcularTotalPedido(pedido);

		for(PedidoProduto pedidoProduto: pedido.getPedidoProdutos()) {
			Produto produto = new Produto();
			pedidoProduto.setPedido(pedido);
 			pedidoProduto.setProduto(produto);
			pedidoProduto.setQtdCompradaPorProduto(pedidoProduto.getQtdCompradaPorProduto());
		}
		
		pedidoRespository.save(pedido);

		return new PedidoResponseDTO(pedido);
	}
	
	
	@Override
	public boolean idExiste(Long id) {
		return pedidoRespository.existsById(id);
	}

	@Override
	public void remover(Long id) {
		pedidoRespository.deleteById(id);
	}

//	@Override
//	public List<Pedido> inserirVarios(List<Pedido> listaPedido) {
//		return pedidoRespository.saveAll(listaPedido);
//	}

	@Override
	public void calcularTotalPedido(Pedido pedido) {
		Long valorTotal = 0l;

		for (PedidoProduto pedidoProduto : pedido.getPedidoProdutos()) {
			valorTotal = valorTotal
					+ pedidoProduto.getQtdCompradaPorProduto() * pedidoProduto.getId().getProduto().getValor();
		}

		pedido.setValorTotalPedido(valorTotal);
	}

	
	public PedidoRepository getPedidoRespository() {
		return pedidoRespository;
	}

	public void setPedidoRespository(PedidoRepository pedidoRespository) {
		this.pedidoRespository = pedidoRespository;
	}

	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

}