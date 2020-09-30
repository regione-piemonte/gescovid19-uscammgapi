package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.gescovid.uscammgapi.dto.SchedeDocumenti;
import it.csi.gescovid.uscammgapi.dto.SchedePrescrizioni;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class Payload {
	// verra' utilizzata la seguente strategia serializzazione degli attributi:
	// [explicit-as-modeled]

	private String descrizione = null;
	private Boolean critica = null;
	private String struttura = null;
	private String stato = null;
	private Integer soggetto = null;
	private Boolean visibileMed118 = Boolean.FALSE; // medico 118
	private Boolean visibileMedCa = Boolean.FALSE; // continuita assistenziale
	private String terapiaCronica = null;
	private List<SchedeDocumenti> documenti = new ArrayList<SchedeDocumenti>();
	private List<SchedePrescrizioni> prescrizioni = new ArrayList<SchedePrescrizioni>();

	@JsonProperty("terapiaCronica")

	public String getTerapiaCronica() {
		return terapiaCronica;
	}

	public void setTerapiaCronica(String terapiaCronica) {
		this.terapiaCronica = terapiaCronica;
	}

	@JsonProperty("visibileMed118")
	public Boolean getVisibileMed118() {
		return visibileMed118;
	}

	public void setVisibileMed118(Boolean visibileMed118) {
		this.visibileMed118 = visibileMed118;
	}

	@JsonProperty("visibileMedCa")
	public Boolean getVisibileMedCa() {
		return visibileMedCa;
	}

	public void setVisibileMedCa(Boolean visibileMedCa) {
		this.visibileMedCa = visibileMedCa;
	}

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

	/**
	 * Se l&#39;intervento � urgente o meno
	 **/

	@JsonProperty("critica")

	public Boolean isCritica() {
		return critica;
	}

	public void setCritica(Boolean critica) {
		this.critica = critica;
	}

	/**
	 * L&#39;id dell&#39;USCA selezionato dal medico
	 **/

	@JsonProperty("struttura")

	public String getStruttura() {
		return struttura;
	}

	public void setStruttura(String struttura) {
		this.struttura = struttura;
	}

	/**
	 * Il codice dello stato da usare (es. Bozza o Inviata)
	 **/

	@JsonProperty("stato")

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * L&#39;id del soggetto per cui creare la scheda
	 **/

	@JsonProperty("soggetto")

	public Integer getSoggetto() {
		return soggetto;
	}

	public void setSoggetto(Integer soggetto) {
		this.soggetto = soggetto;
	}

	/**
	 **/

	@JsonProperty("documenti")

	public List<SchedeDocumenti> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(List<SchedeDocumenti> documenti) {
		this.documenti = documenti;
	}

	/**
	 **/

	@JsonProperty("prescrizioni")

	public List<SchedePrescrizioni> getPrescrizioni() {
		return prescrizioni;
	}

	public void setPrescrizioni(List<SchedePrescrizioni> prescrizioni) {
		this.prescrizioni = prescrizioni;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Payload payload = (Payload) o;
		return Objects.equals(descrizione, payload.descrizione) && Objects.equals(critica, payload.critica)
				&&Objects.equals(terapiaCronica, payload.terapiaCronica)
				&& Objects.equals(struttura, payload.struttura) && Objects.equals(stato, payload.stato)
				&& Objects.equals(soggetto, payload.soggetto) && Objects.equals(documenti, payload.documenti)
				&& Objects.equals(prescrizioni, payload.prescrizioni);
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, critica,terapiaCronica, struttura, stato, soggetto, documenti, prescrizioni);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Payload {\n");

		sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
		sb.append("    critica: ").append(toIndentedString(critica)).append("\n");
		sb.append("    terapiaCronica: ").append(toIndentedString(terapiaCronica)).append("\n");
		sb.append("    struttura: ").append(toIndentedString(struttura)).append("\n");
		sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
		sb.append("    soggetto: ").append(toIndentedString(soggetto)).append("\n");
		sb.append("    documenti: ").append(toIndentedString(documenti)).append("\n");
		sb.append("    prescrizioni: ").append(toIndentedString(prescrizioni)).append("\n");
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
