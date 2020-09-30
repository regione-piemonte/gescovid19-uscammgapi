package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelNotificaPresaVisione {

	private Integer id;
	private String testo;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("testo")
	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public void setId(Integer id) {
		this.id = id;
	}





	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ModelNotificaPresaVisione modelNotifica = (ModelNotificaPresaVisione) o;
		return Objects.equals(id, modelNotifica.id) 
				&& Objects.equals(testo, modelNotifica.testo);


		
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, testo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelNotifica {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    testo: ").append(toIndentedString(testo)).append("\n");

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
