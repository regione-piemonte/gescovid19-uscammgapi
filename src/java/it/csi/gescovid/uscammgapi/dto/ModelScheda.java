package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelDocumento;
import it.csi.gescovid.uscammgapi.dto.ModelIntervento;
import it.csi.gescovid.uscammgapi.dto.ModelPrescrizione;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaCambioStato;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaMedico;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaSoggetto;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaStato;
import it.csi.gescovid.uscammgapi.dto.ModelStruttura;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelScheda {
	// verra' utilizzata la seguente strategia serializzazione degli attributi:
	// [explicit-as-modeled]

	private String id = null;
	private Date data = null;
	private String descrizione = null;
	private Boolean critica = null;
	private String terapiaCronica = null;
	
	private ModelSchedaStato stato = null;
	private List<ModelDocumento> documenti = new ArrayList<ModelDocumento>();
	private ModelSchedaSoggetto soggetto = null;
	private ModelSchedaMedico medico = null;
	private ModelStruttura usca = null;
	private List<ModelPrescrizione> prescrizioni = new ArrayList<ModelPrescrizione>();
	private List<ModelIntervento> intervento = new ArrayList<ModelIntervento>();
	private List<ModelSchedaCambioStato> cronologia = new ArrayList<ModelSchedaCambioStato>();

	// Flag inserito da Mmg e visibilita 118 e medico ca
	private Boolean richiestaMmg;
	private Boolean visibileMedEmergenza;
	private Boolean visibileMedContAssistenziale;
	
	private ModelMonitoraggioTipo monitoraggioTipo = null;
	
	private ModelUtenteMedico medicoTitolato;
	
	
	@JsonProperty("medicoTitolato")
	public ModelUtenteMedico getMedicoTitolato() {
		return medicoTitolato;
	}
	public void setMedicoTitolato(ModelUtenteMedico medicoTitolato) {
		this.medicoTitolato = medicoTitolato;
	}

	private Long totalCount;
	
	@JsonProperty("totalCount")
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	
	@JsonProperty("monitoraggio_tipo")
	public ModelMonitoraggioTipo getMonitoraggioTipo() {
		return monitoraggioTipo;
	}

	public void setMonitoraggioTipo(ModelMonitoraggioTipo monitoraggioTipo) {
		this.monitoraggioTipo = monitoraggioTipo;
	}

	@JsonProperty("terapiaCronica")
	public String getTerapiaCronica() {
		return terapiaCronica;
	}

	public void setTerapiaCronica(String terapiaCronica) {
		this.terapiaCronica = terapiaCronica;
	}

	@JsonProperty("richiestaMmg")
	public Boolean getRichiestaMmg() {
		return richiestaMmg;
	}

	public void setRichiestaMmg(Boolean richiestaMmg) {
		this.richiestaMmg = richiestaMmg;
	}

	@JsonProperty("visibileMedEmergenza")
	public Boolean getVisibileMedEmergenza() {
		return visibileMedEmergenza;

	}

	public void setVisibileMedEmergenza(Boolean visibileMedEmergenza) {
		this.visibileMedEmergenza = visibileMedEmergenza;
	}

	@JsonProperty("visibileMedContAssistenziale")
	public Boolean getVisibileMedContAssistenziale() {
		return visibileMedContAssistenziale;
	}

	public void setVisibileMedContAssistenziale(Boolean visibileMedContAssistenziale) {
		this.visibileMedContAssistenziale = visibileMedContAssistenziale;
	}

	/**
	 * L&#39;id della tipologia
	 **/
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	 * Indica se il medico l&#39;ha segnalata come critica o meno
	 **/

	@JsonProperty("critica")

	public Boolean isCritica() {
		return critica;
	}

	public void setCritica(Boolean critica) {
		this.critica = critica;
	}

	/**
	 **/

	@JsonProperty("stato")

	public ModelSchedaStato getStato() {
		return stato;
	}

	public void setStato(ModelSchedaStato stato) {
		this.stato = stato;
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

	/**
	 **/

	@JsonProperty("soggetto")

	public ModelSchedaSoggetto getSoggetto() {
		return soggetto;
	}

	public void setSoggetto(ModelSchedaSoggetto soggetto) {
		this.soggetto = soggetto;
	}

	/**
	 **/

	@JsonProperty("medico")

	public ModelSchedaMedico getMedico() {
		return medico;
	}

	public void setMedico(ModelSchedaMedico medico) {
		this.medico = medico;
	}

	/**
	 **/

	@JsonProperty("usca")

	public ModelStruttura getUsca() {
		return usca;
	}

	public void setUsca(ModelStruttura usca) {
		this.usca = usca;
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

	@JsonProperty("intervento")

	public List<ModelIntervento> getIntervento() {
		return intervento;
	}

	public void setIntervento(List<ModelIntervento> intervento) {
		this.intervento = intervento;
	}

	/**
	 **/

	@JsonProperty("cronologia")

	public List<ModelSchedaCambioStato> getCronologia() {
		return cronologia;
	}

	public void setCronologia(List<ModelSchedaCambioStato> cronologia) {
		this.cronologia = cronologia;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ModelScheda modelScheda = (ModelScheda) o;
		return Objects.equals(id, modelScheda.id) && Objects.equals(data, modelScheda.data)
				&& Objects.equals(descrizione, modelScheda.descrizione) && Objects.equals(critica, modelScheda.critica)
				&& Objects.equals(stato, modelScheda.stato) && Objects.equals(documenti, modelScheda.documenti)
				&& Objects.equals(soggetto, modelScheda.soggetto) && Objects.equals(medico, modelScheda.medico)
				&& Objects.equals(usca, modelScheda.usca) && Objects.equals(prescrizioni, modelScheda.prescrizioni)
				&& Objects.equals(intervento, modelScheda.intervento)
				&& Objects.equals(cronologia, modelScheda.cronologia)
				&& Objects.equals(terapiaCronica, modelScheda.terapiaCronica)
				&& Objects.equals(totalCount, modelScheda.totalCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, data, descrizione, critica, stato, documenti, soggetto, medico, usca, prescrizioni,
				intervento, cronologia, terapiaCronica, totalCount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelScheda {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
		sb.append("    descrizione: ").append(toIndentedString(descrizione)).append("\n");
		sb.append("    critica: ").append(toIndentedString(critica)).append("\n");
		sb.append("    stato: ").append(toIndentedString(stato)).append("\n");
		sb.append("    documenti: ").append(toIndentedString(documenti)).append("\n");
		sb.append("    soggetto: ").append(toIndentedString(soggetto)).append("\n");
		sb.append("    medico: ").append(toIndentedString(medico)).append("\n");
		sb.append("    usca: ").append(toIndentedString(usca)).append("\n");
		sb.append("    prescrizioni: ").append(toIndentedString(prescrizioni)).append("\n");
		sb.append("    intervento: ").append(toIndentedString(intervento)).append("\n");
		sb.append("    cronologia: ").append(toIndentedString(cronologia)).append("\n");
		sb.append("    terapiaCronica: ").append(toIndentedString(terapiaCronica)).append("\n");
		sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
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
