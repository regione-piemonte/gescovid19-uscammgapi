package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Asr;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Comuni;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.TipoSoggetto;

public class SoggettoExtDto extends Soggetto{

	private Asr asr;
	private Comuni comuneDomicilio;
	private Comuni comuneResidenza;
	private int numeroCampioni;
	private int numeroDecorsi;
	private int ultimoIdTipoEvento;
	private TipoSoggetto tipoSoggetto;
	private Integer enteId;
	
	
	
	public Integer getEnteId() {
		return enteId;
	}
	public void setEnteId(Integer enteId) {
		this.enteId = enteId;
	}
	public int getNumeroDecorsi() {
		return numeroDecorsi;
	}
	public void setNumeroDecorsi(int numeroDecorsi) {
		this.numeroDecorsi = numeroDecorsi;
	}
	public Asr getAsr() {
		return asr;
	}
	public void setAsr(Asr asr) {
		this.asr = asr;
	}
	public Comuni getComuneDomicilio() {
		return comuneDomicilio;
	}
	public void setComuneDomicilio(Comuni comuneDomicilio) {
		this.comuneDomicilio = comuneDomicilio;
	}
	public Comuni getComuneResidenza() {
		return comuneResidenza;
	}
	public void setComuneResidenza(Comuni comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}
	public int getNumeroCampioni() {
		return numeroCampioni;
	}
	public void setNumeroCampioni(int numeroCampioni) {
		this.numeroCampioni = numeroCampioni;
	}
	public int getUltimoIdTipoEvento() {
		return ultimoIdTipoEvento;
	}
	public void setUltimoIdTipoEvento(int ultimoIdTipoEvento) {
		this.ultimoIdTipoEvento = ultimoIdTipoEvento;
	}
	public TipoSoggetto getTipoSoggetto() {
		return tipoSoggetto;
	}
	public void setTipoSoggetto(TipoSoggetto tipoSoggetto) {
		this.tipoSoggetto = tipoSoggetto;
	}
	
	
	
}
