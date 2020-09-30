package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelNotificaEvento {


	private String id;
	private String nome;
	private String descrizione;
	
	@JsonProperty("id") 
	 
	  public String getId() {
	    return id;
	  }
	  public void setId(String id) {
	    this.id = id;
	  }

	  /**
	   * Il nome dell'evento di notifica
	   **/
	  

	  @JsonProperty("nome") 
	 
	  public String getNome() {
	    return nome;
	  }
	  public void setNome(String nome) {
	    this.nome = nome;
	  }

	  /**
	   * Una descrizione dell'evento di notifica
	   **/
	  

	  @JsonProperty("descrizione") 
	 
	  public String getDescrizione() {
	    return descrizione;
	  }
	  public void setDescrizione(String descrizione) {
	    this.descrizione = descrizione;
	  }
	  
	  @Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ModelNotificaEvento modelNotificaEvento = (ModelNotificaEvento) o;
	    return Objects.equals(id, modelNotificaEvento.id) &&
	        Objects.equals(nome, modelNotificaEvento.nome) &&
	        Objects.equals(descrizione, modelNotificaEvento.descrizione);
	  }
	  
	  @Override
	  public int hashCode() {
	    return Objects.hash(id, nome, descrizione);
	  }
	  
	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ModelNotificaEvento {\n");
	    
	    sb.append("    id: ").append(toIndentedString(id)).append("\n");
	    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
	    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
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
