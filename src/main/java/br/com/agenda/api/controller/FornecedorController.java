package br.com.agenda.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.api.handler.ContatoNotFoundException;
import br.com.agenda.api.handler.FornecedorNotFoundException;
import br.com.agenda.api.model.Fornecedor;
import br.com.agenda.api.service.FornecedorService;

/**
 * @author ismaelnc
 *
 */
@RestController
@RequestMapping("/api")
public class FornecedorController {
	
	@Autowired
	private FornecedorService service;
	
	@GetMapping("/fornecedores")
	public List<Fornecedor> list() {
		List<Fornecedor> fornecedor = this.service.listFornecedor();
		return fornecedor;
	}

	@PostMapping("/fornecedores")
	public void save(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response) {
		this.service.save(fornecedor);
	}

	@DeleteMapping("/fornecedores")
	public void remove(@RequestBody Fornecedor fornecedor) {
		this.service.removerFornecedor(fornecedor);
	}

	@DeleteMapping("/fornecedores/{id}")
    public void delete(@PathVariable Long id) {
		Fornecedor fornecedor = service.getById(id);
		if(fornecedor != null) {
			service.removerFornecedorById(id);
		}else {
			throw new FornecedorNotFoundException("Fornecedor não encontrado", null);
		}
	}
	
	@PutMapping("/fornecedores")
	public void update(@RequestBody Fornecedor fornecedor) {
		this.service.updateFornecedor(fornecedor);
	}
	
	@GetMapping("/fornecedores/{nome}")
	public Fornecedor buscaPorNome(@PathVariable String nome) {
		Fornecedor fornecedor = this.service.buscaPorNome(nome);
		return fornecedor;
	}
	
	@GetMapping("/buscarPorEmail/{email}")
	public Fornecedor buscaPorEmail(@PathVariable String email) {
		Fornecedor fornecedor = this.service.buscaPorEmail(email);
		return fornecedor;
	}
}
