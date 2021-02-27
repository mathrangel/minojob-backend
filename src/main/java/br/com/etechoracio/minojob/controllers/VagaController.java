package br.com.etechoracio.minojob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etechoracio.minojob.model.Vaga;
import br.com.etechoracio.minojob.repository.VagaRepository;

@RequestMapping("vaga")
public class VagaController {

	@Autowired
	private VagaRepository repository;
	
	@PostMapping("/create")
	public Vaga Create(@RequestBody Vaga body) {
		return repository.save(body);
	}
	
}
