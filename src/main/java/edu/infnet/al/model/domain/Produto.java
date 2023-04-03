package edu.infnet.al.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private String departamento; 
	private Integer quantidade;
	private String image;
	@OneToMany(cascade=CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name="produtoId")
	private List<Cotacao> cotacoes;
}
