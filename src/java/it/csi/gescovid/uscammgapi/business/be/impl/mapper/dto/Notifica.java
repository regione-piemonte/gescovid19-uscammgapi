package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

import java.util.Date;

public class Notifica {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_id
	 * @mbg.generated
	 */
	private Integer notId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_data_notifica
	 * @mbg.generated
	 */
	private Date notDataNotifica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_data_presa_visione
	 * @mbg.generated
	 */
	private Date notDataPresaVisione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_testo_request
	 * @mbg.generated
	 */
	private String notTestoRequest;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_testo_response
	 * @mbg.generated
	 */
	private String notTestoResponse;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.id_soggetto
	 * @mbg.generated
	 */
	private Integer idSoggetto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.cf_utente_richiesta
	 * @mbg.generated
	 */
	private String cfUtenteRichiesta;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.cf_utente_presa_vis
	 * @mbg.generated
	 */
	private String cfUtentePresaVis;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.cf_utente_dest
	 * @mbg.generated
	 */
	private String cfUtenteDest;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.id_ente
	 * @mbg.generated
	 */
	private Integer idEnte;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.id_struttura
	 * @mbg.generated
	 */
	private String idStruttura;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.priorita_id
	 * @mbg.generated
	 */
	private Integer prioritaId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_tipo_id
	 * @mbg.generated
	 */
	private Integer notTipoId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_ev_id
	 * @mbg.generated
	 */
	private Integer notEvId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_az_id
	 * @mbg.generated
	 */
	private Integer notAzId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_ut_tipo_id
	 * @mbg.generated
	 */
	private Integer notUtTipoId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.utente_operazione
	 * @mbg.generated
	 */
	private String utenteOperazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.data_creazione
	 * @mbg.generated
	 */
	private Date dataCreazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.data_modifica
	 * @mbg.generated
	 */
	private Date dataModifica;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.data_cancellazione
	 * @mbg.generated
	 */
	private Date dataCancellazione;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column notifica.not_ut_tipo_id_dest
	 * @mbg.generated
	 */
	private Integer notUtTipoIdDest;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_id
	 * @return  the value of notifica.not_id
	 * @mbg.generated
	 */
	public Integer getNotId() {
		return notId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_id
	 * @param notId  the value for notifica.not_id
	 * @mbg.generated
	 */
	public void setNotId(Integer notId) {
		this.notId = notId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_data_notifica
	 * @return  the value of notifica.not_data_notifica
	 * @mbg.generated
	 */
	public Date getNotDataNotifica() {
		return notDataNotifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_data_notifica
	 * @param notDataNotifica  the value for notifica.not_data_notifica
	 * @mbg.generated
	 */
	public void setNotDataNotifica(Date notDataNotifica) {
		this.notDataNotifica = notDataNotifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_data_presa_visione
	 * @return  the value of notifica.not_data_presa_visione
	 * @mbg.generated
	 */
	public Date getNotDataPresaVisione() {
		return notDataPresaVisione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_data_presa_visione
	 * @param notDataPresaVisione  the value for notifica.not_data_presa_visione
	 * @mbg.generated
	 */
	public void setNotDataPresaVisione(Date notDataPresaVisione) {
		this.notDataPresaVisione = notDataPresaVisione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_testo_request
	 * @return  the value of notifica.not_testo_request
	 * @mbg.generated
	 */
	public String getNotTestoRequest() {
		return notTestoRequest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_testo_request
	 * @param notTestoRequest  the value for notifica.not_testo_request
	 * @mbg.generated
	 */
	public void setNotTestoRequest(String notTestoRequest) {
		this.notTestoRequest = notTestoRequest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_testo_response
	 * @return  the value of notifica.not_testo_response
	 * @mbg.generated
	 */
	public String getNotTestoResponse() {
		return notTestoResponse;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_testo_response
	 * @param notTestoResponse  the value for notifica.not_testo_response
	 * @mbg.generated
	 */
	public void setNotTestoResponse(String notTestoResponse) {
		this.notTestoResponse = notTestoResponse;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.id_soggetto
	 * @return  the value of notifica.id_soggetto
	 * @mbg.generated
	 */
	public Integer getIdSoggetto() {
		return idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.id_soggetto
	 * @param idSoggetto  the value for notifica.id_soggetto
	 * @mbg.generated
	 */
	public void setIdSoggetto(Integer idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.cf_utente_richiesta
	 * @return  the value of notifica.cf_utente_richiesta
	 * @mbg.generated
	 */
	public String getCfUtenteRichiesta() {
		return cfUtenteRichiesta;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.cf_utente_richiesta
	 * @param cfUtenteRichiesta  the value for notifica.cf_utente_richiesta
	 * @mbg.generated
	 */
	public void setCfUtenteRichiesta(String cfUtenteRichiesta) {
		this.cfUtenteRichiesta = cfUtenteRichiesta;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.cf_utente_presa_vis
	 * @return  the value of notifica.cf_utente_presa_vis
	 * @mbg.generated
	 */
	public String getCfUtentePresaVis() {
		return cfUtentePresaVis;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.cf_utente_presa_vis
	 * @param cfUtentePresaVis  the value for notifica.cf_utente_presa_vis
	 * @mbg.generated
	 */
	public void setCfUtentePresaVis(String cfUtentePresaVis) {
		this.cfUtentePresaVis = cfUtentePresaVis;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.cf_utente_dest
	 * @return  the value of notifica.cf_utente_dest
	 * @mbg.generated
	 */
	public String getCfUtenteDest() {
		return cfUtenteDest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.cf_utente_dest
	 * @param cfUtenteDest  the value for notifica.cf_utente_dest
	 * @mbg.generated
	 */
	public void setCfUtenteDest(String cfUtenteDest) {
		this.cfUtenteDest = cfUtenteDest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.id_ente
	 * @return  the value of notifica.id_ente
	 * @mbg.generated
	 */
	public Integer getIdEnte() {
		return idEnte;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.id_ente
	 * @param idEnte  the value for notifica.id_ente
	 * @mbg.generated
	 */
	public void setIdEnte(Integer idEnte) {
		this.idEnte = idEnte;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.id_struttura
	 * @return  the value of notifica.id_struttura
	 * @mbg.generated
	 */
	public String getIdStruttura() {
		return idStruttura;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.id_struttura
	 * @param idStruttura  the value for notifica.id_struttura
	 * @mbg.generated
	 */
	public void setIdStruttura(String idStruttura) {
		this.idStruttura = idStruttura;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.priorita_id
	 * @return  the value of notifica.priorita_id
	 * @mbg.generated
	 */
	public Integer getPrioritaId() {
		return prioritaId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.priorita_id
	 * @param prioritaId  the value for notifica.priorita_id
	 * @mbg.generated
	 */
	public void setPrioritaId(Integer prioritaId) {
		this.prioritaId = prioritaId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_tipo_id
	 * @return  the value of notifica.not_tipo_id
	 * @mbg.generated
	 */
	public Integer getNotTipoId() {
		return notTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_tipo_id
	 * @param notTipoId  the value for notifica.not_tipo_id
	 * @mbg.generated
	 */
	public void setNotTipoId(Integer notTipoId) {
		this.notTipoId = notTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_ev_id
	 * @return  the value of notifica.not_ev_id
	 * @mbg.generated
	 */
	public Integer getNotEvId() {
		return notEvId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_ev_id
	 * @param notEvId  the value for notifica.not_ev_id
	 * @mbg.generated
	 */
	public void setNotEvId(Integer notEvId) {
		this.notEvId = notEvId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_az_id
	 * @return  the value of notifica.not_az_id
	 * @mbg.generated
	 */
	public Integer getNotAzId() {
		return notAzId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_az_id
	 * @param notAzId  the value for notifica.not_az_id
	 * @mbg.generated
	 */
	public void setNotAzId(Integer notAzId) {
		this.notAzId = notAzId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_ut_tipo_id
	 * @return  the value of notifica.not_ut_tipo_id
	 * @mbg.generated
	 */
	public Integer getNotUtTipoId() {
		return notUtTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_ut_tipo_id
	 * @param notUtTipoId  the value for notifica.not_ut_tipo_id
	 * @mbg.generated
	 */
	public void setNotUtTipoId(Integer notUtTipoId) {
		this.notUtTipoId = notUtTipoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.utente_operazione
	 * @return  the value of notifica.utente_operazione
	 * @mbg.generated
	 */
	public String getUtenteOperazione() {
		return utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.utente_operazione
	 * @param utenteOperazione  the value for notifica.utente_operazione
	 * @mbg.generated
	 */
	public void setUtenteOperazione(String utenteOperazione) {
		this.utenteOperazione = utenteOperazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.data_creazione
	 * @return  the value of notifica.data_creazione
	 * @mbg.generated
	 */
	public Date getDataCreazione() {
		return dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.data_creazione
	 * @param dataCreazione  the value for notifica.data_creazione
	 * @mbg.generated
	 */
	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.data_modifica
	 * @return  the value of notifica.data_modifica
	 * @mbg.generated
	 */
	public Date getDataModifica() {
		return dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.data_modifica
	 * @param dataModifica  the value for notifica.data_modifica
	 * @mbg.generated
	 */
	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.data_cancellazione
	 * @return  the value of notifica.data_cancellazione
	 * @mbg.generated
	 */
	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.data_cancellazione
	 * @param dataCancellazione  the value for notifica.data_cancellazione
	 * @mbg.generated
	 */
	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column notifica.not_ut_tipo_id_dest
	 * @return  the value of notifica.not_ut_tipo_id_dest
	 * @mbg.generated
	 */
	public Integer getNotUtTipoIdDest() {
		return notUtTipoIdDest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column notifica.not_ut_tipo_id_dest
	 * @param notUtTipoIdDest  the value for notifica.not_ut_tipo_id_dest
	 * @mbg.generated
	 */
	public void setNotUtTipoIdDest(Integer notUtTipoIdDest) {
		this.notUtTipoIdDest = notUtTipoIdDest;
	}
}