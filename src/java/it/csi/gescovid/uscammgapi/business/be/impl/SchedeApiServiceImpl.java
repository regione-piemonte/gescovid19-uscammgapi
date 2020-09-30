package it.csi.gescovid.uscammgapi.business.be.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.uscammgapi.business.be.SchedeApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDInterventoTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSchedaStato;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRConsensoFarmacoFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRInterventoFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRInterventoPresc;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRSChedaFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRSchedaPresc;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRSchedaStato;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTConsensoFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTIntervento;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTScheda;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.ProfiloEnum;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.ContatoreCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.InformazioniUtenteCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.SchedeCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.CommonApiMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.ConsensiFarmaciMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.DiarioDettagliMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.InterventoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.RConsensoFarmacoFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.RInterventoFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.RInterventoPrescrizioneMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SchedeApiMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.UtentiMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDFarmacoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDMonitoraggioTipoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRConsensoFarmacoFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRInterventoFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRInterventoPrescMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRSChedaFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTInterventoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTSchedaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.util.Paginazione;
import it.csi.gescovid.uscammgapi.business.be.impl.service.SchedeApiHelperService;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoAzione;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoTipo;
import it.csi.gescovid.uscammgapi.dto.ModelScheda;
import it.csi.gescovid.uscammgapi.dto.Payload;
import it.csi.gescovid.uscammgapi.dto.Payload1;
import it.csi.gescovid.uscammgapi.dto.Payload2;
import it.csi.gescovid.uscammgapi.dto.Payload8;
import it.csi.gescovid.uscammgapi.dto.SchedeConsensoDocumenti;
import it.csi.gescovid.uscammgapi.dto.SchedeDocumenti;
import it.csi.gescovid.uscammgapi.dto.SchedePrescrizioni;
import it.csi.gescovid.uscammgapi.exception.ErroreBuilder;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.CaUtils;
import it.csi.gescovid.uscammgapi.util.LogUtil;

