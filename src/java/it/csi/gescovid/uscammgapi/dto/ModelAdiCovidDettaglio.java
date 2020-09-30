package it.csi.gescovid.uscammgapi.dto;

import java.util.Date;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelAdiCovidDettaglio {

	private Integer adiCovidDettaglioId = null;
	private Date adicovidDettaglioData = null;
	private String adiCovidDettaglioNote = null;
	private Integer adiCovidId = null;
	private Date dataCreazione = null;
	private Date dataModifica = null;

	@JsonProperty("adiCovidDettaglioId")

	public Integer getAdiCovidDettaglioId() {
		return adiCovidDettaglioId;
	}

	public void setAdiCovidDettaglioId(Integer adiCovidDettaglioId) {
		this.adiCovidDettaglioId = adiCovidDettaglioId;
	}

	@JsonProperty("adiCovidDettaglioData")

	public Date getAdicovidDettaglioData() {
		return adicovidDettaglioData;
	}

	public void setAdicovidDettaglioData(Date adicovidDettaglioData) {
		this.adicovidDettaglioData = adicovidDettaglioData;
	}

	@JsonProperty("adiCovidDettaglioNote")

	public String getAdiCovidDettaglioNote() {
		return adiCovidDettaglioNote;
	}

	public void setAdiCovidDettaglioNote(String adiCovidDettaglioNote) {
		this.adiCovidDettaglioNote = adiCovidDettaglioNote;
	}

	@JsonProperty("adiCovidId")

	public Integer getAdiCovidId() {
		return adiCovidId;
	}

	public void setAdiCovidId(Integer adiCovidId) {
		this.adiCovidId = adiCovidId;
	}

	@JsonProperty("adiCovidDataCreazione")

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	@JsonProperty("adiCovidDataModifica")

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ModelAdiCovidDettaglio modelAdiCovidDettaglio = (ModelAdiCovidDettaglio) o;
		return Objects.equals(adiCovidDettaglioId, modelAdiCovidDettaglio.adiCovidDettaglioId)
				&& Objects.equals(adicovidDettaglioData, modelAdiCovidDettaglio.adicovidDettaglioData)
				&& Objects.equals(adiCovidDettaglioNote, modelAdiCovidDettaglio.adiCovidDettaglioNote)
				&& Objects.equals(adiCovidId, modelAdiCovidDettaglio.adiCovidId)
				&& Objects.equals(dataCreazione, modelAdiCovidDettaglio.dataCreazione)
				&& Objects.equals(dataModifica, modelAdiCovidDettaglio.dataModifica);
	}

	@Override
	public int hashCode() {
		return Objects.hash(adiCovidDettaglioId, adicovidDettaglioData, adiCovidDettaglioNote, adiCovidId,
				dataCreazione, dataModifica);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelAdiCovidDettaglio {\n");

		sb.append("    adiCovidDettaglioId: ").append(toIndentedString(adiCovidDettaglioId)).append("\n");
		sb.append("    adicovidData: ").append(toIndentedString(adicovidDettaglioData)).append("\n");
		sb.append("    adiCovidNote: ").append(toIndentedString(adiCovidDettaglioNote)).append("\n");
		sb.append("    adiCovidId: ").append(toIndentedString(adiCovidId)).append("\n");
		sb.append("    dataCreazione: ").append(toIndentedString(dataCreazione)).append("\n");
		sb.append("    dataModifica: ").append(toIndentedString(dataModifica)).append("\n");
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
