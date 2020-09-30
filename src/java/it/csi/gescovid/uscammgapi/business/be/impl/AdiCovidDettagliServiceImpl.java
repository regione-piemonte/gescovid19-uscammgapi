package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.AdiCovidDettagliApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovidDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTAdicovidDetMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelAdiCovidDetCovidusTAdiCovidDetMapping;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovidDettaglio;
import it.csi.gescovid.uscammgapi.dto.Payload9;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class AdiCovidDettagliServiceImpl extends RESTBaseService implements AdiCovidDettagliApi {

	@Autowired
	BaseCovidusTAdicovidDetMapper baseCovidusTAdicovidDetMapper;

	LogUtil log = new LogUtil(this.getClass());

	@Override
	public Response adiCovidDettagliPost(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer idAdiCovid, Payload9 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "adiCovidDettagliPost";
		log.info(methodName, "BEGIN");

		try {
			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			// Verifica utente autorizzato all'applicazione
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);
			checkNotNull(idAdiCovid, "idAdiCovid non valorizzato");

			CovidusTAdiCovidDet covidusTAdiCovidDet = new CovidusTAdiCovidDet();
			covidusTAdiCovidDet.setAdicovidDetData(payload.getAdiCovidDetData());
			covidusTAdiCovidDet.setAdicovidDetNote(payload.getAdiCovidDetNote());
			covidusTAdiCovidDet.setUtenteOperazione(shibIdentitaCodiceFiscale);
			covidusTAdiCovidDet.setAdicovidId(idAdiCovid);
			covidusTAdiCovidDet.setDataCreazione(new Date());
			covidusTAdiCovidDet.setDataModifica(covidusTAdiCovidDet.getDataCreazione());
			baseCovidusTAdicovidDetMapper.insert(covidusTAdiCovidDet);
			logAudit(httpHeaders, "insert", "covidus_t_adicovid_det", mapper.writeValueAsString(covidusTAdiCovidDet));
			log.info(methodName, "inserito adiCovidDet - adiCovidDet => not_id: " + covidusTAdiCovidDet.getAdicovidDetId());

			CovidusTAdiCovidDet adiCovidDetInserito = baseCovidusTAdicovidDetMapper.selectByPrimaryKey(covidusTAdiCovidDet.getAdicovidDetId());
			ModelAdiCovidDettaglio adiCovidDetRitorno = new ModelAdiCovidDetCovidusTAdiCovidDetMapping().from(adiCovidDetInserito);
			
			return  Response.ok(adiCovidDetRitorno).build();
			
		} catch (RESTException e) {
			log.error(methodName, "ERROR RESTException", e);
			throw new WebApplicationException(e.getResponse());
		} catch (Exception e) {
			log.error(methodName, " ERROR Exception", e);
			throw new WebApplicationException(CaRet.internalServerErrResponse());
		}

	}

}
