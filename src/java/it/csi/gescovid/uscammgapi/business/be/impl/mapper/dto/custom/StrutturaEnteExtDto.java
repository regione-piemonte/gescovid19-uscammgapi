package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Struttura;

public class StrutturaEnteExtDto extends Struttura {
	
	private Ente ente;

	public Ente getEnte() {
		return ente;
	}

	public void setEnte(Ente ente) {
		this.ente = ente;
	}
	
	
	
	/*private String nomeEnte;
	private Integer totPostiTarget;
	public String getNomeEnte() {
		return nomeEnte;
	}
	public void setNomeEnte(String nomeEnte) {
		this.nomeEnte = nomeEnte;
	}
	public Integer getTotPostiTarget() {
		return totPostiTarget;
	}
	public void setTotPostiTarget(Integer totPostiTarget) {
		this.totPostiTarget = totPostiTarget;
	}
*/
	
	
	
}
