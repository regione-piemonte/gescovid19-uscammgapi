package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelDocumento;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoAzione;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoTipo;
import it.csi.gescovid.uscammgapi.dto.ModelPrescrizione;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteContatto;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelIntervento   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer id = null;
  private Date data = null;
  private String descrizione = null;
  private String azioneDescrizione = null;
  private ModelUtenteContatto medicoResponsabile = null;
  private ModelInterventoAzione azione = null;
  private ModelInterventoTipo tipo = null;
  private List<ModelPrescrizione> prescrizioni = new ArrayList<ModelPrescrizione>();
  private List<ModelDocumento> documenti = new ArrayList<ModelDocumento>();

  /**
   * L&#39;id dell&#39;intervento
   **/
  

  @JsonProperty("id") 
 
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * La data di creazione della scheda
   **/
  

  @JsonProperty("data") 
 
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }

  /**
   * la descrizione inserita dal medico
   **/
  

  @JsonProperty("descrizione") 
 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * la descrizione inserita dal medico
   **/
  

  @JsonProperty("azione_descrizione") 
 
  public String getAzioneDescrizione() {
    return azioneDescrizione;
  }
  public void setAzioneDescrizione(String azioneDescrizione) {
    this.azioneDescrizione = azioneDescrizione;
  }

  /**
   **/
  

  @JsonProperty("medico_responsabile") 
 
  public ModelUtenteContatto getMedicoResponsabile() {
    return medicoResponsabile;
  }
  public void setMedicoResponsabile(ModelUtenteContatto medicoResponsabile) {
    this.medicoResponsabile = medicoResponsabile;
  }

  /**
   **/
  

  @JsonProperty("azione") 
 
  public ModelInterventoAzione getAzione() {
    return azione;
  }
  public void setAzione(ModelInterventoAzione azione) {
    this.azione = azione;
  }

  /**
   **/
  

  @JsonProperty("tipo") 
 
  public ModelInterventoTipo getTipo() {
    return tipo;
  }
  public void setTipo(ModelInterventoTipo tipo) {
    this.tipo = tipo;
  }

  /**
   **/
  

  @JsonProperty("prescrizioni") 
 
  public List<ModelPrescrizione> getPrescrizioni() {
    return prescrizioni;
  }
  public void setPrescrizioni(List<ModelPrescrizione> prescrizioni) {
    this.prescrizioni = prescrizioni;
  }

  /**
   **/
  

  @JsonProperty("documenti") 
 
  public List<ModelDocumento> getDocumenti() {
    return documenti;
  }
  public void setDocumenti(List<ModelDocumento> documenti) {
    this.documenti = documenti;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelIntervento modelIntervento = (ModelIntervento) o;
    return Objects.equals(id, modelIntervento.id) &&
        Objects.equals(data, modelIntervento.data) &&
        Objects.equals(descrizione, modelIntervento.descrizione) &&
        Objects.equals(azioneDescrizione, modelIntervento.azioneDescrizione) &&
        Objects.equals(medicoResponsabile, modelIntervento.medicoResponsabile) &&
        Objects.equals(azione, modelIntervento.azione) &&
        Objects.equals(tipo, modelIntervento.tipo) &&
        Objects.equals(prescrizioni, modelIntervento.prescrizioni) &&
        Objects.equals(documenti, modelIntervento.documenti);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, data, descrizione, azioneDescrizione, medicoResponsabile, azione, tipo, prescrizioni, documenti);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelIntervento {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    azioneDescrizione: ").append(toIndentedString(azioneDescrizione)).append("\n");
    sb.append("    medicoResponsabile: ").append(toIndentedString(medicoResponsabile)).append("\n");
    sb.append("    azione: ").append(toIndentedString(azione)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    prescrizioni: ").append(toIndentedString(prescrizioni)).append("\n");
    sb.append("    documenti: ").append(toIndentedString(documenti)).append("\n");
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

