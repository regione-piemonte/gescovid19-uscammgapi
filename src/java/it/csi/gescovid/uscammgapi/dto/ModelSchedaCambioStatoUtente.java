package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSchedaCambioStatoUtente   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codiceFiscale = null;
  private String nome = null;
  private String cognome = null;
  private String telefono = null;
  private String email = null;

  /**
   * Il codice fiscale dell&#39;utente
   **/
  

  @JsonProperty("codice_fiscale") 
 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  /**
   * Il nome dell&#39;utente
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Il cognome dell&#39;utente
   **/
  

  @JsonProperty("cognome") 
 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Il telefono dell&#39;utente
   **/
  

  @JsonProperty("telefono") 
 
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * L&#39;email dell&#39;utente
   **/
  

  @JsonProperty("email") 
 
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSchedaCambioStatoUtente modelSchedaCambioStatoUtente = (ModelSchedaCambioStatoUtente) o;
    return Objects.equals(codiceFiscale, modelSchedaCambioStatoUtente.codiceFiscale) &&
        Objects.equals(nome, modelSchedaCambioStatoUtente.nome) &&
        Objects.equals(cognome, modelSchedaCambioStatoUtente.cognome) &&
        Objects.equals(telefono, modelSchedaCambioStatoUtente.telefono) &&
        Objects.equals(email, modelSchedaCambioStatoUtente.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiceFiscale, nome, cognome, telefono, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSchedaCambioStatoUtente {\n");
    
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

