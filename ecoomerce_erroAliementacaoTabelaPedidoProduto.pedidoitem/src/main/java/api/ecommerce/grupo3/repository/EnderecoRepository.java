package api.ecommerce.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.ecommerce.grupo3.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
		
	public Endereco findByCep(String cep);

}
