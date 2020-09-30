package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.gescovid.uscammgapi.dto.SchedeConsenso;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class SchedePrescrizioni   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String prescrizione = null;
  private String valore = null;
  private Integer tipo = null;
  private Integer farmaco = null;
  private Integer ossigenoterapia = null;
  private SchedeConsenso consenso = null;

  /**
   * La prescrizione descritta dal medico
   **/
  

  @JsonProperty("prescrizione") 
 
  public String getPrescrizione() {
    return prescrizione;
  }
  public void setPrescrizione(String prescrizione) {
    this.prescrizione = prescrizione;
  }

  /**
   * Il volore inserito dall&#39;utente
   **/
  

  @JsonProperty("valore") 
 
  public String getValore() {
    return valore;
  }
  public void setValore(String valore) {
    this.valore = valore;
  }

  /**
   * L&#39;id della tipologia di prescrizione
   **/
  

  @JsonProperty("tipo") 
 
  public Integer getTipo() {
    return tipo;
  }
  public void setTipo(Integer tipo) {
    this.tipo = tipo;
  }

  /**
   * L&#39;id del farmaco selezionato
   **/
  

  @JsonProperty("farmaco") 
 
  public Integer getFarmaco() {
    return farmaco;
  }
  public void setFarmaco(Integer farmaco) {
    this.farmaco = farmaco;
  }

  /**
   * L&#39;id dell&#39;ossigenoterapia selezionata
   **/
  

  @JsonProperty("ossigenoterapia") 
 
  public Integer getOssigenoterapia() {
    return ossigenoterapia;
  }
  public void setOssigenoterapia(Integer ossigenoterapia) {
    this.ossigenoterapia = ossigenoterapia;
  }

  /**
   **/
  

  @JsonProperty("consenso") 
 
  public SchedeConsenso getConsenso() {
    return consenso;
  }
  public void setConsenso(SchedeConsenso consenso) {
    this.consenso = consenso;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchedePrescrizioni schedePrescrizioni = (SchedePrescrizioni) o;
    return Objects.equals(prescrizione, schedePrescrizioni.prescrizione) &&
        Objects.equals(valore, schedePrescrizioni.valore) &&
        Objects.equals(tipo, schedePrescrizioni.tipo) &&
        Objects.equals(farmaco, schedePrescrizioni.farmaco) &&
        Objects.equals(ossigenoterapia, schedePrescrizioni.ossigenoterapia) &&
        Objects.equals(consenso, schedePrescrizioni.consenso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prescrizione, valore, tipo, farmaco, ossigenoterapia, consenso);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchedePrescrizioni {\n");
    
    sb.append("    prescrizione: ").append(toIndentedString(prescrizione)).append("\n");
    sb.append("    valore: ").append(toIndentedString(valore)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    farmaco: ").append(toIndentedString(farmaco)).append("\n");
    sb.append("    ossigenoterapia: ").append(toIndentedString(ossigenoterapia)).append("\n");
    sb.append("    consenso: ").append(toIndentedString(consenso)).append("\n");
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

