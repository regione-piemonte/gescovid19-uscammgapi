package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class Errore   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codice = null;
  private String descrizione = null;

  /**
   **/
  

  @JsonProperty("codice") 
 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
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
    Errore errore = (Errore) o;
    return Objects.equals(codice, errore.codice) &&
        Objects.equals(descrizione, errore.descrizione);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, descrizione);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Errore {\n");
    
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

