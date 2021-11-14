package api.ecommerce.grupo3.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import api.ecommerce.grupo3.dto.ProdutoRequestDTO;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "Identificador Único do Produto")
    private Long idProduto;
    
    @NotNull(message = "Preencha um valor para o produto")
    @DecimalMin(value = "0", message = "O preço não pode ser menor que R${value}.00")
    @Column
    @ApiModelProperty(value = "Valor do produto", required = true)
    private Long valor;    
    
    @NotBlank (message = "Preencha um nome para o produto")
    @Size(max = 150, message = "Tamanho maximo 150 de caracteres")
    @Column
    @ApiModelProperty(value = "Nome do produto", required = true)
    private String nomeProduto;    
    
    @NotNull(message = "Digite uma quantidade para o estoque")
    @DecimalMin(value = "0", message = "A quantidade tem ser maior que R${value}.00")
    @Column
    @ApiModelProperty(value = "Quantidade em Estoque", required = true)
    private Long qtdEstoque;    
    
    @NotNull(message = "Preencha a categoria")
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @ApiModelProperty(value = "categoria do produto")
    private Categoria categoria;

    @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.PERSIST)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  	private Set<PedidoProduto> PedidoProduto = new HashSet<>();
    
    public Produto() {
    	
    }

    public Produto(ProdutoRequestDTO produtoRequestDTO) {
    	super();
		this.nomeProduto = produtoRequestDTO.getNomeProduto();
		this.valor = produtoRequestDTO.getValor();
		this.qtdEstoque = produtoRequestDTO.getQtdEstoque();
		this.categoria = produtoRequestDTO.getCategoria();
    }

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
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

	public Set<PedidoProduto> getPedidoProduto() {
		return PedidoProduto;
	}

	public void setPedidoProduto(Set<PedidoProduto> pedidoProduto) {
		PedidoProduto = pedidoProduto;
	}

       
}