package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSoggettoDecodeTipoEvento   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idTipoEvento = null;
  private String descTipoEvento = null;
  private String segno = null;

  /**
   **/
  

  @JsonProperty("idTipoEvento") 
 
  public Integer getIdTipoEvento() {
    return idTipoEvento;
  }
  public void setIdTipoEvento(Integer idTipoEvento) {
    this.idTipoEvento = idTipoEvento;
  }

  /**
   **/
  

  @JsonProperty("descTipoEvento") 
 
  public String getDescTipoEvento() {
    return descTipoEvento;
  }
  public void setDescTipoEvento(String descTipoEvento) {
    this.descTipoEvento = descTipoEvento;
  }

  /**
   **/
  

  @JsonProperty("segno") 
 
  public String getSegno() {
    return segno;
  }
  public void setSegno(String segno) {
    this.segno = segno;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoDecodeTipoEvento modelSoggettoDecodeTipoEvento = (ModelSoggettoDecodeTipoEvento) o;
    return Objects.equals(idTipoEvento, modelSoggettoDecodeTipoEvento.idTipoEvento) &&
        Objects.equals(descTipoEvento, modelSoggettoDecodeTipoEvento.descTipoEvento) &&
        Objects.equals(segno, modelSoggettoDecodeTipoEvento.segno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTipoEvento, descTipoEvento, segno);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggettoDecodeTipoEvento {\n");
    
    sb.append("    idTipoEvento: ").append(toIndentedString(idTipoEvento)).append("\n");
    sb.append("    descTipoEvento: ").append(toIndentedString(descTipoEvento)).append("\n");
    sb.append("    segno: ").append(toIndentedString(segno)).append("\n");
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

