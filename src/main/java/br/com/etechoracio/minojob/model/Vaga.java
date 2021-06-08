package br.com.etechoracio.minojob.model;

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

import br.com.etechoracio.minojob.enums.EstadosEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_VAGA")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "TX_NOME")
	public String nome;
	
	@Column(name = "TX_AREA_INTERESSE")
	public String tx_area_interesse;
	
	@Column(name = "TX_DETALHES")
	public String tx_detalhes;
	
	@Column(name = "TX_FAIXA_SALARIAL")
	public String tx_faixa_salarial;
	
	@Column(name = "CIDADE")
	public String cidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "UF")
	public EstadosEnum uf;
	
	@Column(name = "pais")
	public String pais;
	
	@Column(name = "bairro")
	public String bairro;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPRESA_ID")
	public Usuario empresa;


	
}