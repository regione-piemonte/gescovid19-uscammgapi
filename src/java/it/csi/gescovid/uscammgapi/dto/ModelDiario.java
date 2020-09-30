package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglio;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelDiario   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer id = null;
  private Date dataCreazione = null;
  private List<ModelDiarioDettaglio> dettagli = new ArrayList<ModelDiarioDettaglio>();

  /**
   * L&#39;id del diario
   **/
  

  @JsonProperty("id") 
 
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * La data di creazione del diario
   **/
  

  @JsonProperty("data_creazione") 
 
  public Date getDataCreazione() {
    return dataCreazione;
  }
  public void setDataCreazione(Date dataCreazione) {
    this.dataCreazione = dataCreazione;
  }

  /**
   **/
  

  @JsonProperty("dettagli") 
 
  public List<ModelDiarioDettaglio> getDettagli() {
    return dettagli;
  }
  public void setDettagli(List<ModelDiarioDettaglio> dettagli) {
    this.dettagli = dettagli;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelDiario modelDiario = (ModelDiario) o;
    return Objects.equals(id, modelDiario.id) &&
        Objects.equals(dataCreazione, modelDiario.dataCreazione) &&
        Objects.equals(dettagli, modelDiario.dettagli);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dataCreazione, dettagli);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelDiario {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dataCreazione: ").append(toIndentedString(dataCreazione)).append("\n");
    sb.append("    dettagli: ").append(toIndentedString(dettagli)).append("\n");
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

