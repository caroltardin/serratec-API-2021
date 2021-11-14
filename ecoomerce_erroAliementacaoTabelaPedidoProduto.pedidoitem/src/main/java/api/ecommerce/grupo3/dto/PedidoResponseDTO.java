package api.ecommerce.grupo3.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import api.ecommerce.grupo3.domain.Cliente;
import api.ecommerce.grupo3.domain.Pedido;
import api.ecommerce.grupo3.domain.PedidoProduto;
import api.ecommerce.grupo3.domain.Status;

public class PedidoResponseDTO {

	private Long id_pedido;
	private LocalDate dataPedido;
	private Long valorTotalPedido;
    private Status status;
	private Cliente cliente;
	private List<PedidoProduto> pedidoProdutos = new ArrayList<>();
	
	public PedidoResponseDTO() {
		
	}
	
	public PedidoResponseDTO(Long id_pedido, LocalDate dataPedido, Long valorTotalPedido, Status status,
			Cliente cliente, List<PedidoProduto> pedidoProdutos) {
		this.id_pedido = id_pedido;
		this.dataPedido = dataPedido;
		this.valorTotalPedido = valorTotalPedido;
		this.status = status;
		this.cliente = cliente;
		this.pedidoProdutos = pedidoProdutos;
	}
	
	public PedidoResponseDTO(Pedido pedido) {
		this.id_pedido = pedido.getId_pedido();
		this.dataPedido = pedido.getDataPedido();
		this.valorTotalPedido = pedido.getValorTotalPedido();
		this.status = pedido.getStatus();
		this.cliente = pedido.getCliente();
		this.pedidoProdutos = pedido.getPedidoProdutos();
	}
	
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Long getValorTotalPedido() {
		return valorTotalPedido;
	}
	public void setValorTotalPedido(Long valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<PedidoProduto> getPedidoProdutos() {
		return pedidoProdutos;
	}
	public void setPedidoProdutos(List<PedidoProduto> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
	}
	
	
}
