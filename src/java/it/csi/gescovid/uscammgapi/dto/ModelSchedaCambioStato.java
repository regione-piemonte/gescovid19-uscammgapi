package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaCambioStatoUtente;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaStato;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSchedaCambioStato   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Date dataInizio = null;
  private Date dataFine = null;
  private Integer schedaId = null;
  private ModelSchedaStato stato = null;
  private ModelSchedaCambioStatoUtente utente = null;

  /**
   * Indica quando la scheda � entrata in questo stato
   **/
  

  @JsonProperty("data_inizio") 
 
  public Date getDataInizio() {
    return dataInizio;
  }
  public void setDataInizio(Date dataInizio) {
    this.dataInizio = dataInizio;
  }

  /**
   * Indica quando la scheda � uscita da questo stato
   **/
  

  @JsonProperty("data_fine") 
 
  public Date getDataFine() {
    return dataFine;
  }
  public void setDataFine(Date dataFine) {
    this.dataFine = dataFine;
  }

  /**
   * L&#39;id della scheda
   **/
  

  @JsonProperty("scheda_id") 
 
  public Integer getSchedaId() {
    return schedaId;
  }
  public void setSchedaId(Integer schedaId) {
    this.schedaId = schedaId;
  }

  /**
   **/
  

  @JsonProperty("stato") 
 
  public ModelSchedaStato getStato() {
    return stato;
  }
  public void setStato(ModelSchedaStato stato) {
    this.stato = stato;
  }

  /**
   **/
  

  @JsonProperty("utente") 
 
  public ModelSchedaCambioStatoUtente getUtente() {
    return utente;
  }
  public void setUtente(ModelSchedaCambioStatoUtente utente) {
    this.utente = utente;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSchedaCambioStato modelSchedaCambioStato = (ModelSchedaCambioStato) o;
    return Objects.equals(dataInizio, modelSchedaCambioStato.dataInizio) &&
        Objects.equals(dataFine, modelSchedaCambioStato.dataFine) &&
        Objects.equals(schedaId, modelSchedaCambioStato.schedaId) &&
        Objects.equals(stato, modelSchedaCambioStato.stato) &&
        Objects.equals(utente, modelSchedaCambioStato.utente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataInizio, dataFine, schedaId, stato, utente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSchedaCambioStato {\n");
    
    sb.append("    dataInizio: ").append(toIndentedString(dataInizio)).append("\n");
    sb.append("    dataFine: ").append(toIndentedString(dataFine)).append("\n");
    sb.append("    schedaId: ").append(toIndentedString(schedaId)).append("\n");
    sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
    sb.append("    utente: ").append(toIndentedString(utente)).append("\n");
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

