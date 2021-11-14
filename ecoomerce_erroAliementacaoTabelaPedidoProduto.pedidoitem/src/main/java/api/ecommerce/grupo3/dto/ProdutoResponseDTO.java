package api.ecommerce.grupo3.dto;

import api.ecommerce.grupo3.domain.Categoria;
import api.ecommerce.grupo3.domain.Produto;

public class ProdutoResponseDTO {
	
	private Long idProduto;
	private String nomeProduto;
	private Long valor;
	private Long qtdEstoque;
	private Categoria categoria;
	
	public ProdutoResponseDTO() {
	}
	
	public ProdutoResponseDTO(Long idProduto, String nomeProduto, Long valor, Long qtdEstoque,
			Categoria categoria) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.qtdEstoque = qtdEstoque;
		this.categoria = categoria;
	}

	public ProdutoResponseDTO(Produto produto) {
		super();
		this.idProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.valor = produto.getValor();
		this.qtdEstoque = produto.getQtdEstoque();
		this.categoria = produto.getCategoria();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Long getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Long qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
