package br.com.etechoracio.minojob.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.etechoracio.minojob.enums.DeficienciaEnum;
import br.com.etechoracio.minojob.enums.EstadosEnum;
import br.com.etechoracio.minojob.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "TB_PCD")
public class Usuario implements UserDetails{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "NOME")
	public String nome;
	
	@Column(name = "NASCIMENTO")
	public String nascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TX_DEFICIENCIA")
	public DeficienciaEnum deficiencia;
	
	@Column(name = "EMAIL")
	public String email;
	
	@Column(name = "SENHA")
	public String senha;
	
	@Column(name = "TX_DESCRICAO")
	public String descricao;
	
	@Column(name = "experiencia")
	public String experiencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "UF")
	public EstadosEnum uf;
	
	@Column(name = "CIDADE")
	public String cidade;
	
	@Column(name = "ENDERECO")
	public String endereco;
	
	@Column(name = "CNPJ")
	public String cnpj;
	
	@Column(name = "telefone")
	public String telefone;
	
	@Column(name = "celular")
	public String celular;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil")
	public PerfilEnum perfil;
	
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(Perfil.builder().authority(perfil.name()).build());
	}
}
