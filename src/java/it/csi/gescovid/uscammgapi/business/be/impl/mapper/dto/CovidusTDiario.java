package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

import java.util.Date;

public class CovidusTDiario {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_diario.dia_id
	 * @mbg.generated
	 */
	private Integer diaId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_diario.id_soggetto
	 * @mbg.generated
	 */
	private Long idSoggetto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_diario.utente_operazione
	 * @mbg.generated
	 */
	private String utenteOperazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_diario.id_profilo_operazione
	 * @mbg.generated
	 */
	private Integer idProfiloOperazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_diario.data_creazione
	 * @mbg.generated
	 */
	private Date dataCreazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_diario.data_modifica
	 * @mbg.generated
	 */
	private Date dataModifica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column covidus_t_diario.data_cancellazione
	 * @mbg.generated
	 */
	private Date dataCancellazione;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_diario.dia_id
	 * @return  the value of covidus_t_diario.dia_id
	 * @mbg.generated
	 */
	public Integer getDiaId() {
		return diaId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_diario.dia_id
	 * @param diaId  the value for covidus_t_diario.dia_id
	 * @mbg.generated
	 */
	public void setDiaId(Integer diaId) {
		this.diaId = diaId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_diario.id_soggetto
	 * @return  the value of covidus_t_diario.id_soggetto
	 * @mbg.generated
	 */
	public Long getIdSoggetto() {
		return idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_diario.id_soggetto
	 * @param idSoggetto  the value for covidus_t_diario.id_soggetto
	 * @mbg.generated
	 */
	public void setIdSoggetto(Long idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_diario.utente_operazione
	 * @return  the value of covidus_t_diario.utente_operazione
	 * @mbg.generated
	 */
	public String getUtenteOperazione() {
		return utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_diario.utente_operazione
	 * @param utenteOperazione  the value for covidus_t_diario.utente_operazione
	 * @mbg.generated
	 */
	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_diario.id_profilo_operazione
	 * @return  the value of covidus_t_diario.id_profilo_operazione
	 * @mbg.generated
	 */
	public Integer getIdProfiloOperazione() {
		return idProfiloOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_diario.id_profilo_operazione
	 * @param idProfiloOperazione  the value for covidus_t_diario.id_profilo_operazione
	 * @mbg.generated
	 */
	public void setIdProfiloOperazione(Integer idProfiloOperazione) {
		this.idProfiloOperazione = idProfiloOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_diario.data_creazione
	 * @return  the value of covidus_t_diario.data_creazione
	 * @mbg.generated
	 */
	public Date getDataCreazione() {
		return dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_diario.data_creazione
	 * @param dataCreazione  the value for covidus_t_diario.data_creazione
	 * @mbg.generated
	 */
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_diario.data_modifica
	 * @return  the value of covidus_t_diario.data_modifica
	 * @mbg.generated
	 */
	public Date getDataModifica() {
		return dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_diario.data_modifica
	 * @param dataModifica  the value for covidus_t_diario.data_modifica
	 * @mbg.generated
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column covidus_t_diario.data_cancellazione
	 * @return  the value of covidus_t_diario.data_cancellazione
	 * @mbg.generated
	 */
	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column covidus_t_diario.data_cancellazione
	 * @param dataCancellazione  the value for covidus_t_diario.data_cancellazione
	 * @mbg.generated
	 */
	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}
}