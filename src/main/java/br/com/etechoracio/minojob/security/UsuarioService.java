package br.com.etechoracio.minojob.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.etechoracio.minojob.model.Usuario;
import br.com.etechoracio.minojob.repository.UsuarioRepository;


public class UsuarioService implements UserDetailsService{

	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> resultado = repository.findByEmail(username);
		return resultado.orElseThrow(()-> new UsernameNotFoundException("Usuário Não encontrado:" + username )); 
	}

}
