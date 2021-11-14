package api.ecommerce.grupo3.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Endereco {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco", nullable = false)
    @ApiModelProperty(value = "Identificador único do endereço")
	private Long idEndereco;
	
	@NotBlank (message = "Preencha um CEP válido")
//	@Column(name = "cep")
	@ApiModelProperty(value = "CEP", required = true)
	private String cep;
	
	@ApiModelProperty(value = "Logradouro", required = false)
	private String logradouro;
	
	@ApiModelProperty(value = "Complemento", required = false)
	private String complemento;
	
	@ApiModelProperty(value = "Bairro", required = false)
	private String bairro;
	
	@ApiModelProperty(value = "Localidade", required = false)
	private String localidade;
	
	@ApiModelProperty(value = "UF", required = false)
	private String uf;
	
	@ApiModelProperty(value = "Numero", required = false)
	private String numero;
	
	
	public Long getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Endereco() {
		
	}	
	
	public Endereco(Long idEndereco, String cep, String logradouro, String bairro, String localidade, String uf,
			String numero, String complemento) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.numero = numero;
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", cep=" + cep + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + ", numero="
				+ numero + "]";
	}	
	
	                             
}                       