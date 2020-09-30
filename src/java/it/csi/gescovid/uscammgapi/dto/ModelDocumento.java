package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelDocumento   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String id = null;
  private String nome = null;
  private Integer dimensione = null;
  private String note = null;
  private Integer tipoId = null;

  /**
   * identificativo unico del documento
   **/
  

  @JsonProperty("id") 
 
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Il nome del documento
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * dimensione del documento
   **/
  

  @JsonProperty("dimensione") 
 
  public Integer getDimensione() {
    return dimensione;
  }
  public void setDimensione(Integer dimensione) {
    this.dimensione = dimensione;
  }

  /**
   * Note a corredo del documento
   **/
  

  @JsonProperty("note") 
 
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * Id del tipo di documento
   **/
  

  @JsonProperty("tipo_id") 
 
  public Integer getTipoId() {
    return tipoId;
  }
  public void setTipoId(Integer tipoId) {
    this.tipoId = tipoId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelDocumento modelDocumento = (ModelDocumento) o;
    return Objects.equals(id, modelDocumento.id) &&
        Objects.equals(nome, modelDocumento.nome) &&
        Objects.equals(dimensione, modelDocumento.dimensione) &&
        Objects.equals(note, modelDocumento.note) &&
        Objects.equals(tipoId, modelDocumento.tipoId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, dimensione, note, tipoId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelDocumento {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    dimensione: ").append(toIndentedString(dimensione)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    tipoId: ").append(toIndentedString(tipoId)).append("\n");
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

