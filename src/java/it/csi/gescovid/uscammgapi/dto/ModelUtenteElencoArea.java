package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelUtenteElencoArea   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idArea = null;
  private String idStruttura = null;
  private String idDArea = null;
  private String nome = null;
  private String responsabile = null;
  private String riferimento = null;
  private String statoValidita = null;

  /**
   **/
  

  @JsonProperty("idArea") 
 
  public Integer getIdArea() {
    return idArea;
  }
  public void setIdArea(Integer idArea) {
    this.idArea = idArea;
  }

  /**
   **/
  

  @JsonProperty("idStruttura") 
 
  public String getIdStruttura() {
    return idStruttura;
  }
  public void setIdStruttura(String idStruttura) {
    this.idStruttura = idStruttura;
  }

  /**
   **/
  

  @JsonProperty("idDArea") 
 
  public String getIdDArea() {
    return idDArea;
  }
  public void setIdDArea(String idDArea) {
    this.idDArea = idDArea;
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
   * Potrebbe essere un oggetto ma non conosco la struttura
   **/
  

  @JsonProperty("responsabile") 
 
  public String getResponsabile() {
    return responsabile;
  }
  public void setResponsabile(String responsabile) {
    this.responsabile = responsabile;
  }

  /**
   * Potrebbe essere un oggetto ma non conosco la struttura
   **/
  

  @JsonProperty("riferimento") 
 
  public String getRiferimento() {
    return riferimento;
  }
  public void setRiferimento(String riferimento) {
    this.riferimento = riferimento;
  }

  /**
   **/
  

  @JsonProperty("statoValidita") 
 
  public String getStatoValidita() {
    return statoValidita;
  }
  public void setStatoValidita(String statoValidita) {
    this.statoValidita = statoValidita;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUtenteElencoArea modelUtenteElencoArea = (ModelUtenteElencoArea) o;
    return Objects.equals(idArea, modelUtenteElencoArea.idArea) &&
        Objects.equals(idStruttura, modelUtenteElencoArea.idStruttura) &&
        Objects.equals(idDArea, modelUtenteElencoArea.idDArea) &&
        Objects.equals(nome, modelUtenteElencoArea.nome) &&
        Objects.equals(responsabile, modelUtenteElencoArea.responsabile) &&
        Objects.equals(riferimento, modelUtenteElencoArea.riferimento) &&
        Objects.equals(statoValidita, modelUtenteElencoArea.statoValidita);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idArea, idStruttura, idDArea, nome, responsabile, riferimento, statoValidita);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUtenteElencoArea {\n");
    
    sb.append("    idArea: ").append(toIndentedString(idArea)).append("\n");
    sb.append("    idStruttura: ").append(toIndentedString(idStruttura)).append("\n");
    sb.append("    idDArea: ").append(toIndentedString(idDArea)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    responsabile: ").append(toIndentedString(responsabile)).append("\n");
    sb.append("    riferimento: ").append(toIndentedString(riferimento)).append("\n");
    sb.append("    statoValidita: ").append(toIndentedString(statoValidita)).append("\n");
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

