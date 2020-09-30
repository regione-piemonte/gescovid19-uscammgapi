package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import it.csi.gescovid.uscammgapi.dto.SchedeConsensoDocumenti;
import it.csi.gescovid.uscammgapi.dto.SchedePrescrizioni;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class Payload2   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Date data = null;
  private String descrizione = null;
  private String azioneDescrizione = null;
  private Integer tipo = null;
  private Integer azione = null;
  private Integer soggetto = null; // raffa 11-05-2020 nuovi per ins scheda da usca
  private String struttura = null; // raffa 11-05-2020 nuovi per ins scheda da usca
  private List<SchedeConsensoDocumenti> documenti = new ArrayList<SchedeConsensoDocumenti>();
  private List<SchedePrescrizioni> prescrizioni = new ArrayList<SchedePrescrizioni>();
  
   
  
  @JsonProperty("struttura")
  public String getStruttura() {
	return struttura;
  }
  public void setStruttura(String struttura) {
	this.struttura = struttura;
  }
  
  @JsonProperty("soggetto")
  public Integer getSoggetto() {
	return soggetto;
  }
  public void setSoggetto(Integer soggetto) {
	this.soggetto = soggetto;
  }
/**
   * la data per cui si vuole registrare l&#39;intervento
   **/
  

  @JsonProperty("data") 
 
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }

  /**
   * La descrizione inserita dall&#39;utente
   **/
  

  @JsonProperty("descrizione") 
 
  public String getDescrizione() {
    return descrizione;
  }
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  /**
   * La descrizione dell&#39;azione intrapresa
   **/
  

  @JsonProperty("azione_descrizione") 
 
  public String getAzioneDescrizione() {
    return azioneDescrizione;
  }
  public void setAzioneDescrizione(String azioneDescrizione) {
    this.azioneDescrizione = azioneDescrizione;
  }

  /**
   * L&#39;id della tipologia di intervento
   **/
  

  @JsonProperty("tipo") 
 
  public Integer getTipo() {
    return tipo;
  }
  public void setTipo(Integer tipo) {
    this.tipo = tipo;
  }

  /**
   * L&#39;id dell&#39;azione intrapresa
   **/
  

  @JsonProperty("azione") 
 
  public Integer getAzione() {
    return azione;
  }
  public void setAzione(Integer azione) {
    this.azione = azione;
  }

  /**
   **/
  

  @JsonProperty("documenti") 
 
  public List<SchedeConsensoDocumenti> getDocumenti() {
    return documenti;
  }
  public void setDocumenti(List<SchedeConsensoDocumenti> documenti) {
    this.documenti = documenti;
  }

  /**
   **/
  

  @JsonProperty("prescrizioni") 
 
  public List<SchedePrescrizioni> getPrescrizioni() {
    return prescrizioni;
  }
  public void setPrescrizioni(List<SchedePrescrizioni> prescrizioni) {
    this.prescrizioni = prescrizioni;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payload2 payload2 = (Payload2) o;
    return Objects.equals(data, payload2.data) &&
        Objects.equals(descrizione, payload2.descrizione) &&
        Objects.equals(azioneDescrizione, payload2.azioneDescrizione) &&
        Objects.equals(tipo, payload2.tipo) &&
        Objects.equals(azione, payload2.azione) &&
        Objects.equals(documenti, payload2.documenti) &&
        Objects.equals(prescrizioni, payload2.prescrizioni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, descrizione, azioneDescrizione, tipo, azione, documenti, prescrizioni);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payload2 {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
    sb.append("    azioneDescrizione: ").append(toIndentedString(azioneDescrizione)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    azione: ").append(toIndentedString(azione)).append("\n");
    sb.append("    documenti: ").append(toIndentedString(documenti)).append("\n");
    sb.append("    prescrizioni: ").append(toIndentedString(prescrizioni)).append("\n");
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

