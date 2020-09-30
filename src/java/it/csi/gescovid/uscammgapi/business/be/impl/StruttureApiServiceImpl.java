package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.StruttureApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.StrutturaEnteExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.StrutturaUscaMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelStrutturaStrutturaEnteExtMapping;
import it.csi.gescovid.uscammgapi.dto.ModelStruttura;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class StruttureApiServiceImpl extends RESTBaseService implements StruttureApi {
	
	@Autowired
	StrutturaUscaMapper repositoryStruttureUsca;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	@Override
	public Response struttureUscaGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		String methodName = "struttureUscaGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "struttura ente covidus_r_app_struttura", methodName);
			
			
			List<StrutturaEnteExtDto> lista = repositoryStruttureUsca.selectAllStruttureUsca();
			
			//System.out.println("Ente: " + lista.get(0).getEnte().getIdEnte());
			
			List<ModelStruttura> listaStruttura =  new ModelStrutturaStrutturaEnteExtMapping().fromList(lista);
			
			return Response.ok().entity(listaStruttura).build();
			
		} catch (RESTException e) {
			log.error(methodName, " struttureUscaGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "struttureUscaGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

}
