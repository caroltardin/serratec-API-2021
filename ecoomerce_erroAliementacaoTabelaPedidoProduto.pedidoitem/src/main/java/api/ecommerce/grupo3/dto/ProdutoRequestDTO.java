package api.ecommerce.grupo3.dto;

import api.ecommerce.grupo3.domain.Categoria;
import api.ecommerce.grupo3.domain.Produto;

public class ProdutoRequestDTO {
	
	private String nomeProduto;
	private Long valor;
	private Long qtdEstoque;
	private Categoria categoria;
	
	public ProdutoRequestDTO() {
	}
	
	public ProdutoRequestDTO(String nomeProduto, Long valor, Long qtdEstoque, Categoria categoria) {
		super();
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.qtdEstoque = qtdEstoque;
		this.categoria = categoria;
	}

	public ProdutoRequestDTO(Produto produto) {
		super();
		this.nomeProduto = produto.getNomeProduto();
		this.valor = produto.getValor();
		this.qtdEstoque = produto.getQtdEstoque();
		this.setCategoria(produto.getCategoria());
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
