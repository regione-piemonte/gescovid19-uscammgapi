package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelConsensoTipo;
import it.csi.gescovid.uscammgapi.dto.ModelDocumento;
import it.csi.gescovid.uscammgapi.dto.ModelFarmaco;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelConsensoFarmaco   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String id = null;
  private Date data = null;
  private Integer soggettoId = null;
  private Integer farmacoId = null;
  private Integer tipoId = null;
  private ModelConsensoTipo tipo = null;
  private ModelFarmaco farmaco = null;
  private List<ModelDocumento> documenti = new ArrayList<ModelDocumento>();

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
   * La data del consenso
   **/
  

  @JsonProperty("data") 
 
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }

  /**
   * L&#39;id del soggetto
   **/
  

  @JsonProperty("soggetto_id") 
 
  public Integer getSoggettoId() {
    return soggettoId;
  }
  public void setSoggettoId(Integer soggettoId) {
    this.soggettoId = soggettoId;
  }

  /**
   * L&#39;id del farmaco
   **/
  

  @JsonProperty("farmaco_id") 
 
  public Integer getFarmacoId() {
    return farmacoId;
  }
  public void setFarmacoId(Integer farmacoId) {
    this.farmacoId = farmacoId;
  }

  /**
   * L&#39;id del tipo di consenso
   **/
  

  @JsonProperty("tipo_id") 
 
  public Integer getTipoId() {
    return tipoId;
  }
  public void setTipoId(Integer tipoId) {
    this.tipoId = tipoId;
  }

  /**
   **/
  

  @JsonProperty("tipo") 
 
  public ModelConsensoTipo getTipo() {
    return tipo;
  }
  public void setTipo(ModelConsensoTipo tipo) {
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
  

  @JsonProperty("documenti") 
 
  public List<ModelDocumento> getDocumenti() {
    return documenti;
  }
  public void setDocumenti(List<ModelDocumento> documenti) {
    this.documenti = documenti;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelConsensoFarmaco modelConsensoFarmaco = (ModelConsensoFarmaco) o;
    return Objects.equals(id, modelConsensoFarmaco.id) &&
        Objects.equals(data, modelConsensoFarmaco.data) &&
        Objects.equals(soggettoId, modelConsensoFarmaco.soggettoId) &&
        Objects.equals(farmacoId, modelConsensoFarmaco.farmacoId) &&
        Objects.equals(tipoId, modelConsensoFarmaco.tipoId) &&
        Objects.equals(tipo, modelConsensoFarmaco.tipo) &&
        Objects.equals(farmaco, modelConsensoFarmaco.farmaco) &&
        Objects.equals(documenti, modelConsensoFarmaco.documenti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, data, soggettoId, farmacoId, tipoId, tipo, farmaco, documenti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelConsensoFarmaco {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    soggettoId: ").append(toIndentedString(soggettoId)).append("\n");
    sb.append("    farmacoId: ").append(toIndentedString(farmacoId)).append("\n");
    sb.append("    tipoId: ").append(toIndentedString(tipoId)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    farmaco: ").append(toIndentedString(farmaco)).append("\n");
    sb.append("    documenti: ").append(toIndentedString(documenti)).append("\n");
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

