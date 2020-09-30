package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.SchedaStatiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSchedaStato;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SchedeStatiMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelSchedaStatoCovidusDSchedaStatoMapping;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaStato;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class SchedeStatiApiServiceImpl extends RESTBaseService implements SchedaStatiApi {
	
	@Autowired
	SchedeStatiMapper repositorySchedeStati;
	
	LogUtil log =  new LogUtil(this.getClass());

	@Override
	public Response schedaStatiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		String methodName = "schedaStatiGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			logAudit(httpHeaders, "select", "covidus_d_scheda_stato", methodName);
			
			List<CovidusDSchedaStato> stati = repositorySchedeStati.selectAllSchedeStatiValidi();
			
			List<ModelSchedaStato> listaStatiRit = new ModelSchedaStatoCovidusDSchedaStatoMapping().fromList(stati);
			
			 return Response.ok(listaStatiRit).build();
			
		} catch (RESTException e) {
			log.error(methodName, " schedaStatiGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedaStatiGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
		
	}

	

}
