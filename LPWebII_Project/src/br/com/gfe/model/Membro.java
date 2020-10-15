
package br.com.gfe.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Membro extends PessoaFisica {

	private static final long serialVersionUID = -647689020531529358L;
	
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	private TipoMembro tipoMembro;
	
	private EstadoCivil estadoCivil;

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public TipoMembro getTipoMembro() {
		return tipoMembro;
	}

	public void setTipoMembro(TipoMembro tipoMembro) {
		this.tipoMembro = tipoMembro;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getDataNascimentoFormatada() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getDataNascimento());
	}
	
	public String getDataEntradaMembro() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(false);
	    return sdf.format(this.getDataEntrada());
	}
	
}
