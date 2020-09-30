package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelInterventoAzione   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer id = null;
  private String codice = null;
  private String nome = null;

  /**
   * L&#39;id dell&#39;azione
   **/
  

  @JsonProperty("id") 
 
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Codice univoco della tipologia
   **/
  

  @JsonProperty("codice") 
 
  public String getCodice() {
    return codice;
  }
  public void setCodice(String codice) {
    this.codice = codice;
  }

  /**
   * Nome della tipologia da mostrare sulla UI
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelInterventoAzione modelInterventoAzione = (ModelInterventoAzione) o;
    return Objects.equals(id, modelInterventoAzione.id) &&
        Objects.equals(codice, modelInterventoAzione.codice) &&
        Objects.equals(nome, modelInterventoAzione.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codice, nome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelInterventoAzione {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codice: ").append(toIndentedString(codice)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
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

