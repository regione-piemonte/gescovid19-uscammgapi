package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelUtenteElencoProfilo   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idProfilo = null;
  private String nomeProfilo = null;

  /**
   **/
  

  @JsonProperty("idProfilo") 
 
  public Integer getIdProfilo() {
    return idProfilo;
  }
  public void setIdProfilo(Integer idProfilo) {
    this.idProfilo = idProfilo;
  }

  /**
   **/
  

  @JsonProperty("nomeProfilo") 
 
  public String getNomeProfilo() {
    return nomeProfilo;
  }
  public void setNomeProfilo(String nomeProfilo) {
    this.nomeProfilo = nomeProfilo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUtenteElencoProfilo modelUtenteElencoProfilo = (ModelUtenteElencoProfilo) o;
    return Objects.equals(idProfilo, modelUtenteElencoProfilo.idProfilo) &&
        Objects.equals(nomeProfilo, modelUtenteElencoProfilo.nomeProfilo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idProfilo, nomeProfilo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUtenteElencoProfilo {\n");
    
    sb.append("    idProfilo: ").append(toIndentedString(idProfilo)).append("\n");
    sb.append("    nomeProfilo: ").append(toIndentedString(nomeProfilo)).append("\n");
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

