package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.SoggettiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.IstitutoScolastico;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.SoggettoAura;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.SoggettoContatto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.ElencoDecorso;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.ElencoTampone;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.SoggettoExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.DecorsoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.IstitutiScolasticiMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.MedicoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoAuraMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoContattoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoContattoTipoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.TamponeMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelIstitutoScolasticoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelSoggettoElencoDecorsoElencoDecorsoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelSoggettoElencoTamponeElencoTamponeMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelSoggettoMedicoMedicoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.SoggettoContattoSoggettoMapping;
import it.csi.gescovid.uscammgapi.dto.ModelIstitutoScolastico;
import it.csi.gescovid.uscammgapi.dto.ModelSoggetto;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoAsr;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoComuneDomicilio;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoContatto;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoElencoDecorso;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoElencoTampone;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;


public class SoggettiApiServiceImpl extends RESTBaseService implements SoggettiApi {


	LogUtil log = new LogUtil(this.getClass());

	@Autowired
	SoggettoMapper soggettoMapper;
	
	@Autowired 
	TamponeMapper tamponeMapper;
	
	@Autowired 
	DecorsoMapper decorsoMapper;
	
	@Autowired
	SoggettoAuraMapper soggettoAuraMapper;
	
	@Autowired
	SoggettoContattoMapper soggettoContattoMapper;
	
	@Autowired
	SoggettoContattoTipoMapper soggettoContattoTipoMapper;
	
	@Autowired
	MedicoMapper medicoMapper;
	
	@Autowired
	IstitutiScolasticiMapper istitutiScolasticiMapper;

	@Override
	public Response soggettiSoggettoIdGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, Integer soggettoId, 
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		String methodName = "soggettiSoggettoIdGet";
		log.info(methodName, "BEGIN");
		
		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			logAudit(httpHeaders, "select", "soggetto", methodName);
			
			SoggettoExtDto soggetto = soggettoMapper.selectForElencoByIdSoggetto(soggettoId.longValue());
			
			if (soggetto==null) return Response.ok(null).build();
			
			ModelSoggetto modelsoggetto = getDettaglioSoggetto(soggettoId, soggetto);
			
