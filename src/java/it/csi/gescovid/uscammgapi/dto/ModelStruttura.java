package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelEnte;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelStruttura   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String id = null;
  private String nome = null;
  private String natura = null;
  private ModelEnte ente = null;

  /**
   * Un codice univoco
   **/
  

  @JsonProperty("id") 
 
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Una nome testuale da mostrare sulla UI
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Una nome testuale da mostrare sulla UI
   **/
  

  @JsonProperty("natura") 
 
  public String getNatura() {
    return natura;
  }
  public void setNatura(String natura) {
    this.natura = natura;
  }

  /**
   **/
  

  @JsonProperty("ente") 
 
  public ModelEnte getEnte() {
    return ente;
  }
  public void setEnte(ModelEnte ente) {
    this.ente = ente;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelStruttura modelStruttura = (ModelStruttura) o;
    return Objects.equals(id, modelStruttura.id) &&
        Objects.equals(nome, modelStruttura.nome) &&
        Objects.equals(natura, modelStruttura.natura) &&
        Objects.equals(ente, modelStruttura.ente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, natura, ente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelStruttura {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    natura: ").append(toIndentedString(natura)).append("\n");
    sb.append("    ente: ").append(toIndentedString(ente)).append("\n");
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

