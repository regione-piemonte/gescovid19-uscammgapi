package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class SchedeConsensoDocumenti   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String nome = null;
  private String base64 = null;

  /**
   * Nome del file
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * base64 del file
   **/
  

  @JsonProperty("base64") 
 
  public String getBase64() {
    return base64;
  }
  public void setBase64(String base64) {
    this.base64 = base64;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SchedeConsensoDocumenti schedeConsensoDocumenti = (SchedeConsensoDocumenti) o;
    return Objects.equals(nome, schedeConsensoDocumenti.nome) &&
        Objects.equals(base64, schedeConsensoDocumenti.base64);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, base64);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SchedeConsensoDocumenti {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    base64: ").append(toIndentedString(base64)).append("\n");
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

