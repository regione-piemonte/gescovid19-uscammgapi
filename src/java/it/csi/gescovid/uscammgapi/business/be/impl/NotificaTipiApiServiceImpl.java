package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.NotificaTipiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaTipoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaTipoDNotificaTipoMapping;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaTipo;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class NotificaTipiApiServiceImpl extends RESTBaseService implements NotificaTipiApi {
	@Autowired
	NotificaTipoMapper notificaTipoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());


	@Override
	public Response notificaTipiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		String methodName = "notificaTipiGet";
		log.info(methodName, "BEGIN");
		
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "d_notifica_tipo", methodName);
			
			List<DNotificaTipo> listaNotificaTipi =  notificaTipoMapper.selectAllNotificaTipiValidi();
			
			List<ModelNotificaTipo> listaNotificaTipoRitorno = new ModelNotificaTipoDNotificaTipoMapping().fromList(listaNotificaTipi);
			
			return Response.ok(listaNotificaTipoRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " notificatipiGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " notificatipiGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	

}