package br.com.gfe.model;

import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Usuario extends PessoaFisica {
	
	private static final long serialVersionUID = 2908470700584699594L;
	
	private String senha;
	
	@Enumerated(value = EnumType.STRING)
	private Permissao permissao;
	
	private EstadoCivil estadoCivil;
	
	private Ativo ativo;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}
	
	public String getDataNascimentoFormatada() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getDataNascimento());
	}
	
}
