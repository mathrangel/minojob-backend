package br.com.etechoracio.minojob.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		body.senha = new BCryptPasswordEncoder(12).encode(body.senha);
		return repository.save(body);
	}

	@GetMapping("/id/{id}")
	public Usuario findById(@PathVariable Integer id) {
		Optional<Usuario> resultado = repository.findById(id);
		return resultado.orElse(null);
	}

	@GetMapping("/{email}")
	public Optional<Usuario> findByEmail(@PathVariable String email) {

		return repository.findByEmail(email);
	}

	@PutMapping("/update/{id}")
	public Usuario update(@RequestBody Usuario body, @PathVariable Integer id) {
		Optional<Usuario> existe = repository.findById(id);
		if(!existe.isPresent()) {
			return null;
		}
		body.setId(id);
		return repository.save(body);
	}

	public void delete() {

	}
}
