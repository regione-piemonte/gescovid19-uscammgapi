package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

import java.util.Date;

public class CovidusRInterventoPresc {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.intpresc_id
	 * @mbg.generated
	 */
	private Integer intprescId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.int_id
	 * @mbg.generated
	 */
	private Integer intId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.presc_tipo_id
	 * @mbg.generated
	 */
	private Integer prescTipoId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.prescrizione
	 * @mbg.generated
	 */
	private String prescrizione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.utente_operazione
	 * @mbg.generated
	 */
	private String utenteOperazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.data_creazione
	 * @mbg.generated
	 */
	private Date dataCreazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.data_modifica
	 * @mbg.generated
	 */
	private Date dataModifica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.data_cancellazione
	 * @mbg.generated
	 */
	private Date dataCancellazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.farm_id
	 * @mbg.generated
	 */
	private Integer farmId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.oss_id
	 * @mbg.generated
	 */
	private Integer ossId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.valore
	 * @mbg.generated
	 */
	private String valore;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.farm_consegnato
	 * @mbg.generated
	 */
	private Boolean farmConsegnato;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.farm_consegna_data
	 * @mbg.generated
	 */
	private Date farmConsegnaData;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_r_intervento_presc.farm_consegna_utente
	 * @mbg.generated
	 */
	private String farmConsegnaUtente;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.intpresc_id
	 * @return  the value of covidus_r_intervento_presc.intpresc_id
	 * @mbg.generated
	 */
	public Integer getIntprescId() {
		return intprescId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.intpresc_id
	 * @param intprescId  the value for covidus_r_intervento_presc.intpresc_id
	 * @mbg.generated
	 */
	public void setIntprescId(Integer intprescId) {
		this.intprescId = intprescId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.int_id
	 * @return  the value of covidus_r_intervento_presc.int_id
	 * @mbg.generated
	 */
	public Integer getIntId() {
		return intId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.int_id
	 * @param intId  the value for covidus_r_intervento_presc.int_id
	 * @mbg.generated
	 */
	public void setIntId(Integer intId) {
		this.intId = intId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.presc_tipo_id
	 * @return  the value of covidus_r_intervento_presc.presc_tipo_id
	 * @mbg.generated
	 */
	public Integer getPrescTipoId() {
		return prescTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.presc_tipo_id
	 * @param prescTipoId  the value for covidus_r_intervento_presc.presc_tipo_id
	 * @mbg.generated
	 */
	public void setPrescTipoId(Integer prescTipoId) {
		this.prescTipoId = prescTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.prescrizione
	 * @return  the value of covidus_r_intervento_presc.prescrizione
	 * @mbg.generated
	 */
	public String getPrescrizione() {
		return prescrizione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.prescrizione
	 * @param prescrizione  the value for covidus_r_intervento_presc.prescrizione
	 * @mbg.generated
	 */
	public void setPrescrizione(String prescrizione) {
		this.prescrizione = prescrizione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.utente_operazione
	 * @return  the value of covidus_r_intervento_presc.utente_operazione
	 * @mbg.generated
	 */
	public String getUtenteOperazione() {
		return utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.utente_operazione
	 * @param utenteOperazione  the value for covidus_r_intervento_presc.utente_operazione
	 * @mbg.generated
	 */
	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.data_creazione
	 * @return  the value of covidus_r_intervento_presc.data_creazione
	 * @mbg.generated
	 */
	public Date getDataCreazione() {
		return dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.data_creazione
	 * @param dataCreazione  the value for covidus_r_intervento_presc.data_creazione
	 * @mbg.generated
	 */
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.data_modifica
	 * @return  the value of covidus_r_intervento_presc.data_modifica
	 * @mbg.generated
	 */
	public Date getDataModifica() {
		return dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.data_modifica
	 * @param dataModifica  the value for covidus_r_intervento_presc.data_modifica
	 * @mbg.generated
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.data_cancellazione
	 * @return  the value of covidus_r_intervento_presc.data_cancellazione
	 * @mbg.generated
	 */
	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.data_cancellazione
	 * @param dataCancellazione  the value for covidus_r_intervento_presc.data_cancellazione
	 * @mbg.generated
	 */
	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.farm_id
	 * @return  the value of covidus_r_intervento_presc.farm_id
	 * @mbg.generated
	 */
	public Integer getFarmId() {
		return farmId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.farm_id
	 * @param farmId  the value for covidus_r_intervento_presc.farm_id
	 * @mbg.generated
	 */
	public void setFarmId(Integer farmId) {
		this.farmId = farmId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.oss_id
	 * @return  the value of covidus_r_intervento_presc.oss_id
	 * @mbg.generated
	 */
	public Integer getOssId() {
		return ossId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.oss_id
	 * @param ossId  the value for covidus_r_intervento_presc.oss_id
	 * @mbg.generated
	 */
	public void setOssId(Integer ossId) {
		this.ossId = ossId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.valore
	 * @return  the value of covidus_r_intervento_presc.valore
	 * @mbg.generated
	 */
	public String getValore() {
		return valore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.valore
	 * @param valore  the value for covidus_r_intervento_presc.valore
	 * @mbg.generated
	 */
	public void setValore(String valore) {
		this.valore = valore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.farm_consegnato
	 * @return  the value of covidus_r_intervento_presc.farm_consegnato
	 * @mbg.generated
	 */
	public Boolean getFarmConsegnato() {
		return farmConsegnato;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.farm_consegnato
	 * @param farmConsegnato  the value for covidus_r_intervento_presc.farm_consegnato
	 * @mbg.generated
	 */
	public void setFarmConsegnato(Boolean farmConsegnato) {
		this.farmConsegnato = farmConsegnato;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.farm_consegna_data
	 * @return  the value of covidus_r_intervento_presc.farm_consegna_data
	 * @mbg.generated
	 */
	public Date getFarmConsegnaData() {
		return farmConsegnaData;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.farm_consegna_data
	 * @param farmConsegnaData  the value for covidus_r_intervento_presc.farm_consegna_data
	 * @mbg.generated
	 */
	public void setFarmConsegnaData(Date farmConsegnaData) {
		this.farmConsegnaData = farmConsegnaData;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_r_intervento_presc.farm_consegna_utente
	 * @return  the value of covidus_r_intervento_presc.farm_consegna_utente
	 * @mbg.generated
	 */
	public String getFarmConsegnaUtente() {
		return farmConsegnaUtente;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_r_intervento_presc.farm_consegna_utente
	 * @param farmConsegnaUtente  the value for covidus_r_intervento_presc.farm_consegna_utente
	 * @mbg.generated
	 */
	public void setFarmConsegnaUtente(String farmConsegnaUtente) {
		this.farmConsegnaUtente = farmConsegnaUtente;
	}
}