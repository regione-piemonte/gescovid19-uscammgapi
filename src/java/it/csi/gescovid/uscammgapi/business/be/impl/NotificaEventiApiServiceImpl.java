package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.NotificaEventiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaEvento;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaEventoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaEventoDNotificaEvento;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaEvento;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class NotificaEventiApiServiceImpl extends RESTBaseService implements NotificaEventiApi {

	@Autowired
	NotificaEventoMapper notificaEventoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	@Override
	public Response notificaEventiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
	

		String methodName = "notificaEventiGet";
		log.info(methodName, "BEGIN");
		
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "d_notifica_evento", methodName);
			
			List<DNotificaEvento> listaNotificaEvento =  notificaEventoMapper.selectAllNotificaEventiValidi();
			
			List<ModelNotificaEvento> listaNotificaEventoRitorno = new ModelNotificaEventoDNotificaEvento().fromList(listaNotificaEvento);
			
			return Response.ok(listaNotificaEventoRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " notificaEventoGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " notificaEventoGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
		
		
	}

}
