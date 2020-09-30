package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSoggettoSintomo   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idSintomo = null;
  private Integer idDecorso = null;
  private BigDecimal temperatura = null;
  private String flgDispnea = null;
  private String flgGusto = null;
  private String flgOlfatto = null;
  private String flgTosse = null;
  private String flgDoloriMusc = null;
  private String flgStanchezza = null;
  private String flgCongiuntivite = null;
  private String flgDiarrea = null;
  private String flgRaffreddore = null;
  
  private String flgCefalea = null;
  private String flgFaringodinia = null;
  
  private String noteSintomo = null;
  
  
  
  @JsonProperty("flgCefalea") 
  public String getFlgCefalea() {
	return flgCefalea;
  }
  
  public void setFlgCefalea(String flgCefalea) {
	this.flgCefalea = flgCefalea;
  }
  
  @JsonProperty("flgFaringodinia")
  public String getFlgFaringodinia() {
	return flgFaringodinia;
  }
  public void setFlgFaringodinia(String flgFaringodinia) {
	this.flgFaringodinia = flgFaringodinia;
  }
  
  
  /**
   **/
  

  @JsonProperty("idSintomo") 
 
  public Integer getIdSintomo() {
    return idSintomo;
  }
  public void setIdSintomo(Integer idSintomo) {
    this.idSintomo = idSintomo;
  }

  /**
   **/
  

  @JsonProperty("idDecorso") 
 
  public Integer getIdDecorso() {
    return idDecorso;
  }
  public void setIdDecorso(Integer idDecorso) {
    this.idDecorso = idDecorso;
  }

  /**
   **/
  

  @JsonProperty("temperatura") 
 
  public BigDecimal getTemperatura() {
    return temperatura;
  }
  public void setTemperatura(BigDecimal temperatura) {
    this.temperatura = temperatura;
  }

  /**
   **/
  

  @JsonProperty("flgDispnea") 
 
  public String getFlgDispnea() {
    return flgDispnea;
  }
  public void setFlgDispnea(String flgDispnea) {
    this.flgDispnea = flgDispnea;
  }

  /**
   **/
  

  @JsonProperty("flgGusto") 
 
  public String getFlgGusto() {
    return flgGusto;
  }
  public void setFlgGusto(String flgGusto) {
    this.flgGusto = flgGusto;
  }

  /**
   **/
  

  @JsonProperty("flgOlfatto") 
 
  public String getFlgOlfatto() {
    return flgOlfatto;
  }
  public void setFlgOlfatto(String flgOlfatto) {
    this.flgOlfatto = flgOlfatto;
  }

  /**
   **/
  

  @JsonProperty("flgTosse") 
 
  public String getFlgTosse() {
    return flgTosse;
  }
  public void setFlgTosse(String flgTosse) {
    this.flgTosse = flgTosse;
  }

  /**
   **/
  

  @JsonProperty("flgDoloriMusc") 
 
  public String getFlgDoloriMusc() {
    return flgDoloriMusc;
  }
  public void setFlgDoloriMusc(String flgDoloriMusc) {
    this.flgDoloriMusc = flgDoloriMusc;
  }

  /**
   **/
  

  @JsonProperty("flgStanchezza") 
 
  public String getFlgStanchezza() {
    return flgStanchezza;
  }
  public void setFlgStanchezza(String flgStanchezza) {
    this.flgStanchezza = flgStanchezza;
  }

  /**
   **/
  

  @JsonProperty("flgCongiuntivite") 
 
  public String getFlgCongiuntivite() {
    return flgCongiuntivite;
  }
  public void setFlgCongiuntivite(String flgCongiuntivite) {
    this.flgCongiuntivite = flgCongiuntivite;
  }

  /**
   **/
  

  @JsonProperty("flgDiarrea") 
 
  public String getFlgDiarrea() {
    return flgDiarrea;
  }
  public void setFlgDiarrea(String flgDiarrea) {
    this.flgDiarrea = flgDiarrea;
  }

  /**
   **/
  

  @JsonProperty("flgRaffreddore") 
 
  public String getFlgRaffreddore() {
    return flgRaffreddore;
  }
  public void setFlgRaffreddore(String flgRaffreddore) {
    this.flgRaffreddore = flgRaffreddore;
  }

  /**
   **/
  

  @JsonProperty("noteSintomo") 
 
  public String getNoteSintomo() {
    return noteSintomo;
  }
  public void setNoteSintomo(String noteSintomo) {
    this.noteSintomo = noteSintomo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoSintomo modelSoggettoSintomo = (ModelSoggettoSintomo) o;
    return Objects.equals(idSintomo, modelSoggettoSintomo.idSintomo) &&
        Objects.equals(idDecorso, modelSoggettoSintomo.idDecorso) &&
        Objects.equals(temperatura, modelSoggettoSintomo.temperatura) &&
        Objects.equals(flgDispnea, modelSoggettoSintomo.flgDispnea) &&
        Objects.equals(flgGusto, modelSoggettoSintomo.flgGusto) &&
        Objects.equals(flgOlfatto, modelSoggettoSintomo.flgOlfatto) &&
        Objects.equals(flgTosse, modelSoggettoSintomo.flgTosse) &&
        Objects.equals(flgDoloriMusc, modelSoggettoSintomo.flgDoloriMusc) &&
        Objects.equals(flgStanchezza, modelSoggettoSintomo.flgStanchezza) &&
        Objects.equals(flgCongiuntivite, modelSoggettoSintomo.flgCongiuntivite) &&
        Objects.equals(flgDiarrea, modelSoggettoSintomo.flgDiarrea) &&
        Objects.equals(flgRaffreddore, modelSoggettoSintomo.flgRaffreddore) &&
        Objects.equals(noteSintomo, modelSoggettoSintomo.noteSintomo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idSintomo, idDecorso, temperatura, flgDispnea, flgGusto, flgOlfatto, flgTosse, flgDoloriMusc, flgStanchezza, flgCongiuntivite, flgDiarrea, flgRaffreddore, noteSintomo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggettoSintomo {\n");
    
    sb.append("    idSintomo: ").append(toIndentedString(idSintomo)).append("\n");
    sb.append("    idDecorso: ").append(toIndentedString(idDecorso)).append("\n");
    sb.append("    temperatura: ").append(toIndentedString(temperatura)).append("\n");
    sb.append("    flgDispnea: ").append(toIndentedString(flgDispnea)).append("\n");
    sb.append("    flgGusto: ").append(toIndentedString(flgGusto)).append("\n");
    sb.append("    flgOlfatto: ").append(toIndentedString(flgOlfatto)).append("\n");
    sb.append("    flgTosse: ").append(toIndentedString(flgTosse)).append("\n");
    sb.append("    flgDoloriMusc: ").append(toIndentedString(flgDoloriMusc)).append("\n");
    sb.append("    flgStanchezza: ").append(toIndentedString(flgStanchezza)).append("\n");
    sb.append("    flgCongiuntivite: ").append(toIndentedString(flgCongiuntivite)).append("\n");
    sb.append("    flgDiarrea: ").append(toIndentedString(flgDiarrea)).append("\n");
    sb.append("    flgRaffreddore: ").append(toIndentedString(flgRaffreddore)).append("\n");
    sb.append("    noteSintomo: ").append(toIndentedString(noteSintomo)).append("\n");
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

