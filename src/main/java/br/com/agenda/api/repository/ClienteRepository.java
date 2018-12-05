package br.com.agenda.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.agenda.api.model.Cliente;

/**
 * @author ismaelnc
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Cliente findByNome(String nome);
	
	public Cliente findByEmail(String email);
}
