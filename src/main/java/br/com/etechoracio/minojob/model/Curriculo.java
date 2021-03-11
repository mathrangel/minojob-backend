package br.com.etechoracio.minojob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_CURRICULO")
public class Curriculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "celular")
	public String celular;
	
	@Column(name = "telefone")
	public String telefone;
	
	@Column(name = "tx_idiomas")
	public String tx_idiomas;
	
	@Column(name = "tx_conhecimento")
	public String tx_conhecimento;
	
	@Column(name = "tx_experiencia")
	public String tx_experiencia;
	
	@Column(name = "tx_objetivo")
	public String tx_objetivo;
	
	@Column(name = "tx_formacao")
	public String tx_formacao;

}
