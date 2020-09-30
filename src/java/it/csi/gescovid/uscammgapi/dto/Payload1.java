package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class Payload1   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String stato = null;

  /**
   * Il codice dello stato da usare (es. Bozza o Inviata)
   **/
  

  @JsonProperty("stato") 
 
  public String getStato() {
    return stato;
  }
  public void setStato(String stato) {
    this.stato = stato;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payload1 payload1 = (Payload1) o;
    return Objects.equals(stato, payload1.stato);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stato);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payload1 {\n");
    
    sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
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

