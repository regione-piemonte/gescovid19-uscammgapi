package it.csi.gescovid.uscammgapi.business.be.impl.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.type.JdbcType;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Comuni;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDConsensoTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDMonitoraggioTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSchedaStato;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTConsensoFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTScheda;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.StatoEnum;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Struttura;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.CronologiaStatoCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.InterventoCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.PrescrizioneInterventoCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.PrescrizioneSchedaCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.SchedeCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.ConsensiFarmaciMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.ConsensoFarmacoTFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SchedeApiMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseComuniMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDConsensoTipoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDFarmacoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDMonitoraggioTipoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTSchedaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseEnteMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseSoggettoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseStrutturaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.uscammgapi.business.mapping.ModelConsensoFarmacoCovidusTConsensoFarmacoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelDocumentoCovidusTFileMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelFarmacoCovidusDFarmacoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelMonitoraggioTipiCovidusDMonitoraggioTipiMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelOssigenoterapiaCovidusDOssigenoTerapiaMapping;
import it.csi.gescovid.uscammgapi.dto.ModelConsensoFarmaco;
import it.csi.gescovid.uscammgapi.dto.ModelDocumento;
import it.csi.gescovid.uscammgapi.dto.ModelEnte;
import it.csi.gescovid.uscammgapi.dto.ModelFarmaco;
import it.csi.gescovid.uscammgapi.dto.ModelIntervento;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoAzione;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoTipo;
import it.csi.gescovid.uscammgapi.dto.ModelMonitoraggioTipo;
import it.csi.gescovid.uscammgapi.dto.ModelOssigenoterapia;
import it.csi.gescovid.uscammgapi.dto.ModelPrescrizione;
import it.csi.gescovid.uscammgapi.dto.ModelPrescrizioneTipo;
import it.csi.gescovid.uscammgapi.dto.ModelScheda;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaCambioStato;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaCambioStatoUtente;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaMedico;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaSoggetto;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaSoggettoComune;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaStato;
import it.csi.gescovid.uscammgapi.dto.ModelStruttura;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteContatto;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteMedico;
import it.csi.gescovid.uscammgapi.util.CaUtils;


public class SchedeApiHelperService extends RESTBaseService {

	@Autowired
	BaseComuniMapper baseComuniMapper;

	@Autowired
	BaseCovidusTSchedaMapper baseCovidusTSchedaMapper;

	@Autowired
	BaseSoggettoMapper baseSoggettoMapper;

	@Autowired
	BaseStrutturaMapper baseStrutturaMapper;

	@Autowired
	BaseEnteMapper baseEnteMapper;

	@Autowired
	SchedeApiMapper schedeApiMapper;
	
	@Autowired
	CovidusTFileMapper covidusTFileMapper;
	
	@Autowired
	BaseCovidusDConsensoTipoMapper baseCovidusDConsensoTipoMapper;
	
	@Autowired
	BaseCovidusDFarmacoMapper baseCovidusDFarmacoMapper;
	
	@Autowired
	ConsensiFarmaciMapper consensoFarmacoMapper;
	
	@Autowired
	ConsensoFarmacoTFileMapper consensoFarmacoTFileMapper;
	
	@Autowired
	BaseCovidusDMonitoraggioTipoMapper baseCovidusDMonitoraggioTipoMapper;

