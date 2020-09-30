package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

import java.util.Date;

public class CovidusTScheda {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.sch_id
	 * @mbg.generated
	 */
	private Integer schId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.sch_data
	 * @mbg.generated
	 */
	private Date schData;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.sch_descrizione
	 * @mbg.generated
	 */
	private String schDescrizione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.sch_critica
	 * @mbg.generated
	 */
	private Boolean schCritica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.id_soggetto
	 * @mbg.generated
	 */
	private Long idSoggetto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.id_struttura
	 * @mbg.generated
	 */
	private String idStruttura;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.utente_operazione
	 * @mbg.generated
	 */
	private String utenteOperazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.data_creazione
	 * @mbg.generated
	 */
	private Date dataCreazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.data_modifica
	 * @mbg.generated
	 */
	private Date dataModifica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.data_cancellazione
	 * @mbg.generated
	 */
	private Date dataCancellazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.richiesta_mmg
	 * @mbg.generated
	 */
	private Boolean richiestaMmg;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.visibile_medico_emergenza
	 * @mbg.generated
	 */
	private Boolean visibileMedicoEmergenza;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.visibile_medico_continuita_ass
	 * @mbg.generated
	 */
	private Boolean visibileMedicoContinuitaAss;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.sch_terapia_cronica
	 * @mbg.generated
	 */
	private String schTerapiaCronica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_scheda.monitoraggio_tipo_id
	 * @mbg.generated
	 */
	private Integer monitoraggioTipoId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.sch_id
	 * @return  the value of covidus_t_scheda.sch_id
	 * @mbg.generated
	 */
	public Integer getSchId() {
		return schId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.sch_id
	 * @param schId  the value for covidus_t_scheda.sch_id
	 * @mbg.generated
	 */
	public void setSchId(Integer schId) {
		this.schId = schId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.sch_data
	 * @return  the value of covidus_t_scheda.sch_data
	 * @mbg.generated
	 */
	public Date getSchData() {
		return schData;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.sch_data
	 * @param schData  the value for covidus_t_scheda.sch_data
	 * @mbg.generated
	 */
	public void setSchData(Date schData) {
		this.schData = schData;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.sch_descrizione
	 * @return  the value of covidus_t_scheda.sch_descrizione
	 * @mbg.generated
	 */
	public String getSchDescrizione() {
		return schDescrizione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.sch_descrizione
	 * @param schDescrizione  the value for covidus_t_scheda.sch_descrizione
	 * @mbg.generated
	 */
	public void setSchDescrizione(String schDescrizione) {
		this.schDescrizione = schDescrizione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.sch_critica
	 * @return  the value of covidus_t_scheda.sch_critica
	 * @mbg.generated
	 */
	public Boolean getSchCritica() {
		return schCritica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.sch_critica
	 * @param schCritica  the value for covidus_t_scheda.sch_critica
	 * @mbg.generated
	 */
	public void setSchCritica(Boolean schCritica) {
		this.schCritica = schCritica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.id_soggetto
	 * @return  the value of covidus_t_scheda.id_soggetto
	 * @mbg.generated
	 */
	public Long getIdSoggetto() {
		return idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.id_soggetto
	 * @param idSoggetto  the value for covidus_t_scheda.id_soggetto
	 * @mbg.generated
	 */
	public void setIdSoggetto(Long idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.id_struttura
	 * @return  the value of covidus_t_scheda.id_struttura
	 * @mbg.generated
	 */
	public String getIdStruttura() {
		return idStruttura;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.id_struttura
	 * @param idStruttura  the value for covidus_t_scheda.id_struttura
	 * @mbg.generated
	 */
	public void setIdStruttura(String idStruttura) {
		this.idStruttura = idStruttura;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.utente_operazione
	 * @return  the value of covidus_t_scheda.utente_operazione
	 * @mbg.generated
	 */
	public String getUtenteOperazione() {
		return utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.utente_operazione
	 * @param utenteOperazione  the value for covidus_t_scheda.utente_operazione
	 * @mbg.generated
	 */
	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.data_creazione
	 * @return  the value of covidus_t_scheda.data_creazione
	 * @mbg.generated
	 */
	public Date getDataCreazione() {
		return dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.data_creazione
	 * @param dataCreazione  the value for covidus_t_scheda.data_creazione
	 * @mbg.generated
	 */
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.data_modifica
	 * @return  the value of covidus_t_scheda.data_modifica
	 * @mbg.generated
	 */
	public Date getDataModifica() {
		return dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.data_modifica
	 * @param dataModifica  the value for covidus_t_scheda.data_modifica
	 * @mbg.generated
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.data_cancellazione
	 * @return  the value of covidus_t_scheda.data_cancellazione
	 * @mbg.generated
	 */
	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.data_cancellazione
	 * @param dataCancellazione  the value for covidus_t_scheda.data_cancellazione
	 * @mbg.generated
	 */
	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.richiesta_mmg
	 * @return  the value of covidus_t_scheda.richiesta_mmg
	 * @mbg.generated
	 */
	public Boolean getRichiestaMmg() {
		return richiestaMmg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.richiesta_mmg
	 * @param richiestaMmg  the value for covidus_t_scheda.richiesta_mmg
	 * @mbg.generated
	 */
	public void setRichiestaMmg(Boolean richiestaMmg) {
		this.richiestaMmg = richiestaMmg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.visibile_medico_emergenza
	 * @return  the value of covidus_t_scheda.visibile_medico_emergenza
	 * @mbg.generated
	 */
	public Boolean getVisibileMedicoEmergenza() {
		return visibileMedicoEmergenza;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.visibile_medico_emergenza
	 * @param visibileMedicoEmergenza  the value for covidus_t_scheda.visibile_medico_emergenza
	 * @mbg.generated
	 */
	public void setVisibileMedicoEmergenza(Boolean visibileMedicoEmergenza) {
		this.visibileMedicoEmergenza = visibileMedicoEmergenza;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.visibile_medico_continuita_ass
	 * @return  the value of covidus_t_scheda.visibile_medico_continuita_ass
	 * @mbg.generated
	 */
	public Boolean getVisibileMedicoContinuitaAss() {
		return visibileMedicoContinuitaAss;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.visibile_medico_continuita_ass
	 * @param visibileMedicoContinuitaAss  the value for covidus_t_scheda.visibile_medico_continuita_ass
	 * @mbg.generated
	 */
	public void setVisibileMedicoContinuitaAss(Boolean visibileMedicoContinuitaAss) {
		this.visibileMedicoContinuitaAss = visibileMedicoContinuitaAss;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.sch_terapia_cronica
	 * @return  the value of covidus_t_scheda.sch_terapia_cronica
	 * @mbg.generated
	 */
	public String getSchTerapiaCronica() {
		return schTerapiaCronica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.sch_terapia_cronica
	 * @param schTerapiaCronica  the value for covidus_t_scheda.sch_terapia_cronica
	 * @mbg.generated
	 */
	public void setSchTerapiaCronica(String schTerapiaCronica) {
		this.schTerapiaCronica = schTerapiaCronica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_scheda.monitoraggio_tipo_id
	 * @return  the value of covidus_t_scheda.monitoraggio_tipo_id
	 * @mbg.generated
	 */
	public Integer getMonitoraggioTipoId() {
		return monitoraggioTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_scheda.monitoraggio_tipo_id
	 * @param monitoraggioTipoId  the value for covidus_t_scheda.monitoraggio_tipo_id
	 * @mbg.generated
	 */
	public void setMonitoraggioTipoId(Integer monitoraggioTipoId) {
		this.monitoraggioTipoId = monitoraggioTipoId;
	}
}