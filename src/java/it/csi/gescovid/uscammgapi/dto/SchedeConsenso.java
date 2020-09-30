package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.SchedeConsensoDocumenti;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class SchedeConsenso   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer tipo = null;
  private List<SchedeConsensoDocumenti> documenti = new ArrayList<SchedeConsensoDocumenti>();

  /**
   * La tipologia di consenso
   **/
  

  @JsonProperty("tipo") 
 
  public Integer getTipo() {
    return tipo;
  }
  public void setTipo(Integer tipo) {
    this.tipo = tipo;
  }

  /**
   **/
  

  @JsonProperty("documenti") 
 
  public List<SchedeConsensoDocumenti> getDocumenti() {
    return documenti;
  }
  public void setDocumenti(List<SchedeConsensoDocumenti> documenti) {
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
    SchedeConsenso schedeConsenso = (SchedeConsenso) o;
    return Objects.equals(tipo, schedeConsenso.tipo) &&
        Objects.equals(documenti, schedeConsenso.documenti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipo, documenti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchedeConsenso {\n");
    
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

