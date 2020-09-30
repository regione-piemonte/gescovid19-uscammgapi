package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.NotificaPrioritaApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaPriorita;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaPrioritaMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaPrioritaDNotificaPriorita;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaPriorita;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class NotificaPrioritaApiServiceImpl extends RESTBaseService implements NotificaPrioritaApi{

	@Autowired
	NotificaPrioritaMapper notificaPrioritaMapper;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	
	
	@Override
	public Response notificaPrioritaGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		

			String methodName = "notificaPrioritaGet";
			log.info(methodName, "BEGIN");
			
			try {
				checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
				checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
				
				logAudit(httpHeaders, "select", "d_notifica_azione", methodName);
				
				List<DNotificaPriorita> listaNotificaPriorita =  notificaPrioritaMapper.selectAllNotificaPrioritaValide(); 
				
				List<ModelNotificaPriorita> listaNotificaPrioritaRitorno =  new ModelNotificaPrioritaDNotificaPriorita().fromList(listaNotificaPriorita);
				
				return Response.ok(listaNotificaPrioritaRitorno).build();
				
			}  catch (RESTException e) {
				log.error(methodName, " notificaPrioritaGet ERROR RESTException", e);
				return e.getResponse();
			} catch (Exception e) {
				log.error(methodName, " notificaPrioritaGet ERROR Exception", e);
				return CaRet.internalServerErrResponse();
			}
			
	}

}
