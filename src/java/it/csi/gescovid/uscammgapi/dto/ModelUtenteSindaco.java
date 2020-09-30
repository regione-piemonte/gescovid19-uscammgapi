package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteSindacoComune;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelUtenteSindaco   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String cfUtente = null;
  private String comuneIstat = null;
  private String cognome = null;
  private String nome = null;
  private String telefono = null;
  private String email = null;
  private ModelUtenteSindacoComune comune = null;

  /**
   **/
  

  @JsonProperty("cfUtente") 
 
  public String getCfUtente() {
    return cfUtente;
  }
  public void setCfUtente(String cfUtente) {
    this.cfUtente = cfUtente;
  }

  /**
   **/
  

  @JsonProperty("comuneIstat") 
 
  public String getComuneIstat() {
    return comuneIstat;
  }
  public void setComuneIstat(String comuneIstat) {
    this.comuneIstat = comuneIstat;
  }

  /**
   **/
  

  @JsonProperty("cognome") 
 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   **/
  

  @JsonProperty("telefono") 
 
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   **/
  

  @JsonProperty("email") 
 
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   **/
  

  @JsonProperty("comune") 
 
  public ModelUtenteSindacoComune getComune() {
    return comune;
  }
  public void setComune(ModelUtenteSindacoComune comune) {
    this.comune = comune;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUtenteSindaco modelUtenteSindaco = (ModelUtenteSindaco) o;
    return Objects.equals(cfUtente, modelUtenteSindaco.cfUtente) &&
        Objects.equals(comuneIstat, modelUtenteSindaco.comuneIstat) &&
        Objects.equals(cognome, modelUtenteSindaco.cognome) &&
        Objects.equals(nome, modelUtenteSindaco.nome) &&
        Objects.equals(telefono, modelUtenteSindaco.telefono) &&
        Objects.equals(email, modelUtenteSindaco.email) &&
        Objects.equals(comune, modelUtenteSindaco.comune);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cfUtente, comuneIstat, cognome, nome, telefono, email, comune);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUtenteSindaco {\n");
    
    sb.append("    cfUtente: ").append(toIndentedString(cfUtente)).append("\n");
    sb.append("    comuneIstat: ").append(toIndentedString(comuneIstat)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    comune: ").append(toIndentedString(comune)).append("\n");
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

