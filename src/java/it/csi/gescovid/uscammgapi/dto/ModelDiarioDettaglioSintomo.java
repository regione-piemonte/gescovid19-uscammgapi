package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelDiarioDettaglioSintomo   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer id = null;
  private String codice = null;
  private String nome = null;
  private Boolean misurabile = null;
  private String unitaMisura = null;
  private String note = null;
  private BigDecimal valore = null;

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

  /**
   * Eventuali note inserite dall&#39;utente
   **/
  

  @JsonProperty("note") 
 
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * Il valore della misurazione del sintomo
   **/
  

  @JsonProperty("valore") 
 
  public BigDecimal getValore() {
    return valore;
  }
  public void setValore(BigDecimal valore) {
    this.valore = valore;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelDiarioDettaglioSintomo modelDiarioDettaglioSintomo = (ModelDiarioDettaglioSintomo) o;
    return Objects.equals(id, modelDiarioDettaglioSintomo.id) &&
        Objects.equals(codice, modelDiarioDettaglioSintomo.codice) &&
        Objects.equals(nome, modelDiarioDettaglioSintomo.nome) &&
        Objects.equals(misurabile, modelDiarioDettaglioSintomo.misurabile) &&
        Objects.equals(unitaMisura, modelDiarioDettaglioSintomo.unitaMisura) &&
        Objects.equals(note, modelDiarioDettaglioSintomo.note) &&
        Objects.equals(valore, modelDiarioDettaglioSintomo.valore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codice, nome, misurabile, unitaMisura, note, valore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelDiarioDettaglioSintomo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    misurabile: ").append(toIndentedString(misurabile)).append("\n");
    sb.append("    unitaMisura: ").append(toIndentedString(unitaMisura)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    valore: ").append(toIndentedString(valore)).append("\n");
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

