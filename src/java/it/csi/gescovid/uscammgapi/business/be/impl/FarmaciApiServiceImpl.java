package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.FarmaciApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.FarmacoTipoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelFarmacoCovidusDFarmacoMapping;
import it.csi.gescovid.uscammgapi.dto.ModelFarmaco;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class FarmaciApiServiceImpl extends RESTBaseService implements FarmaciApi {
	
	@Autowired
	FarmacoTipoMapper farmacoTipoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());


	@Override
	public Response farmaciGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		String methodName = "farmaciGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "covidus_d_farmaco", methodName);
			
			List<CovidusDFarmaco> listaFarmaciTipo =  farmacoTipoMapper.selectAllFarmaciTipoValidi();
			
			List<ModelFarmaco> listaFarmaciTipoRitorno = new ModelFarmacoCovidusDFarmacoMapping().fromList(listaFarmaciTipo);
			
			return Response.ok(listaFarmaciTipoRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " farmaciGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " farmaciGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}


}
