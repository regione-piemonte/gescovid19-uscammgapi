package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import java.util.Date;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;

public class InterventoCustomDto {

	private Integer idScheda;

	// Intervento
	private Integer intId;
	private Date intData;
	private String intDesc;
	private String intAzioneIntrapresa;

	// Azione
	private Integer azId;
	private String azCod;
	private String azDesc;

	// Tipo intervento
	private Integer intTipoId;
	private String intTipoCod;
	private String intTipoDesc;
	
	private UtenteContatto medicoResponsabile;
	

	

	public UtenteContatto getMedicoResponsabile() {
		return medicoResponsabile;
	}

	public void setMedicoResponsabile(UtenteContatto medicoResponsabile) {
		this.medicoResponsabile = medicoResponsabile;
	}

	public Integer getIdScheda() {
		return idScheda;
	}

	public void setIdScheda(Integer idScheda) {
		this.idScheda = idScheda;
	}

	public Integer getIntId() {
		return intId;
	}

	public void setIntId(Integer intId) {
		this.intId = intId;
	}

	public Date getIntData() {
		return intData;
	}

	public void setIntData(Date intData) {
		this.intData = intData;
	}

	public String getIntDesc() {
		return intDesc;
	}

	public void setIntDesc(String intDesc) {
		this.intDesc = intDesc;
	}

	public String getIntAzioneIntrapresa() {
		return intAzioneIntrapresa;
	}

	public void setIntAzioneIntrapresa(String intAzioneIntrapresa) {
		this.intAzioneIntrapresa = intAzioneIntrapresa;
	}

	public Integer getAzId() {
		return azId;
	}

	public void setAzId(Integer azId) {
		this.azId = azId;
	}

	public String getAzCod() {
		return azCod;
	}

	public void setAzCod(String azCod) {
		this.azCod = azCod;
	}

	public String getAzDesc() {
		return azDesc;
	}

	public void setAzDesc(String azDesc) {
		this.azDesc = azDesc;
	}

	public Integer getIntTipoId() {
		return intTipoId;
	}

	public void setIntTipoId(Integer intTipoId) {
		this.intTipoId = intTipoId;
	}

	public String getIntTipoCod() {
		return intTipoCod;
	}

	public void setIntTipoCod(String intTipoCod) {
		this.intTipoCod = intTipoCod;
	}

	public String getIntTipoDesc() {
		return intTipoDesc;
	}

	public void setIntTipoDesc(String intTipoDesc) {
		this.intTipoDesc = intTipoDesc;
	}

}
