package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class Payload6   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  
  private String testo = null;
  

    

  @JsonProperty("testo") 
  public String getTesto() {
	return testo;
  }
 
  public void setTesto(String testo) {
	this.testo = testo;
  }
 
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payload6 payload6 = (Payload6) o;
    return Objects.equals(testo, payload6.testo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(testo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payload6 {\n");
    
    sb.append("    testo: ").append(toIndentedString(testo)).append("\n");
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

