package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.NotificaAzioniApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaAzioneMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaAzioneDNotificaAzione;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaAzione;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class NotificaAzioniApiServiceImpl extends RESTBaseService implements NotificaAzioniApi {

	@Autowired
	NotificaAzioneMapper notificaAzioneMapper;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	@Override
	public Response notificaAzioniGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
	

		String methodName = "notificaAzioniGet";
		log.info(methodName, "BEGIN");
		
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "d_notifica_azione", methodName);
			
			List<DNotificaAzione> listaNotificaAzione =  notificaAzioneMapper.selectAllNotificaAzioniValide();
			
			List<ModelNotificaAzione> listaNotificaAzioneRitorno = new ModelNotificaAzioneDNotificaAzione().fromList(listaNotificaAzione);
			
			return Response.ok(listaNotificaAzioneRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " notificaAzioniGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " notificaAzioniGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
		
		
	}

}
