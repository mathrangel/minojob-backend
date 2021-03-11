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
@Table(name = "TB_EMPRESA")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "TX_NOME")
	private String tx_nome;
	
	@Column(name = "TX_EMAIL")
	private String tx_email;
	
	@Column(name = "TX_SENHA")
	private String tx_senha;
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "TX_DESCRICAO")
	private String tx_descricao;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "TX_ENDERECO")
	private String tx_endereco;
	
	@Column(name = "email_contato")
	private String email_contato;
	
}
