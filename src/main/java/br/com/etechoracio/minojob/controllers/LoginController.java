package br.com.etechoracio.minojob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.minojob.dto.LoginDTO;
import br.com.etechoracio.minojob.dto.TokenResponseDTO;
import br.com.etechoracio.minojob.model.Usuario;
import br.com.etechoracio.minojob.security.JwtTokenManager;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtTokenManager jwtTokenManager;

	@PostMapping
	public ResponseEntity<TokenResponseDTO> authenticate(@RequestBody LoginDTO login) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				login.getUsername(), login.getPassword());
		Authentication authentication = authManager.authenticate(authenticationToken);
		Usuario user = (Usuario) authentication.getPrincipal();
		String jwt = jwtTokenManager.generateToken(user);
		return ResponseEntity.ok(TokenResponseDTO.builder().token(jwt).build());
	}

}