	public List<ModelScheda> getElencoSchede(Integer soggetto, String strutture, String stati, String medico, Boolean visibileMed118, Boolean visibileMedCa, Boolean richiesteMmg,
			Paginazione paginazione, Integer idMonitoraggioTipo,List<String> idStrutturaList, String codSchStato, String filter ) {

		List<ModelScheda> elencoSchede = new ArrayList<ModelScheda>();

		List<SchedeCustomDto> elencoSchedeDB = schedeApiMapper.selectElencoSchedePaged(
				soggetto, strutture, stati, medico, visibileMed118, visibileMedCa, richiesteMmg,
				idMonitoraggioTipo,
				idStrutturaList,
				codSchStato,
				filter,
				paginazione.getOrderBy(),
				paginazione.orderAscDesc(),
				paginazione.getOffset(),
				paginazione.getLimit()
				
				);

		Iterator<SchedeCustomDto> iterator = elencoSchedeDB.iterator();
		while (iterator.hasNext()) {
			SchedeCustomDto next = iterator.next();

			ModelScheda modelScheda = new ModelScheda();
			
			modelScheda.setCritica(next.getCritica());
			modelScheda.setData(next.getDataScheda());
			modelScheda.setDescrizione(next.getDescrizioneScheda());
			modelScheda.setId(CaUtils.toString(next.getIdScheda()));
			modelScheda.setTerapiaCronica(next.getSchTerapiaCronica());
			modelScheda.setRichiestaMmg(next.getRichiestaMmg());
			modelScheda.setVisibileMedEmergenza(next.getVisibileMed118());
			modelScheda.setVisibileMedContAssistenziale(next.getVisibileMedCa());
			
			/**
			 * Raffa aggiunta medico titolato
			 */
			if(next.getMedico()!=null) {
				
				ModelUtenteMedico medicoTitolato = new ModelUtenteMedico();
				medicoTitolato.setIdMedico(next.getMedico().getIdMedico()!= null ? next.getMedico().getIdMedico().intValue(): null);
				medicoTitolato.setCfMedico(next.getMedico().getCfMedico() != null ? next.getMedico().getCfMedico(): null);
				medicoTitolato.setCodiceReg(next.getMedico().getCodiceReg() != null ? next.getMedico().getCodiceReg(): null);
				medicoTitolato.setCognome(next.getMedico().getCognome() != null ? next.getMedico().getCognome(): null);
				medicoTitolato.setNome(next.getMedico().getNome() != null ? next.getMedico().getNome(): null);
				
				modelScheda.setMedicoTitolato(medicoTitolato);
			}
			
			// Carico eventuali doc
			// NUOVO Carico documenti di una scheda
			List<CovidusTFile> filescheda = covidusTFileMapper.selectFileByRSchedaId(next.getIdScheda());
			if(filescheda!=null && !filescheda.isEmpty()) {
				List<ModelDocumento> documenti = new ModelDocumentoCovidusTFileMapping().fromList(filescheda);
				modelScheda.setDocumenti(documenti);
			}
			

			if(next.getMonitoraggioTipo()!=null) {
				ModelMonitoraggioTipo tipoMonitoraggio = new ModelMonitoraggioTipiCovidusDMonitoraggioTipiMapping().from(next.getMonitoraggioTipo());
				modelScheda.setMonitoraggioTipo(tipoMonitoraggio);
			}
			
			List<InterventoCustomDto> listaInterventi = schedeApiMapper.selectInterventoByIdScheda(next.getIdScheda());

			List<ModelIntervento> listaModelInterventi = new ArrayList<ModelIntervento>();
			
			for (InterventoCustomDto interventoDB : listaInterventi) {
						
					if (interventoDB != null) {
						
						ModelIntervento modelIntervento = new ModelIntervento();
						modelIntervento.setId(interventoDB.getIntId());
						modelIntervento.setDescrizione(interventoDB.getIntDesc());
						modelIntervento.setAzioneDescrizione(interventoDB.getIntAzioneIntrapresa());
						modelIntervento.setData(interventoDB.getIntData());
		
						// Aggiungo info documento
						// NUOVO Carico documenti di un intervento
						List<CovidusTFile> filesInterventi = covidusTFileMapper.selectFileByRInterventoId(interventoDB.getIntId());
						if(filesInterventi!=null && !filesInterventi.isEmpty()) {
							List<ModelDocumento> documenti = new ModelDocumentoCovidusTFileMapping().fromList(filesInterventi);
							modelIntervento.setDocumenti(documenti);
						}
						
						
						ModelInterventoAzione modelInterventoAzione = new ModelInterventoAzione();
						modelInterventoAzione.setCodice(interventoDB.getAzCod());
						modelInterventoAzione.setId(interventoDB.getAzId());
						modelInterventoAzione.setNome(interventoDB.getAzDesc());
						modelIntervento.setAzione(modelInterventoAzione);
		
						ModelInterventoTipo modelInterventoTipo = new ModelInterventoTipo();
						modelInterventoTipo.setCodice(interventoDB.getIntTipoCod());
						modelInterventoTipo.setId(interventoDB.getIntTipoId());
						modelInterventoTipo.setNome(interventoDB.getIntTipoDesc());
						modelIntervento.setTipo(modelInterventoTipo);
						
						/** 
						 * Aggiunta info medico responsabile dell'intervento
						 */
						ModelUtenteContatto modelUtenteContatto = new ModelUtenteContatto();
						if(interventoDB.getMedicoResponsabile()!=null) {
							modelUtenteContatto.setCodiceFiscale(interventoDB.getMedicoResponsabile().getCfUtente()!=null ? interventoDB.getMedicoResponsabile().getCfUtente() :"");
							modelUtenteContatto.setCognome(interventoDB.getMedicoResponsabile().getCognome() !=null ? interventoDB.getMedicoResponsabile().getCognome() : "");
							modelUtenteContatto.setEmail(interventoDB.getMedicoResponsabile().getEmail() !=null ? interventoDB.getMedicoResponsabile().getEmail() : "");
							modelUtenteContatto.setNome(interventoDB.getMedicoResponsabile().getNome() !=null ? interventoDB.getMedicoResponsabile().getNome(): "");
							modelUtenteContatto.setTelefono(interventoDB.getMedicoResponsabile().getTelefono() !=null ? interventoDB.getMedicoResponsabile().getTelefono() : "");
							modelIntervento.setMedicoResponsabile(modelUtenteContatto);
						}
		
						modelIntervento.setPrescrizioni(getElencoPrescrizioniIntervento(interventoDB.getIntId()));
		
						listaModelInterventi.add(modelIntervento);
						//modelScheda.setIntervento(modelIntervento);
					}
			
			}
			
			modelScheda.setIntervento(listaModelInterventi);

			// Carico le info del medico
			ModelSchedaMedico modelSchedaMedico = new ModelSchedaMedico();
			modelSchedaMedico.setCodiceFiscale(next.getCfMedico());
			modelSchedaMedico.setCognome(next.getCognomeMedico());
			modelSchedaMedico.setEmail(next.getEmailMedico());
			modelSchedaMedico.setNome(next.getNomeMedico());
			modelSchedaMedico.setTelefono(next.getTelefonoMedico());
			modelScheda.setMedico(modelSchedaMedico);
			
			
			ModelSchedaSoggetto modelSchedaSoggetto = new ModelSchedaSoggetto();
			modelSchedaSoggetto.setCodiceFiscale(next.getCodiceFiscale());
			modelSchedaSoggetto.setCognome(next.getCognomeSoggetto());
			modelSchedaSoggetto.setDataNascita(next.getDataNascitaSoggetto());
			modelSchedaSoggetto.setEmail(next.getEmailSoggetto());
			modelSchedaSoggetto.setId(CaUtils.toInteger(next.getIdSoggetto()));
			modelSchedaSoggetto.setNome(next.getNomeSoggetto());
			modelSchedaSoggetto.setTelefono(next.getTelefonoSoggetto());
			modelSchedaSoggetto.setDomicilioAsl(next.getAslDomicilio());
			modelSchedaSoggetto.setResidenzaAsl(next.getAslResidenza());
			modelSchedaSoggetto.setDomicilioComune(getModelComune(next.getComuneDomicilioIstat()));
			modelSchedaSoggetto.setResidenzaComune(getModelComune(next.getComuneResidenzaIstat()));
			modelSchedaSoggetto.setDomicilioIndirizzo(next.getIndirizzoDomicilio());
			modelScheda.setSoggetto(modelSchedaSoggetto);

			ModelSchedaStato modelSchedaStato = new ModelSchedaStato();
			modelSchedaStato.setCodice(next.getStatoSchedaCod());
			modelSchedaStato.setNome(next.getStatoSchedaDesc());
			modelScheda.setStato(modelSchedaStato);

			modelScheda.setCronologia(getCronologiaCambioStato(next.getIdScheda()));

			ModelStruttura modelStruttura = new ModelStruttura();
			modelStruttura.setId(next.getIdStruttura());
			modelStruttura.setNatura(next.getNaturaStruttura());
			modelStruttura.setNome(next.getNomeStruttura());
			ModelEnte modelEnte = new ModelEnte();
			modelEnte.setId(next.getIdEnte());
			modelEnte.setNome(next.getNomeEnte());
			modelStruttura.setEnte(modelEnte);
			modelScheda.setUsca(modelStruttura);

			modelScheda.setPrescrizioni(getElencoPrescrizioniScheda(next.getIdScheda()));
			modelScheda.setTotalCount(next.getTotalCount());

			elencoSchede.add(modelScheda);
		}

		return elencoSchede;
	}

