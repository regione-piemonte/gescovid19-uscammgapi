package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelUtenteSindacoComune   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String istatComune = null;
  private String nomeComune = null;

  /**
   **/
  

  @JsonProperty("istatComune") 
 
  public String getIstatComune() {
    return istatComune;
  }
  public void setIstatComune(String istatComune) {
    this.istatComune = istatComune;
  }

  /**
   **/
  

  @JsonProperty("nomeComune") 
 
  public String getNomeComune() {
    return nomeComune;
  }
  public void setNomeComune(String nomeComune) {
    this.nomeComune = nomeComune;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUtenteSindacoComune modelUtenteSindacoComune = (ModelUtenteSindacoComune) o;
    return Objects.equals(istatComune, modelUtenteSindacoComune.istatComune) &&
        Objects.equals(nomeComune, modelUtenteSindacoComune.nomeComune);
  }

  @Override
  public int hashCode() {
    return Objects.hash(istatComune, nomeComune);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUtenteSindacoComune {\n");
    
    sb.append("    istatComune: ").append(toIndentedString(istatComune)).append("\n");
    sb.append("    nomeComune: ").append(toIndentedString(nomeComune)).append("\n");
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

