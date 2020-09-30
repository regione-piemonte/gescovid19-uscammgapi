package it.csi.gescovid.uscammgapi.dto;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelAdiCovid {

	private Integer adiCovidId = null;
	private Date dataAdiCovidInizio = null;
	private Date dataAdiCovidFine = null;
	private String noteAdiCovid = null;
	private Date dataCreazione = null;
	private Date dataModifica = null;
	private List<ModelAdiCovidDettaglio> dettagli= new ArrayList<ModelAdiCovidDettaglio>();

	@JsonProperty("adiCovidId")

	public Integer getAdiCovidId() {
		return adiCovidId;
	}

	public void setAdiCovidId(Integer adiCovidId) {
		this.adiCovidId = adiCovidId;
	}

	@JsonProperty("dataAdiCovidInizio")

	public Date getDataAdiCovidInizio() {
		return dataAdiCovidInizio;
	}

	public void setDataAdiCovidInizio(Date dataAdiCovidInizio) {
		this.dataAdiCovidInizio = dataAdiCovidInizio;
	}

	@JsonProperty("dataAdiCovidFine")

	public Date getDataAdiCovidFine() {
		return dataAdiCovidFine;
	}

	public void setDataAdiCovidFine(Date dataAdiCovidFine) {
		this.dataAdiCovidFine = dataAdiCovidFine;
	}

	@JsonProperty("noteAdiCovid")

	public String getNoteAdiCovid() {
		return noteAdiCovid;
	}

	public void setNoteAdiCovid(String noteAdiCovid) {
		this.noteAdiCovid = noteAdiCovid;
	}

	@JsonProperty("dataCreazione")

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	@JsonProperty("dataModifica")

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}
	
	  @JsonProperty("dettagli") 

	public List<ModelAdiCovidDettaglio> getDettagli() {
		return dettagli;
	}

	public void setDettagli(List<ModelAdiCovidDettaglio> dettagli) {
		this.dettagli = dettagli;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ModelAdiCovid modelAdiCovid = (ModelAdiCovid) o;
		return Objects.equals(adiCovidId, modelAdiCovid.adiCovidId)
				&& Objects.equals(dataAdiCovidInizio, modelAdiCovid.dataAdiCovidInizio)
				&& Objects.equals(dataAdiCovidFine, modelAdiCovid.dataAdiCovidFine)
				&& Objects.equals(noteAdiCovid, modelAdiCovid.noteAdiCovid)
				&& Objects.equals(dataCreazione, modelAdiCovid.dataCreazione)
				&& Objects.equals(dataModifica, modelAdiCovid.dataModifica)
				&& Objects.equals(dettagli, modelAdiCovid.dettagli);
	}

	@Override
	public int hashCode() {
		return Objects.hash(adiCovidId, dataAdiCovidInizio, dataAdiCovidFine, noteAdiCovid, dataCreazione,
				dataModifica, dettagli);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelAdiCovid {\n");

		sb.append("    adiCovidId: ").append(toIndentedString(adiCovidId)).append("\n");
		sb.append("    dataAdiCovidInizio: ").append(toIndentedString(dataAdiCovidInizio)).append("\n");
		sb.append("    dataAdiCovidFine: ").append(toIndentedString(dataAdiCovidFine)).append("\n");
		sb.append("    noteAdiCovid: ").append(toIndentedString(noteAdiCovid)).append("\n");
		sb.append("    dataCreazione: ").append(toIndentedString(dataCreazione)).append("\n");
		sb.append("    dataModifica: ").append(toIndentedString(dataModifica)).append("\n");
		sb.append("    dettagli: ").append(toIndentedString(dettagli)).append("\n");
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