			return Response.ok(modelsoggetto).build();
			

		} catch (RESTException e) {
			log.error(methodName, " ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	private ModelSoggetto getDettaglioSoggetto(Integer soggettoId, SoggettoExtDto soggetto) {
		
		List<ElencoTampone> elencoTampone = tamponeMapper.selectForElencoByIdSoggetto(soggettoId.longValue());
		List<ElencoDecorso> elencoDecorso = decorsoMapper.selectForElencoByIdSoggetto(soggettoId.longValue());
		List<SoggettoContatto> elencoContattiDa = soggettoContattoMapper.selectContattiDaA(soggettoId.longValue(), null);
		List<SoggettoContatto> elencoContattiA = soggettoContattoMapper.selectContattiDaA(null, soggettoId.longValue());
		Date now = new Date();
		List<IstitutoScolastico> elencoIstitutoScolastico = istitutiScolasticiMapper.selectIstitutiValidiBySoggettoId(soggettoId.longValue(),now);
		
		List<SoggettoAura> elencoSoggettoAura = soggettoAuraMapper.selectByIdSoggetto(soggettoId.longValue());
		
		Integer idAura = elencoSoggettoAura!=null && !elencoSoggettoAura.isEmpty()?elencoSoggettoAura.get(0).getIdAura().intValue() : 0  ;
		
		Medico medico = null;
		/**
		 *  Dovrebbe esserci al piu un solo soggettoAura ma il db ne permette piu di uno, scelgo il primo
		 */
		if (idAura != 0)
		{
			List<Medico> elencoMedico = medicoMapper.selectByIdAuraSogg(idAura.longValue());
			if (elencoMedico!=null && !elencoMedico.isEmpty())
			{	
				medico = elencoMedico.get(0);
				
			}
		}
		
		ModelSoggetto modelsoggetto = convertiSoggettoModelSoggetto(soggetto, idAura);
		modelsoggetto.setMedico(new ModelSoggettoMedicoMedicoMapping().from(medico));

		List<ModelSoggettoElencoTampone> modelelencotampone =  new ModelSoggettoElencoTamponeElencoTamponeMapping().fromList(elencoTampone);
		modelsoggetto.setElencoTampone(modelelencotampone);
		
		//map elenco istituti scolastici
		List<ModelIstitutoScolastico> modelIstitutoScolastico = new ModelIstitutoScolasticoMapping().fromList(elencoIstitutoScolastico);
		modelsoggetto.setElencoIstitutoScolastico(modelIstitutoScolastico);
		
		
		List<ModelSoggettoElencoDecorso> modelelencodecorso =  new ModelSoggettoElencoDecorsoElencoDecorsoMapping().fromList(elencoDecorso);
		modelsoggetto.setElencoDecorso(modelelencodecorso);
		
		List<ModelSoggettoContatto> elencoContattiConDettagliDa = new ArrayList<ModelSoggettoContatto>();
		// dati minimi del soggetto DA
		for (SoggettoContatto soggettoDa : elencoContattiDa) {
			
			Soggetto soggettoExtDa = soggettoMapper.selectByPrimaryKey(soggettoDa.getIdSoggettoDa());
			ModelSoggettoContatto contattoDa = new SoggettoContattoSoggettoMapping().from(soggettoExtDa);
			elencoContattiConDettagliDa.add(contattoDa);
		}
		
		List<ModelSoggettoContatto> elencoContattiConDettagliA = new ArrayList<ModelSoggettoContatto>();
		// dati minimi del soggetto A
		for (SoggettoContatto soggettoA : elencoContattiA) {
			
			Soggetto soggettoExtA = soggettoMapper.selectByPrimaryKey(soggettoA.getIdSoggettoA());
			ModelSoggettoContatto contattoA = new SoggettoContattoSoggettoMapping().from(soggettoExtA);
			elencoContattiConDettagliA.add(contattoA);
		}
		
		modelsoggetto.setElencoContattiDa(elencoContattiConDettagliDa);
		modelsoggetto.setElencoContattiA(elencoContattiConDettagliA);
		
		return modelsoggetto;
	}

	private ModelSoggetto convertiSoggettoModelSoggetto(SoggettoExtDto soggetto, Integer idAura) {
		
		ModelSoggetto msoggetto = new ModelSoggetto();
		msoggetto.setIdAura(idAura);
		msoggetto.setIdSoggetto(soggetto.getIdSoggetto().intValue());
		msoggetto.setIdAsr(soggetto.getIdAsr()!=null ? soggetto.getIdAsr().intValue():0);
		msoggetto.setIdTipoSoggetto(soggetto.getIdTipoSoggetto()!=null ? soggetto.getIdTipoSoggetto(): 0);
		msoggetto.setCodiceFiscale(soggetto.getCodiceFiscale()!=null ? soggetto.getCodiceFiscale() : "");
		msoggetto.setCognome(soggetto.getCognome()!=null? soggetto.getCognome():"" );
		msoggetto.setNome(soggetto.getNome()!=null? soggetto.getNome():"" );
		msoggetto.setComuneResidenzaIstat(soggetto.getComuneResidenzaIstat() !=null? soggetto.getComuneResidenzaIstat():"");
		msoggetto.setComuneDomicilioIstat(soggetto.getComuneDomicilioIstat() !=null? soggetto.getComuneDomicilioIstat():"");
		msoggetto.setIndirizzodomicilio(soggetto.getIndirizzoDomicilio()!=null? soggetto.getIndirizzoDomicilio():"");
		msoggetto.setTelefonoRecapito(soggetto.getTelefonoRecapito()!=null? soggetto.getTelefonoRecapito():"");
		msoggetto.setDataNascita(soggetto.getDataNascita()!=null? soggetto.getDataNascita(): null);
		msoggetto.setAslDomicilio(soggetto.getAslDomicilio()!=null ? soggetto.getAslDomicilio() :"");
		msoggetto.setAslResidenza(soggetto.getAslResidenza()!=null ? soggetto.getAslResidenza() :"");
		msoggetto.setEmail(soggetto.getEmail()!=null ? soggetto.getEmail() :"");
		msoggetto.setNumeroCampioni(soggetto.getNumeroCampioni());
		msoggetto.setNumeroDecorsi(soggetto.getNumeroDecorsi());
		msoggetto.setUltimoIdTipoEvento(soggetto.getUltimoIdTipoEvento());
		
		convertiAsrModelUtenteAsr(soggetto, msoggetto);
		convertiDomicilioResidenza(soggetto, msoggetto);
		
		return msoggetto;
	}

	private void convertiDomicilioResidenza(SoggettoExtDto soggetto, ModelSoggetto msoggetto) {
		//ModelUtenteSindacoComune mcomuneDomicilio = new ModelUtenteSindacoComune();
		ModelSoggettoComuneDomicilio mcomuneDomicilio = new ModelSoggettoComuneDomicilio();
		
		if(soggetto.getComuneDomicilio()!=null) {
			mcomuneDomicilio.setIstatComune(soggetto.getComuneDomicilio().getIstatComune()!=null ? soggetto.getComuneDomicilio().getIstatComune() : "");
			mcomuneDomicilio.setNomeComune(soggetto.getComuneDomicilio().getNomeComune() != null ? soggetto.getComuneDomicilio().getNomeComune() : "");
		}
		msoggetto.setComuneDomicilio(mcomuneDomicilio);
		
		//ModelUtenteSindacoComune mcomunResidenza = new ModelUtenteSindacoComune();
		ModelSoggettoComuneDomicilio mcomunResidenza = new ModelSoggettoComuneDomicilio();
		if(soggetto.getComuneResidenza()!=null) {
			mcomunResidenza.setIstatComune(soggetto.getComuneResidenza()!=null ? soggetto.getComuneResidenza().getIstatComune() : "");
			mcomunResidenza.setNomeComune(soggetto.getComuneResidenza().getNomeComune() != null ? soggetto.getComuneResidenza().getNomeComune() : "");
		}
		msoggetto.setComuneResidenza(mcomunResidenza);
	}

	private void convertiAsrModelUtenteAsr(SoggettoExtDto soggetto, ModelSoggetto msoggetto) {
		//ModelUtenteAsr mutenteasr = new ModelUtenteAsr();
		
		ModelSoggettoAsr mutenteasr= new ModelSoggettoAsr();
		if(soggetto.getAsr()!=null) {
		    mutenteasr.setIdAsr(soggetto.getAsr().getIdAsr()!=null ? soggetto.getAsr().getIdAsr().intValue(): 0);
		    mutenteasr.setDescrizione(soggetto.getAsr().getDescrizione()!=null ? soggetto.getAsr().getDescrizione() : "");
		    mutenteasr.setIdEnte(soggetto.getAsr().getIdEnte()!=null ? soggetto.getAsr().getIdEnte(): 0);
		}
		msoggetto.setAsr(mutenteasr);
	}

	@Override
	public Response soggettiSoggettoCfGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String codiceFiscale,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "soggettiSoggettoCfGet";
		log.info(methodName, "BEGIN");
		
		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			checkNotNull(codiceFiscale, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			logAudit(httpHeaders, "select for cfsoggetto", "soggetto", methodName);
			
			SoggettoExtDto soggetto = soggettoMapper.selectSoggettoBySoggetto(codiceFiscale, null, null, null);
			
			if (soggetto==null) return Response.ok(null).build();
			
			
			ModelSoggetto modelsoggetto = getDettaglioSoggetto(soggetto.getIdSoggetto().intValue(), soggetto);
			
			
			return Response.ok(modelsoggetto).build();
			

		} catch (RESTException e) {
			log.error(methodName, " ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	@Override
	public Response soggettiSoggettoNomeCognomeGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String nome, String cognome, String dataNascita,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "soggettiSoggettoNomeCognomeGet";
		log.info(methodName, "BEGIN");
		
		try {

			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(nome, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(cognome, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(dataNascita, CaConstants.IDENTITA_OBBLIGATORIA);

			logAudit(httpHeaders, "select for nome e cognome", "soggetto", methodName);
			
			SoggettoExtDto soggetto = soggettoMapper.selectSoggettoBySoggetto(null, nome, cognome, dataNascita);
			
			if (soggetto==null) return Response.ok(null).build();
			
			
			ModelSoggetto modelsoggetto = getDettaglioSoggetto(soggetto.getIdSoggetto().intValue(), soggetto);
			
			
			return Response.ok(modelsoggetto).build();
			

		} catch (RESTException e) {
			log.error(methodName, " ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}


}
