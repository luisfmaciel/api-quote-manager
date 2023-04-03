package edu.infnet.al.model.domain;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String razaoSocial;
	private String cnpj;
	private String email;
	private String telefone;
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "fornecedorId")
	@JsonIgnore
	private Cotacao cotacao;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "EnderecoId")
	private Endereco endereco;
}
