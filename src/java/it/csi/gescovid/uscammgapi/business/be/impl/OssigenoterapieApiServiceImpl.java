package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.OssigenoterapieApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDOssigenoTerapia;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.OssigenoterapiaTipoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelOssigenoterapiaCovidusDOssigenoTerapiaMapping;
import it.csi.gescovid.uscammgapi.dto.ModelOssigenoterapia;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class OssigenoterapieApiServiceImpl extends RESTBaseService implements OssigenoterapieApi {
	
	@Autowired
	OssigenoterapiaTipoMapper ossigenoterapiaTipoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());


	@Override
	public Response ossigenoterapieGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		String methodName = "ossigenoterapieGet";
		log.info(methodName, "BEGIN");
		
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "covidus_d_ossigeno_terapia", methodName);
			
			List<CovidusDOssigenoTerapia> listaOssigenoterapiaTipo =  ossigenoterapiaTipoMapper.selectAllOssigenoterapiaTipoValidi();
			
			List<ModelOssigenoterapia> listaOssigenoterapiaTipoRitorno = new ModelOssigenoterapiaCovidusDOssigenoTerapiaMapping().fromList(listaOssigenoterapiaTipo);
			
			return Response.ok(listaOssigenoterapiaTipoRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " ossigenoterapieGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " ossigenoterapieGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	

}
