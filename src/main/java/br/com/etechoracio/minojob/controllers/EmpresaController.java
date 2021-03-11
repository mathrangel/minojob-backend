package br.com.etechoracio.minojob.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.etechoracio.minojob.model.Empresa;
import br.com.etechoracio.minojob.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository repository;
	
	
	//working
	@GetMapping
	public List<Empresa> find() {
		return repository.findAll();
	}
	
	//working
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Integer id) {
		Optional<Empresa> existe = repository.findById(id);
				
		if (!existe.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(existe.get());
	}
	
	//working
	@PostMapping
	public Empresa create(@RequestBody Empresa body) {
		return repository.save(body);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> update(@RequestBody Empresa body, @PathVariable Integer id) {
		Optional<Empresa> existe = repository.findById(id);
		if (!existe.isPresent()) {
			return ResponseEntity.noContent().build();
		}		
		
		return ResponseEntity.ok(repository.save(body));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Optional<Empresa> existe = repository.findById(id);
		if (!existe.isPresent()) {
		return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().build();
	}
	
}
