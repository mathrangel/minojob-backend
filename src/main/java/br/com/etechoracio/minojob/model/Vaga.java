package br.com.etechoracio.minojob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_VAGA")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VAGA")
	public Integer id_vaga;
	
	@Column(name = "TX_NOME")
	public String tx_nome;
	
	@Column(name = "TX_AREA_INTERESSE")
	public String tx_area_interesse;
	
	@Column(name = "TX_DETALHES")
	public String tx_detalhes;
	
	@Column(name = "TX_FAIXA_SALARIAL")
	public String tx_faixa_salarial;
	
	@Column(name = "TX_LOCAL_TRABALHO")
	public String tx_local_trabalho;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPRESA")
	public Empresa empresa_id;
	
}