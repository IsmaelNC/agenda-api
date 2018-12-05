package br.com.agenda.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.com.agenda.api.handler.ClienteNotFoundException;
import br.com.agenda.api.model.Cliente;
import br.com.agenda.api.service.ClienteService;

/**
 * @author ismaelnc
 *
 */

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/cliente")
	public List<Cliente> list() {
		List<Cliente> cliente = this.service.listClientes();
		return cliente;
	}

	@PostMapping("/clientes")
	public void save(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		this.service.save(cliente);
	}

	@DeleteMapping("/clientes")
	public void remove(@RequestBody Cliente cliente) {
		this.service.removerCliente(cliente);
	}

	@DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Long id) {
		Cliente cliente = service.getById(id);
		if(cliente != null) {
			service.removeClienteById(id);
		}//else {
		//	throw new ClienteNotFoundException("Cliente não encontrado", null);
		//}
	}
	
	@PutMapping("/clientes")
	public void update(@RequestBody Cliente cliente) {
		this.service.updateCliente(cliente);
	}
	
	@GetMapping("/clientes/buscarPorNome/{nome}")
	public Cliente buscaPorNome(@PathVariable String nome) {
		Cliente cliente = this.service.buscaPorNome(nome);
		return cliente;
	}
	
	@GetMapping("clientes/buscarPorEmail/{email}")
	public Cliente buscaPorEmail(@PathVariable String email) {
		Cliente cliente = this.service.buscaPorEmail(email);
		return cliente;
	}
}
