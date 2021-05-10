package br.com.etechoracio.minojob.security;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.etechoracio.minojob.enums.PerfilEnum;
import br.com.etechoracio.minojob.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenManager {

	private String secret;
	private long expirationInMillis;
	

	public JwtTokenManager(@Value("${jwt.secret}") String secret, 
						   @Value("${jwt.expiration}") Duration expirationInMillis) {
		this.secret = secret;
		this.expirationInMillis = expirationInMillis.toMillis();
	}

	
	public String generateToken(Usuario user) {
		final Date now = new Date();
		final Date expiration = new Date(now.getTime() + this.expirationInMillis);
		return Jwts.builder().setIssuer("Caelum Eats")
							 .setSubject(Long.toString(user.getId()))
							 .claim("username", user.getEmail())
							 .claim("roles", Arrays.asList(user.getPerfil().name()))
							 .setIssuedAt(now)
							 .setExpiration(expiration)
							 .signWith(SignatureAlgorithm.HS512, this.secret).compact();
	}
	
	public boolean isValid(String jwt) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public Usuario getUserFromToken(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt).getBody();
		
		List<String> roles = claims.get("roles", List.class);
		Usuario user = Usuario.builder().email(claims.get("email", String.class))
								  .id(Integer.parseInt(claims.getSubject()))
								  .perfil(PerfilEnum.valueOf(roles.get(0)))
					    .build();
		return user;
	}
	
}
