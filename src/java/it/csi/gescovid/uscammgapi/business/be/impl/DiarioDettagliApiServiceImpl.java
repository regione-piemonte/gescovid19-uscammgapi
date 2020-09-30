package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.uscammgapi.business.be.DiarioDettagliApi;
import it.csi.gescovid.uscammgapi.business.be.StruttureApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRDiarioDetSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovid;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiario;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiarioDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.StrutturaEnteExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.AdiCovidMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.DiarioDettagliMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.StrutturaUscaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTAdicovidMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelDiarioDettaglioSintomoCovidusDSintomoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelStrutturaStrutturaEnteExtMapping;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovid;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglio;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioSintomo;
import it.csi.gescovid.uscammgapi.dto.ModelStruttura;
import it.csi.gescovid.uscammgapi.dto.Payload3;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DiarioDettagliApiServiceImpl extends RESTBaseService implements DiarioDettagliApi {

	@Autowired
	AdiCovidMapper adiCovidMapper;
	
	@Autowired
	DiarioDettagliMapper diarioDettagliMapper;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	@Override
	public Response diarioDettagliPost(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Payload3 payload, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "diarioDettagliPost";
		log.info(methodName, "BEGIN");
		try {
			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			// Verifica utente autorizzato all'applicazione
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);
			
			//TODO: merge con checkutente per risparmiare una query
			List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(shibIdentitaCodiceFiscale);
			Integer idProfilo = null;
			for (Profilo profilo : elencoProfiliDB) {
				if (profilo.getNomeProfilo().equals(xApplicazioneCodice))
				{
					idProfilo = profilo.getIdProfilo();
				}
			}
			
			
			checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);
			checkNotNull(payload.getSoggetto(), CaConstants.PAYLOAD_OBBLIGATORIO);
			
			// verifica se il diario esiste 
			CovidusTDiario diario = null;

			List<CovidusTDiario> listDiario = diarioDettagliMapper.selectListDiarioByIdSoggetto(payload.getSoggetto());
			
			if (listDiario==null || listDiario.isEmpty())
			{
				log.info(methodName, "diario assente, creazione in corso");
				// provo la creazione del diario
				diario = new CovidusTDiario();
				diario.setIdSoggetto(new Long(payload.getSoggetto()));
				diario.setUtenteOperazione(shibIdentitaCodiceFiscale);
				diario.setIdProfiloOperazione(idProfilo);
				
				try {
					diarioDettagliMapper.insertDiario(diario);
					logAudit(httpHeaders, "insert", "covidus_t_diario", mapper.writeValueAsString(diario));
					log.info(methodName, "diario creato");
				} catch (Exception e) {
					log.error(methodName, "Errore durante la creazione del diario", e);
					throw e;
				}
			} else {
				diario = listDiario.get(0); // so che ne ho sempre uno solo
			}
			
			CovidusTDiarioDet diarioDet = new CovidusTDiarioDet();
			diarioDet.setDiadetData(payload.getData());
			diarioDet.setDiadetNote(payload.getNote());
			//nuova entita adicovid
			if(payload.getAdiCovid()!= null && payload.getAdiCovid().getDataAdiCovidInizio() != null) {
				ModelAdiCovid modelAdiCovid = payload.getAdiCovid();
				CovidusTAdiCovid covidusTAdiCovid = new CovidusTAdiCovid();
				covidusTAdiCovid.setAdicovidDataStart(modelAdiCovid.getDataAdiCovidInizio());
				covidusTAdiCovid.setAdicovidDataEnd(modelAdiCovid.getDataAdiCovidFine());
				covidusTAdiCovid.setAdicovidNote(modelAdiCovid.getNoteAdiCovid());
				covidusTAdiCovid.setDataCreazione(new Date());
				covidusTAdiCovid.setDataModifica(covidusTAdiCovid.getDataCreazione());
				covidusTAdiCovid.setUtenteOperazione(shibIdentitaCodiceFiscale);
				
				adiCovidMapper.insert(covidusTAdiCovid);
				logAudit(httpHeaders, "insert", "covidus_t_adicovid", mapper.writeValueAsString(covidusTAdiCovid));
				log.info(methodName, "testata adicovid creata");
				
				diarioDet.setAdicovidId(covidusTAdiCovid.getAdicovidId());
			}
			
			//
			diarioDet.setDiaId(diario.getDiaId());
			diarioDet.setUtenteOperazione(shibIdentitaCodiceFiscale);
			diarioDet.setIntId(payload.getIntervento());
			diarioDet.setIdProfiloOperazione(idProfilo);
			diarioDettagliMapper.insert(diarioDet);
			logAudit(httpHeaders, "insert", "covidus_t_diario_det", mapper.writeValueAsString(diarioDet));
			log.info(methodName, "diario dettaglio creato");

			if (payload.getSintomi()!=null && !payload.getSintomi().isEmpty())
			{
				for (ModelDiarioDettaglioSintomo sintomo : payload.getSintomi()) {
					CovidusRDiarioDetSintomo rec = new CovidusRDiarioDetSintomo();
					rec.setDiadetId(diarioDet.getDiadetId());
					rec.setSinId(sintomo.getId());
					rec.setSinNote(sintomo.getNote());
					rec.setSinValore(sintomo.getValore());
					rec.setUtenteOperazione(shibIdentitaCodiceFiscale);
					rec.setIdProfiloOperazione(idProfilo);
					diarioDettagliMapper.insertRDiarioDetSintomo(rec);
					logAudit(httpHeaders, "insert", "covidus_r_diario_det_sintomo", mapper.writeValueAsString(sintomo));
				}
			}
			else {
				log.info(methodName, "nessun sintomo inserito");
			}
			
			ModelDiarioDettaglio modelDiarioDettaglio = diarioDettagliMapper.selectModelDiarioDettaglioByPrimaryKey(diarioDet.getDiadetId());
			modelDiarioDettaglio.setSintomi(diarioDettagliMapper.selectSintomiByIdDiarioDett(diarioDet.getDiadetId()));
			return Response.status(Status.CREATED).entity(modelDiarioDettaglio).build();
			
		} catch (RESTException e) {
			log.error(methodName, " diarioDettagliPost ERROR RESTException", e);
			throw new WebApplicationException(e.getResponse());
		} catch (Exception e) {
			log.error(methodName, "diarioDettagliPost ERROR Exception", e);
			throw new WebApplicationException(CaRet.internalServerErrResponse());
		}

		
		
		
	}
	
}
