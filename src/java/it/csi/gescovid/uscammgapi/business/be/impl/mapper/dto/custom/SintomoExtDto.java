package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import java.util.Date;

public class SintomoExtDto {
	
	private Integer diarioDetId;
	private Integer sinId;
	private String sinCod;
	private String sinDesc;
	private String utenteOperazione;
	private Date validitaInizio;
	private Date validitaFine;
	private Date dataCreazione;
	private Date dataModifica;
	private Date dataCancellazione;

	public Integer getSinId() {
		return sinId;
	}

	
	public Integer getDiarioDetId() {
		return diarioDetId;
	}


	public void setDiarioDetId(Integer diarioDetId) {
		this.diarioDetId = diarioDetId;
	}


	public void setSinId(Integer sinId) {
		this.sinId = sinId;
	}

	public String getSinCod() {
		return sinCod;
	}

	public void setSinCod(String sinCod) {
		this.sinCod = sinCod;
	}

	public String getSinDesc() {
		return sinDesc;
	}

	public void setSinDesc(String sinDesc) {
		this.sinDesc = sinDesc;
	}

	public String getUtenteOperazione() {
		return utenteOperazione;
	}

	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}

	public Date getValiditaInizio() {
		return validitaInizio;
	}

	public void setValiditaInizio(Date validitaInizio) {
		this.validitaInizio = validitaInizio;
	}

	public Date getValiditaFine() {
		return validitaFine;
	}

	public void setValiditaFine(Date validitaFine) {
		this.validitaFine = validitaFine;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}


	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}
}
