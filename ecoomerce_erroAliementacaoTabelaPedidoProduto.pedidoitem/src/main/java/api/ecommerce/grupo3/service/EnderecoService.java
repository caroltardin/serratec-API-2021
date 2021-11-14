package api.ecommerce.grupo3.service;

import api.ecommerce.grupo3.domain.Endereco;
import api.ecommerce.grupo3.dto.EnderecoResponseDTO;

public interface EnderecoService {
	
	
	Endereco buscarCep(String cep);
	EnderecoResponseDTO inserirCep(Endereco endereco);
	
	
}
