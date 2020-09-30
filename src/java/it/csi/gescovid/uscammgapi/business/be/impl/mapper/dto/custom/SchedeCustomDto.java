package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import java.util.Date;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDMonitoraggioTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;

public class SchedeCustomDto {

	private Integer idScheda;
	private Date dataScheda;
	private String descrizioneScheda;
	private Boolean critica;
	private String statoSchedaCod;
	private String statoSchedaDesc;
	private String schTerapiaCronica;

	// Soggetto
	private Long idSoggetto;
	private String codiceFiscale;
	private String nomeSoggetto;
	private String cognomeSoggetto;
	private Date dataNascitaSoggetto;
	private String emailSoggetto;
	private String telefonoSoggetto;
	private String aslResidenza;
	private String aslDomicilio;
	private String comuneResidenzaIstat;
	private String comuneDomicilioIstat;
	private String comuneDescrizione;
	private String indirizzoDomicilio;

	// Medico
	private String cfMedico;
	private String nomeMedico;
	private String cognomeMedico;
	private String telefonoMedico;
	private String emailMedico;

	// Struttura
	private String idStruttura;
	private String nomeStruttura;
	private String naturaStruttura;
	private Integer idEnte;
	private String nomeEnte;

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
	
	// Flag inserito da Mmg e visibilita 118 e medico ca
	private Boolean richiestaMmg;
	private Boolean visibileMed118;
	private Boolean visibileMedCa;
	
	// Tipo monitoraggio
	private CovidusDMonitoraggioTipo monitoraggioTipo;
	
	private Long totalCount;
	
	private Medico medico;
	
	
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	

	public CovidusDMonitoraggioTipo getMonitoraggioTipo() {
		return monitoraggioTipo;
	}

	public void setMonitoraggioTipo(CovidusDMonitoraggioTipo monitoraggioTipo) {
		this.monitoraggioTipo = monitoraggioTipo;
	}

	public String getSchTerapiaCronica() {
		return schTerapiaCronica;
	}

	public void setSchTerapiaCronica(String schTerapiaCronica) {
		this.schTerapiaCronica = schTerapiaCronica;
	}

	public Boolean getRichiestaMmg() {
		return richiestaMmg;
	}

	public void setRichiestaMmg(Boolean richiestaMmg) {
		this.richiestaMmg = richiestaMmg;
	}

	public Boolean getVisibileMed118() {
		return visibileMed118;
	}

	public void setVisibileMed118(Boolean visibileMed118) {
		this.visibileMed118 = visibileMed118;
	}

	public Boolean getVisibileMedCa() {
		return visibileMedCa;
	}

	public void setVisibileMedCa(Boolean visibileMedCa) {
		this.visibileMedCa = visibileMedCa;
	}

	public Integer getIdScheda() {
		return idScheda;
	}

	public void setIdScheda(Integer idScheda) {
		this.idScheda = idScheda;
	}

	public Date getDataScheda() {
		return dataScheda;
	}

	public void setDataScheda(Date dataScheda) {
		this.dataScheda = dataScheda;
	}

	public String getDescrizioneScheda() {
		return descrizioneScheda;
	}

	public void setDescrizioneScheda(String descrizioneScheda) {
		this.descrizioneScheda = descrizioneScheda;
	}

	public Boolean getCritica() {
		return critica;
	}

	public void setCritica(Boolean critica) {
		this.critica = critica;
	}

	public String getStatoSchedaCod() {
		return statoSchedaCod;
	}

	public void setStatoSchedaCod(String statoSchedaCod) {
		this.statoSchedaCod = statoSchedaCod;
	}

	public String getStatoSchedaDesc() {
		return statoSchedaDesc;
	}

	public void setStatoSchedaDesc(String statoSchedaDesc) {
		this.statoSchedaDesc = statoSchedaDesc;
	}

	public Long getIdSoggetto() {
		return idSoggetto;
	}

	public void setIdSoggetto(Long idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNomeSoggetto() {
		return nomeSoggetto;
	}

	public void setNomeSoggetto(String nomeSoggetto) {
		this.nomeSoggetto = nomeSoggetto;
	}

	public String getCognomeSoggetto() {
		return cognomeSoggetto;
	}

	public void setCognomeSoggetto(String cognomeSoggetto) {
		this.cognomeSoggetto = cognomeSoggetto;
	}

	public Date getDataNascitaSoggetto() {
		return dataNascitaSoggetto;
	}

	public void setDataNascitaSoggetto(Date dataNascitaSoggetto) {
		this.dataNascitaSoggetto = dataNascitaSoggetto;
	}

	public String getEmailSoggetto() {
		return emailSoggetto;
	}

	public void setEmailSoggetto(String emailSoggetto) {
		this.emailSoggetto = emailSoggetto;
	}

	public String getTelefonoSoggetto() {
		return telefonoSoggetto;
	}

	public void setTelefonoSoggetto(String telefonoSoggetto) {
		this.telefonoSoggetto = telefonoSoggetto;
	}

	public String getAslResidenza() {
		return aslResidenza;
	}

	public void setAslResidenza(String aslResidenza) {
		this.aslResidenza = aslResidenza;
	}

	public String getAslDomicilio() {
		return aslDomicilio;
	}

	public void setAslDomicilio(String aslDomicilio) {
		this.aslDomicilio = aslDomicilio;
	}

	public String getComuneResidenzaIstat() {
		return comuneResidenzaIstat;
	}

	public void setComuneResidenzaIstat(String comuneResidenzaIstat) {
		this.comuneResidenzaIstat = comuneResidenzaIstat;
	}

	public String getComuneDomicilioIstat() {
		return comuneDomicilioIstat;
	}

	public void setComuneDomicilioIstat(String comuneDomicilioIstat) {
		this.comuneDomicilioIstat = comuneDomicilioIstat;
	}

	public String getIndirizzoDomicilio() {
		return indirizzoDomicilio;
	}

	public void setIndirizzoDomicilio(String indirizzoDomicilio) {
		this.indirizzoDomicilio = indirizzoDomicilio;
	}

	public String getCfMedico() {
		return cfMedico;
	}

	public void setCfMedico(String cfMedico) {
		this.cfMedico = cfMedico;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getCognomeMedico() {
		return cognomeMedico;
	}

	public void setCognomeMedico(String cognomeMedico) {
		this.cognomeMedico = cognomeMedico;
	}

	public String getTelefonoMedico() {
		return telefonoMedico;
	}

	public void setTelefonoMedico(String telefonoMedico) {
		this.telefonoMedico = telefonoMedico;
	}

	public String getEmailMedico() {
		return emailMedico;
	}

	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}

	public String getIdStruttura() {
		return idStruttura;
	}

	public void setIdStruttura(String idStruttura) {
		this.idStruttura = idStruttura;
	}

	public String getNomeStruttura() {
		return nomeStruttura;
	}

	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}

	public String getNaturaStruttura() {
		return naturaStruttura;
	}

	public void setNaturaStruttura(String naturaStruttura) {
		this.naturaStruttura = naturaStruttura;
	}

	public Integer getIdEnte() {
		return idEnte;
	}

	public void setIdEnte(Integer idEnte) {
		this.idEnte = idEnte;
	}

	public String getNomeEnte() {
		return nomeEnte;
	}

	public void setNomeEnte(String nomeEnte) {
		this.nomeEnte = nomeEnte;
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

	public String getComuneDescrizione() {
		return comuneDescrizione;
	}

	public void setComuneDescrizione(String comuneDescrizione) {
		this.comuneDescrizione = comuneDescrizione;
	}
	
	

}
