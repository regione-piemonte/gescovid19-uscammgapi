package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import java.util.Date;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiario;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiarioDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Utenti;

public class DiarioExtDto  {
	
	private Integer diaId;
	private Long idSoggetto;
	private String utenteOperazione;
	private Integer idProfiloOperazione;
	private Date dataCreazione;
	private Date dataModifica;
	private Date dataCancellazione;

	DiarioDetExtDto diarioDet;
	SintomoExtDto sintomo;


	public DiarioDetExtDto getDiarioDet() {
		return diarioDet;
	}
	public void setDiarioDet(DiarioDetExtDto diarioDet) {
		this.diarioDet = diarioDet;
	}
	public SintomoExtDto getSintomo() {
		return sintomo;
	}
	public void setSintomo(SintomoExtDto sintomo) {
		this.sintomo = sintomo;
	}
	public Integer getDiaId() {
		return diaId;
	}
	public void setDiaId(Integer diaId) {
		this.diaId = diaId;
	}
	public Long getIdSoggetto() {
		return idSoggetto;
	}
	public void setIdSoggetto(Long idSoggetto) {
		this.idSoggetto = idSoggetto;
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
		result = prime * result + ((diaId == null) ? 0 : diaId.hashCode());
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
		DiarioExtDto other = (DiarioExtDto) obj;
		if (diaId == null) {
			if (other.diaId != null)
				return false;
		} else if (!diaId.equals(other.diaId))
			return false;
		return true;
	}
		
		
		

}
