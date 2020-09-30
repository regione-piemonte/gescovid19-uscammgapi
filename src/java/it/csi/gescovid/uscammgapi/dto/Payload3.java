package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioSintomo;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class Payload3 {
	// verra' utilizzata la seguente strategia serializzazione degli attributi:
	// [explicit-as-modeled]

	private Date data = null;
	private String note = null;
	private Integer soggetto = null;
	private Integer intervento = null;
	private List<ModelDiarioDettaglioSintomo> sintomi = new ArrayList<ModelDiarioDettaglioSintomo>();
	private ModelAdiCovid adiCovid = new ModelAdiCovid();

	/**
	 * La data per la quale si vuole registrare il dettaglio del diario
	 **/
	@JsonProperty("adiCovid")

	
	public ModelAdiCovid getAdiCovid() {
		return adiCovid;
	}

	public void setAdiCovid(ModelAdiCovid adiCovid) {
		this.adiCovid = adiCovid;
	}

	@JsonProperty("data")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * La descrizione inserita dall&#39;utente
	 **/

	@JsonProperty("note")

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * L&#39;id del soggetto
	 **/

	@JsonProperty("soggetto")

	public Integer getSoggetto() {
		return soggetto;
	}

	public void setSoggetto(Integer soggetto) {
		this.soggetto = soggetto;
	}

	/**
	 * L&#39;id dell&#39;intervento
	 **/

	@JsonProperty("intervento")

	public Integer getIntervento() {
		return intervento;
	}

	public void setIntervento(Integer intervento) {
		this.intervento = intervento;
	}

	/**
	 **/

	@JsonProperty("sintomi")

	public List<ModelDiarioDettaglioSintomo> getSintomi() {
		return sintomi;
	}

	public void setSintomi(List<ModelDiarioDettaglioSintomo> sintomi) {
		this.sintomi = sintomi;
	}
	

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Payload3 payload3 = (Payload3) o;
		return Objects.equals(data, payload3.data) && Objects.equals(note, payload3.note)
				&& Objects.equals(soggetto, payload3.soggetto) && Objects.equals(intervento, payload3.intervento)
				&& Objects.equals(adiCovid, payload3.adiCovid)
				&& Objects.equals(sintomi, payload3.sintomi);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, note, soggetto, intervento, sintomi);

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Payload3 {\n");

		sb.append("    data: ").append(toIndentedString(data)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
		sb.append("    soggetto: ").append(toIndentedString(soggetto)).append("\n");
		sb.append("    intervento: ").append(toIndentedString(intervento)).append("\n");
		sb.append("    sintomi: ").append(toIndentedString(sintomi)).append("\n");
		sb.append("    adiCovid: ").append(toIndentedString(adiCovid)).append("\n");
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
