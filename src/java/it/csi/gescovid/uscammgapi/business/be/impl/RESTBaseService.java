package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusLogAudit;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.ProfiloEnum;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.Audit;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.AuditMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.CovidusLogAuditMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.UtentiMapper;
import it.csi.gescovid.uscammgapi.dto.util.UtilitiStream;
import it.csi.gescovid.uscammgapi.exception.ErroreBuilder;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.LogUtil;
import it.csi.gescovid.uscammgapi.util.SpringSupportedResource;

public class RESTBaseService extends SpringSupportedResource {

	@Autowired
	UtentiMapper utentiMapper;

	@Autowired
	//CovidusLogAuditMapper repositoryLogAudit;
	AuditMapper repositoryAudit;
	
	LogUtil log = new LogUtil(this.getClass());

//	protected void checkUtenteAutorizzato(String shibIdentitaCodiceFiscale, String xApplicazioneCodice) {
//		if(xApplicazioneCodice.equalsIgnoreCase("APPLICAZIONE_ESTERNA")) return; // nessun controllo
//		
//		List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(shibIdentitaCodiceFiscale);
//		boolean isPresenteProfilo = UtilitiStream.verificaProfili(elencoProfiliDB, xApplicazioneCodice);
//		checkCondition(isPresenteProfilo,
//				ErroreBuilder.from(Status.UNAUTHORIZED).descrizione("Utente non autorizzato").exception());
//	}
	

	protected void checkUtenteAutorizzato(String shibIdentitaCodiceFiscale, String xApplicazioneCodice) {
		if(xApplicazioneCodice.equalsIgnoreCase("APPLICAZIONE_ESTERNA")) return; // nessun controllo
		
		List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(shibIdentitaCodiceFiscale);
		
		boolean isPresenteProfilo = false;
		
		for (Profilo profilo : elencoProfiliDB) {
			if(profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_USCA.getCodice())
					|| profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_MMG.getCodice())
					|| profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_CONTASSISTENZIALE.getCodice()) 
					|| profilo.getNomeProfilo().equalsIgnoreCase(ProfiloEnum.MEDICO_118.getCodice())
					) {
				isPresenteProfilo = true; 
				break;
			}
		}
				
		checkCondition(isPresenteProfilo,
				ErroreBuilder.from(Status.UNAUTHORIZED).descrizione("Utente non autorizzato").exception());
	}

	protected void logAudit(HttpHeaders headers, String action, String table, String description) {
		String shibIdentitaCf = getHeaderParam(headers, "Shib-Identita-CodiceFiscale", true);
		log.info("logAudit", "[HeaderParam - Shib-Identita-CodiceFiscale] value: " + shibIdentitaCf);
		//String xApplicationcodice = getHeaderParam(headers, "X-Applicazione-Codice", true);
		//String xRequestId = getHeaderParam(headers, "X-Request-Id", true);
		String ipAddress =  getHeaderParam(headers, "X-Forwarded-For", false);
		log.info("logAudit", "[HeaderParam - X-Forwarded-For] value: " + ipAddress);
		//ipAddress = StringUtils.contains(ipAddress, ",")?  ipAddress.substring(0, ipAddress.indexOf(",")): ipAddress;
		String userAgent = getHeaderParam(headers, "User-Agent", false);
		log.info("logAudit", "[HeaderParam - User-Agent] value: " + userAgent);
			
		Audit logAudit = new Audit();
		
		logAudit.setAction(action);
		logAudit.setUser(shibIdentitaCf);
		logAudit.setIp(ipAddress);
		logAudit.setTable(table);
		logAudit.setDescription(description);
		
		repositoryAudit.insert(logAudit);
	}

	protected String getHeaderParam(HttpHeaders httpHeaders, String headerParam, boolean obbligatorio) throws RESTException {
		List<String> values = httpHeaders.getRequestHeader(headerParam);
		String ret = "";
		if(obbligatorio) {
			if (values == null) {
				throw ErroreBuilder.from(Status.BAD_REQUEST).descrizione("Parametro mancante: " + headerParam).exception();
			} else if (values.size() == 0 ) {
				throw ErroreBuilder.from(Status.BAD_REQUEST).descrizione("Parametro mancante: " + headerParam).exception();
			}else {
				ret = values.get(0);
			}
		}
		else if(values != null && values.size() != 0) {
			ret = values.get(0);
		}
		
		return ret;
	}
	
	
	
	public String convertiStrutture(List<String> elencoIdStruttura) {
		String res = "";

		if (elencoIdStruttura.size() == 0) {
			return null;
		}

		Iterator<String> iterator = elencoIdStruttura.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();

			if (res.isEmpty()) {
				res = "'" + next.trim() + "'";
			} else {
				res += ",'" + next.trim() + "'";
			}
		}

		return res;
	}

	/**
	 * Controlla che il parametro obj sia valorizzato; diversamente solleva una
	 * {@link RESTException} con Status.BAD_REQUEST e con il messaggio passato come
	 * parametro.
	 * 
	 * @param obj
	 * @param message
	 */
	protected void checkNotNull(Object obj, String message) {
		checkNotNull(obj, ErroreBuilder.from(Status.BAD_REQUEST).descrizione(message).exception());
	}

	/**
	 * Controlla che il parametro obj sia valorizzato; diversamente solleva
	 * l'eccezione passata come parametro.
	 * 
	 * @param obj
	 * @param re
	 */
	protected void checkNotNull(Object obj, RESTException re) {
		checkCondition(obj != null, re);
	}

	/**
	 * Controlla che il parametro str sia valorizzato; diversamente solleva una
	 * {@link RESTException} con Status.BAD_REQUEST e con il messaggio passato come
	 * parametro.
	 * 
	 * @param obj
	 * @param re
	 */
	protected void checkNotBlank(String str, String message) {
		checkNotBlank(str, ErroreBuilder.from(Status.BAD_REQUEST).descrizione(message).exception());
	}

	/**
	 * Controlla che il parametro str sia valorizzato; diversamente solleva
	 * l'eccezione passata come parametro.
	 * 
	 * @param obj
	 * @param re
	 */
	protected void checkNotBlank(String str, RESTException re) {
		checkCondition(StringUtils.isNotBlank(str), re);
	}

	/**
	 * Controlla che la condizione isOk sia uguale a <code>true</code>; diversamente
	 * solleva l'eccezione passata come parametro.
	 * 
	 * @param isOk
	 * @param re
	 */
	protected void checkCondition(boolean isOk, RESTException re) {
		if (!isOk) {
			throw re;
		}
	}

	/**
	 * Controlla che la condizione isOk sia uguale a <code>true</code>; diversamente
	 * solleva una {@link RESTException} con Status.BAD_REQUEST e con il messaggio
	 * passato come parametro.
	 * 
	 * @param isOk
	 * @param re
	 */
	protected void checkCondition(boolean isOk, String message) {
		checkCondition(isOk, ErroreBuilder.from(Status.BAD_REQUEST).descrizione(message).exception());
	}
}
