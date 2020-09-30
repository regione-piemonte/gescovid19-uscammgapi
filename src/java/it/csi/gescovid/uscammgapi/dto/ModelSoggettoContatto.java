package it.csi.gescovid.uscammgapi.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.SoggettoContatto;

public class ModelSoggettoContatto   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idSoggetto = null;
  private String codiceFiscale = null;
  private String cognome = null;
  private String nome = null;
  //private String indirizzodomicilio = null;
  private String telefonoRecapito = null;
  private Date dataNascita = null;
  private String aslResidenza = null;
  private String aslDomicilio = null;
  private String email = null;

  
  
  @JsonProperty("idSoggetto") 
  public Integer getIdSoggetto() {
    return idSoggetto;
  }
  public void setIdSoggetto(Integer idSoggetto) {
    this.idSoggetto = idSoggetto;
  }

  

  @JsonProperty("codiceFiscale") 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

 
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
  @JsonProperty("telefonoRecapito") 
  public String getTelefonoRecapito() {
    return telefonoRecapito;
  }
  public void setTelefonoRecapito(String telefonoRecapito) {
    this.telefonoRecapito = telefonoRecapito;
  }

  /**
   **/
  @JsonProperty("dataNascita") 
  public Date getDataNascita() {
    return dataNascita;
  }
  public void setDataNascita(Date dataNascita) {
    this.dataNascita = dataNascita;
  }

  /**
   **/
  @JsonProperty("aslResidenza") 
  public String getAslResidenza() {
    return aslResidenza;
  }
  public void setAslResidenza(String aslResidenza) {
    this.aslResidenza = aslResidenza;
  }

  /**
   **/
  @JsonProperty("aslDomicilio") 
  public String getAslDomicilio() {
    return aslDomicilio;
  }
  public void setAslDomicilio(String aslDomicilio) {
    this.aslDomicilio = aslDomicilio;
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoContatto modelSoggetto = (ModelSoggettoContatto) o;
    return Objects.equals(idSoggetto, modelSoggetto.idSoggetto) &&
        Objects.equals(codiceFiscale, modelSoggetto.codiceFiscale) &&
        Objects.equals(cognome, modelSoggetto.cognome) &&
        Objects.equals(nome, modelSoggetto.nome) &&
        Objects.equals(telefonoRecapito, modelSoggetto.telefonoRecapito) &&
        Objects.equals(dataNascita, modelSoggetto.dataNascita) &&
        Objects.equals(aslResidenza, modelSoggetto.aslResidenza) &&
        Objects.equals(aslDomicilio, modelSoggetto.aslDomicilio) &&
        Objects.equals(email, modelSoggetto.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idSoggetto, codiceFiscale, cognome, nome, telefonoRecapito, dataNascita, aslResidenza, aslDomicilio, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggetto {\n");
    
    sb.append("    idSoggetto: ").append(toIndentedString(idSoggetto)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    telefonoRecapito: ").append(toIndentedString(telefonoRecapito)).append("\n");
    sb.append("    dataNascita: ").append(toIndentedString(dataNascita)).append("\n");
    sb.append("    aslResidenza: ").append(toIndentedString(aslResidenza)).append("\n");
    sb.append("    aslDomicilio: ").append(toIndentedString(aslDomicilio)).append("\n");
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

