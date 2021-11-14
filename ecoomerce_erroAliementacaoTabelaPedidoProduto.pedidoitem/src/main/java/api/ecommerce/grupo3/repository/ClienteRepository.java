package api.ecommerce.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.ecommerce.grupo3.domain.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByEmail(String email);
	
	

}