	private List<ModelSchedaCambioStato> getCronologiaCambioStato(Integer idScheda) {

		List<ModelSchedaCambioStato> elencoCambioStati = new ArrayList<ModelSchedaCambioStato>();

		List<CronologiaStatoCustomDto> cronologiaDB = schedeApiMapper.selectCronologiaStatiByIdScheda(idScheda);

		Iterator<CronologiaStatoCustomDto> iterator = cronologiaDB.iterator();
		while (iterator.hasNext()) {
			CronologiaStatoCustomDto next = iterator.next();

			ModelSchedaCambioStato modelSchedaCambioStato = new ModelSchedaCambioStato();
			modelSchedaCambioStato.setDataFine(next.getDataFine());
			modelSchedaCambioStato.setDataInizio(next.getDataInizio());
			modelSchedaCambioStato.setSchedaId(next.getSchedaId());

			ModelSchedaStato modelSchedaStato = new ModelSchedaStato();
			modelSchedaCambioStato.setStato(modelSchedaStato);
			modelSchedaStato.setCodice(next.getCodiceStato());
			modelSchedaStato.setNome(next.getDescrizioneStato());
			modelSchedaCambioStato.setStato(modelSchedaStato);

			ModelSchedaCambioStatoUtente modelSchedaCambioStatoUtente = new ModelSchedaCambioStatoUtente();
			modelSchedaCambioStatoUtente.setCodiceFiscale(next.getCodiceFiscale());
			modelSchedaCambioStatoUtente.setCognome(next.getCognome());
			modelSchedaCambioStatoUtente.setEmail(next.getEmail());
			modelSchedaCambioStatoUtente.setNome(next.getNome());
			modelSchedaCambioStatoUtente.setTelefono(next.getTelefono());
			modelSchedaCambioStato.setUtente(modelSchedaCambioStatoUtente);

			elencoCambioStati.add(modelSchedaCambioStato);
		}

		return elencoCambioStati;
	}

