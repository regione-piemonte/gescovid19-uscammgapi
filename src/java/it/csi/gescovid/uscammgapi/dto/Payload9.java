package it.csi.gescovid.uscammgapi.dto;

import java.sql.Date;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class Payload9 {

	private Date adiCovidDetData = null;
	private String adiCovidDetNote = null;

	@JsonProperty("adiCovidDetData")
	public Date getAdiCovidDetData() {
		return adiCovidDetData;
	}

	public void setAdiCovidDetData(Date adiCovidDetData) {
		this.adiCovidDetData = adiCovidDetData;
	}

	@JsonProperty("adiCovidDetNote")

	public String getAdiCovidDetNote() {
		return adiCovidDetNote;
	}

	public void setAdiCovidDetNote(String adiCovidDetNote) {
		this.adiCovidDetNote = adiCovidDetNote;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Payload9 payload9 = (Payload9) o;
		return Objects.equals(adiCovidDetData, payload9.adiCovidDetData)
				&& Objects.equals(adiCovidDetNote, payload9.adiCovidDetNote);
	}



	@Override
	public int hashCode() {
		return Objects.hash(adiCovidDetData, adiCovidDetNote);

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Payload9 {\n");
		sb.append("    adiCovidData: ").append(toIndentedString(adiCovidDetData)).append("\n");
		sb.append("    adiCovidNote: ").append(toIndentedString(adiCovidDetNote)).append("\n");
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
