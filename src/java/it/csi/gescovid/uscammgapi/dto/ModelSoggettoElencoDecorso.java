package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoArea;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoDecodeTipoEvento;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoSintomo;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteElencoStruttura;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSoggettoElencoDecorso   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idDecorso = null;
  private Integer idSoggetto = null;
  private String luogoPaziente = null;
  private String descrizioneContesto = null;
  private String comuneRicoveroIstat = null;
  private Integer idRepRicovero = null;
  private String condizioniCliniche = null;
  private Integer idDimiss = null;
  private String sintomi = null;
  private String ospedaleRicovero = null;
  private Date dataDimissioni = null;
  private Date dataInizioSint = null;
  private Date dataEvento = null;
  private Integer idTipoEvento = null;
  private Integer idAreaa = null;
  private String note = null;
  private Date dataPrevFineEvento = null;
  private String indirizzoDecorso = null;
  private String decorsoPresso = null;
  private String comuneRicovero = null;
  private String esitoDimissioni = null;
  private String repartoRicovero = null;
  private ModelSoggettoDecodeTipoEvento decodeTipoEvento = null;
  private ModelSoggettoSintomo sintomo = null;
  private ModelSoggettoArea area = null;
  private ModelUtenteElencoStruttura struttura = null;

  /**
   **/
  

  @JsonProperty("idDecorso") 
 
  public Integer getIdDecorso() {
    return idDecorso;
  }
  public void setIdDecorso(Integer idDecorso) {
    this.idDecorso = idDecorso;
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
  

  @JsonProperty("luogoPaziente") 
 
  public String getLuogoPaziente() {
    return luogoPaziente;
  }
  public void setLuogoPaziente(String luogoPaziente) {
    this.luogoPaziente = luogoPaziente;
  }

  /**
   **/
  

  @JsonProperty("descrizioneContesto") 
 
  public String getDescrizioneContesto() {
    return descrizioneContesto;
  }
  public void setDescrizioneContesto(String descrizioneContesto) {
    this.descrizioneContesto = descrizioneContesto;
  }

  /**
   **/
  

  @JsonProperty("comuneRicoveroIstat") 
 
  public String getComuneRicoveroIstat() {
    return comuneRicoveroIstat;
  }
  public void setComuneRicoveroIstat(String comuneRicoveroIstat) {
    this.comuneRicoveroIstat = comuneRicoveroIstat;
  }

  /**
   **/
  

  @JsonProperty("idRepRicovero") 
 
  public Integer getIdRepRicovero() {
    return idRepRicovero;
  }
  public void setIdRepRicovero(Integer idRepRicovero) {
    this.idRepRicovero = idRepRicovero;
  }

  /**
   **/
  

  @JsonProperty("condizioniCliniche") 
 
  public String getCondizioniCliniche() {
    return condizioniCliniche;
  }
  public void setCondizioniCliniche(String condizioniCliniche) {
    this.condizioniCliniche = condizioniCliniche;
  }

  /**
   **/
  

  @JsonProperty("idDimiss") 
 
  public Integer getIdDimiss() {
    return idDimiss;
  }
  public void setIdDimiss(Integer idDimiss) {
    this.idDimiss = idDimiss;
  }

  /**
   **/
  

  @JsonProperty("sintomi") 
 
  public String getSintomi() {
    return sintomi;
  }
  public void setSintomi(String sintomi) {
    this.sintomi = sintomi;
  }

  /**
   **/
  

  @JsonProperty("ospedaleRicovero") 
 
  public String getOspedaleRicovero() {
    return ospedaleRicovero;
  }
  public void setOspedaleRicovero(String ospedaleRicovero) {
    this.ospedaleRicovero = ospedaleRicovero;
  }

  /**
   **/
  

  @JsonProperty("dataDimissioni") 
 
  public Date getDataDimissioni() {
    return dataDimissioni;
  }
  public void setDataDimissioni(Date dataDimissioni) {
    this.dataDimissioni = dataDimissioni;
  }

  /**
   **/
  

  @JsonProperty("dataInizioSint") 
 
  public Date getDataInizioSint() {
    return dataInizioSint;
  }
  public void setDataInizioSint(Date dataInizioSint) {
    this.dataInizioSint = dataInizioSint;
  }

  /**
   **/
  

  @JsonProperty("dataEvento") 
 
  public Date getDataEvento() {
    return dataEvento;
  }
  public void setDataEvento(Date dataEvento) {
    this.dataEvento = dataEvento;
  }

  /**
   **/
  

  @JsonProperty("idTipoEvento") 
 
  public Integer getIdTipoEvento() {
    return idTipoEvento;
  }
  public void setIdTipoEvento(Integer idTipoEvento) {
    this.idTipoEvento = idTipoEvento;
  }

  /**
   **/
  

  @JsonProperty("idAreaa") 
 
  public Integer getIdAreaa() {
    return idAreaa;
  }
  public void setIdAreaa(Integer idAreaa) {
    this.idAreaa = idAreaa;
  }

  /**
   **/
  

  @JsonProperty("note") 
 
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }

  /**
   **/
  

  @JsonProperty("dataPrevFineEvento") 
 
  public Date getDataPrevFineEvento() {
    return dataPrevFineEvento;
  }
  public void setDataPrevFineEvento(Date dataPrevFineEvento) {
    this.dataPrevFineEvento = dataPrevFineEvento;
  }

  /**
   **/
  

  @JsonProperty("indirizzoDecorso") 
 
  public String getIndirizzoDecorso() {
    return indirizzoDecorso;
  }
  public void setIndirizzoDecorso(String indirizzoDecorso) {
    this.indirizzoDecorso = indirizzoDecorso;
  }

  /**
   **/
  

  @JsonProperty("decorsoPresso") 
 
  public String getDecorsoPresso() {
    return decorsoPresso;
  }
  public void setDecorsoPresso(String decorsoPresso) {
    this.decorsoPresso = decorsoPresso;
  }

  /**
   **/
  

  @JsonProperty("comuneRicovero") 
 
  public String getComuneRicovero() {
    return comuneRicovero;
  }
  public void setComuneRicovero(String comuneRicovero) {
    this.comuneRicovero = comuneRicovero;
  }

  /**
   **/
  

  @JsonProperty("esitoDimissioni") 
 
  public String getEsitoDimissioni() {
    return esitoDimissioni;
  }
  public void setEsitoDimissioni(String esitoDimissioni) {
    this.esitoDimissioni = esitoDimissioni;
  }

  /**
   **/
  

  @JsonProperty("repartoRicovero") 
 
  public String getRepartoRicovero() {
    return repartoRicovero;
  }
  public void setRepartoRicovero(String repartoRicovero) {
    this.repartoRicovero = repartoRicovero;
  }

  /**
   **/
  

  @JsonProperty("decodeTipoEvento") 
 
  public ModelSoggettoDecodeTipoEvento getDecodeTipoEvento() {
    return decodeTipoEvento;
  }
  public void setDecodeTipoEvento(ModelSoggettoDecodeTipoEvento decodeTipoEvento) {
    this.decodeTipoEvento = decodeTipoEvento;
  }

  /**
   **/
  

  @JsonProperty("sintomo") 
 
  public ModelSoggettoSintomo getSintomo() {
    return sintomo;
  }
  public void setSintomo(ModelSoggettoSintomo sintomo) {
    this.sintomo = sintomo;
  }

  /**
   **/
  

  @JsonProperty("area") 
 
  public ModelSoggettoArea getArea() {
    return area;
  }
  public void setArea(ModelSoggettoArea area) {
    this.area = area;
  }

  /**
   **/
  

  @JsonProperty("struttura") 
 
  public ModelUtenteElencoStruttura getStruttura() {
    return struttura;
  }
  public void setStruttura(ModelUtenteElencoStruttura struttura) {
    this.struttura = struttura;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoElencoDecorso modelSoggettoElencoDecorso = (ModelSoggettoElencoDecorso) o;
    return Objects.equals(idDecorso, modelSoggettoElencoDecorso.idDecorso) &&
        Objects.equals(idSoggetto, modelSoggettoElencoDecorso.idSoggetto) &&
        Objects.equals(luogoPaziente, modelSoggettoElencoDecorso.luogoPaziente) &&
        Objects.equals(descrizioneContesto, modelSoggettoElencoDecorso.descrizioneContesto) &&
        Objects.equals(comuneRicoveroIstat, modelSoggettoElencoDecorso.comuneRicoveroIstat) &&
        Objects.equals(idRepRicovero, modelSoggettoElencoDecorso.idRepRicovero) &&
        Objects.equals(condizioniCliniche, modelSoggettoElencoDecorso.condizioniCliniche) &&
        Objects.equals(idDimiss, modelSoggettoElencoDecorso.idDimiss) &&
        Objects.equals(sintomi, modelSoggettoElencoDecorso.sintomi) &&
        Objects.equals(ospedaleRicovero, modelSoggettoElencoDecorso.ospedaleRicovero) &&
        Objects.equals(dataDimissioni, modelSoggettoElencoDecorso.dataDimissioni) &&
        Objects.equals(dataInizioSint, modelSoggettoElencoDecorso.dataInizioSint) &&
        Objects.equals(dataEvento, modelSoggettoElencoDecorso.dataEvento) &&
        Objects.equals(idTipoEvento, modelSoggettoElencoDecorso.idTipoEvento) &&
        Objects.equals(idAreaa, modelSoggettoElencoDecorso.idAreaa) &&
        Objects.equals(note, modelSoggettoElencoDecorso.note) &&
        Objects.equals(dataPrevFineEvento, modelSoggettoElencoDecorso.dataPrevFineEvento) &&
        Objects.equals(indirizzoDecorso, modelSoggettoElencoDecorso.indirizzoDecorso) &&
        Objects.equals(decorsoPresso, modelSoggettoElencoDecorso.decorsoPresso) &&
        Objects.equals(comuneRicovero, modelSoggettoElencoDecorso.comuneRicovero) &&
        Objects.equals(esitoDimissioni, modelSoggettoElencoDecorso.esitoDimissioni) &&
        Objects.equals(repartoRicovero, modelSoggettoElencoDecorso.repartoRicovero) &&
        Objects.equals(decodeTipoEvento, modelSoggettoElencoDecorso.decodeTipoEvento) &&
        Objects.equals(sintomo, modelSoggettoElencoDecorso.sintomo) &&
        Objects.equals(area, modelSoggettoElencoDecorso.area) &&
        Objects.equals(struttura, modelSoggettoElencoDecorso.struttura);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDecorso, idSoggetto, luogoPaziente, descrizioneContesto, comuneRicoveroIstat, idRepRicovero, condizioniCliniche, idDimiss, sintomi, ospedaleRicovero, dataDimissioni, dataInizioSint, dataEvento, idTipoEvento, idAreaa, note, dataPrevFineEvento, indirizzoDecorso, decorsoPresso, comuneRicovero, esitoDimissioni, repartoRicovero, decodeTipoEvento, sintomo, area, struttura);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggettoElencoDecorso {\n");
    
    sb.append("    idDecorso: ").append(toIndentedString(idDecorso)).append("\n");
    sb.append("    idSoggetto: ").append(toIndentedString(idSoggetto)).append("\n");
    sb.append("    luogoPaziente: ").append(toIndentedString(luogoPaziente)).append("\n");
    sb.append("    descrizioneContesto: ").append(toIndentedString(descrizioneContesto)).append("\n");
    sb.append("    comuneRicoveroIstat: ").append(toIndentedString(comuneRicoveroIstat)).append("\n");
    sb.append("    idRepRicovero: ").append(toIndentedString(idRepRicovero)).append("\n");
    sb.append("    condizioniCliniche: ").append(toIndentedString(condizioniCliniche)).append("\n");
    sb.append("    idDimiss: ").append(toIndentedString(idDimiss)).append("\n");
    sb.append("    sintomi: ").append(toIndentedString(sintomi)).append("\n");
    sb.append("    ospedaleRicovero: ").append(toIndentedString(ospedaleRicovero)).append("\n");
    sb.append("    dataDimissioni: ").append(toIndentedString(dataDimissioni)).append("\n");
    sb.append("    dataInizioSint: ").append(toIndentedString(dataInizioSint)).append("\n");
    sb.append("    dataEvento: ").append(toIndentedString(dataEvento)).append("\n");
    sb.append("    idTipoEvento: ").append(toIndentedString(idTipoEvento)).append("\n");
    sb.append("    idAreaa: ").append(toIndentedString(idAreaa)).append("\n");
    sb.append("    note: ").append(toIndentedString(note)).append("\n");
    sb.append("    dataPrevFineEvento: ").append(toIndentedString(dataPrevFineEvento)).append("\n");
    sb.append("    indirizzoDecorso: ").append(toIndentedString(indirizzoDecorso)).append("\n");
    sb.append("    decorsoPresso: ").append(toIndentedString(decorsoPresso)).append("\n");
    sb.append("    comuneRicovero: ").append(toIndentedString(comuneRicovero)).append("\n");
    sb.append("    esitoDimissioni: ").append(toIndentedString(esitoDimissioni)).append("\n");
    sb.append("    repartoRicovero: ").append(toIndentedString(repartoRicovero)).append("\n");
    sb.append("    decodeTipoEvento: ").append(toIndentedString(decodeTipoEvento)).append("\n");
    sb.append("    sintomo: ").append(toIndentedString(sintomo)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    struttura: ").append(toIndentedString(struttura)).append("\n");
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