	private ModelSchedaSoggettoComune getModelComune(String codiceIstat) {

		Comuni comune = baseComuniMapper.selectByPrimaryKey(codiceIstat);

		ModelSchedaSoggettoComune modelSchedaSoggettoComune = new ModelSchedaSoggettoComune();

		if (comune != null) {
			modelSchedaSoggettoComune.setIstat(comune.getIstatComune());
			modelSchedaSoggettoComune.setNome(comune.getNomeComune());
		}

		return modelSchedaSoggettoComune;
	}

	public ModelIntervento getIntervento(Integer idIntervento) {

		InterventoCustomDto interventoDB = schedeApiMapper.selectInterventoById(idIntervento);

		ModelIntervento modelIntervento = new ModelIntervento();

		if (interventoDB != null) {
			modelIntervento.setId(interventoDB.getIntId());
			modelIntervento.setDescrizione(interventoDB.getIntDesc());
			modelIntervento.setAzioneDescrizione(interventoDB.getIntAzioneIntrapresa());
			modelIntervento.setData(interventoDB.getIntData());

			ModelInterventoAzione modelInterventoAzione = new ModelInterventoAzione();
			modelInterventoAzione.setCodice(interventoDB.getAzCod());
			modelInterventoAzione.setId(interventoDB.getAzId());
			modelInterventoAzione.setNome(interventoDB.getAzDesc());
			modelIntervento.setAzione(modelInterventoAzione);

			ModelInterventoTipo modelInterventoTipo = new ModelInterventoTipo();
			modelInterventoTipo.setCodice(interventoDB.getIntTipoCod());
			modelInterventoTipo.setId(interventoDB.getIntTipoId());
			modelInterventoTipo.setNome(interventoDB.getIntTipoDesc());
			modelIntervento.setTipo(modelInterventoTipo);

			modelIntervento.setPrescrizioni(getElencoPrescrizioniIntervento(interventoDB.getIntId()));
		}

		return modelIntervento;
	}

