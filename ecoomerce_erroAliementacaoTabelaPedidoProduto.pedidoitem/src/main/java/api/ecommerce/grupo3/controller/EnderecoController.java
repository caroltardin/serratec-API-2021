package api.ecommerce.grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.ecommerce.grupo3.domain.Endereco;
import api.ecommerce.grupo3.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping("{cep}")
    @ApiOperation(value = "Lista o endereço pelo CEP", notes = "Listagem de endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereço pelo CEP"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Ocorreu alguma excessão")
    })
	
	public ResponseEntity<Endereco> buscarCep(@PathVariable String cep) {
		Endereco endereco = enderecoService.buscarCep(cep);
		if (endereco == null) {
			return ResponseEntity.notFound().build();
	} else {
		return ResponseEntity.ok(endereco);
		}
	}
	
}
