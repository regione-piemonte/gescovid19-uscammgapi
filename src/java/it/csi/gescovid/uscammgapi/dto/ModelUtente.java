package it.csi.gescovid.uscammgapi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelUtente   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private String cfUtente = null;
  private String nome = null;
  private String cognome = null;
  private String telefono = null;
  private String email = null;
  private List<ModelUtenteElencoStruttura> elencoStruttura = new ArrayList<ModelUtenteElencoStruttura>();
  private List<ModelProfilo> elencoProfili = new ArrayList<ModelProfilo>();

  /**
   * Il codice fiscale dell&#39;utente loggato
   **/
  

  @JsonProperty("cfUtente") 
  public String getCfUtente() {
    return cfUtente;
  }
  public void setCfUtente(String cfUtente) {
    this.cfUtente = cfUtente;
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
   * il cognome dell&#39;utente
   **/
  

  @JsonProperty("cognome") 
  public String getCognome() {
    return cognome;
  }
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Il numero di telefono dell&#39;utente
   **/
  

  @JsonProperty("telefono") 
  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * L&#39;indirizzo email
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
  

  @JsonProperty("elencoStruttura") 
  public List<ModelUtenteElencoStruttura> getElencoStruttura() {
    return elencoStruttura;
  }
  public void setElencoStruttura(List<ModelUtenteElencoStruttura> elencoStruttura) {
    this.elencoStruttura = elencoStruttura;
  }
  
  
  @JsonProperty("elencoProfili") 
  public List<ModelProfilo> getElencoProfili() {
    return elencoProfili;
  }

  public void setElencoProfili(List<ModelProfilo> elencoProfili) {
	this.elencoProfili = elencoProfili;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUtente modelUtente = (ModelUtente) o;
    return Objects.equals(cfUtente, modelUtente.cfUtente) &&
        Objects.equals(nome, modelUtente.nome) &&
        Objects.equals(cognome, modelUtente.cognome) &&
        Objects.equals(telefono, modelUtente.telefono) &&
        Objects.equals(email, modelUtente.email) &&
        Objects.equals(elencoStruttura, modelUtente.elencoStruttura)&&
        Objects.equals(elencoProfili, modelUtente.elencoProfili);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cfUtente, nome, cognome, telefono, email, elencoStruttura, elencoProfili);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUtente {\n");
    
    sb.append("    cfUtente: ").append(toIndentedString(cfUtente)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    elencoStruttura: ").append(toIndentedString(elencoStruttura)).append("\n");
    sb.append("    elencoProfili: ").append(toIndentedString(elencoProfili)).append("\n");
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

