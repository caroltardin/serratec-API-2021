package api.ecommerce.grupo3.dto;

import api.ecommerce.grupo3.domain.Categoria;

public class CategoriaResponseDTO {
	
	private Long idCategoria;
	private String nomeCategoria;
	private String descricaoCategoria;
	
	public CategoriaResponseDTO() {
		super();
	}

	public CategoriaResponseDTO(Long idCategoria, String nomeCategoria, String descricaoCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}
	
	public CategoriaResponseDTO( Categoria categoria) {
		super();
		this.idCategoria = categoria.getIdCategoria();
		this.nomeCategoria = categoria.getNomeCategoria();
		this.descricaoCategoria = categoria.getDescricaoCategoria();
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
