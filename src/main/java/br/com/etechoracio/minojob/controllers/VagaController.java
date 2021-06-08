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

import br.com.etechoracio.minojob.model.Usuario;
import br.com.etechoracio.minojob.model.Vaga;
import br.com.etechoracio.minojob.repository.UsuarioRepository;
import br.com.etechoracio.minojob.repository.VagaRepository;

@RestController
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaRepository repository;
	
	@Autowired
	private UsuarioRepository empresaRepository;
	
	
	//working
	@GetMapping
	public List<Vaga> find() {
		List<Vaga> resultado = repository.findAll();
		resultado.forEach(e-> {
			if (e.getEmpresa() != null) { 
				e.getEmpresa().getId();
			}
		});
		
		return resultado;
		
	}
	
	@GetMapping("/{nome}")
	public List<Vaga> findByName(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
	
	@PostMapping("/admin/create")
	public ResponseEntity<Vaga> create(@RequestBody Vaga body) {
		Optional<Usuario> empresa = empresaRepository.findById(body.getEmpresa().getId());
		
		if (!empresa.isPresent()) {
			return ResponseEntity.noContent().build();
		} 
		body.setEmpresa(empresa.get());
		
		return ResponseEntity.ok(repository.save(body)) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vaga> update(@RequestBody Vaga body, @PathVariable Integer id) {
		Optional<Vaga> existe = repository.findById(id);
		if (!existe.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(repository.save(body));
		
	}
	
	//not working
	@DeleteMapping("/{id}")
	public void delete() {}
	
}
