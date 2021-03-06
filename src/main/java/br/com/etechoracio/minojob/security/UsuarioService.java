package br.com.etechoracio.minojob.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.etechoracio.minojob.model.Usuario;
import br.com.etechoracio.minojob.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> resultado = repository.findByEmail(username);
		return resultado.orElseThrow(()-> new UsernameNotFoundException("Usuário Não encontrado:" + username )); 
	}

}
