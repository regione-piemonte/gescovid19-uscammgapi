package it.csi.gescovid.uscammgapi.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class ModelSoggetto   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idSoggetto = null;
  private Integer idAsr = null;
  private Integer idTipoSoggetto = null;
  private String codiceFiscale = null;
  private String cognome = null;
  private String nome = null;
  private String comuneResidenzaIstat = null;
  private String comuneDomicilioIstat = null;
  private String indirizzodomicilio = null;
  private String telefonoRecapito = null;
  private Date dataNascita = null;
  private String aslResidenza = null;
  private String aslDomicilio = null;
  private String email = null;
  private Integer numeroCampioni = null;
  private Integer numeroDecorsi = null;
  private Integer ultimoIdTipoEvento = null;
  private Integer idAura = null;
  private ModelSoggettoMedico medico = null;
  private ModelSoggettoAsr asr = null;
  private ModelSoggettoComuneDomicilio comuneDomicilio = null;
  private ModelSoggettoComuneDomicilio comuneResidenza = null;
  private List<ModelSoggettoElencoTampone> elencoTampone = new ArrayList<ModelSoggettoElencoTampone>();
  private List<ModelSoggettoElencoDecorso> elencoDecorso = new ArrayList<ModelSoggettoElencoDecorso>();
  
  private List<ModelIstitutoScolastico> elencoIstitutoScolastico = new ArrayList<ModelIstitutoScolastico>();
  
  private List<ModelSoggettoContatto> elencoContattiDa;
  private List<ModelSoggettoContatto> elencoContattiA;
  
  @JsonProperty("elencoIstitutoScolastico") 
  public List<ModelIstitutoScolastico> getElencoIstitutoScolastico() {
	  return elencoIstitutoScolastico;
  }
  public void setElencoIstitutoScolastico(List<ModelIstitutoScolastico> elencoIstitutoScolastico) {
	  this.elencoIstitutoScolastico = elencoIstitutoScolastico;
  }
  
  @JsonProperty("elencoContattiDa") 
  public List<ModelSoggettoContatto> getElencoContattiDa() {
	return elencoContattiDa;
  }
  public void setElencoContattiDa(List<ModelSoggettoContatto> elencoContattiDa) {
	this.elencoContattiDa = elencoContattiDa;
  }
  
  @JsonProperty("elencoContattiA") 
  public List<ModelSoggettoContatto> getElencoContattiA() {
	return elencoContattiA;
  }
  public void setElencoContattiA(List<ModelSoggettoContatto> elencoContattiA) {
	this.elencoContattiA = elencoContattiA;
  }
  
  
  @JsonProperty("idSoggetto") 
  public Integer getIdSoggetto() {
    return idSoggetto;
  }
  public void setIdSoggetto(Integer idSoggetto) {
    this.idSoggetto = idSoggetto;
  }

  /**
   **/
  

  @JsonProperty("idAsr") 
 
  public Integer getIdAsr() {
    return idAsr;
  }
  public void setIdAsr(Integer idAsr) {
    this.idAsr = idAsr;
  }

  /**
   **/
  

  @JsonProperty("idTipoSoggetto") 
 
  public Integer getIdTipoSoggetto() {
    return idTipoSoggetto;
  }
  public void setIdTipoSoggetto(Integer idTipoSoggetto) {
    this.idTipoSoggetto = idTipoSoggetto;
  }

  /**
   **/
  

  @JsonProperty("codiceFiscale") 
 
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
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
  

  @JsonProperty("comuneResidenzaIstat") 
 
  public String getComuneResidenzaIstat() {
    return comuneResidenzaIstat;
  }
  public void setComuneResidenzaIstat(String comuneResidenzaIstat) {
    this.comuneResidenzaIstat = comuneResidenzaIstat;
  }

  /**
   **/
  

  @JsonProperty("comuneDomicilioIstat") 
 
  public String getComuneDomicilioIstat() {
    return comuneDomicilioIstat;
  }
  public void setComuneDomicilioIstat(String comuneDomicilioIstat) {
    this.comuneDomicilioIstat = comuneDomicilioIstat;
  }

  /**
   **/
  

  @JsonProperty("indirizzodomicilio") 
 
  public String getIndirizzodomicilio() {
    return indirizzodomicilio;
  }
  public void setIndirizzodomicilio(String indirizzodomicilio) {
    this.indirizzodomicilio = indirizzodomicilio;
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

  /**
   **/
  

  @JsonProperty("numeroCampioni") 
 
  public Integer getNumeroCampioni() {
    return numeroCampioni;
  }
  public void setNumeroCampioni(Integer numeroCampioni) {
    this.numeroCampioni = numeroCampioni;
  }

  /**
   **/
  

  @JsonProperty("numeroDecorsi") 
 
  public Integer getNumeroDecorsi() {
    return numeroDecorsi;
  }
  public void setNumeroDecorsi(Integer numeroDecorsi) {
    this.numeroDecorsi = numeroDecorsi;
  }

  /**
   **/
  

  @JsonProperty("ultimoIdTipoEvento") 
 
  public Integer getUltimoIdTipoEvento() {
    return ultimoIdTipoEvento;
  }
  public void setUltimoIdTipoEvento(Integer ultimoIdTipoEvento) {
    this.ultimoIdTipoEvento = ultimoIdTipoEvento;
  }

  /**
   **/
  

  @JsonProperty("idAura") 
 
  public Integer getIdAura() {
    return idAura;
  }
  public void setIdAura(Integer idAura) {
    this.idAura = idAura;
  }

  /**
   **/
  

  @JsonProperty("medico") 
 
  public ModelSoggettoMedico getMedico() {
    return medico;
  }
  public void setMedico(ModelSoggettoMedico medico) {
    this.medico = medico;
  }

  /**
   **/
  

  @JsonProperty("asr") 
 
  public ModelSoggettoAsr getAsr() {
    return asr;
  }
  public void setAsr(ModelSoggettoAsr asr) {
    this.asr = asr;
  }

  /**
   **/
  

  @JsonProperty("comuneDomicilio") 
 
  public ModelSoggettoComuneDomicilio getComuneDomicilio() {
    return comuneDomicilio;
  }
  public void setComuneDomicilio(ModelSoggettoComuneDomicilio comuneDomicilio) {
    this.comuneDomicilio = comuneDomicilio;
  }

  /**
   **/
  

  @JsonProperty("comuneResidenza") 
 
  public ModelSoggettoComuneDomicilio getComuneResidenza() {
    return comuneResidenza;
  }
  public void setComuneResidenza(ModelSoggettoComuneDomicilio comuneResidenza) {
    this.comuneResidenza = comuneResidenza;
  }

  /**
   **/
  

  @JsonProperty("elencoTampone") 
 
  public List<ModelSoggettoElencoTampone> getElencoTampone() {
    return elencoTampone;
  }
  public void setElencoTampone(List<ModelSoggettoElencoTampone> elencoTampone) {
    this.elencoTampone = elencoTampone;
  }

  /**
   **/
  

  @JsonProperty("elencoDecorso") 
 
  public List<ModelSoggettoElencoDecorso> getElencoDecorso() {
    return elencoDecorso;
  }
  public void setElencoDecorso(List<ModelSoggettoElencoDecorso> elencoDecorso) {
    this.elencoDecorso = elencoDecorso;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggetto modelSoggetto = (ModelSoggetto) o;
    return Objects.equals(idSoggetto, modelSoggetto.idSoggetto) &&
        Objects.equals(idAsr, modelSoggetto.idAsr) &&
        Objects.equals(idTipoSoggetto, modelSoggetto.idTipoSoggetto) &&
        Objects.equals(codiceFiscale, modelSoggetto.codiceFiscale) &&
        Objects.equals(cognome, modelSoggetto.cognome) &&
        Objects.equals(nome, modelSoggetto.nome) &&
        Objects.equals(comuneResidenzaIstat, modelSoggetto.comuneResidenzaIstat) &&
        Objects.equals(comuneDomicilioIstat, modelSoggetto.comuneDomicilioIstat) &&
        Objects.equals(indirizzodomicilio, modelSoggetto.indirizzodomicilio) &&
        Objects.equals(telefonoRecapito, modelSoggetto.telefonoRecapito) &&
        Objects.equals(dataNascita, modelSoggetto.dataNascita) &&
        Objects.equals(aslResidenza, modelSoggetto.aslResidenza) &&
        Objects.equals(aslDomicilio, modelSoggetto.aslDomicilio) &&
        Objects.equals(email, modelSoggetto.email) &&
        Objects.equals(numeroCampioni, modelSoggetto.numeroCampioni) &&
        Objects.equals(numeroDecorsi, modelSoggetto.numeroDecorsi) &&
        Objects.equals(ultimoIdTipoEvento, modelSoggetto.ultimoIdTipoEvento) &&
        Objects.equals(idAura, modelSoggetto.idAura) &&
        Objects.equals(medico, modelSoggetto.medico) &&
        Objects.equals(asr, modelSoggetto.asr) &&
        Objects.equals(comuneDomicilio, modelSoggetto.comuneDomicilio) &&
        Objects.equals(comuneResidenza, modelSoggetto.comuneResidenza) &&
        Objects.equals(elencoTampone, modelSoggetto.elencoTampone) &&
        Objects.equals(elencoIstitutoScolastico, modelSoggetto.elencoIstitutoScolastico) &&
        Objects.equals(elencoDecorso, modelSoggetto.elencoDecorso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idSoggetto, idAsr, idTipoSoggetto, codiceFiscale, cognome, nome, comuneResidenzaIstat, comuneDomicilioIstat, indirizzodomicilio, telefonoRecapito, dataNascita, aslResidenza, aslDomicilio, email, numeroCampioni, numeroDecorsi, 
    		ultimoIdTipoEvento, idAura, medico, asr, comuneDomicilio, 
    		comuneResidenza, elencoTampone, elencoDecorso, elencoIstitutoScolastico);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggetto {\n");
    
    sb.append("    idSoggetto: ").append(toIndentedString(idSoggetto)).append("\n");
    sb.append("    idAsr: ").append(toIndentedString(idAsr)).append("\n");
    sb.append("    idTipoSoggetto: ").append(toIndentedString(idTipoSoggetto)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    comuneResidenzaIstat: ").append(toIndentedString(comuneResidenzaIstat)).append("\n");
    sb.append("    comuneDomicilioIstat: ").append(toIndentedString(comuneDomicilioIstat)).append("\n");
    sb.append("    indirizzodomicilio: ").append(toIndentedString(indirizzodomicilio)).append("\n");
    sb.append("    telefonoRecapito: ").append(toIndentedString(telefonoRecapito)).append("\n");
    sb.append("    dataNascita: ").append(toIndentedString(dataNascita)).append("\n");
    sb.append("    aslResidenza: ").append(toIndentedString(aslResidenza)).append("\n");
    sb.append("    aslDomicilio: ").append(toIndentedString(aslDomicilio)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    numeroCampioni: ").append(toIndentedString(numeroCampioni)).append("\n");
    sb.append("    numeroDecorsi: ").append(toIndentedString(numeroDecorsi)).append("\n");
    sb.append("    ultimoIdTipoEvento: ").append(toIndentedString(ultimoIdTipoEvento)).append("\n");
    sb.append("    idAura: ").append(toIndentedString(idAura)).append("\n");
    sb.append("    medico: ").append(toIndentedString(medico)).append("\n");
    sb.append("    asr: ").append(toIndentedString(asr)).append("\n");
    sb.append("    comuneDomicilio: ").append(toIndentedString(comuneDomicilio)).append("\n");
    sb.append("    comuneResidenza: ").append(toIndentedString(comuneResidenza)).append("\n");
    sb.append("    elencoTampone: ").append(toIndentedString(elencoTampone)).append("\n");
    sb.append("    elencoDecorso: ").append(toIndentedString(elencoDecorso)).append("\n");
    sb.append("    elencoIstitutoScolastico: ").append(toIndentedString(elencoIstitutoScolastico)).append("\n");
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

