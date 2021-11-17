package api.ecommerce.grupo3.domain;

import java.math.BigDecimal;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "Identificados Único do Produto")
    private Long id_produto;
    
    @NotNull(message = "Preencha um valor para o produto")
    @DecimalMin(value = "0", message = "O preço não pode ser menor que R${value}.00")
    @Column
    @ApiModelProperty(value = "Valor do produto", required = true)
    private BigDecimal valor;    
    
    @NotBlank (message = "Preencha um nome para o produto")
    @Size(max = 150, message = "Tamanho maximo 150 de caracteres")
    @Column
    @ApiModelProperty(value = "Nome do produto", required = true)
    private String nomeProduto;    
    
    @NotNull(message = "Digite uma quantidade para o estoque")
    @DecimalMin(value = "0", message = "A quantidade tem ser maior que R${value}.00")
    @Column
    @ApiModelProperty(value = "Quantidade em Estoque", required = true)
    private BigDecimal qtdEstoque;    
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @ApiModelProperty(value = "categoria do produto")
    private Categoria categoria;


    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(BigDecimal qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}