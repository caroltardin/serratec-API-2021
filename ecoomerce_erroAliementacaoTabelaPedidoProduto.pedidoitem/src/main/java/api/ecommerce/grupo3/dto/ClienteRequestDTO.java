package api.ecommerce.grupo3.dto;

import api.ecommerce.grupo3.domain.Cliente;

public class ClienteRequestDTO {

	private String nome;
	private String email;
	private String cpf;
	private String cep;
	private String numero;
	private String complemento;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ClienteRequestDTO() {

	}

	public ClienteRequestDTO(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public ClienteRequestDTO(Cliente cliente) {
		super();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.cep = cliente.getEndereco().getCep();
		this.complemento = cliente.getEndereco().getComplemento();
		this.numero = cliente.getEndereco().getNumero();
	}

}
