package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelIstitutoScolastico   {
 
  
  private Integer idIstituto 			=null; 				
  private String  codiceIstituto 		= null;		
  private String  denominazioneIstituto = null;		
  private String  indirizzoIstituto 	= null;		
  private String  comuneIstituto 		= null;	
  private String  provinciaIstituto 	= null;		
  private String  telIstituto 			= null;	
  private String  ordineIstituto        = null; 


  @JsonProperty("id_istituto") 
  public Integer getIdIstituto() {
	  return idIstituto;
  }
  public void setIdIstituto(Integer idIstituto) {
	  this.idIstituto = idIstituto;
  }
  
  @JsonProperty("codice_istituto") 
  public String getCodiceIstituto() {
	  return codiceIstituto;
  }
  public void setCodiceIstituto(String codiceIstituto) {
	  this.codiceIstituto = codiceIstituto;
  }
  
  @JsonProperty("denominazione_istituto") 
  public String getDenominazioneIstituto() {
	  return denominazioneIstituto;
  }  
  public void setDenominazioneIstituto(String denominazioneIstituto) {
	  this.denominazioneIstituto = denominazioneIstituto;
  }
  
  @JsonProperty("indirizzo_istituto") 
  public String getIndirizzoIstituto() {
	  return indirizzoIstituto;
  }
  public void setIndirizzoIstituto(String indirizzoIstituto) {
	  this.indirizzoIstituto = indirizzoIstituto;
  }
  
  @JsonProperty("comune_istituto") 
  public String getComuneIstituto() {
	  return comuneIstituto;
  }
  public void setComuneIstituto(String comuneIstituto) {
	  this.comuneIstituto = comuneIstituto;
  }
  
  @JsonProperty("provincia_istituto") 
  public String getProvinciaIstituto() {
	  return provinciaIstituto;
  }
  public void setProvinciaIstituto(String provinciaIstituto) {
	  this.provinciaIstituto = provinciaIstituto;
  }
  
  @JsonProperty("tel_istituto") 
  public String getTelIstituto() {
	  return telIstituto;
  }
  public void setTelIstituto(String telIstituto) {
	  this.telIstituto = telIstituto;
  }
  
  @JsonProperty("ordine_istituto") 
  public String getOrdineIstituto() {
	  return ordineIstituto;
  }
  public void setOrdineIstituto(String ordineIstituto) {
	  this.ordineIstituto = ordineIstituto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelIstitutoScolastico modelIstitutoScolastico = (ModelIstitutoScolastico) o;
    return Objects.equals(idIstituto, modelIstitutoScolastico.idIstituto) &&
        Objects.equals(codiceIstituto, modelIstitutoScolastico.codiceIstituto) &&
        Objects.equals(denominazioneIstituto, modelIstitutoScolastico.denominazioneIstituto) &&
        Objects.equals(indirizzoIstituto, modelIstitutoScolastico.indirizzoIstituto) &&
        Objects.equals(comuneIstituto, modelIstitutoScolastico.comuneIstituto) &&
        Objects.equals(provinciaIstituto, modelIstitutoScolastico.provinciaIstituto) &&
        Objects.equals(telIstituto, modelIstitutoScolastico.telIstituto) &&
        Objects.equals(ordineIstituto, modelIstitutoScolastico.ordineIstituto) 
        ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIstituto  , 				
            codiceIstituto, 	
            denominazioneIstituto, 
            indirizzoIstituto,	
            comuneIstituto, 	
            provinciaIstituto, 	
            telIstituto, 		
            ordineIstituto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelIstitutoScolastico {\n");
	sb.append("idIstituto  				: ").append(toIndentedString(idIstituto)).append("\n");
    sb.append("codiceIstituto		    : ").append(toIndentedString(codiceIstituto)).append("\n");
    sb.append("denominazioneIstituto    : ").append(toIndentedString(denominazioneIstituto)).append("\n");
    sb.append("indirizzoIstituto	    : ").append(toIndentedString(indirizzoIstituto)).append("\n");
    sb.append("comuneIstituto		    : ").append(toIndentedString(comuneIstituto)).append("\n");
    sb.append("provinciaIstituto	    : ").append(toIndentedString(provinciaIstituto)).append("\n");
    sb.append("telIstituto				: ").append(toIndentedString(telIstituto)).append("\n");
    sb.append("ordineIstituto		    : ").append(toIndentedString(ordineIstituto)).append("\n");
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

