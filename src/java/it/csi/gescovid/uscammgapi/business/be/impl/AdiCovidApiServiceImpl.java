package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.AdiCovidApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovid;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovidDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTScheda;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.AdiCovidDetMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.AdiCovidMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelAdiCovidCovidusTAdiCovidMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelAdiCovidDetCovidusTAdiCovidDetMapping;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovid;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovidDettaglio;
import it.csi.gescovid.uscammgapi.dto.Payload;
import it.csi.gescovid.uscammgapi.dto.Payload10;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class AdiCovidApiServiceImpl extends RESTBaseService implements AdiCovidApi {

	@Autowired
	AdiCovidMapper adiCovidMapper;

	@Autowired
	AdiCovidDetMapper adiCovidDetMapper;

	LogUtil log = new LogUtil(this.getClass());

	@Override
	public Response adiCovidGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer idAdiCovid, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "adiCovidGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			// Verifica utente autorizzato all'applicazione
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			List<CovidusTAdiCovid> listCovidusTAdiCovid = null;

			if (idAdiCovid != null) {
				listCovidusTAdiCovid = adiCovidMapper.selectByPrimaryKeyAndUtente(idAdiCovid,
						shibIdentitaCodiceFiscale);
			} else {
				listCovidusTAdiCovid = adiCovidMapper.selectAllByUtente(shibIdentitaCodiceFiscale);
			}

			List<ModelAdiCovid> listModelAdiCovid = new ArrayList<ModelAdiCovid>();
			if (listCovidusTAdiCovid != null && !listCovidusTAdiCovid.isEmpty()) {
				listModelAdiCovid = new ModelAdiCovidCovidusTAdiCovidMapping().fromList(listCovidusTAdiCovid);

				for (ModelAdiCovid adiCovidTemp : listModelAdiCovid) {
					List<CovidusTAdiCovidDet> listCovidusTAdiCovidDet = adiCovidDetMapper
							.selectByIdAdiCovid(adiCovidTemp.getAdiCovidId());
					if (listCovidusTAdiCovidDet != null && !listCovidusTAdiCovidDet.isEmpty()) {
						List<ModelAdiCovidDettaglio> listModelAdiCovidDet = new ModelAdiCovidDetCovidusTAdiCovidDetMapping()
								.fromList(listCovidusTAdiCovidDet);
						adiCovidTemp.setDettagli(listModelAdiCovidDet);
					}
				}
			}

			return Response.ok().entity(listModelAdiCovid).build();

		} catch (RESTException e) {
			log.error(methodName, "ERROR RESTException", e);
			throw new WebApplicationException(e.getResponse());
		} catch (Exception e) {
			log.error(methodName, " ERROR Exception", e);
			throw new WebApplicationException(CaRet.internalServerErrResponse());
		}
	}

	@Override
	public Response adiCovidChiudiMonitoraggioPut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer adicovidId, Payload10 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		
		String methodName = "adiCovidChiudiMonitoraggioPut";
		log.info(methodName, "BEGIN");

		try {

			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(adicovidId, "adicovidId non valorizzato");


			CovidusTAdiCovid covidusTAdiCovid = adiCovidMapper.selectByPrimaryKey(adicovidId);

			covidusTAdiCovid.setAdicovidDataEnd(payload.getAdiCovidDataFine());
			covidusTAdiCovid.setDataModifica(covidusTAdiCovid.getAdicovidDataEnd());
			adiCovidMapper.updateByPrimaryKey(covidusTAdiCovid);
			
			logAudit(httpHeaders, "update", "covidus_t_adicovid", mapper.writeValueAsString(covidusTAdiCovid));
		

			return Response.ok(covidusTAdiCovid).build();

		} catch (RESTException e) {
			log.error(methodName, "adiCovidChiudiMonitoraggioPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "adiCovidChiudiMonitoraggioPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}

}
