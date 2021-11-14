package api.ecommerce.grupo3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import api.ecommerce.grupo3.dto.CategoriaRequestDTO;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "Identificador Único da categoria")
    private Long idCategoria;

    @NotBlank (message = "Preencha um nome para a categoria")
    @Size(max = 50, message="Tamanho maximo 50 caracteres")
    @Column(nullable = false)
    @ApiModelProperty(value = "Nome da Categoria")
    private String nomeCategoria;

    @Column
    @ApiModelProperty(value = "Descrição da Categoria")
    private String descricaoCategoria;

    public Categoria() {
		super();
	}

	public Categoria(CategoriaRequestDTO categoriaRequestDTO) {
    	super();
    	this.nomeCategoria = categoriaRequestDTO.getNomeCategoria();
    	this.descricaoCategoria = categoriaRequestDTO.getDescricaoCategoria();
	}

	public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

}