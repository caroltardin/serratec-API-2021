package api.ecommerce.grupo3.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PedidoProduto {
	
	@EmbeddedId
	private PedidoProdutoPK id = new PedidoProdutoPK();
		
	@Column
    @ApiModelProperty(value = "Valor do produto", required = true)
	Long qtdCompradaPorProduto;
	
	public PedidoProduto() {
		super();
	}
	
	public PedidoProduto(Pedido pedido, Produto produto, Long qtdCompradaPorProduto) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.qtdCompradaPorProduto = qtdCompradaPorProduto;
	}

	public PedidoProdutoPK getId() {
		return id;
	}

	public void setId(PedidoProdutoPK id) {
		this.id = id;
	}

	public Long getQtdCompradaPorProduto() {
		return qtdCompradaPorProduto;
	}

	public void setQtdCompradaPorProduto(Long qtdCompradaPorProduto) {
		this.qtdCompradaPorProduto = qtdCompradaPorProduto;
	}
	
}