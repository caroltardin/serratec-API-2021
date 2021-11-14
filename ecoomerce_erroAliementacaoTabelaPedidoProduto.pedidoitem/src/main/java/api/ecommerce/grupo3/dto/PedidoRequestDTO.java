package api.ecommerce.grupo3.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import api.ecommerce.grupo3.domain.Cliente;
import api.ecommerce.grupo3.domain.Pedido;
import api.ecommerce.grupo3.domain.PedidoProduto;
import api.ecommerce.grupo3.domain.Status;

public class PedidoRequestDTO {

	private LocalDate dataPedido;
    private Status status;
	private Cliente cliente;
	private List<PedidoProduto> pedidoProdutos = new ArrayList<>();
	
	public PedidoRequestDTO(LocalDate dataPedido, Status status, Cliente cliente,
			List<PedidoProduto> pedidoProdutos) {
		this.dataPedido = dataPedido;
		this.status = status;
		this.cliente = cliente;
		this.pedidoProdutos = pedidoProdutos;
	}
	
	public PedidoRequestDTO(Pedido pedido) {
		this.dataPedido = pedido.getDataPedido();
		this.status = pedido.getStatus();
		this.cliente = pedido.getCliente();
		this.pedidoProdutos = pedido.getPedidoProdutos();
	}
	
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
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