package api.ecommerce.grupo3.dto;

import api.ecommerce.grupo3.domain.Cliente;

public class ClienteResponseDTO {

	private Long id_cliente;
	private String nome;
	private String email;

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClienteResponseDTO() {

	}

	public ClienteResponseDTO(Long id_cliente, String nome, String email) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.email = email;

	}

	public ClienteResponseDTO(Cliente cliente) {
		this.id_cliente = cliente.getId_cliente();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}

}