import static it.csi.gescovid.uscammgapi.business.be.impl.mapper.util.MapperUtil.toBoolean;
import static it.csi.gescovid.uscammgapi.business.be.impl.mapper.util.MapperUtil.toInteger;
import static it.csi.gescovid.uscammgapi.business.be.impl.mapper.util.MapperUtil.toLike;
import static it.csi.gescovid.uscammgapi.business.be.impl.mapper.util.MapperUtil.toListString;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class SchedeApiServiceImpl extends SchedeApiHelperService implements SchedeApi {
	@Autowired
	DiarioDettagliMapper diarioDettagliMapper;
	
	@Autowired
	BaseCovidusTInterventoMapper baseCovidusTInterventoMapper;
	
	@Autowired
	BaseCovidusDFarmacoMapper baseCovidusDFarmacoMapper;
	
	@Autowired
	CovidusTFileMapper covidusTFileMapper;

	@Autowired
	RConsensoFarmacoFileMapper rConsensoFarmacoFileMapper;

	@Autowired
	RInterventoFileMapper rInterventoFileMapper;

	@Autowired
	RInterventoPrescrizioneMapper rInterventoPrescrizioneMapper;

	@Autowired
	InterventoMapper interventoMapper;

	@Autowired
	SchedeApiMapper schedeApiMapper;

	@Autowired
	UtentiMapper utentiMapper;

	@Autowired
	CommonApiMapper commonApiMapper;

	@Autowired
	BaseCovidusTFileMapper baseCovidusTFileMapper;

	@Autowired
	ConsensiFarmaciMapper consensoFarmacoMapper;

	@Autowired
	BaseCovidusRConsensoFarmacoFileMapper baseCovidusRConsensoFarmacoFileMapper;

	@Autowired
	BaseCovidusRInterventoFileMapper baseCovidusRInterventoFileMapper;

	@Autowired
	BaseCovidusRSChedaFileMapper baseCovidusRSChedaFileMapper;

	@Autowired
	BaseCovidusRInterventoPrescMapper baseCovidusRInterventoPrescMapper;

	@Autowired
	BaseCovidusTSchedaMapper baseCovidusTSchedaMapper;
	
	
	@Autowired
	BaseCovidusDMonitoraggioTipoMapper baseCovidusDMonitoraggioTipoMapper;
	
	LogUtil log = new LogUtil(this.getClass());

	@Override
	public Response schedeGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer soggetto, String stati, String medico,String idMonitoraggioTipo, String filter, String idStrutturaStr,String codSchStato, String orderby, 
			 Long rowPerPage,Long pageNumber,String descendingStr,SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		
		String methodName = "schedeGet";
		log.info(methodName, "BEGIN");
		
		
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			logAudit(httpHeaders, "select", "covidus_t_scheda", "selectAll");

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);


			List<InformazioniUtenteCustomDto> selectInformazioniUtente = commonApiMapper
					.selectInformazioniUtente(shibIdentitaCodiceFiscale);
			
			if(selectInformazioniUtente == null || selectInformazioniUtente.isEmpty()) {
				
				// se il chiamante e' il frontend USCA, quindi codice applicazione MED USCA, ritorno errore
				if(xApplicazioneCodice.equalsIgnoreCase(ProfiloEnum.MEDICO_USCA.getCodice())){
					return ErroreBuilder.from(Status.NOT_FOUND)
							.descrizione("Uente non associato a strutture").exception()
							.getResponseBuilder().build();
				}

			}


			Iterator<InformazioniUtenteCustomDto> iterator = selectInformazioniUtente.iterator();
			
			List<String> elencoIdStruttura = new ArrayList<String>();
			while (iterator.hasNext()) {
				InformazioniUtenteCustomDto next = iterator.next();
				elencoIdStruttura.add(next.getStrutturaId());
			}

			
			List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(shibIdentitaCodiceFiscale);
			// Nuova gestione
			Boolean visibileMed118 = false;
			Boolean visibileMedCa = false;
			Boolean richiesteMmg = null;

			for (Profilo profilo : elencoProfiliDB) {
				// aggiungo controllo sul profilo per la visibilita
				if (profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_118.getCodice())) {
					visibileMed118 = true;
					visibileMedCa = null;

				} else if (profilo.getNomeProfilo()
						.equalsIgnoreCase(ProfiloEnum.MEDICO_CONTASSISTENZIALE.getCodice())) {
					visibileMed118 = null;
					visibileMedCa = true;

				} else if (profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_MMG.getCodice()) || profilo
						.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_GESTIONE_PAZIENTI.getCodice())) {
					visibileMed118 = null;
					visibileMedCa = null;
					richiesteMmg = null;
					break;
				} else if (profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_USCA.getCodice())) {
					visibileMed118 = null;
					visibileMedCa = null;
					richiesteMmg = null;
					break;
				}
			}
			
			Paginazione paginazione = new Paginazione(orderby, rowPerPage, pageNumber, toBoolean(descendingStr));


			List<ModelScheda> elencoSchede = getElencoSchede(soggetto, convertiStrutture(elencoIdStruttura),
					convertiStati(stati), medico, visibileMed118, visibileMedCa, richiesteMmg, paginazione, 
					toInteger(idMonitoraggioTipo),toListString(idStrutturaStr, ",", null), codSchStato,
					toLike(filter)
					);
			
			Long rowsNumber;
			if(paginazione.isActive()) {
				//rowsNumber = schedeApiMapper.selectElencoSchedePagedCount(soggetto, convertiStrutture(elencoIdStruttura), convertiStati(stati), 
					//	medico, visibileMed118, visibileMedCa, richiesteMmg, toInteger(idMonitoraggioTipo),toListString(idStrutturaStr, ",", null),  toInteger(idSchStato),toLike(filter));
				rowsNumber = 0L;
				if(elencoSchede!=null && !elencoSchede.isEmpty()) {
					rowsNumber = elencoSchede.get(0).getTotalCount();
					if(rowsNumber==null) {
						rowsNumber = 0L;
					}
				}
			
			} else {
				rowsNumber = elencoSchede==null?0L: elencoSchede.size();
			}
			

			return Response.ok(elencoSchede).header("Rows-Number", rowsNumber).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	public String convertiStrutture(List<String> elencoIdStruttura) {
		String res = "";

		if (elencoIdStruttura.size() == 0) {
			return null;
		}

		Iterator<String> iterator = elencoIdStruttura.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();

			if (res.isEmpty()) {
				res = "'" + next.trim() + "'";
			} else {
				res += ",'" + next.trim() + "'";
			}
		}

		return res;
	}

	public String convertiStati(String stati) {
		String res = "";

		if (stati == null) {
			return null;
		}

		StringTokenizer str = new StringTokenizer(stati, ",");
		while (str.hasMoreTokens()) {
			String nextToken = str.nextToken();

			if (res.isEmpty()) {
				res = "'" + nextToken.trim() + "'";
			} else {
				res += ",'" + nextToken.trim() + "'";
			}
		}

		return res;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response schedePost(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Payload payload, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedePost";
		log.info(methodName, "BEGIN");

		try {
			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
			checkNotBlank(payload.getDescrizione(), "Descrizione non valorizzata");
			checkNotBlank(payload.getStato(), "Stato non valorizzato");
			checkNotNull(payload.getSoggetto(), "Soggetto non valorizzato");
			checkNotNull(payload.getStruttura(), "Struttura non valorizzata");
			checkNotNull(payload.isCritica(), "Criticita non specificata");

			List<SchedePrescrizioni> prescrizioni = payload.getPrescrizioni();
			checkNotNull(prescrizioni, "Prescrizioni non valorizzate");
			checkDettagli(prescrizioni);

			ContatoreCustomDto schedeAttivePerSoggetto = schedeApiMapper
					.selectSchedeAttivePerSoggetto(payload.getSoggetto());
			if (schedeAttivePerSoggetto != null && schedeAttivePerSoggetto.getNumero().intValue() > 0) {
				return ErroreBuilder.from(Status.BAD_REQUEST)
						.descrizione("E' gia' presente una scheda attiva per il soggetto specificato").exception()
						.getResponseBuilder().build();

			}

			CovidusTScheda covidusTScheda = new CovidusTScheda();
			covidusTScheda.setIdSoggetto(CaUtils.toLong(payload.getSoggetto()));
			covidusTScheda.setIdStruttura(payload.getStruttura());
			covidusTScheda.setSchCritica(payload.isCritica());
			covidusTScheda.setSchDescrizione(payload.getDescrizione());
			covidusTScheda.setUtenteOperazione(shibIdentitaCodiceFiscale);
			covidusTScheda.setRichiestaMmg(Boolean.TRUE); // inserimento da mmg
			covidusTScheda.setSchData(new Date());

			// Questi arrivano da visurammg
			covidusTScheda.setVisibileMedicoEmergenza(payload.getVisibileMed118()); // visibilita 118
			covidusTScheda.setVisibileMedicoContinuitaAss(payload.getVisibileMedCa()); // visibilita med

			covidusTScheda.setSchTerapiaCronica(payload.getTerapiaCronica());

			schedeApiMapper.insertSchedaExt(covidusTScheda);
			logAudit(httpHeaders, "insert", "covidus_t_scheda", mapper.writeValueAsString(covidusTScheda));
			log.info(methodName, "inserita nuova scheda - covidus_t_scheda => sch_id: " + covidusTScheda.getSchId());

			List<SchedeDocumenti> documenti = payload.getDocumenti();
			// Danilo: gestione documenti
			if (documenti != null && !documenti.isEmpty()) {
				for (SchedeDocumenti documento : documenti) {
					if (documento != null) {
						CovidusTFile covidusTFile = new CovidusTFile();
						// covidusTFile.setFileId(fileId);

						salvaDocumento(shibIdentitaCodiceFiscale, documento.getNome(), documento.getBase64(),
								covidusTFile);
						logAudit(httpHeaders, "insert", "covidus_t_file", mapper.writeValueAsString(covidusTFile));
						log.info(methodName,
								"inserito nuovo documento - covidus_t_file => fileId: " + covidusTFile.getFileId());

						// Inserisco relazione tra doc e scheda
						CovidusRSChedaFile rschedafile = new CovidusRSChedaFile();
						rschedafile.setDataCreazione(new Date());
						rschedafile.setDataModifica(new Date());
						rschedafile.setFileId(covidusTFile.getFileId());
						rschedafile.setSchId(covidusTScheda.getSchId());
						rschedafile.setUtenteOperazione(shibIdentitaCodiceFiscale);
						baseCovidusRSChedaFileMapper.insert(rschedafile);
						logAudit(httpHeaders, "insert", "covidus_r_scheda_file",
								mapper.writeValueAsString(rschedafile));
						log.info(methodName,
								"inserita nuova relazione tra scheda e documento - covidus_r_scheda_file => rschedafile: "
										+ rschedafile.getSchFileId());
					}

				}
			}
			// fine gestione documenti

			CovidusDSchedaStato covidusDSchedaStato = schedeApiMapper.selectSchedaStatoByCodStato(payload.getStato());

			CovidusRSchedaStato covidusRSchedaStato = new CovidusRSchedaStato();
			// covidusRSchedaStato.setIdProfiloOperazione(); //FIXME
			covidusRSchedaStato.setSchId(covidusTScheda.getSchId());
			covidusRSchedaStato.setSchStatoId(covidusDSchedaStato.getSchStatoId());
			covidusRSchedaStato.setUtenteOperazione(shibIdentitaCodiceFiscale);
			schedeApiMapper.insertRSchedaStato(covidusRSchedaStato);
			logAudit(httpHeaders, "insert", "covidus_r_scheda_stato", mapper.writeValueAsString(covidusRSchedaStato));
			log.info(methodName, "inserito nuovo stato scheda - covidus_r_scheda_stato => scar_stato_id: "
					+ covidusRSchedaStato.getScarStatoId());

			List<SchedePrescrizioni> prescrizioniIns = payload.getPrescrizioni();
			Iterator<SchedePrescrizioni> iterator = prescrizioniIns.iterator();

			while (iterator.hasNext()) {

				SchedePrescrizioni next = iterator.next();

				CovidusRSchedaPresc covidusRSchedaPresc = new CovidusRSchedaPresc();
				covidusRSchedaPresc.setPrescrizione(next.getPrescrizione());
				covidusRSchedaPresc.setPrescTipoId(next.getTipo());
				covidusRSchedaPresc.setSchId(covidusTScheda.getSchId());
				covidusRSchedaPresc.setUtenteOperazione(shibIdentitaCodiceFiscale);
				// Aggiunta nuovi campi
				if (next.getValore() != null && !next.getValore().isEmpty())
					covidusRSchedaPresc.setValore(next.getValore());

				boolean consensoNecessario = false;
				if (next.getFarmaco() != null) {
					covidusRSchedaPresc.setFarmId(next.getFarmaco());
					consensoNecessario = isFarmacoConsensoNecessario(next.getFarmaco());
				}

				if (next.getOssigenoterapia() != null)
					covidusRSchedaPresc.setOssId(next.getOssigenoterapia());

				// Inserisco nella covidusRSchedaPresc
				schedeApiMapper.insertRSchedaPrescrizione(covidusRSchedaPresc);

				logAudit(httpHeaders, "insert", "covidus_r_scheda_presc",
						mapper.writeValueAsString(covidusRSchedaPresc));
				log.info(methodName, "inserito nuova prescrizione - covidus_r_scheda_presc => schpresc_id: "
						+ covidusRSchedaPresc.getSchprescId());

				// se il farmaco richiede il consenso lo inserisco
				if (consensoNecessario) {

					// checkNotNull(next.getConsenso(), "Consenso non valorizzato");

					if (next.getConsenso() != null) {
						CovidusTConsensoFarmaco covidusTConsensoFarmaco = new CovidusTConsensoFarmaco();
						covidusTConsensoFarmaco.setConsTipoId(next.getConsenso().getTipo());
						covidusTConsensoFarmaco.setIdSoggetto(CaUtils.toLong(payload.getSoggetto()));
						covidusTConsensoFarmaco.setFarmId(next.getFarmaco());
						covidusTConsensoFarmaco.setConsfarmData(new Date());
						covidusTConsensoFarmaco.setDataCreazione(new Date());
						covidusTConsensoFarmaco.setDataModifica(new Date());
						covidusTConsensoFarmaco.setUtenteOperazione(shibIdentitaCodiceFiscale);
						consensoFarmacoMapper.insert(covidusTConsensoFarmaco);
						logAudit(httpHeaders, "insert", "covidus_t_consenso_farmaco",
								mapper.writeValueAsString(covidusTConsensoFarmaco));
						log.info(methodName,
								"inserito nuovo consenso farmaco - covidus_t_consenso_farmaco => consfarmId: "
										+ covidusTConsensoFarmaco.getConsfarmId());

						boolean consensoScritto = isConsensoScritto(next.getConsenso().getTipo());

						if (consensoScritto) {

							// inserisco i documenti del consenso
							List<SchedeConsensoDocumenti> consensoDocs = next.getConsenso().getDocumenti();
							if (consensoDocs != null && !consensoDocs.isEmpty()) {

								for (SchedeConsensoDocumenti documento : consensoDocs) {

									if (documento != null) {
										CovidusTFile covidusTFile = new CovidusTFile();
										// covidusTFile.setFileId(fileId);
										salvaDocumento(shibIdentitaCodiceFiscale, documento.getNome(),
												documento.getBase64(), covidusTFile);

										logAudit(httpHeaders, "insert", "covidus_t_file",
												mapper.writeValueAsString(covidusTFile));

										CovidusRConsensoFarmacoFile covidusRConsensoFarmacoFile = new CovidusRConsensoFarmacoFile();
										covidusRConsensoFarmacoFile
												.setConsfarmId(covidusTConsensoFarmaco.getConsfarmId());
										covidusRConsensoFarmacoFile.setFileId(covidusTFile.getFileId());
										covidusRConsensoFarmacoFile.setUtenteOperazione(shibIdentitaCodiceFiscale);
										// baseCovidusRConsensoFarmacoFileMapper.insert(covidusRConsensoFarmacoFile);
										consensoFarmacoMapper.insertRConsensoFarmacoFile(covidusRConsensoFarmacoFile);
										logAudit(httpHeaders, "insert", "covidus_r_consenso_farmaco_file",
												mapper.writeValueAsString(covidusTFile));

									}

								}
							}
							// fine gestione documenti

						}
					}
				}
			}

			ModelScheda schedaInserita = getScheda(covidusTScheda.getSchId());
			return Response.ok(schedaInserita).build();

		} catch (RESTException e) {
			log.error(methodName, "schedePost ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedePost ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	private void salvaDocumento(String shibIdentitaCodiceFiscale, String filename, String base64String,
			CovidusTFile covidusTFile) {

		covidusTFile.setFileName(filename);

		// byte[] file = Base64.getEncoder().encode(documento.getBase64().getBytes());

		// String base64String =
		// "data:text/html;base64,PGh0bWw+DQogIDxoZWFkPg0KICAgIDx0aXRsZT5QYWdpbmEgZGkgUmVkaXJlY3Q8L3RpdGxlPg0KICAgIDxsaW5rIHJlbD0ibWFuaWZlc3QiIGhyZWY9Im1hbmlmZXN0Lmpzb24iIC8+DQogICAgPG1ldGEgaHR0cC1lcXVpdj0icmVmcmVzaCIgY29udGVudD0iMTtVUkw9Li9ob21lIiAvPg0KICA8L2hlYWQ+DQogIDxib2R5Pg0KICAgIDxwPg0KICAgICAgUmVkaXJlY3QNCiAgICA8L3A+DQogIDwvYm9keT4NCjwvaHRtbD4NCg==";

		String[] strings = base64String.split(",");
		String tipoFile = strings[0];

		String mineType = tipoFile.substring(tipoFile.indexOf(":") + 1, tipoFile.indexOf(";"));
		System.out.println("mineType::" + mineType);

		// convert base64 string to binary data
		// byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
		byte[] file = Base64.getDecoder().decode(strings[1]);

		covidusTFile.setFile(file);
		covidusTFile.setFileType(mineType);
		covidusTFile.setFileSize(BigDecimal.valueOf(file.length));
		covidusTFile.setDataCreazione(new Date());
		covidusTFile.setDataModifica(covidusTFile.getDataCreazione());
		covidusTFile.setUtenteOperazione(shibIdentitaCodiceFiscale);
		baseCovidusTFileMapper.insert(covidusTFile);
	}

	private void checkDettagli(List<SchedePrescrizioni> dettagli) {
		Iterator<SchedePrescrizioni> iterator = dettagli.iterator();

		while (iterator.hasNext()) {
			SchedePrescrizioni next = iterator.next();

			// checkNotNull(next.getPrescrizione(), "Prescrizione non valorizzata");
			checkNotNull(next.getTipo(), "Tipo non valorizzato");
		}
	}

	@Override
	public Response schedeSchedaIdInterventoAzioniGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer schedaId,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedeSchedaIdInterventoAzioniGet";
		log.info(methodName, "BEGIN");

		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			logAudit(httpHeaders, "select", "covidus_t_intervento", "selectAll");

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			// checkNotNull(schedaId, "schedaId non valorizzata");

			List<CovidusDAzione> interventoDB = schedeApiMapper.selectAllDAzioni();

			List<ModelInterventoAzione> elencoInterventi = new ArrayList<ModelInterventoAzione>();

			Iterator<CovidusDAzione> iterator = interventoDB.iterator();
			while (iterator.hasNext()) {
				CovidusDAzione next = iterator.next();

				ModelInterventoAzione modelInterventoAzione = new ModelInterventoAzione();
				modelInterventoAzione.setCodice(next.getAzCod());
				modelInterventoAzione.setId(next.getAzId());
				modelInterventoAzione.setNome(next.getAzDesc());

				elencoInterventi.add(modelInterventoAzione);
			}

			return Response.ok(elencoInterventi).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeSchedaIdInterventoAzioniGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeSchedaIdInterventoAzioniGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response schedeSchedaIdInterventoPost(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer schedaId, Payload2 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedeSchedaIdInterventoPost";
		log.info(methodName, "BEGIN");

		try {
			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			// xApplicazioneCodice = a usca, 118 o guardia medica
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(shibIdentitaCodiceFiscale);

			Boolean visibileAMedici118 = false;
			Boolean visibileAMediciContAss = false;

			for (Profilo profilo : elencoProfiliDB) {
				if (profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_USCA.getCodice())) {
					visibileAMedici118 = Boolean.FALSE;
					visibileAMediciContAss = Boolean.FALSE;
					break;
				} else if (profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_118.getCodice())) {
					visibileAMedici118 = Boolean.TRUE;
					visibileAMediciContAss = Boolean.FALSE;
				} else if (profilo.getNomeProfilo()
						.equalsIgnoreCase(ProfiloEnum.MEDICO_CONTASSISTENZIALE.getCodice())) {
					visibileAMedici118 = Boolean.FALSE;
					visibileAMediciContAss = Boolean.TRUE;
				}
			}

			// Questo controllo va rilassato, da nuove specifiche se schedaid == null
			// siamo nel caso del medico usca o 118 o guardia medica
			Boolean inserimentoDaMMG = Boolean.TRUE;
			if (schedaId == 0) {
				inserimentoDaMMG = Boolean.FALSE;
			}

			// Carico i profili per impostare i flag 118 / guardia medica / usca

			// checkNotNull(schedaId, "schedaId non valorizzato");
			// Parametri riferiti all'intervento
			checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
			checkNotBlank(payload.getDescrizione(), "Descrizione non valorizzata");
			checkNotNull(payload.getTipo(), "Tipo non valorizzato");
			List<SchedePrescrizioni> prescrizioni = payload.getPrescrizioni();
			checkNotNull(prescrizioni, "Prescrizioni non valorizzate");

			/**
			 * Raffa 28-04-2020: la scheda non e' piu legata a un intervento unico, quindi
			 * il seguente controllo non serve piu COMMENNTO
			 */
			/**
			 * InterventoCustomDto checkIntervento =
			 * schedeApiMapper.selectInterventoByIdScheda(schedaId);
			 * 
			 * if (checkIntervento != null && checkIntervento.getIntId() != null) { return
			 * ErroreBuilder.from(Status.BAD_REQUEST) .descrizione("E' gia' presente un
			 * intervento per la scheda specificata").exception()
			 * .getResponseBuilder().build(); }
			 **/

			if (!inserimentoDaMMG) {
				// Inserisco una scheda

				CovidusTScheda covidusTScheda = new CovidusTScheda();
				covidusTScheda.setIdSoggetto(CaUtils.toLong(payload.getSoggetto()));
				covidusTScheda.setIdStruttura(payload.getStruttura());
				covidusTScheda.setSchData(payload.getData());
				covidusTScheda.setSchCritica(Boolean.TRUE); // FIXME: possiamo inserire un valore default? per ora metto
															// TRUE
				covidusTScheda.setSchDescrizione(payload.getDescrizione()); // FIXME: metto la descrizione
																			// dell'intervento?
				covidusTScheda.setUtenteOperazione(shibIdentitaCodiceFiscale);
				covidusTScheda.setRichiestaMmg(inserimentoDaMMG);
				covidusTScheda.setVisibileMedicoEmergenza(visibileAMedici118);
				covidusTScheda.setVisibileMedicoContinuitaAss(visibileAMediciContAss);

				schedeApiMapper.insertSchedaExt(covidusTScheda);
				logAudit(httpHeaders, "insert", "covidus_t_scheda", mapper.writeValueAsString(covidusTScheda));
				log.info(methodName,
						"inserita nuova scheda - covidus_t_scheda => sch_id: " + covidusTScheda.getSchId());
				schedaId = covidusTScheda.getSchId();

				// FIXME: lo stato e' direttamente in PRESO IN CARICO
				CovidusDSchedaStato covidusDSchedaStato = schedeApiMapper.selectSchedaStatoByCodStato("P");

				CovidusRSchedaStato covidusRSchedaStato = new CovidusRSchedaStato();
				covidusRSchedaStato.setSchId(covidusTScheda.getSchId());
				covidusRSchedaStato.setSchStatoId(covidusDSchedaStato.getSchStatoId());
				covidusRSchedaStato.setUtenteOperazione(shibIdentitaCodiceFiscale);
				schedeApiMapper.insertRSchedaStato(covidusRSchedaStato);
				logAudit(httpHeaders, "insert", "covidus_r_scheda_stato",
						mapper.writeValueAsString(covidusRSchedaStato));
				log.info(methodName, "inserito nuovo stato scheda - covidus_r_scheda_stato => scar_stato_id: "
						+ covidusRSchedaStato.getScarStatoId());

			}

			CovidusTIntervento covidusTIntervento = new CovidusTIntervento();
			covidusTIntervento.setAzId(payload.getAzione());
			covidusTIntervento.setIntAzioneIntrapresa(payload.getAzioneDescrizione());
			covidusTIntervento.setIntDesc(payload.getDescrizione());
			covidusTIntervento.setIntTipoId(payload.getTipo());
			covidusTIntervento.setSchId(schedaId);
			covidusTIntervento.setUtenteOperazione(shibIdentitaCodiceFiscale);
			covidusTIntervento.setIntData(payload.getData());
			schedeApiMapper.insertIntervento(covidusTIntervento);
			logAudit(httpHeaders, "insert", "covidus_t_intervento", mapper.writeValueAsString(covidusTIntervento));
			log.info(methodName,
					"inserito nuovo intervento - covidus_t_intervento => int_id: " + covidusTIntervento.getIntId());

			// Leggo la scheda per ricavarmi il soggetto
			CovidusTScheda scheda = schedeApiMapper.selectSchedaByPrimaryKey(schedaId);
			List<SchedeConsensoDocumenti> documenti = payload.getDocumenti();
			// Inserimento eventuali doc
			if (documenti != null && !documenti.isEmpty()) {
				for (SchedeConsensoDocumenti documento : documenti) {
					if (documento != null) {
						CovidusTFile covidusTFile = new CovidusTFile();

						salvaDocumento(shibIdentitaCodiceFiscale, documento.getNome(), documento.getBase64(),
								covidusTFile);
						logAudit(httpHeaders, "insert", "covidus_t_file", mapper.writeValueAsString(covidusTFile));
						log.info(methodName,
								"inserito nuovo documento - covidus_t_file => fileId: " + covidusTFile.getFileId());

						// Inserisco la relazione nella r_intervento_file
						CovidusRInterventoFile rinterventofile = new CovidusRInterventoFile();
						rinterventofile.setFileId(covidusTFile.getFileId());
						rinterventofile.setIntId(covidusTIntervento.getIntId());
						rinterventofile.setUtenteOperazione(shibIdentitaCodiceFiscale);
						rinterventofile.setDataCreazione(new Date());
						rinterventofile.setDataModifica(new Date());

						baseCovidusRInterventoFileMapper.insert(rinterventofile);
						logAudit(httpHeaders, "insert", "covidus_r_intervento_file",
								mapper.writeValueAsString(rinterventofile));
						log.info(methodName,
								"inserita nuova relazione intervento - documento - covidus_r_intervento_file => IntFileId: "
										+ rinterventofile.getIntFileId());

					}

				}
			}
			// fine gestione documenti

			List<SchedePrescrizioni> prescrizioniIns = payload.getPrescrizioni();
			Iterator<SchedePrescrizioni> iterator = prescrizioniIns.iterator();

			while (iterator.hasNext()) {

				SchedePrescrizioni next = iterator.next();

				CovidusRInterventoPresc covidusRInterventoPresc = new CovidusRInterventoPresc();
				covidusRInterventoPresc.setIntId(covidusTIntervento.getIntId());
				covidusRInterventoPresc.setPrescrizione(next.getPrescrizione());
				covidusRInterventoPresc.setPrescTipoId(next.getTipo());
				covidusRInterventoPresc.setUtenteOperazione(shibIdentitaCodiceFiscale);

				// Aggiunti nuovi parametri
				if (next.getOssigenoterapia() != null)
					covidusRInterventoPresc.setOssId(next.getOssigenoterapia());

				if (next.getValore() != null && !next.getValore().isEmpty())
					covidusRInterventoPresc.setValore(next.getValore());

				boolean consensoNecessario = false;
				if (next.getFarmaco() != null) {
					covidusRInterventoPresc.setFarmId(next.getFarmaco());
					consensoNecessario = isFarmacoConsensoNecessario(next.getFarmaco());
				}

				schedeApiMapper.insertRInterventoPrescrizione(covidusRInterventoPresc);

				logAudit(httpHeaders, "insert", "covidus_r_intervento_presc",
						mapper.writeValueAsString(covidusRInterventoPresc));
				log.info(methodName, "inserito nuovo record - covidus_r_intervento_presc => intpresc_id: "
						+ covidusRInterventoPresc.getIntprescId());

				if (consensoNecessario) {

					// checkNotNull(next.getConsenso(), "Consenso non valorizzato");

					if (next.getConsenso() != null) {
						// Gestione Consenso e documenti (va sulla consenso farmaco)
						CovidusTConsensoFarmaco covidusTConsensoFarmaco = new CovidusTConsensoFarmaco();
						covidusTConsensoFarmaco.setConsTipoId(next.getConsenso().getTipo());
						covidusTConsensoFarmaco.setIdSoggetto(scheda.getIdSoggetto());
						covidusTConsensoFarmaco.setFarmId(next.getFarmaco());
						covidusTConsensoFarmaco.setConsfarmData(new Date());
						covidusTConsensoFarmaco.setDataCreazione(new Date());
						covidusTConsensoFarmaco.setDataModifica(new Date());
						covidusTConsensoFarmaco.setUtenteOperazione(shibIdentitaCodiceFiscale);
						consensoFarmacoMapper.insert(covidusTConsensoFarmaco);
						logAudit(httpHeaders, "insert", "covidus_t_consenso_farmaco",
								mapper.writeValueAsString(covidusTConsensoFarmaco));
						log.info(methodName,
								"inserito nuovo consenso farmaco - covidus_t_consenso_farmaco => consfarmId: "
										+ covidusTConsensoFarmaco.getConsfarmId());

						boolean consensoScritto = isConsensoScritto(next.getConsenso().getTipo());

						if (consensoScritto) {
							// inserisco i documenti del consenso
							List<SchedeConsensoDocumenti> consensoDocs = next.getConsenso().getDocumenti();
							if (consensoDocs != null && !consensoDocs.isEmpty()) {

								for (SchedeConsensoDocumenti documento : consensoDocs) {

									if (documento != null) {
										CovidusTFile covidusTFile = new CovidusTFile();
										// covidusTFile.setFileId(fileId);

										salvaDocumento(shibIdentitaCodiceFiscale, documento.getNome(),
												documento.getBase64(), covidusTFile);

										logAudit(httpHeaders, "insert", "covidus_t_file",
												mapper.writeValueAsString(covidusTFile));

										CovidusRConsensoFarmacoFile covidusRConsensoFarmacoFile = new CovidusRConsensoFarmacoFile();
										covidusRConsensoFarmacoFile
												.setConsfarmId(covidusTConsensoFarmaco.getConsfarmId());
										covidusRConsensoFarmacoFile.setFileId(covidusTFile.getFileId());
										covidusRConsensoFarmacoFile.setUtenteOperazione(shibIdentitaCodiceFiscale);
										consensoFarmacoMapper.insertRConsensoFarmacoFile(covidusRConsensoFarmacoFile);
										// baseCovidusRConsensoFarmacoFileMapper.insert(covidusRConsensoFarmacoFile);
										logAudit(httpHeaders, "insert", "covidus_r_consenso_farmaco_file",
												mapper.writeValueAsString(covidusTFile));

									}

								}
							}

						}
					}
				}
			}

			/**
			 * Raffa 28-04-2020: L'inserimento dell'intervento NON comporta lo stato a Evasa
			 * della scheda
			 */
			// CovidusDSchedaStato covidusDSchedaStato =
			// schedeApiMapper.selectSchedaStatoByCodStato("E");

			/**
			 * 
			 * 
			 * // Chiusura dello stato attuale CovidusRSchedaStato statoDaAggiornare =
			 * schedeApiMapper.selectStatoValidoByIdScheda(schedaId);
			 * schedeApiMapper.updateStatoPerChiusura(statoDaAggiornare);
			 * logAudit(httpHeaders, "update", "covidus_r_scheda_stato",
			 * mapper.writeValueAsString(statoDaAggiornare));
			 */

			/**
			 * 
			 * 
			 * // Inserimento del nuovo stato CovidusRSchedaStato covidusRSchedaStatoIns =
			 * new CovidusRSchedaStato();
			 * covidusRSchedaStatoIns.setIdProfiloOperazione(statoDaAggiornare.getIdProfiloOperazione());
			 * covidusRSchedaStatoIns.setSchId(statoDaAggiornare.getSchId());
			 * covidusRSchedaStatoIns.setSchStatoId(covidusDSchedaStato.getSchStatoId());
			 * covidusRSchedaStatoIns.setUtenteOperazione(shibIdentitaCodiceFiscale);
			 * schedeApiMapper.insertRSchedaStato(covidusRSchedaStatoIns);
			 * logAudit(httpHeaders, "insert", "covidus_r_scheda_stato",
			 * mapper.writeValueAsString(covidusRSchedaStatoIns));
			 */

			ModelScheda modelScheda = getScheda(covidusTIntervento.getSchId());
			return Response.ok(modelScheda).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeSchedaIdInterventoPost ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeSchedaIdInterventoPost ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	@Override
	public Response schedeSchedaIdInterventoTipiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer schedaId,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedeSchedaIdInterventoTipiGet";
		log.info(methodName, "BEGIN");

		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			logAudit(httpHeaders, "select", "covidus_t_intervento", "selectAll");

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			// checkNotNull(schedaId, "schedaId non valorizzata");

			List<CovidusDInterventoTipo> elencoInterventiDB = schedeApiMapper.selectAllDInterventoTipo();

			List<ModelInterventoTipo> elencoInterventi = new ArrayList<ModelInterventoTipo>();

			Iterator<CovidusDInterventoTipo> iterator = elencoInterventiDB.iterator();
			while (iterator.hasNext()) {
				CovidusDInterventoTipo next = iterator.next();

				ModelInterventoTipo modelInterventoAzione = new ModelInterventoTipo();
				modelInterventoAzione.setCodice(next.getIntTipoCod());
				modelInterventoAzione.setId(next.getIntTipoId());
				modelInterventoAzione.setNome(next.getIntTipoDesc());

				elencoInterventi.add(modelInterventoAzione);
			}

			return Response.ok(elencoInterventi).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeSchedaIdInterventoTipiGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeSchedaIdInterventoTipiGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response schedeSchedaIdStatoPut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer schedaId, Payload1 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedeSchedaIdStatoPut";
		log.info(methodName, "BEGIN");

		try {
			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(schedaId, "schedaId non valorizzato");
			checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
			checkNotBlank(payload.getStato(), "Stato non valorizzato");

			// Lettura dello stato attuale
			CovidusDSchedaStato covidusDSchedaStato = schedeApiMapper.selectSchedaStatoByCodStato(payload.getStato());

			// Chiusura dello stato attuale
			CovidusRSchedaStato statoDaAggiornare = schedeApiMapper.selectStatoValidoByIdScheda(schedaId);
			schedeApiMapper.updateStatoPerChiusura(statoDaAggiornare);
			logAudit(httpHeaders, "update", "covidus_r_scheda_stato", mapper.writeValueAsString(statoDaAggiornare));

			// Inserimento del nuovo stato
			CovidusRSchedaStato covidusRSchedaStatoIns = new CovidusRSchedaStato();
			covidusRSchedaStatoIns.setIdProfiloOperazione(statoDaAggiornare.getIdProfiloOperazione());
			covidusRSchedaStatoIns.setSchId(statoDaAggiornare.getSchId());
			covidusRSchedaStatoIns.setSchStatoId(covidusDSchedaStato.getSchStatoId());
			covidusRSchedaStatoIns.setUtenteOperazione(shibIdentitaCodiceFiscale);
			schedeApiMapper.insertRSchedaStato(covidusRSchedaStatoIns);
			logAudit(httpHeaders, "insert", "covidus_r_scheda_stato",
					mapper.writeValueAsString(covidusRSchedaStatoIns));

			ModelScheda scheda = getScheda(schedaId);
			return Response.ok(scheda).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeSchedaIdStatoPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeSchedaIdStatoPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	@Override
	public Response schedeFlagVisibilitaPut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer schedaId, Payload payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedeFlagVisibilitaPut";
		log.info(methodName, "BEGIN");

		try {

			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(schedaId, "schedaId non valorizzato");

//			List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(shibIdentitaCodiceFiscale);
//			boolean trovato = false;
//			for(int i=0; i<elencoProfiliDB.size() && !trovato; i++) {
//				if(elencoProfiliDB.get(i).getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_MMG.getCodice()))
//					trovato = true;
//			}
//			
//			checkCondition(trovato, ErroreBuilder.from(Status.UNAUTHORIZED).descrizione("L'utente non ha un profilo MMG associato").exception());

			CovidusTScheda covidusTScheda = schedeApiMapper.selectSchedaByPrimaryKey(schedaId);

			if (payload.getVisibileMed118() != null)
				covidusTScheda.setVisibileMedicoEmergenza(payload.getVisibileMed118().booleanValue());
			if (payload.getVisibileMed118() != null)
				covidusTScheda.setVisibileMedicoContinuitaAss(payload.getVisibileMedCa().booleanValue());

			schedeApiMapper.updateSchedaVisibilita(covidusTScheda);
			logAudit(httpHeaders, "update", "covidus_t_scheda", mapper.writeValueAsString(covidusTScheda));

			covidusTScheda = baseCovidusTSchedaMapper.selectByPrimaryKey(schedaId);

			return Response.ok(covidusTScheda).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeFlagVisibilitaPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeFlagVisibilitaPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}

	@Override
	public Response schedeTerapiaCronicaPut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer schedaId, Payload payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedeTerapiaCronicaPut";
		log.info(methodName, "BEGIN");

		try {

			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(schedaId, "schedaId non valorizzato");
			checkNotNull(payload.getTerapiaCronica(), "terapia cronica non valorizzata");

			CovidusTScheda covidusTScheda = schedeApiMapper.selectSchedaByPrimaryKey(schedaId);

			covidusTScheda.setSchTerapiaCronica(payload.getTerapiaCronica());

			schedeApiMapper.updateSchedaTerapiaCronica(covidusTScheda);
			logAudit(httpHeaders, "update", "covidus_t_scheda", mapper.writeValueAsString(covidusTScheda));

			covidusTScheda = baseCovidusTSchedaMapper.selectByPrimaryKey(schedaId);

			return Response.ok(covidusTScheda).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeTerapiaCronicaPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeTerapiaCronicaPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}
	
	
	@Override
	public Response schedeMonitoraggioTipoPut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer schedaId, Payload8 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "schedeMonitoraggioTipoPut";
		log.info(methodName, "BEGIN");

		try {

			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(schedaId, "schedaId non valorizzato");
			checkNotNull(payload.getIdTipoMonitoraggio(), "id tipo monitoraggio non valorizzato");

			CovidusTScheda covidusTScheda = schedeApiMapper.selectSchedaByPrimaryKey(schedaId);

			covidusTScheda.setMonitoraggioTipoId(payload.getIdTipoMonitoraggio());

			schedeApiMapper.updateSchedaMonitoraggioTipo(covidusTScheda);
			logAudit(httpHeaders, "update", "covidus_t_scheda", mapper.writeValueAsString(covidusTScheda));

			covidusTScheda = baseCovidusTSchedaMapper.selectByPrimaryKey(schedaId);
			
			//CovidusDMonitoraggioTipo covidusDMonitoraggioTipo = baseCovidusDMonitoraggioTipoMapper.selectByPrimaryKey(covidusTScheda.getMonitoraggioTipoId());

			//ModelMonitoraggioTipo monitoraggioTipo = new ModelMonitoraggioTipiCovidusDMonitoraggioTipiMapping().from(covidusDMonitoraggioTipo);
			
			
			return Response.ok(covidusTScheda).build();

		} catch (RESTException e) {
			log.error(methodName, "schedeTerapiaCronicaPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeTerapiaCronicaPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	@Override
	public Response schedeDeleteIntervento(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer idIntervento,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "schedeDeleteIntervento";
		log.info(methodName, "BEGIN");
		try {

			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(idIntervento, "idIntervento non valorizzato");

			// PASSO 1 - OTTENERE LA SCHEDA

			CovidusTIntervento intervento = baseCovidusTInterventoMapper.selectByPrimaryKey(idIntervento);
			
			CovidusTScheda scheda = schedeApiMapper.selectSchedaAttivaByIdIntervento(intervento.getIntId());
			// PASSO 2 - DALLA SCHEDA CONTROLLARE LO STATO
			if (scheda != null) { // SE L'INTERVENTO SI RIFERISCE AD UNA SCHEDA NON CHIUSA (NON EVASA E NON
									// RESPINTA)
				// CONTROLLARE SE SI TRATTA DELL'ULTIMO INTERVENTO INSERITO PER QUESTA SCHEDA E
				// NON GIA' CANCELLATO
				/**
				 * 25/05/2020 : raffa --> non bisogna piu controllare l'ultimo intervento inserito   
				
				CovidusTIntervento ultimoIntervento = schedeApiMapper.selectUltimoInterventoByScheda(scheda.getSchId());

				if (!(idIntervento.equals(ultimoIntervento.getIntId())
						&& ultimoIntervento.getDataCancellazione() == null)){// se passa il controllo si tratta
																				// dell'ultimo intervento inserito e non
																				// e' stato gia' cancellato
					return ErroreBuilder.from(Status.BAD_REQUEST,"L'intervento e' gia' stato cancellato o non e' l'ultimo inserito").exception().getResponse();

				}	 */
					// eseguire la cancellazione di tutto

				// 1)cancellazione intervento (covidus_t_intervento)
				interventoMapper.logicDeleteByPrimaryKey(idIntervento);

				// 2)cancellazione prescrizione (covidus_r_intervento_presc)
				List<CovidusRInterventoPresc> listRInterventoPresc = rInterventoPrescrizioneMapper
						.selectByIdIntervento(idIntervento);
				rInterventoPrescrizioneMapper.logicDeleteByIdIntervento(idIntervento);

				// ottengo tutti gli id dei farmaci collegati a un prescrizione
				List<Integer> idFarmaci = new ArrayList<>();
				for (CovidusRInterventoPresc rInterventoPresc : listRInterventoPresc) {
					idFarmaci.add(rInterventoPresc.getFarmId());
				}

				// 3)cancellazione relazione tra file e intervento (covidus_r_intervento_file)
				rInterventoFileMapper.logicDeleteByIdIntervento(idIntervento);

				// 4)cancellazione covidus_t_file legato al'intervento;

				CovidusRInterventoFile rInterventoFile = rInterventoFileMapper.selectByIdIntervento(idIntervento);
				if (rInterventoFile != null)
					covidusTFileMapper.logicDeleteByPrimaryKey(rInterventoFile.getFileId());

				/**
				 * 
				 Raffaela 22-05-2020
				 PER IL MOMENTO COMMENTO LA PARTE DI CANCELLAZIONE LOGICA DEL CONSENSO AL FARMACO SULLA PRESCRIZIONE
				 PERCHE' LO STESSO CONSENSO E' VALIDO ANCHE PER ALTRE PRESCRIZIONI 
				
				// 5)cancellazione consenso
				Long idSoggetto = scheda.getIdSoggetto();
				//per ogni farmaco di una prescrzione-intervento ne ottengo la codifica e controllo se è necessario il consenso
				for (Integer idFarmaco : idFarmaci) {
					CovidusDFarmaco Dfarmaco = baseCovidusDFarmacoMapper.selectByPrimaryKey(idFarmaco);
					if (Dfarmaco.getFarmConsensoNecessario()) { //se e' necessario il consenso allora controllo che sia scritto o orale 
						
						List<CovidusTConsensoFarmaco> covidusTConsensoFarmaco = consensoFarmacoMapper
								.selectConsensiByFiltro(idSoggetto.intValue(), idFarmaco, null);
						if(covidusTConsensoFarmaco!= null && !covidusTConsensoFarmaco.isEmpty()) {
							consensoFarmacoMapper.logicDeleteByPrimaryKey(covidusTConsensoFarmaco.get(0).getConsfarmId()); //cancello consenso al farmaco  
							
							if(covidusTConsensoFarmaco.get(0).getConsTipoId()==4) { //se il consenso e' di tipo scritto
								rConsensoFarmacoFileMapper.logicDeleteByIdConsenso(covidusTConsensoFarmaco.get(0).getConsfarmId()); //cancello la relazione consenso-file
								
								CovidusRConsensoFarmacoFile rConsensoFarmacoFile = rConsensoFarmacoFileMapper.selectByConsFarmId(covidusTConsensoFarmaco.get(0).getConsfarmId());
								covidusTFileMapper.logicDeleteByPrimaryKey(rConsensoFarmacoFile.getFileId()); //cancello il file 
							}
						}
						
					}

				}//END FOR
				
				
				*/
				// 6) cancellazione diario dettaglio
				diarioDettagliMapper.logicDeleteByIdIntervento(idIntervento);
				
				
			}else {
				 return ErroreBuilder.from(Status.BAD_REQUEST,"La scheda relativa all'intervento non e' attiva").exception().getResponse();
			}

			return Response.ok().build();

		} catch (RESTException e) {
			log.error(methodName, "ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	@Override
	public Response schedeGetXlsx(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, String stati, String strutture, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {


		String methodName = "schedeGetXlsx";
		log.info(methodName, "BEGIN");

		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(strutture, "Struttura obbligatoria");
			
			logAudit(httpHeaders, "select", "covidus_t_scheda", "selectAll");

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			List<SchedeCustomDto> elencoSchede = schedeApiMapper.elencoSchedeExcel(stati, strutture, shibIdentitaCodiceFiscale);
			
			StreamingOutput os = convertObjectsToXlsx(elencoSchede);
			
			String fileName = "estrazione_schede.xlsx";
			
			return Response.ok(os).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();

		} catch (RESTException e) {
			log.error(methodName, "schedeGetXlsx ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedeGetXlsx ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

}
