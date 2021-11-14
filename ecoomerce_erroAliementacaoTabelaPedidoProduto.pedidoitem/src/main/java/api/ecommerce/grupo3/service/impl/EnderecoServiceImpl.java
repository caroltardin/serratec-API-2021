package api.ecommerce.grupo3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import api.ecommerce.grupo3.domain.Endereco;
import api.ecommerce.grupo3.dto.EnderecoResponseDTO;
import api.ecommerce.grupo3.repository.EnderecoRepository;
import api.ecommerce.grupo3.service.EnderecoService;


@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco buscarCep(String cep) throws HttpClientErrorException{
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/" + cep + "/json";
		Endereco enderecoViaCep = restTemplate.getForObject(uri, Endereco.class);
		String cepSemTraco = enderecoViaCep.getCep().replaceAll("-", "");
		enderecoViaCep.setCep(cepSemTraco);		
		return enderecoViaCep;
	}	
	
		
	@Override
	public EnderecoResponseDTO inserirCep(Endereco endereco) {
		endereco = enderecoRepository.save(endereco);
		return new EnderecoResponseDTO(endereco);
		}
	

}
