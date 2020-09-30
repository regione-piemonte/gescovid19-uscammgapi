package it.csi.gescovid.uscammgapi.business.be.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gescovid.uscammgapi.business.be.UtentiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.UtentiApiMapper;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteContatto;
import it.csi.gescovid.uscammgapi.dto.Payload4;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UtentiApiServiceImpl extends RESTBaseService implements UtentiApi {

	@Autowired
	UtentiApiMapper utentiApiMapper;

	LogUtil log = new LogUtil(this.getClass());

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response utentiUtenteCfContattiPut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String utenteCf, Payload4 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "utentiUtenteCfContattiPut";
		log.info(methodName, "BEGIN");

		try {
			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(utenteCf, "utenteCf non valorizzato");

			String email = (payload != null ? payload.getEmail() : null);
			String telefono = (payload != null ? payload.getTelefono() : null);

			UtenteContatto utenteDaAgg = utentiApiMapper.selectUtenteContattoByPrimaryKey(utenteCf);
			ModelUtenteContatto modelUtenteContatto = new ModelUtenteContatto();
			
		
			if(utenteDaAgg==null) { 
				
				utenteDaAgg = new UtenteContatto();
				utenteDaAgg.setCfUtente(utenteCf);
				utenteDaAgg.setEmail(email);
				utenteDaAgg.setTelefono(telefono);
				utentiApiMapper.insert(utenteDaAgg);
				
				logAudit(httpHeaders, "insert", "utente_contatto", mapper.writeValueAsString(utenteDaAgg));
			}
			else{
			
				// da verificare perchè si fa questa cosa
				//utenteDaAgg.setNome(utenteDaAgg.getNome());
				//utenteDaAgg.setCognome(utenteDaAgg.getCognome());
							
				utenteDaAgg.setEmail(email);
				utenteDaAgg.setTelefono(telefono);
				if (payload != null) {
					utentiApiMapper.updateUtenteContattoByCodiceFiscale(utenteDaAgg);
				}
				logAudit(httpHeaders, "update", "utente_contatto", mapper.writeValueAsString(utenteDaAgg));
	
				
			}	
			
			modelUtenteContatto = utentiApiMapper.selectModelUtenteContattoByPrimaryKey(utenteCf);
			
			return Response.ok(modelUtenteContatto).build();

		} catch (RESTException e) {
			log.error(methodName, "utentiUtenteCfContattiPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "utentiUtenteCfContattiPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

}
