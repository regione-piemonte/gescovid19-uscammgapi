package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

public class RUtenteProfilo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column r_utente_profilo.cf_utente
	 * @mbg.generated
	 */
	private String cfUtente;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column r_utente_profilo.id_profilo
	 * @mbg.generated
	 */
	private Integer idProfilo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column r_utente_profilo.note
	 * @mbg.generated
	 */
	private String note;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column r_utente_profilo.cf_utente
	 * @return  the value of r_utente_profilo.cf_utente
	 * @mbg.generated
	 */
	public String getCfUtente() {
		return cfUtente;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column r_utente_profilo.cf_utente
	 * @param cfUtente  the value for r_utente_profilo.cf_utente
	 * @mbg.generated
	 */
	public void setCfUtente(String cfUtente) {
		this.cfUtente = cfUtente;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column r_utente_profilo.id_profilo
	 * @return  the value of r_utente_profilo.id_profilo
	 * @mbg.generated
	 */
	public Integer getIdProfilo() {
		return idProfilo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column r_utente_profilo.id_profilo
	 * @param idProfilo  the value for r_utente_profilo.id_profilo
	 * @mbg.generated
	 */
	public void setIdProfilo(Integer idProfilo) {
		this.idProfilo = idProfilo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column r_utente_profilo.note
	 * @return  the value of r_utente_profilo.note
	 * @mbg.generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column r_utente_profilo.note
	 * @param note  the value for r_utente_profilo.note
	 * @mbg.generated
	 */
	public void setNote(String note) {
		this.note = note;
	}
}