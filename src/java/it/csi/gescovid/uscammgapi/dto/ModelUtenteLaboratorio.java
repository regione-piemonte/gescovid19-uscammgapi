package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelUtenteLaboratorio   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idLaboratorio = null;
  private String descrizione = null;
  private String siglaLaboratorio = null;
  private Integer capacitaGiornaliera = null;

  /**
   * L&#39;id del laboratorio
   **/
  

  @JsonProperty("idLaboratorio") 
 
  public Integer getIdLaboratorio() {
    return idLaboratorio;
  }
  public void setIdLaboratorio(Integer idLaboratorio) {
    this.idLaboratorio = idLaboratorio;
  }

  /**
   * La descrizione del laboratorio
   **/
  

  @JsonProperty("descrizione") 
 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * La sigla del laboratorio
   **/
  

  @JsonProperty("siglaLaboratorio") 
 
  public String getSiglaLaboratorio() {
    return siglaLaboratorio;
  }
  public void setSiglaLaboratorio(String siglaLaboratorio) {
    this.siglaLaboratorio = siglaLaboratorio;
  }

  /**
   * La capacit� giornalier� del laboratorio
   **/
  

  @JsonProperty("capacitaGiornaliera") 
 
  public Integer getCapacitaGiornaliera() {
    return capacitaGiornaliera;
  }
  public void setCapacitaGiornaliera(Integer capacitaGiornaliera) {
    this.capacitaGiornaliera = capacitaGiornaliera;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUtenteLaboratorio modelUtenteLaboratorio = (ModelUtenteLaboratorio) o;
    return Objects.equals(idLaboratorio, modelUtenteLaboratorio.idLaboratorio) &&
        Objects.equals(descrizione, modelUtenteLaboratorio.descrizione) &&
        Objects.equals(siglaLaboratorio, modelUtenteLaboratorio.siglaLaboratorio) &&
        Objects.equals(capacitaGiornaliera, modelUtenteLaboratorio.capacitaGiornaliera);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idLaboratorio, descrizione, siglaLaboratorio, capacitaGiornaliera);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUtenteLaboratorio {\n");
    
    sb.append("    idLaboratorio: ").append(toIndentedString(idLaboratorio)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    siglaLaboratorio: ").append(toIndentedString(siglaLaboratorio)).append("\n");
    sb.append("    capacitaGiornaliera: ").append(toIndentedString(capacitaGiornaliera)).append("\n");
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

