package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSoggettoAsr   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idAsr = null;
  private String descrizione = null;
  private Integer idEnte = null;

  /**
   * L&#39;id dell&#39;asr
   **/
  

  @JsonProperty("idAsr") 
 
  public Integer getIdAsr() {
    return idAsr;
  }
  public void setIdAsr(Integer idAsr) {
    this.idAsr = idAsr;
  }

  /**
   * Il nome dell&#39;asr
   **/
  

  @JsonProperty("descrizione") 
 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * L&#39;id dell&#39;ente
   **/
  

  @JsonProperty("idEnte") 
 
  public Integer getIdEnte() {
    return idEnte;
  }
  public void setIdEnte(Integer idEnte) {
    this.idEnte = idEnte;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoAsr modelSoggettoAsr = (ModelSoggettoAsr) o;
    return Objects.equals(idAsr, modelSoggettoAsr.idAsr) &&
        Objects.equals(descrizione, modelSoggettoAsr.descrizione) &&
        Objects.equals(idEnte, modelSoggettoAsr.idEnte);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAsr, descrizione, idEnte);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggettoAsr {\n");
    
    sb.append("    idAsr: ").append(toIndentedString(idAsr)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    idEnte: ").append(toIndentedString(idEnte)).append("\n");
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