	public ModelScheda getScheda(Integer idScheda) {

		ModelScheda modelScheda = new ModelScheda();

		CovidusTScheda schedaDB = schedeApiMapper.selectSchedaByPrimaryKey(idScheda);

		if (schedaDB != null) {

			modelScheda.setCritica(schedaDB.getSchCritica());
			modelScheda.setData(schedaDB.getSchData());
			modelScheda.setDescrizione(schedaDB.getSchDescrizione());
			modelScheda.setTerapiaCronica(schedaDB.getSchTerapiaCronica());
			
			// NUOVI FLAG
			modelScheda.setRichiestaMmg(schedaDB.getRichiestaMmg());
			modelScheda.setVisibileMedEmergenza(schedaDB.getVisibileMedicoEmergenza());
			modelScheda.setVisibileMedContAssistenziale(schedaDB.getVisibileMedicoContinuitaAss());
			
			// MONITORAGGIO TIPO 
			if(schedaDB.getMonitoraggioTipoId() !=null) {
				
				CovidusDMonitoraggioTipo tipoMonitoraggioDB = baseCovidusDMonitoraggioTipoMapper.selectByPrimaryKey(schedaDB.getMonitoraggioTipoId());
				ModelMonitoraggioTipo tipoMonitoraggio = new ModelMonitoraggioTipiCovidusDMonitoraggioTipiMapping().from(tipoMonitoraggioDB);
				modelScheda.setMonitoraggioTipo(tipoMonitoraggio);
			}
			
			modelScheda.setId(CaUtils.toString(schedaDB.getSchId()));
			
			
			// NUOVO Carico documenti di una scheda
			List<CovidusTFile> filescheda = covidusTFileMapper.selectFileByRSchedaId(schedaDB.getSchId());
			if(filescheda!=null && !filescheda.isEmpty()) {
				List<ModelDocumento> documenti = new ModelDocumentoCovidusTFileMapping().fromList(filescheda);
				modelScheda.setDocumenti(documenti);
			}
			
			List<InterventoCustomDto> listaInterventi = schedeApiMapper.selectInterventoByIdScheda(schedaDB.getSchId());
			
			List<ModelIntervento> listaModelInterventi = new ArrayList<ModelIntervento>();
			for (InterventoCustomDto interventoDB : listaInterventi) {
				
				if (interventoDB != null) {
					
					
					ModelIntervento modelIntervento = new ModelIntervento();
					modelIntervento.setId(interventoDB.getIntId());
					modelIntervento.setDescrizione(interventoDB.getIntDesc());
					modelIntervento.setAzioneDescrizione(interventoDB.getIntAzioneIntrapresa());
					modelIntervento.setData(interventoDB.getIntData());
	
					
					// NUOVO Carico documenti di un intervento
					List<CovidusTFile> filesInterventi = covidusTFileMapper.selectFileByRInterventoId(interventoDB.getIntId());
					if(filesInterventi!=null && !filesInterventi.isEmpty()) {
						List<ModelDocumento> documenti = new ModelDocumentoCovidusTFileMapping().fromList(filesInterventi);
						modelIntervento.setDocumenti(documenti);
					}
					
					ModelInterventoAzione modelInterventoAzione = new ModelInterventoAzione();
					modelInterventoAzione.setCodice(interventoDB.getAzCod());
					modelInterventoAzione.setId(interventoDB.getAzId());
					modelInterventoAzione.setNome(interventoDB.getAzDesc());
					modelIntervento.setAzione(modelInterventoAzione);
	
					ModelInterventoTipo modelInterventoTipo = new ModelInterventoTipo();
					modelInterventoTipo.setCodice(interventoDB.getIntTipoCod());
					modelInterventoTipo.setId(interventoDB.getIntTipoId());
					modelInterventoTipo.setNome(interventoDB.getIntTipoDesc());
					modelIntervento.setTipo(modelInterventoTipo);
					
					/** 
					 * Aggiunta info medico responsabile dell'intervento
					 */
					ModelUtenteContatto modelUtenteContatto = new ModelUtenteContatto();
					if(interventoDB.getMedicoResponsabile()!=null) {
						
						modelUtenteContatto.setCodiceFiscale(interventoDB.getMedicoResponsabile().getCfUtente());
						modelUtenteContatto.setCognome(interventoDB.getMedicoResponsabile().getCognome());
						modelUtenteContatto.setEmail(interventoDB.getMedicoResponsabile().getEmail());
						modelUtenteContatto.setNome(interventoDB.getMedicoResponsabile().getNome());
						modelUtenteContatto.setTelefono(interventoDB.getMedicoResponsabile().getTelefono());
						modelIntervento.setMedicoResponsabile(modelUtenteContatto);
					}
	
					modelIntervento.setPrescrizioni(getElencoPrescrizioniIntervento(interventoDB.getIntId()));
	
					//modelScheda.setIntervento(modelIntervento);
					listaModelInterventi.add(modelIntervento);
				}
			
			}
			modelScheda.setIntervento(listaModelInterventi);

			UtenteContatto medicoDB = schedeApiMapper.selectUtenteContattoByCf(schedaDB.getUtenteOperazione());
			if (medicoDB != null) {
				ModelSchedaMedico modelSchedaMedico = new ModelSchedaMedico();
				modelSchedaMedico.setCodiceFiscale(medicoDB.getCfUtente());
				modelSchedaMedico.setCognome(medicoDB.getCognome());
				modelSchedaMedico.setEmail(medicoDB.getEmail());
				modelSchedaMedico.setNome(medicoDB.getNome());
				modelSchedaMedico.setTelefono(medicoDB.getTelefono());
				modelScheda.setMedico(modelSchedaMedico);
			}

			Soggetto soggettoDB = baseSoggettoMapper.selectByPrimaryKey(schedaDB.getIdSoggetto());
			if (soggettoDB != null) {
				ModelSchedaSoggetto modelSchedaSoggetto = new ModelSchedaSoggetto();
				modelSchedaSoggetto.setCodiceFiscale(soggettoDB.getCodiceFiscale());
				modelSchedaSoggetto.setCognome(soggettoDB.getCognome());
				modelSchedaSoggetto.setDataNascita(soggettoDB.getDataNascita());
				modelSchedaSoggetto.setEmail(soggettoDB.getEmail());
				modelSchedaSoggetto.setId(CaUtils.toInteger(soggettoDB.getIdSoggetto()));
				modelSchedaSoggetto.setNome(soggettoDB.getNome());
				modelSchedaSoggetto.setTelefono(soggettoDB.getTelefonoRecapito());
				modelSchedaSoggetto.setDomicilioAsl(soggettoDB.getAslDomicilio());
				modelSchedaSoggetto.setResidenzaAsl(soggettoDB.getAslResidenza());
				modelSchedaSoggetto.setDomicilioComune(getModelComune(soggettoDB.getComuneDomicilioIstat()));
				modelSchedaSoggetto.setResidenzaComune(getModelComune(soggettoDB.getComuneResidenzaIstat()));
				modelSchedaSoggetto.setDomicilioIndirizzo(soggettoDB.getIndirizzoDomicilio());

				modelScheda.setSoggetto(modelSchedaSoggetto);
			}

			CovidusDSchedaStato statoDB = schedeApiMapper.selectStatoByIdScheda(schedaDB.getSchId());
			if (statoDB != null) {
				ModelSchedaStato modelSchedaStato = new ModelSchedaStato();
				modelSchedaStato.setCodice(statoDB.getSchStatoCod());
				modelSchedaStato.setNome(statoDB.getSchStatoDesc());
				modelScheda.setStato(modelSchedaStato);
			}

			Struttura strutturaDB = baseStrutturaMapper.selectByPrimaryKey(schedaDB.getIdStruttura());
			if (strutturaDB != null) {
				ModelStruttura modelStruttura = new ModelStruttura();
				modelStruttura.setId(strutturaDB.getIdStruttura());
				modelStruttura.setNatura(strutturaDB.getNatura());
				modelStruttura.setNome(strutturaDB.getNome());

				ModelEnte modelEnte = new ModelEnte();
				Ente enteDB = baseEnteMapper.selectByPrimaryKey(strutturaDB.getIdEnte());
				if (enteDB != null) {
					modelEnte.setId(enteDB.getIdEnte());
					modelEnte.setNome(enteDB.getNome());
					modelStruttura.setEnte(modelEnte);
				}

				modelScheda.setUsca(modelStruttura);
			}

			modelScheda.setCronologia(getCronologiaCambioStato(schedaDB.getSchId()));

			modelScheda.setPrescrizioni(getElencoPrescrizioniScheda(schedaDB.getSchId()));
		}

		return modelScheda;
	}

