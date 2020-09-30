package it.csi.gescovid.uscammgapi.dto;

import java.util.Date;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelNotifica {

	private String id;
	private String descrizione;
	private String testoRisposta;
	private String cfUtenteRichiesta;
	private String cfUtenteDestinatario;
	private String idSoggetto;
	private String idStruttura;
	private Integer idEnte;
	private Integer idTipo;
	private String codTipo;
	private String descrTipo;
	private Integer idTipoUtente;
	private Integer idTipoUtenteDest;
	
	private String codTipoUtente;
	private String descrTipoUtente;
	
	private String descrTipoUtenteDest;
	private String codTipoUtenteDest;
	
	
	private Integer idEvento;
	private String tipoEvento;
	private String tipoDescEvento;
	private Integer idAzione;
	private String codAzione;
	private String descrAzione;
	private Integer idPriorita;
	private String codPriorita;
	private String descrPriorita;
	private String esitoTampone;
	private Date data;
	private Date dataPresaVisione;
	private String cfUtentePresaVisione;
	private ModelSoggetto soggetto;
	private ModelUtente medico;
	private ModelUtenteMedico medicoTitolato;
	
	
	@JsonProperty("medicoTitolato")
	public ModelUtenteMedico getMedicoTitolato() {
		return medicoTitolato;
	}


	public void setMedicoTitolato(ModelUtenteMedico medicoTitolato) {
		this.medicoTitolato = medicoTitolato;
	}


	@JsonProperty("esitoTampone")
	public String getEsitoTampone() {
		return esitoTampone;
	}

	
	@JsonProperty("tipoDescEvento")
	public String getTipoDescEvento() {
		return tipoDescEvento;
	}

	public void setTipoDescEvento(String tipoDescEvento) {
		this.tipoDescEvento = tipoDescEvento;
	}



	public void setEsitoTampone(String esitoTampone) {
		this.esitoTampone = esitoTampone;
	}

	@JsonProperty("codPriorita")
	public String getCodPriorita() {
		return codPriorita;
	}

	public void setCodPriorita(String codPriorita) {
		this.codPriorita = codPriorita;
	}

	
	
	
	@JsonProperty("codTipoUtente")
	public String getCodTipoUtente() {
		return codTipoUtente;
	}

	public void setCodTipoUtente(String codTipoUtente) {
		this.codTipoUtente = codTipoUtente;
	}

	@JsonProperty("descrTipoUtente")
	public String getDescrTipoUtente() {
		return descrTipoUtente;
	}

	public void setDescrTipoUtente(String descrTipoUtente) {
		this.descrTipoUtente = descrTipoUtente;
	}

	@JsonProperty("descrTipoUtenteDest")
	public String getDescrTipoUtenteDest() {
		return descrTipoUtenteDest;
	}

	public void setDescrTipoUtenteDest(String descrTipoUtenteDest) {
		this.descrTipoUtenteDest = descrTipoUtenteDest;
	}

	@JsonProperty("codTipoUtenteDest")
	public String getCodTipoUtenteDest() {
		return codTipoUtenteDest;
	}

	public void setCodTipoUtenteDest(String codTipoUtenteDest) {
		this.codTipoUtenteDest = codTipoUtenteDest;
	}

	@JsonProperty("codTipo")
	public String getCodTipo() {
		return codTipo;
	}

	public void setCodTipo(String codTipo) {
		this.codTipo = codTipo;
	}

	@JsonProperty("descrTipo")
	public String getDescrTipo() {
		return descrTipo;
	}

	public void setDescrTipo(String descrTipo) {
		this.descrTipo = descrTipo;
	}

	@JsonProperty("codAzione")
	public String getCodAzione() {
		return codAzione;
	}

	public void setCodAzione(String codAzione) {
		this.codAzione = codAzione;
	}
	@JsonProperty("descrAzione")
	public String getDescrAzione() {
		return descrAzione;
	}

	public void setDescrAzione(String descrAzione) {
		this.descrAzione = descrAzione;
	}

	@JsonProperty("descrPriorita")

	public String getDescrPriorita() {
		return descrPriorita;
	}

	public void setDescrPriorita(String descrPriorita) {
		this.descrPriorita = descrPriorita;
	}

	@JsonProperty("dataPresaVisione")
	public Date getDataPresaVisione() {
		return dataPresaVisione;
	}

	public void setDataPresaVisione(Date dataPresaVisione) {
		this.dataPresaVisione = dataPresaVisione;
	}

	@JsonProperty("cfUtentePresaVisione")
	public String getCfUtentePresaVisione() {
		return cfUtentePresaVisione;
	}

	public void setCfUtentePresaVisione(String cfUtentePresaVisione) {
		this.cfUtentePresaVisione = cfUtentePresaVisione;
	}

	@JsonProperty("soggetto")
	public ModelSoggetto getSoggetto() {
		return soggetto;
	}

	public void setSoggetto(ModelSoggetto soggetto) {
		this.soggetto = soggetto;
	}

	@JsonProperty("medico")
	public ModelUtente getMedico() {
		return medico;
	}

	public void setMedico(ModelUtente medico) {
		this.medico = medico;
	}

	@JsonProperty("tipoEvento")

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@JsonProperty("testoRisposta")

	public String getTestoRisposta() {
		return testoRisposta;
	}

	public void setTestoRisposta(String testoRisposta) {
		this.testoRisposta = testoRisposta;
	}

	@JsonProperty("dataNotifica")

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@JsonProperty("id")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("descrizione")

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@JsonProperty("cfUtenteRichiesta")

	public String getCfUtenteRichiesta() {
		return cfUtenteRichiesta;
	}

	public void setCfUtenteRichiesta(String cfUtenteRichiesta) {
		this.cfUtenteRichiesta = cfUtenteRichiesta;
	}

	@JsonProperty("cfUtenteDestinatario")

	public String getCfUtenteDestinatario() {
		return cfUtenteDestinatario;
	}

	public void setCfUtenteDestinatario(String cfUtenteDestinatario) {
		this.cfUtenteDestinatario = cfUtenteDestinatario;
	}

	@JsonProperty("idSoggetto")

	public String getIdSoggetto() {
		return idSoggetto;
	}

	public void setIdSoggetto(String idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	@JsonProperty("idStruttura")

	public String getIdStruttura() {
		return idStruttura;
	}

	public void setIdStruttura(String idStruttura) {
		this.idStruttura = idStruttura;
	}

	@JsonProperty("idEnte")

	public Integer getIdEnte() {
		return idEnte;
	}

	public void setIdEnte(Integer idEnte) {
		this.idEnte = idEnte;
	}

	@JsonProperty("idTipo")

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	@JsonProperty("idTipoUtente")

	public Integer getIdTipoUtente() {
		return idTipoUtente;
	}

	public void setIdTipoUtente(Integer idTipoUtente) {
		this.idTipoUtente = idTipoUtente;
	}

	@JsonProperty("idTipoUtenteDest")

	public Integer getIdTipoUtenteDest() {
		return idTipoUtenteDest;
	}

	public void setIdTipoUtenteDest(Integer idTipoUtenteDest) {
		this.idTipoUtenteDest = idTipoUtenteDest;
	}

	@JsonProperty("idEvento")

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	@JsonProperty("idAzione")

	public Integer getIdAzione() {
		return idAzione;
	}

	public void setIdAzione(Integer idAzione) {
		this.idAzione = idAzione;
	}

	@JsonProperty("idPriorita")

	public Integer getIdPriorita() {
		return idPriorita;
	}

	public void setIdPriorita(Integer idPriorita) {
		this.idPriorita = idPriorita;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ModelNotifica modelNotifica = (ModelNotifica) o;
		return Objects.equals(id, modelNotifica.id) && Objects.equals(descrizione, modelNotifica.descrizione)
				&& Objects.equals(testoRisposta, modelNotifica.testoRisposta)
				&& Objects.equals(cfUtenteRichiesta, modelNotifica.cfUtenteRichiesta)
				&& Objects.equals(cfUtenteDestinatario, modelNotifica.cfUtenteDestinatario)
				&& Objects.equals(idSoggetto, modelNotifica.idSoggetto)
				&& Objects.equals(idStruttura, modelNotifica.idStruttura)
				&& Objects.equals(idEnte, modelNotifica.idEnte) && Objects.equals(idTipo, modelNotifica.idTipo)
				&& Objects.equals(idTipoUtente, modelNotifica.idTipoUtente)
				&& Objects.equals(idTipoUtenteDest, modelNotifica.idTipoUtenteDest)
				&& Objects.equals(idEvento, modelNotifica.idEvento) && Objects.equals(idAzione, modelNotifica.idAzione)
				&& Objects.equals(idPriorita, modelNotifica.idPriorita) && Objects.equals(data, modelNotifica.data)
				&& Objects.equals(testoRisposta, modelNotifica.testoRisposta)
				&& Objects.equals(tipoEvento, modelNotifica.tipoEvento)
				&& Objects.equals(soggetto, modelNotifica.soggetto)
				&& Objects.equals(medico, modelNotifica.medico)
				&& Objects.equals(dataPresaVisione, modelNotifica.dataPresaVisione)
				&& Objects.equals(cfUtentePresaVisione, modelNotifica.cfUtentePresaVisione)
		&& Objects.equals(codPriorita, modelNotifica.codPriorita)
		&& Objects.equals(descrPriorita, modelNotifica.descrPriorita)
		&& Objects.equals(esitoTampone, modelNotifica.esitoTampone);
		
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, descrizione, testoRisposta, cfUtenteRichiesta, cfUtenteDestinatario, idSoggetto,
				idStruttura, idEnte, idTipo, idTipoUtente, idTipoUtenteDest, idEvento, idAzione, idPriorita, data, tipoEvento, soggetto, medico
				,dataPresaVisione,cfUtentePresaVisione, codPriorita, descrPriorita, esitoTampone);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelNotifica {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
		sb.append("    testoRisposta: ").append(toIndentedString(testoRisposta)).append("\n");
		sb.append("    cfUtenteRichiesta: ").append(toIndentedString(cfUtenteRichiesta)).append("\n");
		sb.append("    cfUtenteDestinatario: ").append(toIndentedString(cfUtenteDestinatario)).append("\n");
		sb.append("    idSoggetto: ").append(toIndentedString(idSoggetto)).append("\n");
		sb.append("    idStruttura: ").append(toIndentedString(idStruttura)).append("\n");
		sb.append("    idEnte: ").append(toIndentedString(idEnte)).append("\n");
		sb.append("    idTipo: ").append(toIndentedString(idTipo)).append("\n");
		sb.append("    idTipoUtente: ").append(toIndentedString(idTipoUtente)).append("\n");
		sb.append("    idTipoUtenteDest: ").append(toIndentedString(idTipoUtenteDest)).append("\n");
		sb.append("    idEvento: ").append(toIndentedString(idEvento)).append("\n");
		sb.append("    idAzione: ").append(toIndentedString(idAzione)).append("\n");
		sb.append("    idPriorita: ").append(toIndentedString(idPriorita)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
		sb.append("    tipoEvento: ").append(toIndentedString(tipoEvento)).append("\n");
		sb.append("    soggetto: ").append(toIndentedString(soggetto)).append("\n");
		sb.append("    medico: ").append(toIndentedString(medico)).append("\n");
		sb.append("    dataPresaVisione: ").append(toIndentedString(dataPresaVisione)).append("\n");
		sb.append("    codPriorita: ").append(toIndentedString(codPriorita)).append("\n");
		sb.append("    descrPriorita: ").append(toIndentedString(descrPriorita)).append("\n");
		sb.append("    esitoTampone: ").append(toIndentedString(esitoTampone)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
