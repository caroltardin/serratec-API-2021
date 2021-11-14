package api.ecommerce.grupo3.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

import api.ecommerce.grupo3.dto.ClienteRequestDTO;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente {
	//senha aqui ou em usuario?
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
    @ApiModelProperty(value = "Identificador único do cliente")
	private Long id_cliente;
	
	//message ou valdiar pela try catch
	@NotBlank
	@CPF
	@Column(unique = true, nullable = false, length = 11)
	@ApiModelProperty(value = "CPF", required = true)
	private String cpf;
	
	@NotBlank
	@Email
	@Column(unique = true)
	@ApiModelProperty(value = "Email", required = true)
	private String email;
	
	@Column
	@ApiModelProperty(value = "Data de Nascimento")
	private LocalDate dataNascimento;
	
	@NotBlank
	@Column
    @Size(max = 100)
	@ApiModelProperty(value = "Nome do cliente", required = true)
	private String nome;	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@OneToMany(mappedBy = "id_pedido")
	//testar depois
	//@JoinColumn(name = "id_pedido")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Pedido> pedidos;

	public Cliente() {
		
	}	
		
	public Cliente(Long id_cliente, @NotBlank @CPF String cpf, @NotBlank @Email String email, LocalDate dataNascimento,
			@NotBlank @Size(max = 100) String nome, Endereco endereco, List<Pedido> pedidos) {
		super();
		this.id_cliente = id_cliente;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.endereco = endereco;
		this.pedidos = pedidos;
	}

	public Cliente(ClienteRequestDTO clienteRequestDTO) {
		super();
		this.nome = clienteRequestDTO.getNome();
		this.email = clienteRequestDTO.getEmail();
		this.cpf = clienteRequestDTO.getCpf();
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", nome=" + nome + ", endereco=" + endereco + ", pedidos=" + pedidos + "]";
	}
	

	
}