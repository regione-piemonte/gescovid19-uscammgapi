package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.MedicoAura;

public class SoggettoAuraExt {
	
	private String codiceFiscale;
	private String cognome;
	private String nome;
	private String dataNascitaStr;
	private String comuneNascita;
	private String provinciaNascita;
	private String sesso;
	private String dataDecessoStr;
	private String statoNascita;
	private Integer idAura;
	
	private Medico medico;

	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Integer getIdAura() {
		return idAura;
	}
	public void setIdAura(Integer idAura) {
		this.idAura = idAura;
	}
	public String getStatoNascita() {
		return statoNascita;
	}
	public void setStatoNascita(String statoNascita) {
		this.statoNascita = statoNascita;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascitaStr() {
		return dataNascitaStr;
	}
	public void setDataNascitaStr(String dataNascitaStr) {
		this.dataNascitaStr = dataNascitaStr;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}
	public String getProvinciaNascita() {
		return provinciaNascita;
	}
	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getDataDecessoStr() {
		return dataDecessoStr;
	}
	public void setDataDecessoStr(String dataDecessoStr) {
		this.dataDecessoStr = dataDecessoStr;
	}
	

}
