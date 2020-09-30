package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import io.swagger.annotations.ApiModel;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioAutore;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioSintomo;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelDiarioDettaglio {
	// verra' utilizzata la seguente strategia serializzazione degli attributi:
	// [explicit-as-modeled]

	private Integer id = null;
	private Date data = null;
	private String note = null;
	private Integer idAdiCovid = null;
	private Date dataCreazione = null;
	private Date dataModifica = null;
	private Integer diarioId = null;
	private Integer interventoId = null;
	private ModelDiarioDettaglioAutore autore = null;
	private List<ModelDiarioDettaglioSintomo> sintomi = new ArrayList<ModelDiarioDettaglioSintomo>();
	private ModelAdiCovid adiCovid = null;

	/**
	 * L&#39;id della tipologia
	 **/

	@JsonProperty("adicovid")
	public ModelAdiCovid getAdiCovid() {
		return adiCovid;
	}

	public void setAdiCovid(ModelAdiCovid adiCovid) {
		this.adiCovid = adiCovid;
	}

	@JsonProperty("idAdiCovid")

	public Integer getIdAdiCovid() {
		return idAdiCovid;
	}

	public void setIdAdiCovid(Integer idAdiCovid) {
		this.idAdiCovid = idAdiCovid;
	}

	@JsonProperty("id")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * La data di creazione del dettaglio
	 **/

	@JsonProperty("data")

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * La note inserite dall&#39;utente (medico, operatore USCA o paziente)
	 **/

	@JsonProperty("note")

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * La data di creazione del dettaglio
	 **/

	@JsonProperty("data_creazione")

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	/**
	 * La data dell&#39;ultima modifica del dettaglio
	 **/

	@JsonProperty("data_modifica")

	public Date getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(Date dataModifica) {
		this.dataModifica = dataModifica;
	}

	/**
	 * L&#39;id del diario a cui appartiene questo dettaglio
	 **/

	@JsonProperty("diario_id")

	public Integer getDiarioId() {
		return diarioId;
	}

	public void setDiarioId(Integer diarioId) {
		this.diarioId = diarioId;
	}

	/**
	 * L&#39;id dell&#39;intervento che ha generato questo dettaglio
	 **/

	@JsonProperty("intervento_id")

	public Integer getInterventoId() {
		return interventoId;
	}

	public void setInterventoId(Integer interventoId) {
		this.interventoId = interventoId;
	}

	/**
	 **/

	@JsonProperty("autore")

	public ModelDiarioDettaglioAutore getAutore() {
		return autore;
	}

	public void setAutore(ModelDiarioDettaglioAutore autore) {
		this.autore = autore;
	}

	/**
	 **/

	@JsonProperty("sintomi")

	public List<ModelDiarioDettaglioSintomo> getSintomi() {
		return sintomi;
	}

	public void setSintomi(List<ModelDiarioDettaglioSintomo> sintomi) {
		this.sintomi = sintomi;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ModelDiarioDettaglio modelDiarioDettaglio = (ModelDiarioDettaglio) o;
		return Objects.equals(id, modelDiarioDettaglio.id) && Objects.equals(data, modelDiarioDettaglio.data)
				&& Objects.equals(note, modelDiarioDettaglio.note)
				&& Objects.equals(idAdiCovid, modelDiarioDettaglio.idAdiCovid)
				&& Objects.equals(dataCreazione, modelDiarioDettaglio.dataCreazione)
				&& Objects.equals(dataModifica, modelDiarioDettaglio.dataModifica)
				&& Objects.equals(diarioId, modelDiarioDettaglio.diarioId)
				&& Objects.equals(interventoId, modelDiarioDettaglio.interventoId)
				&& Objects.equals(autore, modelDiarioDettaglio.autore)
				&& Objects.equals(adiCovid, modelDiarioDettaglio.adiCovid)
				&& Objects.equals(sintomi, modelDiarioDettaglio.sintomi);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, data, note, idAdiCovid, dataCreazione, dataModifica, diarioId, interventoId, autore,
				sintomi,adiCovid);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ModelDiarioDettaglio {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");
		sb.append("    note: ").append(toIndentedString(note)).append("\n");
		sb.append("    isAdiCovid: ").append(toIndentedString(idAdiCovid)).append("\n");
		sb.append("    dataCreazione: ").append(toIndentedString(dataCreazione)).append("\n");
		sb.append("    dataModifica: ").append(toIndentedString(dataModifica)).append("\n");
		sb.append("    diarioId: ").append(toIndentedString(diarioId)).append("\n");
		sb.append("    interventoId: ").append(toIndentedString(interventoId)).append("\n");
		sb.append("    autore: ").append(toIndentedString(autore)).append("\n");
		sb.append("    sintomi: ").append(toIndentedString(sintomi)).append("\n");
		sb.append("    adiCovid: ").append(toIndentedString(adiCovid)).append("\n");
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
