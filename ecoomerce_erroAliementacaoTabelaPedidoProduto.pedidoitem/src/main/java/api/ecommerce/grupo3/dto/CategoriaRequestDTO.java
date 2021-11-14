package api.ecommerce.grupo3.dto;

import api.ecommerce.grupo3.domain.Categoria;

public class CategoriaRequestDTO {
	
	private String nomeCategoria;
	private String descricaoCategoria;
	
	public CategoriaRequestDTO() {
		super();
	}

	public CategoriaRequestDTO(String nomeCategoria, String descricaoCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}

	public CategoriaRequestDTO(Categoria categoria) {
		super();
		this.nomeCategoria = categoria.getNomeCategoria();
		this.descricaoCategoria = categoria.getDescricaoCategoria();
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
