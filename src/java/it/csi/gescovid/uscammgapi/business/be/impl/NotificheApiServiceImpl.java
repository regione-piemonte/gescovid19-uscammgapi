package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.NotificheApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaEvento;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaPriorita;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaUtenteTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Notifica;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.SoggettoAura;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.InformazioniUtenteCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.SoggettoExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.extended.NotificaExt;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.CommonApiMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.MedicoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaAzioneMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaEventoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaPrioritaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaTipoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.NotificaUtenteTipoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoAuraExt;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoAuraMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseNotificaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseSoggettoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseUtenteContattoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.service.AuraHelperService;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaNotifica;
import it.csi.gescovid.uscammgapi.business.mapping.ModelNotificaNotificaExt;
import it.csi.gescovid.uscammgapi.dto.ModelNotifica;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaPresaVisione;
import it.csi.gescovid.uscammgapi.dto.Payload5;
import it.csi.gescovid.uscammgapi.dto.Payload6;
import it.csi.gescovid.uscammgapi.dto.Payload7;
import it.csi.gescovid.uscammgapi.dto.util.Message;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class NotificheApiServiceImpl extends RESTBaseService implements NotificheApi {

	@Autowired
	BaseUtenteContattoMapper baseUtenteContattoMapper;

	@Autowired
	BaseSoggettoMapper baseSoggettoMapper;

	@Autowired
	BaseNotificaMapper baseNotificaMapper;

	@Autowired
	NotificaAzioneMapper notificaAzioneMapper;

	@Autowired
	NotificaEventoMapper notificaEventoMapper;

	@Autowired
	NotificaTipoMapper notificaTipoMapper;

	@Autowired
	NotificaPrioritaMapper notificaPrioritaMapper;

	@Autowired
	NotificaUtenteTipoMapper notificaUtenteTipoMapper;

	@Autowired
	NotificaMapper notificaMapper;

	@Autowired
	SoggettoMapper soggettoMapper;

	@Autowired
	SoggettoAuraMapper soggettoAuraMapper;

	@Autowired
	MedicoMapper medicoMapper;
	
	@Autowired
	CommonApiMapper commonApiMapper;

	LogUtil log = new LogUtil(this.getClass());
	
	@Autowired
	AuraHelperService auraHelper;

	@Override
	public Response notificheGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer idEnte,String struttura, String tipoUtenteMitt, String tipoUtenteDest,
			String cfUtenteDestinatario, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		String methodName = "notificheGet";
		log.info(methodName, "BEGIN");

		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(tipoUtenteDest, "tipoUtenteDest obbligatorio");
//			checkNotNull(tipoUtenteMitt, "tipoUtenteMitt obbligatorio");
			
			
			// DATO IL CODICE TIPO UTENTE MITT RECUPERO IL L'ID 
			Integer notificaUtenteTipoMitt = null;
			if(tipoUtenteMitt!=null) {
				List<DNotificaUtenteTipo> listNotificaUtenteTipoId = notificaUtenteTipoMapper
						.selectNotificaUtenteTipoIdByCod(tipoUtenteMitt);
				notificaUtenteTipoMitt = listNotificaUtenteTipoId.get(0).getNotUtTipoId();
				
			}

			// DATO IL CODICE TIPO UTENTE DEST RECUPERO IL L'ID 
			List<DNotificaUtenteTipo> listNotificaUtenteTipoId = notificaUtenteTipoMapper.selectNotificaUtenteTipoIdByCod(tipoUtenteDest);
			Integer notificaUtenteTipoDest = listNotificaUtenteTipoId.get(0).getNotUtTipoId();

			// CONTROLLO APPLICAZIONE CHIAMANTE, CONTROLLO MITTENTE E DESTINATARIO
			String filtroCfUtenteDestinatario = null;
			String filtroCfUtenteRichiedente = null;
			Integer ente = null;
			
			boolean eseguiquerydelegati = true;
			/**
			  *
			  *		SONO MMG (APPLICAZIONI MMG)
			  *			MITT MMG ---> DEST USCA  notifiche con CF richiedente = CF utente collegato (medico)  
			  *			MITT MMG ---> DEST SISP  notifiche con CF richiedente = CF utente collegato (medico)  
			  *			DEST MMG ---> MITT USCA  notifiche con CF destinatario = CF utente collegato (medico)  
			  *			DEST MMG ---> MITT MMG   notifiche con CF destinatario = CF utente collegato (medico)
			  * 
			  * 
			  *  	SONO USCA (APPLICAZIONI USCA)
			  * 		MITT USCA ---> DEST MMG  notifiche con CF richiedente = CF utente collegato (medico usca) 
			  * 		MITT USCA ---> DEST SISP notifiche con CF richiedente = CF utente collegato (medico usca) 
			  * 		DEST USCA ---> MITT MMG  notifiche con struttura tra quelle dell'utente collegato (medico usca)  
			*/
            if(xApplicazioneCodice.equalsIgnoreCase("APPLICAZIONE_ESTERNA") && idEnte == null) { // x discriminare che nn arrivo da sisp
				// FIXME: IMPORTANTE DA SISTEMARE --> per ora assumiamo che possa essre MMG ma andr� modificato
            	// come era in prima versione, quindi ogni applicazione si presenta col suo codice
				
            	log.info(methodName," Get Notifiche da Applicazione MMG (xApplicazioneCodice: "+xApplicazioneCodice+")");
            	if(tipoUtenteMitt.equalsIgnoreCase("MMG") && (tipoUtenteDest.equalsIgnoreCase("USCA") 
																	|| tipoUtenteDest.equalsIgnoreCase("SISP")
																	)){

					filtroCfUtenteDestinatario = null;
					filtroCfUtenteRichiedente  = shibIdentitaCodiceFiscale;
					
					log.info(methodName,"NOTIFICHE INVIATE DA: " + tipoUtenteMitt + " Richiedente:" + filtroCfUtenteRichiedente + " DESTINATARIO " + tipoUtenteDest);
            		
				}else if(tipoUtenteDest.equalsIgnoreCase("MMG") && (tipoUtenteMitt.equalsIgnoreCase("USCA") 
																	|| tipoUtenteMitt.equalsIgnoreCase("MMG") )) {
					filtroCfUtenteDestinatario = shibIdentitaCodiceFiscale;
					filtroCfUtenteRichiedente  = null;
					
					log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " Destinatario: " + filtroCfUtenteDestinatario + " INVIATE DA: " + tipoUtenteMitt);
            		
				}

			}
            

            String strutture = null;
			if(xApplicazioneCodice.equalsIgnoreCase("MED USCA")) {
				
				eseguiquerydelegati = false;
				
				log.info(methodName,"Get Notifiche da Applicazione MED USCA (xApplicazioneCodice: "+xApplicazioneCodice+")");
				if(tipoUtenteMitt.equalsIgnoreCase("USCA") && (tipoUtenteDest.equalsIgnoreCase("MMG") 
						|| tipoUtenteDest.equalsIgnoreCase("SISP"))){
					filtroCfUtenteDestinatario = null;
					filtroCfUtenteRichiedente  = shibIdentitaCodiceFiscale;
					
					log.info(methodName,"NOTIFICHE INVIATE DA: " + tipoUtenteMitt + " Richiedente:" + filtroCfUtenteRichiedente + " DESTINATARIO " + tipoUtenteDest);
				
				}else if (tipoUtenteDest.equalsIgnoreCase("USCA") && tipoUtenteMitt.equalsIgnoreCase("MMG")) {
						filtroCfUtenteDestinatario = null;
						filtroCfUtenteRichiedente  = null;
										
					// Carico le strutture di appartenza sul cf
					strutture = getStruttureByCfMedicoUsca(shibIdentitaCodiceFiscale);
					
					if(strutture == null) filtroCfUtenteRichiedente = shibIdentitaCodiceFiscale;
					
					if(strutture!=null)
						log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " il destinatario => strutture [" + strutture + "] del cf :  "+ shibIdentitaCodiceFiscale);
					else
						log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " senza strutture (strano!) quindi il destinatario e' l'utente loggato:"+ shibIdentitaCodiceFiscale);
				}
			}
	
			// QUESTA CONDIZIONE CI DICE CHE L'APPLICAZIONE CHIAMANTE E' IL SISP  
			if(tipoUtenteDest.equalsIgnoreCase("SISP") && tipoUtenteMitt == null && idEnte !=null) {
				
				log.info(methodName,"Get Notifiche da Applicazione SISP");
				
				eseguiquerydelegati = false;
			
				// PER IL SISP NON HO CODICE APPLICAZIONE, QUINDI RICONOSCO CHE MI CHIAMA GESTIONE PAZIENTI
				// PERCHE ARRIVA UTENTE DEST SISP E L'ENTE
			
				ente = idEnte;
				
				log.info(methodName,"NOTIFICHE DESTINATARIO A : " + tipoUtenteDest + " per l'ente: " +ente + " eseguiquerydelegati: " + eseguiquerydelegati);
			}
			
			/**
			 * VECCHIA VERSIONE */
			List<NotificaExt> listNotifica =  new ArrayList<>();
			if(!eseguiquerydelegati) {
				log.info(methodName," eseguo le notifiche con query vecchia ");
				long t0 = System.currentTimeMillis();
				listNotifica = notificaMapper.selectNotificheByFiltroSisp(filtroCfUtenteDestinatario, filtroCfUtenteRichiedente,
					notificaUtenteTipoMitt, notificaUtenteTipoDest, ente, strutture);
				long t1 = System.currentTimeMillis() - t0;
				log.info(methodName,"Query selectNotificheByFiltroSisp eseguita in: "+t1+" ms. Num risultati: "+listNotifica.size()+"."
						+ "\nParams: [filtroCfUtenteDestinatario: "+filtroCfUtenteDestinatario
						+" ; filtroCfUtenteRichiedente: "+ filtroCfUtenteRichiedente
						+" ; notificaUtenteTipoMitt "+notificaUtenteTipoMitt
						+" ; notificaUtenteTipoDest: "+ notificaUtenteTipoDest
						+" ; ente: "+ ente
						+" ; strutture: "+ strutture+"]");
			}else {
				
				long t0 = System.currentTimeMillis();
				listNotifica = notificaMapper.selectNotificheByFiltro(filtroCfUtenteDestinatario, filtroCfUtenteRichiedente,
					notificaUtenteTipoMitt, notificaUtenteTipoDest, ente, strutture);
				long t1 = System.currentTimeMillis() - t0;
				log.info(methodName,"Query selectNotificheByFiltro eseguita in: "+t1+" ms. Num risultati: "+listNotifica.size()+"."
						+ "\nParams: [filtroCfUtenteDestinatario: "+filtroCfUtenteDestinatario
						+" ; filtroCfUtenteRichiedente: "+ filtroCfUtenteRichiedente
						+" ; notificaUtenteTipoMitt "+notificaUtenteTipoMitt
						+" ; notificaUtenteTipoDest: "+ notificaUtenteTipoDest
						+" ; ente: "+ ente
						+" ; strutture: "+ strutture+"]");
			}
			
			List<ModelNotifica> listNotificheRitorno = new ModelNotificaNotificaExt().fromList(listNotifica);

			// aggiungo altri dettagli non aggiunti nella prima fase di mapping
			if (listNotificheRitorno != null && !listNotificheRitorno.isEmpty()) {
				long t0 = System.currentTimeMillis();
				for (ModelNotifica notificaRitorno : listNotificheRitorno) {
					// aggiungo i dettagli del soggetto ricavandoli con la query
					notificaRitorno.setEsitoTampone(notificaMapper.getEsitoTampone(Integer.valueOf(notificaRitorno.getId())));
				}
				long t1 = System.currentTimeMillis() - t0;
				log.info(methodName,"Ciclo per query getEsitoTampone eseguito in: "+t1+" ms");
			}

			return Response.ok().entity(listNotificheRitorno).build();

		} catch (RESTException e) {
			log.error(methodName, "notificheGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "notificheGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}
	
	
	
	
	@Override
	public Response notificheCountGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer idEnte,String struttura, String tipoUtenteMitt, String tipoUtenteDest,
			String cfUtenteDestinatario, 
			String eventoCodeInParam,
			String eventoCodeNotInParam,
			SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		String methodName = "notificheCountGet";
		log.info(methodName, "BEGIN");

		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(tipoUtenteDest, "tipoUtenteDest obbligatorio");

			
			// DATO IL CODICE TIPO UTENTE MITT RECUPERO IL L'ID 
			Integer notificaUtenteTipoMitt = null;
			if(tipoUtenteMitt!=null) {
				List<DNotificaUtenteTipo> listNotificaUtenteTipoId = notificaUtenteTipoMapper
						.selectNotificaUtenteTipoIdByCod(tipoUtenteMitt);
				notificaUtenteTipoMitt = listNotificaUtenteTipoId.get(0).getNotUtTipoId();
				
			}

			// DATO IL CODICE TIPO UTENTE DEST RECUPERO IL L'ID 
			List<DNotificaUtenteTipo> listNotificaUtenteTipoId = notificaUtenteTipoMapper.selectNotificaUtenteTipoIdByCod(tipoUtenteDest);
			Integer notificaUtenteTipoDest = listNotificaUtenteTipoId.get(0).getNotUtTipoId();

			// CONTROLLO APPLICAZIONE CHIAMANTE, CONTROLLO MITTENTE E DESTINATARIO
			String filtroCfUtenteDestinatario = null;
			String filtroCfUtenteRichiedente = null;
			Integer ente = null;
			/**
			  *
			  *		SONO MMG (APPLICAZIONI MMG)
			  *			MITT MMG ---> DEST USCA  notifiche con CF richiedente = CF utente collegato (medico)  
			  *			MITT MMG ---> DEST SISP  notifiche con CF richiedente = CF utente collegato (medico)  
			  *			DEST MMG ---> MITT USCA  notifiche con CF destinatario = CF utente collegato (medico)  
			  *			DEST MMG ---> MITT MMG   notifiche con CF destinatario = CF utente collegato (medico)
			  * 
			  * 
			  *  	SONO USCA (APPLICAZIONI USCA)
			  * 		MITT USCA ---> DEST MMG  notifiche con CF richiedente = CF utente collegato (medico usca) 
			  * 		MITT USCA ---> DEST SISP notifiche con CF richiedente = CF utente collegato (medico usca) 
			  * 		DEST USCA ---> MITT MMG  notifiche con struttura tra quelle dell'utente collegato (medico usca)  
			*/
            if(xApplicazioneCodice.equalsIgnoreCase("APPLICAZIONE_ESTERNA") && idEnte == null) { // x discriminare che nn arrivo da sisp
				// FIXME: IMPORTANTE DA SISTEMARE --> per ora assumiamo che possa essre MMG ma andr� modificato
            	// come era in prima versione, quindi ogni applicazione si presenta col suo codice
				
            	log.info(methodName," Get Notifiche da Applicazione MMG (xApplicazioneCodice: "+xApplicazioneCodice+")");
            	if(tipoUtenteMitt.equalsIgnoreCase("MMG") && (tipoUtenteDest.equalsIgnoreCase("USCA") 
																	|| tipoUtenteDest.equalsIgnoreCase("SISP")
																	)){

					filtroCfUtenteDestinatario = null;
					filtroCfUtenteRichiedente  = shibIdentitaCodiceFiscale;
					
					log.info(methodName,"NOTIFICHE INVIATE DA: " + tipoUtenteMitt + " Richiedente:" + filtroCfUtenteRichiedente + " DESTINATARIO " + tipoUtenteDest);
            		
				}else if(tipoUtenteDest.equalsIgnoreCase("MMG") && (tipoUtenteMitt.equalsIgnoreCase("USCA") 
																	|| tipoUtenteMitt.equalsIgnoreCase("MMG") )) {
					filtroCfUtenteDestinatario = shibIdentitaCodiceFiscale;
					filtroCfUtenteRichiedente  = null;
					
					log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " Destinatario: " + filtroCfUtenteDestinatario + " INVIATE DA: " + tipoUtenteMitt);
            		
				}

			}
            

            String strutture = null;
			if(xApplicazioneCodice.equalsIgnoreCase("MED USCA")) {
				
				log.info(methodName,"Get Notifiche da Applicazione MED USCA (xApplicazioneCodice: "+xApplicazioneCodice+")");
				if(tipoUtenteMitt.equalsIgnoreCase("USCA") && (tipoUtenteDest.equalsIgnoreCase("MMG") 
						|| tipoUtenteDest.equalsIgnoreCase("SISP"))){
					filtroCfUtenteDestinatario = null;
					filtroCfUtenteRichiedente  = shibIdentitaCodiceFiscale;
					
					log.info(methodName,"NOTIFICHE INVIATE DA: " + tipoUtenteMitt + " Richiedente:" + filtroCfUtenteRichiedente + " DESTINATARIO " + tipoUtenteDest);
				
				}else if (tipoUtenteDest.equalsIgnoreCase("USCA") && tipoUtenteMitt.equalsIgnoreCase("MMG")) {
						filtroCfUtenteDestinatario = null;
						filtroCfUtenteRichiedente  = null;
										
					// Carico le strutture di appartenza sul cf
					strutture = getStruttureByCfMedicoUsca(shibIdentitaCodiceFiscale);
					
					if(strutture == null) filtroCfUtenteRichiedente = shibIdentitaCodiceFiscale;
					
					if(strutture!=null)
						log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " il destinatario => strutture [" + strutture + "] del cf :  "+ shibIdentitaCodiceFiscale);
					else
						log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " senza strutture (strano!) quindi il destinatario e' l'utente loggato:"+ shibIdentitaCodiceFiscale);
				}
			}
	
			// QUESTA CONDIZIONE CI DICE CHE L'APPLICAZIONE CHIAMANTE E' IL SISP  
			if(tipoUtenteDest.equalsIgnoreCase("SISP") && tipoUtenteMitt == null && idEnte !=null) {
				
				log.info(methodName,"Get Notifiche da Applicazione SISP");
			
				// PER IL SISP NON HO CODICE APPLICAZIONE, QUINDI RICONOSCO CHE MI CHIAMA GESTIONE PAZIENTI
				// PERCHE ARRIVA UTENTE DEST SISP E L'ENTE
			
				ente = idEnte;
				
				log.info(methodName,"NOTIFICHE DESTINATARIO A : " + tipoUtenteDest + " per l'ente: " +ente);
			}
			
			
			long count = notificaMapper.countNotificheByFiltro(filtroCfUtenteDestinatario, filtroCfUtenteRichiedente,
						notificaUtenteTipoMitt, notificaUtenteTipoDest, ente, strutture, 
						toList(eventoCodeInParam, "-", null), 
						toList(eventoCodeNotInParam, "-", null));
						
					
			log.info(methodName,"result: " + count + " per l'ente: " +ente);
			
			return Response.ok().entity(count).build();

		} catch (RESTException e) {
			log.error(methodName, "notificheGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "notificheGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}
	
	@Override
	public Response notificheCountByTipoGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer idEnte,String struttura, String tipoUtenteMitt, String tipoUtenteDest,
			String cfUtenteDestinatario, 
			String tipoCodeInParam,
    		String tipoCodeNotInParam,
			SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {

		String methodName = "notificheCountGet";
		log.info(methodName, "BEGIN");

		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);

			checkNotNull(tipoUtenteDest, "tipoUtenteDest obbligatorio");

			
			// DATO IL CODICE TIPO UTENTE MITT RECUPERO IL L'ID 
			Integer notificaUtenteTipoMitt = null;
			if(tipoUtenteMitt!=null) {
				List<DNotificaUtenteTipo> listNotificaUtenteTipoId = notificaUtenteTipoMapper
						.selectNotificaUtenteTipoIdByCod(tipoUtenteMitt);
				notificaUtenteTipoMitt = listNotificaUtenteTipoId.get(0).getNotUtTipoId();
				
			}

			// DATO IL CODICE TIPO UTENTE DEST RECUPERO IL L'ID 
			List<DNotificaUtenteTipo> listNotificaUtenteTipoId = notificaUtenteTipoMapper.selectNotificaUtenteTipoIdByCod(tipoUtenteDest);
			Integer notificaUtenteTipoDest = listNotificaUtenteTipoId.get(0).getNotUtTipoId();

			// CONTROLLO APPLICAZIONE CHIAMANTE, CONTROLLO MITTENTE E DESTINATARIO
			String filtroCfUtenteDestinatario = cfUtenteDestinatario;
			String filtroCfUtenteRichiedente = null;
			Integer ente = null;
			/**
			  *
			  *		SONO MMG (APPLICAZIONI MMG)
			  *			MITT MMG ---> DEST USCA  notifiche con CF richiedente = CF utente collegato (medico)  
			  *			MITT MMG ---> DEST SISP  notifiche con CF richiedente = CF utente collegato (medico)  
			  *			DEST MMG ---> MITT USCA  notifiche con CF destinatario = CF utente collegato (medico)  
			  *			DEST MMG ---> MITT MMG   notifiche con CF destinatario = CF utente collegato (medico)
			  * 
			  * 
			  *  	SONO USCA (APPLICAZIONI USCA)
			  * 		MITT USCA ---> DEST MMG  notifiche con CF richiedente = CF utente collegato (medico usca) 
			  * 		MITT USCA ---> DEST SISP notifiche con CF richiedente = CF utente collegato (medico usca) 
			  * 		DEST USCA ---> MITT MMG  notifiche con struttura tra quelle dell'utente collegato (medico usca)  
			*/
            if(xApplicazioneCodice.equalsIgnoreCase("APPLICAZIONE_ESTERNA") && idEnte == null) { // x discriminare che nn arrivo da sisp
				// FIXME: IMPORTANTE DA SISTEMARE --> per ora assumiamo che possa essre MMG ma andr� modificato
            	// come era in prima versione, quindi ogni applicazione si presenta col suo codice
				
            	log.info(methodName," Get Notifiche da Applicazione MMG (xApplicazioneCodice: "+xApplicazioneCodice+")");
            	if(tipoUtenteMitt.equalsIgnoreCase("MMG") && (tipoUtenteDest.equalsIgnoreCase("USCA") 
																	|| tipoUtenteDest.equalsIgnoreCase("SISP")
																	)){

					filtroCfUtenteDestinatario = null;
					filtroCfUtenteRichiedente  = shibIdentitaCodiceFiscale;
					
					log.info(methodName,"NOTIFICHE INVIATE DA: " + tipoUtenteMitt + " Richiedente:" + filtroCfUtenteRichiedente + " DESTINATARIO " + tipoUtenteDest);
            		
				}else if(tipoUtenteDest.equalsIgnoreCase("MMG") && (tipoUtenteMitt.equalsIgnoreCase("USCA") 
																	|| tipoUtenteMitt.equalsIgnoreCase("MMG") )) {
					filtroCfUtenteDestinatario = shibIdentitaCodiceFiscale;
					filtroCfUtenteRichiedente  = null;
					
					log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " Destinatario: " + filtroCfUtenteDestinatario + " INVIATE DA: " + tipoUtenteMitt);
            		
				}

			}
            

            String strutture = null;
			if(xApplicazioneCodice.equalsIgnoreCase("MED USCA")) {
				
				log.info(methodName,"Get Notifiche da Applicazione MED USCA (xApplicazioneCodice: "+xApplicazioneCodice+")");
				if(tipoUtenteMitt.equalsIgnoreCase("USCA") && (tipoUtenteDest.equalsIgnoreCase("MMG") 
						|| tipoUtenteDest.equalsIgnoreCase("SISP"))){
					filtroCfUtenteDestinatario = null;
					filtroCfUtenteRichiedente  = shibIdentitaCodiceFiscale;
					
					log.info(methodName,"NOTIFICHE INVIATE DA: " + tipoUtenteMitt + " Richiedente:" + filtroCfUtenteRichiedente + " DESTINATARIO " + tipoUtenteDest);
				
				}else if (tipoUtenteDest.equalsIgnoreCase("USCA") && tipoUtenteMitt.equalsIgnoreCase("MMG")) {
						filtroCfUtenteDestinatario = null;
						filtroCfUtenteRichiedente  = null;
										
					// Carico le strutture di appartenza sul cf
					strutture = getStruttureByCfMedicoUsca(shibIdentitaCodiceFiscale);
					
					if(strutture == null) filtroCfUtenteRichiedente = shibIdentitaCodiceFiscale;
					
					if(strutture!=null)
						log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " il destinatario => strutture [" + strutture + "] del cf :  "+ shibIdentitaCodiceFiscale);
					else
						log.info(methodName,"NOTIFICHE DESTINATE A : " + tipoUtenteDest + " senza strutture (strano!) quindi il destinatario e' l'utente loggato:"+ shibIdentitaCodiceFiscale);
				}
			}
	
			// QUESTA CONDIZIONE CI DICE CHE L'APPLICAZIONE CHIAMANTE E' IL SISP  
			if(tipoUtenteDest.equalsIgnoreCase("SISP") && tipoUtenteMitt == null && idEnte !=null) {
				
				log.info(methodName,"Get Notifiche da Applicazione SISP");
			
				// PER IL SISP NON HO CODICE APPLICAZIONE, QUINDI RICONOSCO CHE MI CHIAMA GESTIONE PAZIENTI
				// PERCHE ARRIVA UTENTE DEST SISP E L'ENTE
			
				ente = idEnte;
				
				log.info(methodName,"NOTIFICHE DESTINATARIO A : " + tipoUtenteDest + " per l'ente: " +ente);
			}
			
			
			long count = notificaMapper.countNotificheByFiltroForTipo(filtroCfUtenteDestinatario, filtroCfUtenteRichiedente,
						notificaUtenteTipoMitt, notificaUtenteTipoDest, ente, strutture,
						toList(tipoCodeInParam, "-", null),
						toList(tipoCodeNotInParam, "-", null));
					
			log.info(methodName,"result: " + count + " per l'ente: " +ente);
			
			return Response.ok().entity(count).build();

		} catch (RESTException e) {
			log.error(methodName, "notificheGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "notificheGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	

	private List<String> toList(String s, String regexSeparator, List<String> defaultResult) {
		
		if(StringUtils.isBlank(s)) {
			return defaultResult;
		}
		
		String[] split = s.split(regexSeparator);
		
		return Arrays.asList(split);
	}




	private String getStruttureByCfMedicoUsca(String shibIdentitaCodiceFiscale) {
		
		List<InformazioniUtenteCustomDto> selectInformazioniUtente = commonApiMapper.selectInformazioniUtente(shibIdentitaCodiceFiscale);
		
		Iterator<InformazioniUtenteCustomDto> iterator = selectInformazioniUtente.iterator();
		List<String> elencoIdStruttura = new ArrayList<String>();
		while (iterator.hasNext()) {
			InformazioniUtenteCustomDto next = iterator.next();
			elencoIdStruttura.add(next.getStrutturaId());
			 
		}
		
		return convertiStrutture(elencoIdStruttura);
	}
	
	@Override
	public Response notifichePost(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Payload5 payload, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {

		String methodName = "notifichePost";
		log.info(methodName, "BEGIN");

		try {
			ObjectMapper mapper = new ObjectMapper();

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);
			checkNotNull(payload, CaConstants.PAYLOAD_OBBLIGATORIO);

			Notifica notifica = new Notifica();
			notifica.setCfUtenteRichiesta(shibIdentitaCodiceFiscale);
			notifica.setIdSoggetto(payload.getSoggettoId());

			List<DNotificaUtenteTipo> listaNotificaUtenteTipo = notificaUtenteTipoMapper
					.selectNotificaUtenteTipoIdByCod(payload.getTipoUtente());
			if (listaNotificaUtenteTipo != null && !listaNotificaUtenteTipo.isEmpty())
				notifica.setNotUtTipoId(listaNotificaUtenteTipo.get(0).getNotUtTipoId());

			List<DNotificaUtenteTipo> listaNotificaUtenteTipoDest = notificaUtenteTipoMapper
					.selectNotificaUtenteTipoIdByCod(payload.getTipoUtenteDest());
			if (listaNotificaUtenteTipoDest != null && !listaNotificaUtenteTipoDest.isEmpty())
				notifica.setNotUtTipoIdDest(listaNotificaUtenteTipoDest.get(0).getNotUtTipoId());
			// FIXME:notifica.setIdStruttura(String.valueOf(payload.getStruttura()));

			// Gestione ente: si ricava dal soggetto 1) se sul soggetto c'� l'asl di
			// domiciclio l'ente (asl) si ricava da li
			// altrimenti 2) recupero dall'id asr che c'� sul soggetto e risalgo all'asl di
			// appartenza del soggetto

			// se sisp
			if (payload.getTipoUtenteDest().equalsIgnoreCase("SISP")) {
				SoggettoExtDto soggetto = soggettoMapper.selectEnteByIdSoggetto(payload.getSoggettoId().longValue());
				notifica.setIdEnte(soggetto.getEnteId());
			}else if (payload.getEnte() !=null) notifica.setIdEnte(payload.getEnte());

			// se mmg destinatario quindi ci va il cf del medico, leggendolo da Aura, 
			// MA solo se getCfUtenteDestinatario ==null
			// perch� altrimenti si sovrascive il cf del medico incaso di mittente usca
			if (payload.getTipoUtenteDest().equalsIgnoreCase("MMG") && StringUtils.isEmpty(payload.getCfUtenteDestinatario())) {

				List<SoggettoAura> elencoSoggettoAura = soggettoAuraMapper
						.selectByIdSoggetto(payload.getSoggettoId().longValue());
				Integer idAura = elencoSoggettoAura != null && !elencoSoggettoAura.isEmpty()
						? elencoSoggettoAura.get(0).getIdAura().intValue()
						: 0;

				Medico medico = null;
				/**
				 * Dovrebbe esserci al piu un solo soggettoAura ma il db ne permette piu di uno,
				 * scelgo il primo (come in gestionepazienti)
				 */
				if (idAura != 0) {
					List<Medico> elencoMedico = medicoMapper.selectByIdAuraSogg(idAura.longValue());
					if (elencoMedico != null && !elencoMedico.isEmpty()) {
						medico = elencoMedico.get(0);
						notifica.setCfUtenteDest(medico.getCfMedico());
					}
				}else {
					// devo ricavare id aura e medico 
					Soggetto soggetto = soggettoMapper.selectByPrimaryKey(payload.getSoggettoId().longValue());
					SoggettoAuraExt soggAura = auraHelper.findProfiliAnagrafici(soggetto.getCodiceFiscale());
					
					if(soggAura.getMedico()!= null) {						
						medico = soggAura.getMedico();
						notifica.setCfUtenteDest(medico.getCfMedico());
					}else {
						log.error(methodName,"codice fiscale medico non presente");
						Response resp = Response.status(Status.NOT_FOUND).entity(new Message(Status.NOT_FOUND.name(),"Codice fiscale del medico non presente in AURA, la notifica non pu� essere inviata")).build();
						return resp;
					}
				}

			} else
				notifica.setCfUtenteDest(payload.getCfUtenteDestinatario()); 
			
			
			if (payload.getTipoUtenteDest().equalsIgnoreCase("USCA") && 
					payload.getStruttura()!=null && !payload.getStruttura().isEmpty()) {
				// setto la struttura 
				notifica.setIdStruttura(payload.getStruttura());
			}

			notifica.setNotDataNotifica(new Date());
			notifica.setUtenteOperazione(shibIdentitaCodiceFiscale);

			List<DNotificaAzione> listaNotificaAzione = notificaAzioneMapper
					.selectNotificaAzioniIdByCod(payload.getAzione());
			if (listaNotificaAzione != null && !listaNotificaAzione.isEmpty())
				notifica.setNotAzId(listaNotificaAzione.get(0).getNotAzId());

			List<DNotificaPriorita> listaNotificaPriorita = notificaPrioritaMapper
					.selectNotificaPrioritaIdByCod(payload.getPriorita());
			if (listaNotificaPriorita != null && !listaNotificaPriorita.isEmpty())
				notifica.setPrioritaId(listaNotificaPriorita.get(0).getPrioritaId());

			List<DNotificaEvento> listaNotificaEvento = notificaEventoMapper
					.selectNotificaEventoIdByCod(payload.getEvento());
			if (listaNotificaEvento != null && !listaNotificaEvento.isEmpty())
				notifica.setNotEvId(listaNotificaEvento.get(0).getNotEvId());

			List<DNotificaTipo> listaNotificaTipo = notificaTipoMapper
					.selectNotificaTipoIdByCod(payload.getTipoNotifica());
			if (listaNotificaTipo != null && !listaNotificaTipo.isEmpty())
				notifica.setNotTipoId(listaNotificaTipo.get(0).getNotTipoId());

			notifica.setDataCreazione(notifica.getNotDataNotifica());
			notifica.setDataModifica(notifica.getNotDataNotifica());
			notifica.setNotTestoRequest(payload.getDescrizione());

			baseNotificaMapper.insert(notifica);
			logAudit(httpHeaders, "insert", "notifica", mapper.writeValueAsString(notifica));
			log.info(methodName, "inserita notifica - notifica => not_id: " + notifica.getNotId());

			Notifica notificaInserita = baseNotificaMapper.selectByPrimaryKey(notifica.getNotId());
			ModelNotifica notificaRitorno = new ModelNotificaNotifica().from(notificaInserita);

			return Response.ok(notificaRitorno).build();

		} catch (RESTException e) {
			log.error(methodName, "notificaPost ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "notificaPost ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}

	@Override
	public Response notificaIdAzionePut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer notificaId, Payload6 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "notifichePut";
		log.info(methodName, "BEGIN");

		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);
			checkNotNull(notificaId, "id notifica mancante");

			ModelNotifica notificaAggiornataRitorno = aggiornaNotifica(shibIdentitaCodiceFiscale, notificaId, payload.getTesto());
			
			return Response.ok(notificaAggiornataRitorno).build();

		} catch (RESTException e) {
			log.error(methodName, "notificaPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "notificaPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}


	@Override
	public Response notifichePresaVisionePut(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Payload7 payload,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		String methodName = "notifichePresaVisionePut";
		log.info(methodName, "BEGIN");

		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkUtenteAutorizzato(shibIdentitaCodiceFiscale, xApplicazioneCodice);
			checkNotNull(payload.getNotifiche(), "lista ids notifiche da aggiornare nulla");

			//List<ModelNotificaPresaVisione> listaNotificheAggiornate = new ArrayList<ModelNotificaPresaVisione>();
			
			for (ModelNotificaPresaVisione notifica : payload.getNotifiche()) {
				
				ModelNotificaPresaVisione notificaRes = new ModelNotificaPresaVisione();
				Notifica notificaDb = new Notifica();
				
				notificaDb.setNotId(notifica.getId());
				notificaDb.setCfUtentePresaVis(shibIdentitaCodiceFiscale);
				notificaDb.setNotTestoResponse(notifica.getTesto());
				notificaDb.setNotDataPresaVisione(new Date());
				notificaDb.setDataModifica(notificaDb.getNotDataPresaVisione());
				
				
				notificaMapper.updateByPrimaryKeyRidotta(notificaDb);

//				Notifica notificaAggiornata = notificaMapper.selectByPrimaryKey(notifica.getId());
//				
//				notificaRes.setId(notificaAggiornata.getNotId());
//				notificaRes.setTestoRisposta(notificaAggiornata.getNotTestoRequest());
//
//				
//				listaNotificheAggiornate.add(notificaRes);
			}
			
			return Response.ok().build();

		} catch (RESTException e) {
			log.error(methodName, "notificaPut ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "notificaPut ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}

	}
	
	
	private ModelNotifica aggiornaNotifica(String shibIdentitaCodiceFiscale, Integer notificaId, String testo) {
		
		Notifica notifica = new Notifica();
		notifica.setNotId(notificaId);
		notifica.setNotDataPresaVisione(new Date());
		notifica.setCfUtentePresaVis(shibIdentitaCodiceFiscale);
		notifica.setNotTestoResponse(testo);
		notifica.setDataModifica(notifica.getNotDataPresaVisione());
		
		notificaMapper.updateByPrimaryKeyRidotta(notifica);

		Notifica notificaAggiornata = notificaMapper.selectByPrimaryKey(notificaId);
		ModelNotifica notificaAggiornataRitorno = new ModelNotificaNotifica().from(notificaAggiornata);
		return notificaAggiornataRitorno;
	}


}
