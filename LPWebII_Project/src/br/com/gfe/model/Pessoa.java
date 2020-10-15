package br.com.gfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa extends Model<Pessoa> {
	
	private static final long serialVersionUID = 6716965768454292604L;
	
	/*	DECLARAÃ‡ÃƒO DAS VARIÃ�VEIS DO OBJETO PESSOA*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidPessoa")
	@SequenceGenerator(name = "seqidPessoa", sequenceName = "seqidPessoa", allocationSize = 1)
	private Integer id;
	
	private String nome;
	
	private String endereco;
	
	private String telefone;
	
	private String email;
	
	
	/*METODOS ACESSORES*/
	
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


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}
