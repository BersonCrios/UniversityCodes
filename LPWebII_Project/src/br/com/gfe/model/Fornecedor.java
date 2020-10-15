package br.com.gfe.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fornecedor extends Pessoa {

	private static final long serialVersionUID = -4490728768978618450L;

	
	/*DECLARAÃ‡ÃƒO DAS VARIÃ�VEIS DO OBJETO FORNECEDOR QUE HERDA DE PESSOA*/
	@Temporal(TemporalType.DATE)
	private Date fornecedorDesde;
	
	private String cnpj;

	private String razaoSocial;
			

	/*METODOS ACESSORES*/ 
	public Date getFornecedorDesde() {
		return fornecedorDesde;
	}

	public void setFornecedorDesde(Date fornecedorDesde) {
		this.fornecedorDesde = fornecedorDesde;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getDataInicioFornecedorFormatada() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getFornecedorDesde());
	}
	
}