	public List<ModelPrescrizione> getElencoPrescrizioniIntervento(Integer idIntervento) {
		List<ModelPrescrizione> elencoPrescrizioni = new ArrayList<ModelPrescrizione>();

		List<PrescrizioneInterventoCustomDto> elencoPrescrizioniDB = schedeApiMapper
				.selectPrescrizioniInterventoByIdIntervento(idIntervento);

		Iterator<PrescrizioneInterventoCustomDto> iterator = elencoPrescrizioniDB.iterator();

		while (iterator.hasNext()) {
			PrescrizioneInterventoCustomDto next = iterator.next();

			ModelPrescrizione modelPrescrizione = new ModelPrescrizione();

			modelPrescrizione.setId(CaUtils.toString(next.getIntprescId()));
			modelPrescrizione.setPrescrizione(next.getPrescrizione());

			ModelPrescrizioneTipo modelPrescrizioneTipo = new ModelPrescrizioneTipo();
			modelPrescrizioneTipo.setCodice(next.getPrescTipoCod());
			modelPrescrizioneTipo.setId(CaUtils.toString(next.getPrescTipoId()));
			modelPrescrizioneTipo.setNome(next.getPrescTipoDesc());

			// NUOVI CAMPI
			modelPrescrizione.setValore(next.getValore()!=null ? next.getValore() :"");
			modelPrescrizione.setConsegnatoDaFarmacia(next.getFarmConsegnato());
			modelPrescrizione.setDataConsegnaFarmacia(next.getFarmConsegnaData()!=null ? next.getFarmConsegnaData() : null);
			
			//FIXME 
			// FARMACISTA
			
			if(next.getFarmaco()!=null) {
				ModelFarmaco farmaco = new ModelFarmacoCovidusDFarmacoMapping().from(next.getFarmaco());
				modelPrescrizione.setFarmaco(farmaco);
			}
			
			if(next.getOssigenoTerapia()!=null) {
				ModelOssigenoterapia ossigenoterapia = new ModelOssigenoterapiaCovidusDOssigenoTerapiaMapping().from(next.getOssigenoTerapia());
				modelPrescrizione.setOssigenoterapia(ossigenoterapia);
			}
			
			
			
			modelPrescrizione.setTipo(modelPrescrizioneTipo);

			elencoPrescrizioni.add(modelPrescrizione);
		}

		return elencoPrescrizioni;
	}

