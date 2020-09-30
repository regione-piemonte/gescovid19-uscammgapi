package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelDiarioDettaglioAutore   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String codiceFiscale = null;
  private String nome = null;
  private String cognome = null;
  private String telefono = null;
  private String mail = null;

  /**
   * il codice fiscale dell&#39;autore
   **/
  

  @JsonProperty("codice_fiscale") 
 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  /**
   * il nome dell&#39;autore
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * il cognome dell&#39;autore
   **/
  

  @JsonProperty("cognome") 
 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Il numero di telefono dell&#39;autore
   **/
  

  @JsonProperty("telefono") 
 
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * L&#39;indirizzo email dell&#39;autore
   **/
  

  @JsonProperty("mail") 
 
  public String getMail() {
    return mail;
  }
  public void setMail(String mail) {
    this.mail = mail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelDiarioDettaglioAutore modelDiarioDettaglioAutore = (ModelDiarioDettaglioAutore) o;
    return Objects.equals(codiceFiscale, modelDiarioDettaglioAutore.codiceFiscale) &&
        Objects.equals(nome, modelDiarioDettaglioAutore.nome) &&
        Objects.equals(cognome, modelDiarioDettaglioAutore.cognome) &&
        Objects.equals(telefono, modelDiarioDettaglioAutore.telefono) &&
        Objects.equals(mail, modelDiarioDettaglioAutore.mail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codiceFiscale, nome, cognome, telefono, mail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelDiarioDettaglioAutore {\n");
    
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    mail: ").append(toIndentedString(mail)).append("\n");
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

