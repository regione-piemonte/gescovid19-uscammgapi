package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import java.util.Date;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;

public class DiarioDetExtDto {
	private Integer diadetId;
	private Date diadetData;
	private String diadetNote;
	private Integer diaId;
	private Integer intId;
	private String utenteOperazione;
	private Integer idProfiloOperazione;
	private Date dataCreazione;
	private Date dataModifica;
	private Date dataCancellazione;

	UtenteContatto utenteContatto;
	
	public UtenteContatto getUtenteContatto() {
		return utenteContatto;
	}


	public void setUtenteContatto(UtenteContatto utenteContatto) {
		this.utenteContatto = utenteContatto;
	}


	public Integer getDiadetId() {
		return diadetId;
	}

	
	public void setDiadetId(Integer diadetId) {
		this.diadetId = diadetId;
	}


	public Date getDiadetData() {
		return diadetData;
	}


	public void setDiadetData(Date diadetData) {
		this.diadetData = diadetData;
	}

	
	public String getDiadetNote() {
		return diadetNote;
	}


	public void setDiadetNote(String diadetNote) {
		this.diadetNote = diadetNote;
	}

	
	public Integer getDiaId() {
		return diaId;
	}

	
	public void setDiaId(Integer diaId) {
		this.diaId = diaId;
	}


	public Integer getIntId() {
		return intId;
	}


	public void setIntId(Integer intId) {
		this.intId = intId;
	}


	public String getUtenteOperazione() {
		return utenteOperazione;
	}


	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}


	public Integer getIdProfiloOperazione() {
		return idProfiloOperazione;
	}


	public void setIdProfiloOperazione(Integer idProfiloOperazione) {
		this.idProfiloOperazione = idProfiloOperazione;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diadetId == null) ? 0 : diadetId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiarioDetExtDto other = (DiarioDetExtDto) obj;
		if (diadetId == null) {
			if (other.diadetId != null)
				return false;
		} else if (!diadetId.equals(other.diadetId))
			return false;
		return true;
	}
}