	public List<ModelPrescrizione> getElencoPrescrizioniScheda(Integer idScheda) {
		List<ModelPrescrizione> elencoPrescrizioni = new ArrayList<ModelPrescrizione>();

		List<PrescrizioneSchedaCustomDto> elencoPrescrizioniDB = schedeApiMapper.selectPrescrizioniByIdScheda(idScheda);

		Iterator<PrescrizioneSchedaCustomDto> iterator = elencoPrescrizioniDB.iterator();

		while (iterator.hasNext()) {
			PrescrizioneSchedaCustomDto next = iterator.next();

			ModelPrescrizione modelPrescrizione = new ModelPrescrizione();

			modelPrescrizione.setId(CaUtils.toString(next.getSchprescId()));
			modelPrescrizione.setPrescrizione(next.getPrescrizione());
			modelPrescrizione.setValore(next.getValore()!=null ? next.getValore() :"");
			modelPrescrizione.setConsegnatoDaFarmacia(next.getFarmConsegnato());
			modelPrescrizione.setDataConsegnaFarmacia(next.getFarmConsegnaData()!=null ? next.getFarmConsegnaData() : null);
			
			//FIXME 
			// FARMACISTA
			boolean consensoNecessario = false;
			if(next.getFarmaco()!=null) {
				ModelFarmaco farmaco = new ModelFarmacoCovidusDFarmacoMapping().from(next.getFarmaco());
				modelPrescrizione.setFarmaco(farmaco);
				
				consensoNecessario = isFarmacoConsensoNecessario(next.getFarmaco().getFarmId());
				
				if(consensoNecessario) {
					
					/**
					CovidusTConsensoFarmaco tconsenso = consensoFarmacoMapper.selectConsensoByFarmId(next.getFarmaco().getFarmId());
					if(tconsenso!=null && isConsensoScritto(tconsenso.getConsTipoId())) {
						List<CovidusTFile> files = consensoFarmacoTFileMapper.selectInfoConsensiTFileByIdConsensoFarmaco(tconsenso.getConsfarmId());
						List<ModelDocumento> docs = new ModelDocumentoCovidusTFileMapping().fromList(files);
						
						// fixme verificare se serve, nello yaml x ora non c'e
						
					}
					*/
					
				}
				
			}
			
			if(next.getOssigenoTerapia()!=null) {
				ModelOssigenoterapia ossigenoterapia = new ModelOssigenoterapiaCovidusDOssigenoTerapiaMapping().from(next.getOssigenoTerapia());
				modelPrescrizione.setOssigenoterapia(ossigenoterapia);
			}

			ModelPrescrizioneTipo modelPrescrizioneTipo = new ModelPrescrizioneTipo();
			modelPrescrizioneTipo.setCodice(next.getPrescTipoCod());
			modelPrescrizioneTipo.setId(CaUtils.toString(next.getPrescTipoId()));
			modelPrescrizioneTipo.setNome(next.getPrescTipoDesc());

			modelPrescrizione.setTipo(modelPrescrizioneTipo);

			elencoPrescrizioni.add(modelPrescrizione);
		}

		return elencoPrescrizioni;
	}
	
	
	protected boolean isFarmacoConsensoNecessario(Integer farmaId) {
		CovidusDFarmaco dfarmaco = baseCovidusDFarmacoMapper.selectByPrimaryKey(farmaId);
		boolean consensoNecessario = dfarmaco !=null && dfarmaco.getFarmConsensoNecessario();
		return consensoNecessario;
	}

	protected boolean isConsensoScritto(Integer consTipoId) {
		CovidusDConsensoTipo consensoTipo = baseCovidusDConsensoTipoMapper.selectByPrimaryKey(consTipoId);
		return consensoTipo!=null && consensoTipo.getConsTipoCod().equalsIgnoreCase("S");
	}
	
	
	
	protected StreamingOutput convertObjectsToXlsx(List<SchedeCustomDto> list) {
		final XSSFWorkbook workbook = createWorkbook();

		if (list != null) {
			
			
			Sheet sheet = workbook.getSheet("Schede");

			XSSFFont headerFont = workbook.createFont();
			headerFont.setFontName("Arial");
			headerFont.setFontHeightInPoints((short) 8);
			headerFont.setBold(true);

			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			//cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setFillForegroundColor(IndexedColors.WHITE.index);
			cellStyle.setFont(headerFont);
			cellStyle.setWrapText(false);
			
			
			CellStyle cellDateStyle = workbook.createCellStyle();
			cellDateStyle.setBorderBottom(BorderStyle.THIN);
			cellDateStyle.setBorderTop(BorderStyle.THIN);
			cellDateStyle.setBorderRight(BorderStyle.THIN);
			cellDateStyle.setBorderLeft(BorderStyle.THIN);
			//cellDateStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellDateStyle.setFillForegroundColor(IndexedColors.WHITE.index);
			cellDateStyle.setFont(headerFont);
			cellDateStyle.setWrapText(false);
			cellDateStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("dd/mm/yyyy"));

			
			int indexRow = 1;
			for (SchedeCustomDto scheda : list) {
				
				int indexColumn = 0;
			
				// prime colonne 
				Row row = sheet.createRow(indexRow);
				
				
				// Cognome + Nome
				Cell cell = row.createCell(indexColumn);
				//cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getCognomeSoggetto() + " " + scheda.getNomeSoggetto());
				indexColumn++;
				
				// Nome 
//				cell = row.createCell(indexColumn);
//				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
//				cell.setCellValue(scheda.getNomeSoggetto());
//				indexColumn++;
				
				// CF
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getCodiceFiscale());
				indexColumn++;
				
				// Data Nascita Soggetto
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellDateStyle);
				cell.setCellValue(scheda.getDataNascitaSoggetto());
				indexColumn++;

