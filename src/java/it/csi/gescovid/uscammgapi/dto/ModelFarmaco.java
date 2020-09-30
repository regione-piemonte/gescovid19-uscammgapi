package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelFarmaco   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String id = null;
  private String nome = null;
  private String descrizione = null;
  private Boolean consensoNecessario = null;
  private Integer prescrizioneTipoId = null;

  /**
   * identificativo univoco
   **/
  

  @JsonProperty("id") 
 
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Il nome del farmaco
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Una descrizione del farmaco
   **/
  

  @JsonProperty("descrizione") 
 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * Indica se il consenso � necessario o meno per questo farmaco
   **/
  

  @JsonProperty("consenso_necessario") 
 
  public Boolean isConsensoNecessario() {
    return consensoNecessario;
  }
  public void setConsensoNecessario(Boolean consensoNecessario) {
    this.consensoNecessario = consensoNecessario;
  }

  /**
   * Id del tipo della tipologia di prescrizione
   **/
  

  @JsonProperty("prescrizione_tipo_id") 
 
  public Integer getPrescrizioneTipoId() {
    return prescrizioneTipoId;
  }
  public void setPrescrizioneTipoId(Integer prescrizioneTipoId) {
    this.prescrizioneTipoId = prescrizioneTipoId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelFarmaco modelFarmaco = (ModelFarmaco) o;
    return Objects.equals(id, modelFarmaco.id) &&
        Objects.equals(nome, modelFarmaco.nome) &&
        Objects.equals(descrizione, modelFarmaco.descrizione) &&
        Objects.equals(consensoNecessario, modelFarmaco.consensoNecessario) &&
        Objects.equals(prescrizioneTipoId, modelFarmaco.prescrizioneTipoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descrizione, consensoNecessario, prescrizioneTipoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelFarmaco {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    consensoNecessario: ").append(toIndentedString(consensoNecessario)).append("\n");
    sb.append("    prescrizioneTipoId: ").append(toIndentedString(prescrizioneTipoId)).append("\n");
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

