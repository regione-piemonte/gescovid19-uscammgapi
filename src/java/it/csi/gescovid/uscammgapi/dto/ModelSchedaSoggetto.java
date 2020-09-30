package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaSoggettoComune;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSchedaSoggetto   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer id = null;
  private String codiceFiscale = null;
  private String nome = null;
  private String cognome = null;
  private Date dataNascita = null;
  private String email = null;
  private String telefono = null;
  private String domicilioIndirizzo = null;
  private String domicilioAsl = null;
  private String residenzaAsl = null;
  private ModelSchedaSoggettoComune domicilioComune = null;
  private ModelSchedaSoggettoComune residenzaComune = null;

  /**
   * L&#39;id del sogetto
   **/
  

  @JsonProperty("id") 
 
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Il codice fiscale del sogetto
   **/
  

  @JsonProperty("codice_fiscale") 
 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  /**
   * il nome del sogetto
   **/
  

  @JsonProperty("nome") 
 
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Il cognome del sogetto
   **/
  

  @JsonProperty("cognome") 
 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * la data di nascita del soggetto
   **/
  

  @JsonProperty("data_nascita") 
 
  public Date getDataNascita() {
    return dataNascita;
  }
  public void setDataNascita(Date dataNascita) {
    this.dataNascita = dataNascita;
  }

  /**
   * La mail del soggetto
   **/
  

  @JsonProperty("email") 
 
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Il telefono del soggetto
   **/
  

  @JsonProperty("telefono") 
 
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * L&#39;indirizzo di domicilio del soggetto
   **/
  

  @JsonProperty("domicilio_indirizzo") 
 
  public String getDomicilioIndirizzo() {
    return domicilioIndirizzo;
  }
  public void setDomicilioIndirizzo(String domicilioIndirizzo) {
    this.domicilioIndirizzo = domicilioIndirizzo;
  }

  /**
   * Il nome dell&#39;ASL di domicilio
   **/
  

  @JsonProperty("domicilio_asl") 
 
  public String getDomicilioAsl() {
    return domicilioAsl;
  }
  public void setDomicilioAsl(String domicilioAsl) {
    this.domicilioAsl = domicilioAsl;
  }

  /**
   * Il nome dell&#39;ASL di residenza
   **/
  

  @JsonProperty("residenza_asl") 
 
  public String getResidenzaAsl() {
    return residenzaAsl;
  }
  public void setResidenzaAsl(String residenzaAsl) {
    this.residenzaAsl = residenzaAsl;
  }

  /**
   **/
  

  @JsonProperty("domicilio_comune") 
 
  public ModelSchedaSoggettoComune getDomicilioComune() {
    return domicilioComune;
  }
  public void setDomicilioComune(ModelSchedaSoggettoComune domicilioComune) {
    this.domicilioComune = domicilioComune;
  }

  /**
   **/
  

  @JsonProperty("residenza_comune") 
 
  public ModelSchedaSoggettoComune getResidenzaComune() {
    return residenzaComune;
  }
  public void setResidenzaComune(ModelSchedaSoggettoComune residenzaComune) {
    this.residenzaComune = residenzaComune;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSchedaSoggetto modelSchedaSoggetto = (ModelSchedaSoggetto) o;
    return Objects.equals(id, modelSchedaSoggetto.id) &&
        Objects.equals(codiceFiscale, modelSchedaSoggetto.codiceFiscale) &&
        Objects.equals(nome, modelSchedaSoggetto.nome) &&
        Objects.equals(cognome, modelSchedaSoggetto.cognome) &&
        Objects.equals(dataNascita, modelSchedaSoggetto.dataNascita) &&
        Objects.equals(email, modelSchedaSoggetto.email) &&
        Objects.equals(telefono, modelSchedaSoggetto.telefono) &&
        Objects.equals(domicilioIndirizzo, modelSchedaSoggetto.domicilioIndirizzo) &&
        Objects.equals(domicilioAsl, modelSchedaSoggetto.domicilioAsl) &&
        Objects.equals(residenzaAsl, modelSchedaSoggetto.residenzaAsl) &&
        Objects.equals(domicilioComune, modelSchedaSoggetto.domicilioComune) &&
        Objects.equals(residenzaComune, modelSchedaSoggetto.residenzaComune);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codiceFiscale, nome, cognome, dataNascita, email, telefono, domicilioIndirizzo, domicilioAsl, residenzaAsl, domicilioComune, residenzaComune);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSchedaSoggetto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    dataNascita: ").append(toIndentedString(dataNascita)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    domicilioIndirizzo: ").append(toIndentedString(domicilioIndirizzo)).append("\n");
    sb.append("    domicilioAsl: ").append(toIndentedString(domicilioAsl)).append("\n");
    sb.append("    residenzaAsl: ").append(toIndentedString(residenzaAsl)).append("\n");
    sb.append("    domicilioComune: ").append(toIndentedString(domicilioComune)).append("\n");
    sb.append("    residenzaComune: ").append(toIndentedString(residenzaComune)).append("\n");
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

