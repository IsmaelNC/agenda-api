package br.com.agenda.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.api.model.Fornecedor;

/**
 * @author ismaelnc
 *
 */
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	
	public Fornecedor findByNome(String nome);
	
	public Fornecedor findByEmail(String email);
}
