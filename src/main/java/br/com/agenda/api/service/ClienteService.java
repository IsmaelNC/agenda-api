package br.com.agenda.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.api.model.Cliente;
import br.com.agenda.api.repository.ClienteRepository;

/**
 * @author ismaelnc
 *
 */

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional
	public void save(Cliente cliente) {
		this.repository.save(cliente);
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> listClientes(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void removerCliente(Cliente cliente) {
		this.repository.delete(cliente);
	}
	
	@Transactional
	public void removeClienteById(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional
	public void updateCliente(Cliente cliente) {
		this.repository.saveAndFlush(cliente);
	}
	
	@Transactional(readOnly=true)
	public Cliente getById(Long id) {
		return this.repository.getOne(id);
	}
	
	@Transactional(readOnly=true)
	public Cliente buscaPorNome(String nome) {
		return this.repository.findByNome(nome);
	}
	
	@Transactional(readOnly=true)
	public Cliente buscaPorEmail(String email) {
		return this.repository.findByEmail(email);
	}
}
