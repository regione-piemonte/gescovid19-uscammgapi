package it.csi.gescovid.uscammgapi.dto;

import java.sql.Date;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class Payload10 {

	private Date adiCovidDataFine = null;
	

	@JsonProperty("adiCovidDataFine")
	public Date getAdiCovidDataFine() {
		return adiCovidDataFine;
	}
	public void setAdiCovidDataFine(Date adiCovidDataFine) {
		this.adiCovidDataFine = adiCovidDataFine;
	}	

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Payload10 payload = (Payload10) o;
		return Objects.equals(adiCovidDataFine, payload.adiCovidDataFine);
				
	}


	@Override
	public int hashCode() {
		return Objects.hash(adiCovidDataFine);

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Payload10 {\n");
		sb.append("    adiCovidDataFine: ").append(toIndentedString(adiCovidDataFine)).append("\n");
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
