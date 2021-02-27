package br.com.etechoracio.minojob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_EMPRESA")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EMPRESA")
	private Integer id_empresa;
	
	@Column(name = "TX_NOME")
	private String tx_nome;
	
	@Column(name = "TX_EMAIL")
	private String tx_email;
	
	@Column(name = "TX_SENHA")
	private String tx_senha;
	
	@Column(name = "TX_CNPJ")
	private String tx_cnpj;
	
	@Column(name = "TX_DESCRICAO")
	private String tx_descricao;
	
	@Column(name = "TX_TEL")
	private String tx_telefone;
	
	@Column(name = "TX_ENDERECO")
	private String tx_endereco;
	
	@Column(name = "TX_EMAIL_CONTATO")
	private String tx_email_contato;
	
	@Column(name = "TX_SITE")
	private String tx_site;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "vaga_id")
	private Vaga vaga_id;
	
}
