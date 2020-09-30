package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelMonitoraggioTipo   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String id = null;
  private String codice = null;
  private String descrizione = null;

  /**
   * identificativo univoco
   **/
  

  @JsonProperty("id") 
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Il nome della terapia
   **/
  

  @JsonProperty("codice") 
 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * Una descrizione della terapia
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
    ModelMonitoraggioTipo modelMonitoraggioTipo = (ModelMonitoraggioTipo) o;
    return Objects.equals(id, modelMonitoraggioTipo.id) &&
        Objects.equals(codice, modelMonitoraggioTipo.codice) &&
        Objects.equals(descrizione, modelMonitoraggioTipo.descrizione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codice, descrizione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelMonitoraggioTipo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
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

