package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.MonitoraggioTipoApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDMonitoraggioTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.CovidusDMonitoraggioTipoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelMonitoraggioTipiCovidusDMonitoraggioTipiMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaAzioneDNotificaAzione;
import it.csi.gescovid.uscammgapi.dto.ModelMonitoraggioTipo;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaAzione;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class MonitoraggioTipoApiServiceImpl extends RESTBaseService implements MonitoraggioTipoApi {

	@Autowired
	CovidusDMonitoraggioTipoMapper monitoraggioTipoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	@Override
	public Response monitoraggioTipiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
	

		String methodName = "monitoraggioTipiGet";
		log.info(methodName, "BEGIN");
		
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "covidus_d_monitoraggio_tipo", methodName);
			
			List<CovidusDMonitoraggioTipo> lista =  monitoraggioTipoMapper.selectAllMonitoraggioTipiValidi();
			
			List<ModelMonitoraggioTipo> listaNotificaAzioneRitorno = new ModelMonitoraggioTipiCovidusDMonitoraggioTipiMapping().fromList(lista);
			
			return Response.ok(listaNotificaAzioneRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " monitoraggioTipiGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " monitoraggioTipiGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
		
		
	}

}
