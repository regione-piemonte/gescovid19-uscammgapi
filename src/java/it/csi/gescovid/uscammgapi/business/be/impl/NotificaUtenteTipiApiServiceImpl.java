package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.NotificaUtenteTipiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaUtenteTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaUtenteTipoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaTipoDNotificaTipoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaUtenteTipoDNotificaUtenteTipo;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaTipo;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaUtenteTipo;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class NotificaUtenteTipiApiServiceImpl  extends RESTBaseService implements NotificaUtenteTipiApi {

	@Autowired
	NotificaUtenteTipoMapper notificaUtenteTipoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	
	@Override
	public Response notificaUtenteTipiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		String methodName = "notificaUtenteTipiGet";
		log.info(methodName, "BEGIN");
		
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "d_notifica_utente_tipo", methodName);
			
			List<DNotificaUtenteTipo> listaNotificaUtenteTipo =  notificaUtenteTipoMapper.selectAllNotificaUtenteTipiValidi();
			
			List<ModelNotificaUtenteTipo> listaNotificaTipoRitorno = new ModelNotificaUtenteTipoDNotificaUtenteTipo().fromList(listaNotificaUtenteTipo);
			
			return Response.ok(listaNotificaTipoRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " notificaUtenteTipiGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " notificaUtenteTipiGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

}
