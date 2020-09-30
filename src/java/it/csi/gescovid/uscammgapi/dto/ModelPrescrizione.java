package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelFarmaco;
import it.csi.gescovid.uscammgapi.dto.ModelOssigenoterapia;
import it.csi.gescovid.uscammgapi.dto.ModelPrescrizioneTipo;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteContatto;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelPrescrizione   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String id = null;
  private String prescrizione = null;
  private String valore = null;
  private Boolean consegnatoDaFarmacia = null;
  private Date dataConsegnaFarmacia = null;
  private ModelUtenteContatto farmacista = null;
  private ModelPrescrizioneTipo tipo = null;
  private ModelFarmaco farmaco = null;
  private ModelOssigenoterapia ossigenoterapia = null;

  /**
   * L&#39;id della prescrizione
   **/
  

  @JsonProperty("id") 
 
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Un codice univoco
   **/
  

  @JsonProperty("prescrizione") 
 
  public String getPrescrizione() {
    return prescrizione;
  }
  public void setPrescrizione(String prescrizione) {
    this.prescrizione = prescrizione;
  }

  /**
   * Il valore associato alla prescrizione
   **/
  

  @JsonProperty("valore") 
 
  public String getValore() {
    return valore;
  }
  public void setValore(String valore) {
    this.valore = valore;
  }

  /**
   * Indica se il farmaco � stato consegnato in farmacia
   **/
  

  @JsonProperty("consegnato_da_farmacia") 
 
  public Boolean isConsegnatoDaFarmacia() {
    return consegnatoDaFarmacia;
  }
  public void setConsegnatoDaFarmacia(Boolean consegnatoDaFarmacia) {
    this.consegnatoDaFarmacia = consegnatoDaFarmacia;
  }

  /**
   * La data di consegna in farmacia
   **/
  

  @JsonProperty("data_consegna_farmacia") 
 
  public Date getDataConsegnaFarmacia() {
    return dataConsegnaFarmacia;
  }
  public void setDataConsegnaFarmacia(Date dataConsegnaFarmacia) {
    this.dataConsegnaFarmacia = dataConsegnaFarmacia;
  }

  /**
   **/
  

  @JsonProperty("farmacista") 
 
  public ModelUtenteContatto getFarmacista() {
    return farmacista;
  }
  public void setFarmacista(ModelUtenteContatto farmacista) {
    this.farmacista = farmacista;
  }

  /**
   **/
  

  @JsonProperty("tipo") 
 
  public ModelPrescrizioneTipo getTipo() {
    return tipo;
  }
  public void setTipo(ModelPrescrizioneTipo tipo) {
    this.tipo = tipo;
  }

  /**
   **/
  

  @JsonProperty("farmaco") 
 
  public ModelFarmaco getFarmaco() {
    return farmaco;
  }
  public void setFarmaco(ModelFarmaco farmaco) {
    this.farmaco = farmaco;
  }

  /**
   **/
  

  @JsonProperty("ossigenoterapia") 
 
  public ModelOssigenoterapia getOssigenoterapia() {
    return ossigenoterapia;
  }
  public void setOssigenoterapia(ModelOssigenoterapia ossigenoterapia) {
    this.ossigenoterapia = ossigenoterapia;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelPrescrizione modelPrescrizione = (ModelPrescrizione) o;
    return Objects.equals(id, modelPrescrizione.id) &&
        Objects.equals(prescrizione, modelPrescrizione.prescrizione) &&
        Objects.equals(valore, modelPrescrizione.valore) &&
        Objects.equals(consegnatoDaFarmacia, modelPrescrizione.consegnatoDaFarmacia) &&
        Objects.equals(dataConsegnaFarmacia, modelPrescrizione.dataConsegnaFarmacia) &&
        Objects.equals(farmacista, modelPrescrizione.farmacista) &&
        Objects.equals(tipo, modelPrescrizione.tipo) &&
        Objects.equals(farmaco, modelPrescrizione.farmaco) &&
        Objects.equals(ossigenoterapia, modelPrescrizione.ossigenoterapia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, prescrizione, valore, consegnatoDaFarmacia, dataConsegnaFarmacia, farmacista, tipo, farmaco, ossigenoterapia);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelPrescrizione {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    prescrizione: ").append(toIndentedString(prescrizione)).append("\n");
    sb.append("    valore: ").append(toIndentedString(valore)).append("\n");
    sb.append("    consegnatoDaFarmacia: ").append(toIndentedString(consegnatoDaFarmacia)).append("\n");
    sb.append("    dataConsegnaFarmacia: ").append(toIndentedString(dataConsegnaFarmacia)).append("\n");
    sb.append("    farmacista: ").append(toIndentedString(farmacista)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    farmaco: ").append(toIndentedString(farmaco)).append("\n");
    sb.append("    ossigenoterapia: ").append(toIndentedString(ossigenoterapia)).append("\n");
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

