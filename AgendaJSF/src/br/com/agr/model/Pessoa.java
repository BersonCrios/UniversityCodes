package br.com.agr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Pessoa extends Model<Pessoa> {

	private static final long serialVersionUID = -4204794522130889274L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidpessoa")
	@SequenceGenerator(name = "seqidpessoa", sequenceName = "seqidpessoa", allocationSize = 1)
	private Integer id;
	
	private String nome;
	private String telefone;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
