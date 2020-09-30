package it.csi.gescovid.uscammgapi.dto;

import java.util.Date;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.TamponeMotivo;

public class ModelSoggettoElencoTampone   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idTampone = null;
  private Integer idSoggetto = null;
  private Integer idLaboratorio = null;
  private String criterioEpidemiologicoCovid19 = null;
  private Integer idTestCovid = null;
  private Integer idRisTamp = null;
  private String tamponeAutorizzato = null;
  private Date dataInserimentoRichiesta = null;
  private Date dataUltimaModifica = null;
  private String utenteUltimaModifica = null;
  private Date dataTest = null;
  private String medicoRichiedente = null;
  private String contattoRichiedente = null;
  private String risTampone = null;
  private ModelSoggettoLaboratorio laboratorio = null;
  private ModelSoggettoTestCovid testCovid = null;
  
  private TamponeMotivo tamponeMotivo =null;

  
  @JsonProperty("tamponeMotivo")
  public TamponeMotivo getTamponeMotivo() {
	return tamponeMotivo;
  }

  public void setTamponeMotivo(TamponeMotivo tamponeMotivo) {
		this.tamponeMotivo = tamponeMotivo;
  }

  @JsonProperty("idTampone") 
  public Integer getIdTampone() {
    return idTampone;
  }
  public void setIdTampone(Integer idTampone) {
    this.idTampone = idTampone;
  }

  /**
   **/
  

  @JsonProperty("idSoggetto") 
 
  public Integer getIdSoggetto() {
    return idSoggetto;
  }
  public void setIdSoggetto(Integer idSoggetto) {
    this.idSoggetto = idSoggetto;
  }

  /**
   **/
  

  @JsonProperty("idLaboratorio") 
 
  public Integer getIdLaboratorio() {
    return idLaboratorio;
  }
  public void setIdLaboratorio(Integer idLaboratorio) {
    this.idLaboratorio = idLaboratorio;
  }

  /**
   **/
  

  @JsonProperty("criterioEpidemiologicoCovid19") 
 
  public String getCriterioEpidemiologicoCovid19() {
    return criterioEpidemiologicoCovid19;
  }
  public void setCriterioEpidemiologicoCovid19(String criterioEpidemiologicoCovid19) {
    this.criterioEpidemiologicoCovid19 = criterioEpidemiologicoCovid19;
  }

  /**
   **/
  

  @JsonProperty("idTestCovid") 
 
  public Integer getIdTestCovid() {
    return idTestCovid;
  }
  public void setIdTestCovid(Integer idTestCovid) {
    this.idTestCovid = idTestCovid;
  }

  /**
   **/
  

  @JsonProperty("idRisTamp") 
 
  public Integer getIdRisTamp() {
    return idRisTamp;
  }
  public void setIdRisTamp(Integer idRisTamp) {
    this.idRisTamp = idRisTamp;
  }

  /**
   **/
  

  @JsonProperty("tamponeAutorizzato") 
 
  public String getTamponeAutorizzato() {
    return tamponeAutorizzato;
  }
  public void setTamponeAutorizzato(String tamponeAutorizzato) {
    this.tamponeAutorizzato = tamponeAutorizzato;
  }

  /**
   **/
  

  @JsonProperty("dataInserimentoRichiesta") 
 
  public Date getDataInserimentoRichiesta() {
    return dataInserimentoRichiesta;
  }
  public void setDataInserimentoRichiesta(Date dataInserimentoRichiesta) {
    this.dataInserimentoRichiesta = dataInserimentoRichiesta;
  }

  /**
   **/
  

  @JsonProperty("dataUltimaModifica") 
 
  public Date getDataUltimaModifica() {
    return dataUltimaModifica;
  }
  public void setDataUltimaModifica(Date dataUltimaModifica) {
    this.dataUltimaModifica = dataUltimaModifica;
  }

  /**
   **/
  

  @JsonProperty("utenteUltimaModifica") 
 
  public String getUtenteUltimaModifica() {
    return utenteUltimaModifica;
  }
  public void setUtenteUltimaModifica(String utenteUltimaModifica) {
    this.utenteUltimaModifica = utenteUltimaModifica;
  }

  /**
   **/
  

  @JsonProperty("dataTest") 
 
  public Date getDataTest() {
    return dataTest;
  }
  public void setDataTest(Date dataTest) {
    this.dataTest = dataTest;
  }

  /**
   **/
  

  @JsonProperty("medicoRichiedente") 
 
  public String getMedicoRichiedente() {
    return medicoRichiedente;
  }
  public void setMedicoRichiedente(String medicoRichiedente) {
    this.medicoRichiedente = medicoRichiedente;
  }

  /**
   **/
  

  @JsonProperty("contattoRichiedente") 
 
  public String getContattoRichiedente() {
    return contattoRichiedente;
  }
  public void setContattoRichiedente(String contattoRichiedente) {
    this.contattoRichiedente = contattoRichiedente;
  }

  /**
   **/
  

  @JsonProperty("risTampone") 
 
  public String getRisTampone() {
    return risTampone;
  }
  public void setRisTampone(String risTampone) {
    this.risTampone = risTampone;
  }

  /**
   **/
  

  @JsonProperty("laboratorio") 
 
  public ModelSoggettoLaboratorio getLaboratorio() {
    return laboratorio;
  }
  public void setLaboratorio(ModelSoggettoLaboratorio laboratorio) {
    this.laboratorio = laboratorio;
  }

  /**
   **/
  

  @JsonProperty("testCovid") 
 
  public ModelSoggettoTestCovid getTestCovid() {
    return testCovid;
  }
  public void setTestCovid(ModelSoggettoTestCovid testCovid) {
    this.testCovid = testCovid;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoElencoTampone modelSoggettoElencoTampone = (ModelSoggettoElencoTampone) o;
    return Objects.equals(idTampone, modelSoggettoElencoTampone.idTampone) &&
        Objects.equals(idSoggetto, modelSoggettoElencoTampone.idSoggetto) &&
        Objects.equals(idLaboratorio, modelSoggettoElencoTampone.idLaboratorio) &&
        Objects.equals(criterioEpidemiologicoCovid19, modelSoggettoElencoTampone.criterioEpidemiologicoCovid19) &&
        Objects.equals(idTestCovid, modelSoggettoElencoTampone.idTestCovid) &&
        Objects.equals(idRisTamp, modelSoggettoElencoTampone.idRisTamp) &&
        Objects.equals(tamponeAutorizzato, modelSoggettoElencoTampone.tamponeAutorizzato) &&
        Objects.equals(dataInserimentoRichiesta, modelSoggettoElencoTampone.dataInserimentoRichiesta) &&
        Objects.equals(dataUltimaModifica, modelSoggettoElencoTampone.dataUltimaModifica) &&
        Objects.equals(utenteUltimaModifica, modelSoggettoElencoTampone.utenteUltimaModifica) &&
        Objects.equals(dataTest, modelSoggettoElencoTampone.dataTest) &&
        Objects.equals(medicoRichiedente, modelSoggettoElencoTampone.medicoRichiedente) &&
        Objects.equals(contattoRichiedente, modelSoggettoElencoTampone.contattoRichiedente) &&
        Objects.equals(risTampone, modelSoggettoElencoTampone.risTampone) &&
        Objects.equals(laboratorio, modelSoggettoElencoTampone.laboratorio) &&
        Objects.equals(testCovid, modelSoggettoElencoTampone.testCovid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTampone, idSoggetto, idLaboratorio, criterioEpidemiologicoCovid19, idTestCovid, idRisTamp, tamponeAutorizzato, dataInserimentoRichiesta, dataUltimaModifica, utenteUltimaModifica, dataTest, medicoRichiedente, contattoRichiedente, risTampone, laboratorio, testCovid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggettoElencoTampone {\n");
    
    sb.append("    idTampone: ").append(toIndentedString(idTampone)).append("\n");
    sb.append("    idSoggetto: ").append(toIndentedString(idSoggetto)).append("\n");
    sb.append("    idLaboratorio: ").append(toIndentedString(idLaboratorio)).append("\n");
    sb.append("    criterioEpidemiologicoCovid19: ").append(toIndentedString(criterioEpidemiologicoCovid19)).append("\n");
    sb.append("    idTestCovid: ").append(toIndentedString(idTestCovid)).append("\n");
    sb.append("    idRisTamp: ").append(toIndentedString(idRisTamp)).append("\n");
    sb.append("    tamponeAutorizzato: ").append(toIndentedString(tamponeAutorizzato)).append("\n");
    sb.append("    dataInserimentoRichiesta: ").append(toIndentedString(dataInserimentoRichiesta)).append("\n");
    sb.append("    dataUltimaModifica: ").append(toIndentedString(dataUltimaModifica)).append("\n");
    sb.append("    utenteUltimaModifica: ").append(toIndentedString(utenteUltimaModifica)).append("\n");
    sb.append("    dataTest: ").append(toIndentedString(dataTest)).append("\n");
    sb.append("    medicoRichiedente: ").append(toIndentedString(medicoRichiedente)).append("\n");
    sb.append("    contattoRichiedente: ").append(toIndentedString(contattoRichiedente)).append("\n");
    sb.append("    risTampone: ").append(toIndentedString(risTampone)).append("\n");
    sb.append("    laboratorio: ").append(toIndentedString(laboratorio)).append("\n");
    sb.append("    testCovid: ").append(toIndentedString(testCovid)).append("\n");
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

