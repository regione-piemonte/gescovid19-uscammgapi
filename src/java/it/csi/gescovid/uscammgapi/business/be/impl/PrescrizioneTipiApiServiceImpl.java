package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.PrescrizioneTipiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDPrescTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.PrescTipoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelPrescrizioneTipoCoviduDPrescTipoExtMapping;
import it.csi.gescovid.uscammgapi.dto.ModelPrescrizioneTipo;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class PrescrizioneTipiApiServiceImpl extends RESTBaseService implements PrescrizioneTipiApi {
	
	@Autowired
	PrescTipoMapper prescTipoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());
	
	@Override
	public Response prescrizioneTipiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		String methodName = "prescrizioneTipiGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			
			List<CovidusDPrescTipo> lista = prescTipoMapper.selectAll();

			logAudit(httpHeaders, "select", "covidus_d_presc_tipo", "selectAll");
			
			List<ModelPrescrizioneTipo> listaPrescrizioneTipo =  new ModelPrescrizioneTipoCoviduDPrescTipoExtMapping().fromList(lista);
			
			return Response.ok().entity(listaPrescrizioneTipo).build();
			
		} catch (RESTException e) {
			log.error(methodName, " schedaStatiGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedaStatiGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}
	
	

}
