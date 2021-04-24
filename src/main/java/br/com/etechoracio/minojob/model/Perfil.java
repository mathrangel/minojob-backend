package br.com.etechoracio.minojob.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Perfil implements GrantedAuthority {

	private String authority;
	
}
