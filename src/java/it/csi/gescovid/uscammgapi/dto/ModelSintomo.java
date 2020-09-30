package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSintomo   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer id = null;
  private String codice = null;
  private String nome = null;
  private Boolean misurabile = null;
  private String unitaMisura = null;

  /**
   * L&#39;id del sintomo
   **/
  

  @JsonProperty("id") 
 
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Un codice univoco del sitomo
   **/
  

  @JsonProperty("codice") 
 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * nome del sintomo da mostrare sula UI
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Indica se il sintomo � misurabile o meno
   **/
  

  @JsonProperty("misurabile") 
 
  public Boolean isMisurabile() {
    return misurabile;
  }
  public void setMisurabile(Boolean misurabile) {
    this.misurabile = misurabile;
  }

  /**
   * L&#39;unit� di misura da usare per dare info
   **/
  

  @JsonProperty("unita_misura") 
 
  public String getUnitaMisura() {
    return unitaMisura;
  }
  public void setUnitaMisura(String unitaMisura) {
    this.unitaMisura = unitaMisura;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSintomo modelSintomo = (ModelSintomo) o;
    return Objects.equals(id, modelSintomo.id) &&
        Objects.equals(codice, modelSintomo.codice) &&
        Objects.equals(nome, modelSintomo.nome) &&
        Objects.equals(misurabile, modelSintomo.misurabile) &&
        Objects.equals(unitaMisura, modelSintomo.unitaMisura);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codice, nome, misurabile, unitaMisura);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSintomo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    misurabile: ").append(toIndentedString(misurabile)).append("\n");
    sb.append("    unitaMisura: ").append(toIndentedString(unitaMisura)).append("\n");
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

