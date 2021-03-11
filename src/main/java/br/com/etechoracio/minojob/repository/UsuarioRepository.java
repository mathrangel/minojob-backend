package br.com.etechoracio.minojob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.minojob.model.Curriculo;
import br.com.etechoracio.minojob.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Curriculo save(Curriculo body);

}