				// Asl Domicilio
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getAslDomicilio());
				indexColumn++;
				
				// Indirizzo Domicilio
				String indirizzoDomicilio = scheda.getIndirizzoDomicilio() !=null ? scheda.getIndirizzoDomicilio() :"";
				String comuneDescrizione = scheda.getComuneDescrizione()!=null ? scheda.getComuneDescrizione() : "Non censito";
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(indirizzoDomicilio + " " + comuneDescrizione);
				indexColumn++;
				
				
				// Desc scheda
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getDescrizioneScheda());
				indexColumn++;
				

				// critica 
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getCritica()!=null && scheda.getCritica()? "SI" : " NO");
				indexColumn++;

				// richiesta mmg 
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getRichiestaMmg()!=null && scheda.getRichiestaMmg()? "SI" : " NO");
				indexColumn++;
				
				// Monitoraggio
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getMonitoraggioTipo()!=null? scheda.getMonitoraggioTipo().getMonitoraggioTipoDesc() : "");
				indexColumn++;
				
				// Stato
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				String statoDesc = "";
				
				if(scheda.getStatoSchedaCod().equalsIgnoreCase(StatoEnum.INVIATO.getCodice())) {
					statoDesc = "IN ATTESA";
				}else if(scheda.getStatoSchedaCod().equalsIgnoreCase(StatoEnum.PRESO_IN_CARICO.getCodice())){
					statoDesc = "IN CARICO";
				}else if(scheda.getStatoSchedaCod().equalsIgnoreCase(StatoEnum.ESEGUITO.getCodice())){
					statoDesc = "EVASO";
				}else if(scheda.getStatoSchedaCod().equalsIgnoreCase(StatoEnum.RESPINTO.getCodice())){
					statoDesc = "RIFIUTATO";
				}
				
				cell.setCellValue(statoDesc);
				indexColumn++;
				
				
				
				// Medico 
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getNomeMedico() +" "+ scheda.getCognomeMedico());
				indexColumn++;
				
				// Email medico 
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getEmailMedico());
				indexColumn++;

				// Data Richiesta
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellDateStyle);
				cell.setCellValue(scheda.getDataScheda());
				indexColumn++;

				// Id Struttura
//				cell = row.createCell(indexColumn);
//				cell.setCellStyle(sheet.getRow(0).getCell(indexColumn).getCellStyle());
//				cell.setCellValue(scheda.getIdStruttura());
//				indexColumn++;
				
				// Struttura
				cell = row.createCell(indexColumn);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(scheda.getNomeStruttura());
				indexColumn++;

				indexRow++;
			}
		}

		StreamingOutput streamOutput = new StreamingOutput() {

			@Override
			public void write(OutputStream out) throws IOException, WebApplicationException {
				workbook.write(out);
			}

		};

		return streamOutput;
	}

	
	
	private static XSSFWorkbook createWorkbook() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Schede");
		Row header = sheet.createRow(0);

		XSSFFont headerFont = workbook.createFont();
		headerFont.setFontName("Arial");
		headerFont.setFontHeightInPoints((short) 9);
		headerFont.setBold(true);

		XSSFFont rowFont = workbook.createFont();
		rowFont.setFontName("Arial");
		rowFont.setFontHeightInPoints((short) 8);
		rowFont.setBold(false);
		int i = 0;
		for (String hName : headers) {
			CellStyle headerStyle = workbook.createCellStyle();
			Cell headerCell = header.createCell(i);
			headerCell.setCellValue(hName);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(headersColors[i].index);
			headerStyle.setFont(headerFont);
			headerStyle.setWrapText(true);
			headerCell.setCellStyle(headerStyle);
			sheet.setColumnWidth(i, headersWidth[i]);
			i++;
		}

		return workbook;
	}

	private static String[] headers = { 			
			"Assistito", "Codice fiscale", "Data di nascita", 
			"Asl di domicilio", "Indirizzo di domicilio", 
			"Descrizione scheda", "Critica", "Richiesta MMG", "Monitoraggio", "Stato",
			"Medico", "Data richiesta", "Email medico", 
			"Struttura"  };


	
	private static IndexedColors[] headersColors = { 
			IndexedColors.AQUA,IndexedColors.AQUA, IndexedColors.AQUA, IndexedColors.AQUA, 
			IndexedColors.AQUA, IndexedColors.AQUA, 
			IndexedColors.AQUA, IndexedColors.AQUA,  
			IndexedColors.AQUA, IndexedColors.AQUA,
			IndexedColors.AQUA,IndexedColors.AQUA, IndexedColors.AQUA, IndexedColors.AQUA
			};
	
	private static Integer[] headersWidth = { 
			6000, 6000, 6000, 6000, 6000, 6000, 6000, 6000,
			6000, 6000, 6000, 6000, 6000, 6000 };

}
