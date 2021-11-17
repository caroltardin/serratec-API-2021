package api.ecommerce.grupo3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "Identificador Único da categoria")
    private Long id_categoria;

    @NotBlank (message = "Preencha um nome para a categoria")
    @Size(max = 50, message="Tamanho maximo 50 caracteres")
    @Column(nullable = false)
    @ApiModelProperty(value = "Nome da Categoria")
    private String nome_categoria;

    @Column
    @ApiModelProperty(value = "Descrição da Categoria")
    private String descricao_categoria;

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getDescricao_categoria() {
        return descricao_categoria;
    }

    public void setDescricao_categoria(String descricao_categoria) {
        this.descricao_categoria = descricao_categoria;
    }


}