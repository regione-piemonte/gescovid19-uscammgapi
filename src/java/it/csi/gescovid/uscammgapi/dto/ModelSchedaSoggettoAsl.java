package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSchedaSoggettoAsl   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codice = null;
  private String nome = null;
  private String descrizione = null;
  private String regioneCodice = null;
  private String regioneNome = null;
  private Integer asrId = null;

  /**
   * Il codice dell&#39;ASL
   **/
  

  @JsonProperty("codice") 
 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * Il nome dell&#39;ASL
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * La descrizione estesa dell&#39;ASL
   **/
  

  @JsonProperty("descrizione") 
 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * Il codice della regione di appartenenza
   **/
  

  @JsonProperty("regione_codice") 
 
  public String getRegioneCodice() {
    return regioneCodice;
  }
  public void setRegioneCodice(String regioneCodice) {
    this.regioneCodice = regioneCodice;
  }

  /**
   * Il nome della regione di appartenenza
   **/
  

  @JsonProperty("regione_nome") 
 
  public String getRegioneNome() {
    return regioneNome;
  }
  public void setRegioneNome(String regioneNome) {
    this.regioneNome = regioneNome;
  }

  /**
   * L&#39;id dell&#39;asr di appartenenza
   **/
  

  @JsonProperty("asr_id") 
 
  public Integer getAsrId() {
    return asrId;
  }
  public void setAsrId(Integer asrId) {
    this.asrId = asrId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSchedaSoggettoAsl modelSchedaSoggettoAsl = (ModelSchedaSoggettoAsl) o;
    return Objects.equals(codice, modelSchedaSoggettoAsl.codice) &&
        Objects.equals(nome, modelSchedaSoggettoAsl.nome) &&
        Objects.equals(descrizione, modelSchedaSoggettoAsl.descrizione) &&
        Objects.equals(regioneCodice, modelSchedaSoggettoAsl.regioneCodice) &&
        Objects.equals(regioneNome, modelSchedaSoggettoAsl.regioneNome) &&
        Objects.equals(asrId, modelSchedaSoggettoAsl.asrId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codice, nome, descrizione, regioneCodice, regioneNome, asrId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSchedaSoggettoAsl {\n");
    
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    regioneCodice: ").append(toIndentedString(regioneCodice)).append("\n");
    sb.append("    regioneNome: ").append(toIndentedString(regioneNome)).append("\n");
    sb.append("    asrId: ").append(toIndentedString(asrId)).append("\n");
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

