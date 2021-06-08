package br.com.etechoracio.minojob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.minojob.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {

	List<Vaga> findByNome(String nome);
	
}
