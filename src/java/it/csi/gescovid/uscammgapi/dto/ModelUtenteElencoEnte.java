package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelUtenteElencoEnte   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idEnte = null;
  private String nome = null;
  private Integer totPostiTarget = null;

  /**
   **/
  

  @JsonProperty("idEnte") 
 
  public Integer getIdEnte() {
    return idEnte;
  }
  public void setIdEnte(Integer idEnte) {
    this.idEnte = idEnte;
  }

  /**
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   **/
  

  @JsonProperty("totPostiTarget") 
 
  public Integer getTotPostiTarget() {
    return totPostiTarget;
  }
  public void setTotPostiTarget(Integer totPostiTarget) {
    this.totPostiTarget = totPostiTarget;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUtenteElencoEnte modelUtenteElencoEnte = (ModelUtenteElencoEnte) o;
    return Objects.equals(idEnte, modelUtenteElencoEnte.idEnte) &&
        Objects.equals(nome, modelUtenteElencoEnte.nome) &&
        Objects.equals(totPostiTarget, modelUtenteElencoEnte.totPostiTarget);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEnte, nome, totPostiTarget);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUtenteElencoEnte {\n");
    
    sb.append("    idEnte: ").append(toIndentedString(idEnte)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    totPostiTarget: ").append(toIndentedString(totPostiTarget)).append("\n");
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

