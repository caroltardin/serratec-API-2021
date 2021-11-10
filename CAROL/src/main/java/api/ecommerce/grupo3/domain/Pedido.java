package api.ecommerce.grupo3.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Número do Pedido")
	@Column
	private Long id_pedido;
	
	@NotNull(message = "campo obrigatório")
	@Column
    @ApiModelProperty(value = "Data do pedido", required = true)
	private LocalDate dataPedido;

	@Column
	private Long valorTotalPedido;

	@NotNull(message = "campo obrigatório")
	@Enumerated(EnumType.ORDINAL)
    private Status status;
	
	@NotNull(message = "campo obrigatório")
	@ManyToOne
	@JoinColumn(name = "id_cliente")
    @ApiModelProperty(value = "código do cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "id.pedido", cascade = CascadeType.PERSIST)
	private Set<PedidoProduto> PedidoProduto = new HashSet<>();
	
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

	public void setValorTotalPedido(Long valorTotal) {
		this.valorTotalPedido = valorTotal;
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

	public Set<PedidoProduto> getPedidoProduto() {
		return PedidoProduto;
	}

	public void setPedidoProduto(Set<PedidoProduto> pedidoProduto) {
		PedidoProduto = pedidoProduto;
	}	
		
}