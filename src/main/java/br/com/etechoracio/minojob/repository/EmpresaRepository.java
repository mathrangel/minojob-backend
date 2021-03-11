package br.com.etechoracio.minojob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.minojob.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
