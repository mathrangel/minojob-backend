package br.com.etechoracio.minojob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.minojob.model.Curriculo;
import br.com.etechoracio.minojob.repository.CurriculoRepository;

@RestController
@RequestMapping("/curriculo")
public class CurriculoController {

	@Autowired
	private CurriculoRepository repository;
	
	@PostMapping
	public Curriculo create(@RequestBody Curriculo body) {
		return repository.save(body);
	}
	
	public void list() {
		
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
}
