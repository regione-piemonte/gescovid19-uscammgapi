package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.gescovid.uscammgapi.business.be.DiariApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovid;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovidDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.DiarioExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.AdiCovidDetMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.AdiCovidMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.DiariMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelAdiCovidCovidusTAdiCovidMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelAdiCovidDetCovidusTAdiCovidDetMapping;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovid;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovidDettaglio;
import it.csi.gescovid.uscammgapi.dto.ModelDiario;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglio;
import it.csi.gescovid.uscammgapi.dto.util.UtilitiStream;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

@Service
public class DiariApiServiceImpl extends RESTBaseService implements DiariApi {
	@Autowired
	AdiCovidMapper adiCovidMapper;

	@Autowired
	AdiCovidDetMapper adiCovidDetMapper;

	@Autowired
	DiariMapper repositoryDiariMapper;

	LogUtil log = new LogUtil(this.getClass());

	@Override
	public Response diariGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer soggetto, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "diariGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(soggetto, "Soggetto obbligatorio");
			logAudit(httpHeaders, "select", "covidus_t_diario covidus_t_diario_det utente_contatto sintomo",
					methodName);
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);
			// TODO in attesa di capire se bisogna fare le ricerche per il soggetto

			// TODO entra una volta sola su db se si lascia la ricerca aperta preferibile
			// usare questo
			/*
			 * List<DiarioExtDto> listaDiariExt =
			 * repositoryDiariMapper.selectAllDiariPerSoggetto(soggetto);
			 * 
			 * List<ModelDiario> listaDiari =
			 * UtilitiStream.listaDiariDistinct(listaDiariExt);
			 */
			// TODO da decommentare
			List<ModelDiario> listaDiari = repositoryDiariMapper.selectDiariPerIdSoggetto(soggetto);
			for (ModelDiario diarioTmp : listaDiari) {
				diarioTmp.setDettagli(repositoryDiariMapper.selectDiariDettagliPerIdDiario(diarioTmp.getId()));
				for (ModelDiarioDettaglio dettTmp : diarioTmp.getDettagli()) {
					dettTmp.setSintomi(repositoryDiariMapper.selectSintomiPerIdDettaglioDett(dettTmp.getId()));
					// inizio parte di dettaglio dell'intervento
					ModelAdiCovid modelAdiCovid = getAdiCovidDetails(dettTmp.getIdAdiCovid());
					dettTmp.setAdiCovid(modelAdiCovid);

				}

			}

			return Response.ok().entity(listaDiari).build();
		} catch (RESTException e) {
			log.error(methodName, " diariGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "diariGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}

	private List<ModelDiario> raggruppaDiari(List<DiarioExtDto> listaDiariExt) {
		List<ModelDiario> listaDiari = new ArrayList<ModelDiario>();
		for (DiarioExtDto diario : listaDiariExt) {
			// if()
		}

		return listaDiari;
	}

	public ModelAdiCovid getAdiCovidDetails(Integer idAdiCovid) {

		CovidusTAdiCovid covidusTAdiCovid = null;

		covidusTAdiCovid = adiCovidMapper.selectByPrimaryKey(idAdiCovid);

		ModelAdiCovid modelAdiCovid = null;
		if (covidusTAdiCovid != null) {
			
			modelAdiCovid = new ModelAdiCovidCovidusTAdiCovidMapping().from(covidusTAdiCovid);

			List<CovidusTAdiCovidDet> listCovidusTAdiCovidDet = adiCovidDetMapper
					.selectByIdAdiCovid(modelAdiCovid.getAdiCovidId());
			if (listCovidusTAdiCovidDet != null && !listCovidusTAdiCovidDet.isEmpty()) {
				List<ModelAdiCovidDettaglio> listModelAdiCovidDet = new ModelAdiCovidDetCovidusTAdiCovidDetMapping()
						.fromList(listCovidusTAdiCovidDet);
				modelAdiCovid.setDettagli(listModelAdiCovidDet);
			}
			return modelAdiCovid;

		}else
			return null;
	}
}
