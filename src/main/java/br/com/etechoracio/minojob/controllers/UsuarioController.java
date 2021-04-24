package br.com.etechoracio.minojob.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.minojob.model.Usuario;
import br.com.etechoracio.minojob.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public Usuario create(@RequestBody Usuario body) {
		return repository.save(body);
	}
	
	@GetMapping("/{email}")
	public Optional<Usuario> findByEmail(@PathVariable String email) {
		
		return repository.findByEmail(email);
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
}
