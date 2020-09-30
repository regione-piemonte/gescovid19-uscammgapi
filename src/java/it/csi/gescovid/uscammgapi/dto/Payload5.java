package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class Payload5 {
	// verra' utilizzata la seguente strategia serializzazione degli attributi:
	// [explicit-as-modeled]

	private String descrizione = null; // testo della notifica
	private String azione = null; // presa visione o nessuna
	private String priorita = null; // id del tipo priorita', quindi es. urgente, normale, bassa
	private String evento = null; // id del tipo evento, quindi es. quarantena o aggravamento
	private String tipoNotifica = null; // id del tipo notifica, quindi es. informativa, richiesta, comunicazione
	private String tipoUtente = null; // id del tipo di utente della notifica quindi es. mmg, usca, sisp, medico 118,guardia medica ecc.
	private String tipoUtenteDest = null;										
	private Integer soggettoId = null; // id del soggetto per cui inserire la notifica
	private String cfUtenteRichiesta = null; // Il cf dell'utente che invia la notifica
	private String struttura = null; // id della struttura che vedra le notifiche (vedi usca)
	private Integer ente = null; // id ente (escluso sisp, perchè l'ente si ricava dal soggetto) 
	private String cfUtenteDestinatario = null; // cd dell'utente a cui è rivolta la notifica in caso di inserimento da
												// parte dell'usca

	/**
	 * La descrizione inserita dall&#39;utente
	 **/
	@JsonProperty("descrizione")
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@JsonProperty("priorita")
	public String getPriorita() {
		return priorita;
	}

	@JsonProperty("evento")
	public String getEvento() {
		return evento;
	}

	@JsonProperty("tipoNotifica")
	public String getTipoNotifica() {
		return tipoNotifica;
	}

	@JsonProperty("soggettoId")
	public Integer getSoggettoId() {
		return soggettoId;
	}

	@JsonProperty("cfUtenteRichiesta")
	public String getCfUtenteRichiesta() {
		return cfUtenteRichiesta;
	}

	public void setCfUtenteRichiesta(String cfUtenteRichiesta) {
		this.cfUtenteRichiesta = cfUtenteRichiesta;
	}

	public void setPriorita(String priorita) {
		this.priorita = priorita;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public void setTipoNotifica(String tipoNotifica) {
		this.tipoNotifica = tipoNotifica;
	}

	public void setSoggettoId(Integer soggettoId) {
		this.soggettoId = soggettoId;
	}

	@JsonProperty("azione")
	public String getAzione() {
		return azione;
	}

	public void setAzione(String azione) {
		this.azione = azione;
	}

	@JsonProperty("struttura")
	public String getStruttura() {
		return struttura;
	}

	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}

	@JsonProperty("ente")
	public Integer getEnte() {
		return ente;
	}

	public void setEnteId(Integer ente) {
		this.ente = ente;
	}

	@JsonProperty("cfUtenteDestinatario")
	public String getCfUtenteDestinatario() {
		return cfUtenteDestinatario;
	}

	public void setCfUtenteDestinatario(String CfUtenteDestinatario) {
		this.cfUtenteDestinatario = CfUtenteDestinatario;
	}

	@JsonProperty("tipoUtente")
	public String getTipoUtente() {
		return tipoUtente;
	}

	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}
	
	
	@JsonProperty("tipoUtenteDest")
	public String getTipoUtenteDest() {
		return tipoUtenteDest;
	}

	public void setTipoUtenteDest(String tipoUtenteDest) {
		this.tipoUtenteDest = tipoUtenteDest;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Payload5 payload = (Payload5) o;
		return Objects.equals(descrizione, payload.descrizione) && Objects.equals(priorita, payload.priorita)
				&& Objects.equals(azione, payload.azione) && Objects.equals(tipoNotifica, payload.tipoNotifica)
				&& Objects.equals(soggettoId, payload.soggettoId) 
				//&& Objects.equals(ente, payload.ente)
				&& Objects.equals(evento, payload.evento) && Objects.equals(cfUtenteRichiesta, payload.cfUtenteRichiesta)
				//&& Objects.equals(struttura, payload.struttura)
				&& Objects.equals(cfUtenteDestinatario, payload.cfUtenteDestinatario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, priorita, azione, tipoNotifica, soggettoId, 
				//ente, 
				evento, cfUtenteRichiesta,
				//struttura, 
				cfUtenteDestinatario);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Payload {\n");

		sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
		sb.append("    priorita: ").append(toIndentedString(priorita)).append("\n");
		sb.append("    azione: ").append(toIndentedString(azione)).append("\n");
		sb.append("    tipoNotifica: ").append(toIndentedString(tipoNotifica)).append("\n");
		sb.append("    soggetto: ").append(toIndentedString(soggettoId)).append("\n");
		//sb.append("    ente: ").append(toIndentedString(ente)).append("\n");
		sb.append("    evento: ").append(toIndentedString(evento)).append("\n");
		sb.append("    cfUtenteRichiesta: ").append(toIndentedString(cfUtenteRichiesta)).append("\n");
		//sb.append("    struttura: ").append(toIndentedString(struttura)).append("\n");
		sb.append("    cfUtenteDestinatario: ").append(toIndentedString(cfUtenteDestinatario)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
