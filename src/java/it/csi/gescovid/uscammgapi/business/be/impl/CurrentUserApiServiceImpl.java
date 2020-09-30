package it.csi.gescovid.uscammgapi.business.be.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response.Status;

import it.csi.gescovid.uscammgapi.business.be.CurrentUserApi;
import it.csi.gescovid.uscammgapi.business.be.impl.service.CurrentUserService;
import it.csi.gescovid.uscammgapi.dto.ModelUtente;
import it.csi.gescovid.uscammgapi.exception.ErroreBuilder;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class CurrentUserApiServiceImpl extends CurrentUserService implements CurrentUserApi {


	LogUtil log = new LogUtil(this.getClass());

	@Override
	public Response currentUserGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		
		String methodName = "currentUserGet";
		log.info(methodName, "BEGIN");
		
		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			// xApplicazioneCodice = a usca, 118 o guardia medica
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);
			logAudit(httpHeaders, "select", "utenti", "selectElencoProfili");
			
			ModelUtente utente = loadUser(shibIdentitaCodiceFiscale);  
			
			/**
			 * raffa modifica
			 */
			
			if(utente == null) {

				return ErroreBuilder.from(Status.INTERNAL_SERVER_ERROR)
						.descrizione("Utente con codice fiscale " + shibIdentitaCodiceFiscale +" non trovato.").exception()
						.getResponseBuilder().build();
			}
			
			return Response.ok(utente).build();
			
			

		} catch (RESTException e) {
			log.error(methodName, "currentUserGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "currentUserGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}


}
