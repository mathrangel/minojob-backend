package br.com.etechoracio.minojob.model;

import java.sql.Timestamp;

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

import br.com.etechoracio.minojob.enums.deficienciaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_PCD")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "TX_NOME")
	public String tx_nome;
	
	@Column(name = "DT_NASCIMENTO")
	public Timestamp dt_nascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TX_DEFICIENCIA")
	public deficienciaEnum tx_deficiencia;
	
	@Column(name = "TX_EMAIL")
	public String tx_email;
	
	@Column(name = "TX_SENHA")
	public String tx_senha;
	
	@Column(name = "TX_AREA_INTERESSE")
	public String tx_area_interesse;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curriculo_id")
	public Curriculo curriculo;
	
}
