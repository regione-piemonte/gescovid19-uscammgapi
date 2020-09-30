package it.csi.gescovid.uscammgapi.business.be.impl.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import it.csi.gescovid.uscammgapi.business.aura.find.DatiAnagrafici;
import it.csi.gescovid.uscammgapi.business.aura.find.FindProfiliAnagraficiResult;
import it.csi.gescovid.uscammgapi.business.aura.get.GetProfiloSanitarioResponse;
import it.csi.gescovid.uscammgapi.business.aura.get.SoggettoAuraBody;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SoggettoAuraExt;
import it.csi.gescovid.uscammgapi.business.delegate.AuraWsDelegate;
import it.csi.gescovid.uscammgapi.util.LogUtil;

@Component
public class AuraHelperService {
	
	
	@Value("${auraprefix.url}")
	private String auraprefixUrl;
	@Value("${aura.user}")
	private String auraUser;
	@Value("${aura.pwd}")
	private String auraPwd;
	@Value("${aura.timeoutmills}")
	private int auraTimeout;
	

//	private String auraprefixUrl="https://tst-portale.ruparpiemonte.it/sanitxens/AURA.WS";
//	private String auraUser="test";
//	private String auraPwd="stop";
//	private int auraTimeout=10000;

	LogUtil log = new LogUtil(this.getClass());
	
	
	public  SoggettoAuraExt findProfiliAnagrafici(String codiceFiscale) throws Exception{

	    it.csi.gescovid.uscammgapi.business.aura.find.FindProfiliAnagraficiResult fp= AuraWsDelegate.findProfiliAnagrafici(codiceFiscale, null, null, null, auraUser, auraPwd, auraprefixUrl, auraTimeout);
		return removedCFDuplicatedInactive(extractFromFindProfili(fp));
	}
	
	
	private SoggettoAuraExt removedCFDuplicatedInactive(List<SoggettoAuraExt> list) throws Exception {
		
		String methodName = "removedCFDuplicatedInactive";
		log.info(methodName, "BEGIN");
		
		if (list==null) return null;
		
		SoggettoAuraExt result = new SoggettoAuraExt();
		
		log.info(methodName, " trovati num soggetti"+list.size());
		
		
		if (list.size()<2) {
			
			for (SoggettoAuraExt soggetto : list) {
				
				Medico medico = extractMedicoFromAura(soggetto.getIdAura().toString());
				soggetto.setMedico(medico);
				result = soggetto;
				break;
			}
			
		}
		
		return result;

	}
	

	private List<SoggettoAuraExt> extractFromFindProfili(FindProfiliAnagraficiResult fp) {
		if (fp==null 
				|| fp.getHeader()==null
				|| fp.getHeader().getCodiceRitorno()==null
				|| fp.getBody()==null
				|| fp.getBody().getElencoProfili()==null
				|| !fp.getHeader().getCodiceRitorno().equals("1")
				|| (fp.getFooter()!=null 
					&& fp.getFooter().getMessages()!=null 
					&& fp.getFooter().getMessages().getMessage()!=null
					&& !fp.getFooter().getMessages().getMessage().isEmpty())
			)
		{
			return new ArrayList<SoggettoAuraExt>();
		}
		
		List<DatiAnagrafici> datis =  fp.getBody().getElencoProfili().getDatianagrafici() ;
		if (datis==null || datis.isEmpty())
		{
			return new ArrayList<SoggettoAuraExt>();
		}
		List<SoggettoAuraExt> soggetti = new ArrayList<SoggettoAuraExt>();
		for (DatiAnagrafici dati : datis) {
			SoggettoAuraExt sog = new SoggettoAuraExt();
			sog.setCodiceFiscale(dati.getCodiceFiscale());
			sog.setNome(dati.getNome());
			sog.setCognome(dati.getCognome());
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
				sog.setDataNascitaStr(sdf2.format(sdf.parse(dati.getDataNascita())));
			} catch (Exception e) {
			}
			sog.setComuneNascita(dati.getComuneNascita());
			sog.setProvinciaNascita(dati.getProvinciaNascita());
			sog.setStatoNascita(dati.getStatoNascita());
			sog.setSesso(dati.getSesso());
			if (dati.getDataDecesso()!=null && !dati.getDataDecesso().isEmpty())
			{
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
					sog.setDataDecessoStr(sdf2.format(sdf.parse(dati.getDataDecesso())));
				} catch (Exception e) {
				}
			}
			sog.setIdAura(dati.getIdProfiloAnagrafico().intValue());
			soggetti.add(sog);
		}

		
		return soggetti;
	}
	
	private Medico extractMedicoFromAura(String idAura) throws Exception {
		
		String methodName = "extractMedicoFromAura";
		log.info(methodName, "BEGIN");
		
		GetProfiloSanitarioResponse gr = AuraWsDelegate.getProfiloSanitario(idAura, auraUser, auraPwd, auraprefixUrl, auraTimeout );
		if (gr==null || gr.getGetProfiloSanitarioResult()==null 
				|| gr.getGetProfiloSanitarioResult().getHeader()==null
				|| gr.getGetProfiloSanitarioResult().getHeader().getCodiceRitorno()==null
				|| !gr.getGetProfiloSanitarioResult().getHeader().getCodiceRitorno().equals("1")
				|| gr.getGetProfiloSanitarioResult().getBody()==null
				|| gr.getGetProfiloSanitarioResult().getBody().getInfoAnag()==null
				|| gr.getGetProfiloSanitarioResult().getBody().getInfoAnag().getDatiPrimari()==null
				|| gr.getGetProfiloSanitarioResult().getBody().getInfoAnag().getDatiPrimari().getStatoProfiloAnagrafico()==null
				|| !gr.getGetProfiloSanitarioResult().getBody().getInfoAnag().getDatiPrimari().getStatoProfiloAnagrafico().equals("1")
				|| gr.getGetProfiloSanitarioResult().getBody().getInfoSan()==null
				|| (gr.getGetProfiloSanitarioResult().getFooter()!=null 
					&& gr.getGetProfiloSanitarioResult().getFooter().getMessages()!=null 
					&& gr.getGetProfiloSanitarioResult().getFooter().getMessages().getMessage()!=null
					&& !gr.getGetProfiloSanitarioResult().getFooter().getMessages().getMessage().isEmpty())
				)
		{
			return null;
		}
	
		Medico medico = null;
		SoggettoAuraBody body =  gr.getGetProfiloSanitarioResult().getBody();
		
		//if (body.getInfoSan().getIdMedico()!=null){
		if (body.getInfoSan().getCodiceFiscaleMedico() != null){
			medico = new Medico();
			medico.setCfMedico(body.getInfoSan().getCodiceFiscaleMedico());
			medico.setCodiceReg(body.getInfoSan().getCodRegionaleMedico());
			medico.setCognome(body.getInfoSan().getCognomeMedico());
			medico.setNome(body.getInfoSan().getNomeMedico());
			medico.setIdMedico(body.getInfoSan().getIdMedico().longValue());
		}
		else {
			log.info(methodName, "Soggetto con dati sanitari nulli");
		}
			
		
		return medico;
	}

}
