package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelNotificaAzione {
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
	   * Il nome dell'azione di notifica
	   **/
	  

	  @JsonProperty("nome") 
	 
	  public String getNome() {
	    return nome;
	  }
	  public void setNome(String nome) {
	    this.nome = nome;
	  }

	  /**
	   * Una descrizione dell' azione di notifica
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
	    ModelNotificaAzione modelNotificaAzione = (ModelNotificaAzione) o;
	    return Objects.equals(id, modelNotificaAzione.id) &&
	        Objects.equals(nome, modelNotificaAzione.nome) &&
	        Objects.equals(descrizione, modelNotificaAzione.descrizione);
	  }
	  
	  @Override
	  public int hashCode() {
	    return Objects.hash(id, nome, descrizione);
	  }
	  
	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ModelNotificaAzione {\n");
	    
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
