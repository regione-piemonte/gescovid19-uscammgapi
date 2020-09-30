package it.csi.gescovid.uscammgapi.business.be.impl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.impl.RESTBaseService;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Area;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Struttura;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UserLogged;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.MedicoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.ProfiloMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SindacoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.UtenteAreaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.UtenteEnteMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.UtenteStrutturaMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.UtentiMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelUtenteElencoProfiloProfiloMapping;
import it.csi.gescovid.uscammgapi.dto.ModelProfilo;
import it.csi.gescovid.uscammgapi.dto.ModelUtente;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteElencoArea;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteElencoStruttura;
import it.csi.gescovid.uscammgapi.util.LogUtil;


public class CurrentUserService extends RESTBaseService{
	
	/**
	 * Qui c'e la chiamata ai mapper
	 * 
	 * 
	 */
	LogUtil log = new LogUtil(CurrentUserService.class);
	
	@Autowired
	UtentiMapper utentiMapper;

	@Autowired
	UtenteStrutturaMapper utenteStrutturaMapper;

	
	protected ModelUtente loadUser(String  codiceFiscale) {
		
		ModelUtente utente = new ModelUtente();
		// qui ho info utente
		UserLogged userLogged = utentiMapper.selectInfoUtenteLoggedByCf(codiceFiscale);
		
		if(userLogged == null ) {
			return null;
		}
		
		List<Profilo> elencoProfiliDB = utentiMapper.selectElencoProfili(codiceFiscale);
		
		if(elencoProfiliDB!=null) {
			List<ModelProfilo> profili = new ModelUtenteElencoProfiloProfiloMapping().fromList(elencoProfiliDB);
			utente.setElencoProfili(profili);
		}
		
		
		utente.setCfUtente(userLogged.getCfUtente());
		utente.setNome(userLogged.getNome()!=null ? userLogged.getNome() :"");
		utente.setCognome(userLogged.getCognome() !=null ? userLogged.getCognome() : "");
		utente.setEmail(userLogged.getEmail() !=null ? userLogged.getEmail() : "");
		utente.setTelefono(userLogged.getTelefono() != null ? userLogged.getTelefono() : "");
				
		List<Struttura> elencoStrutture = utenteStrutturaMapper.selectElencoStrutturaByCodiceFiscale(codiceFiscale) ;
		
		List<ModelUtenteElencoStruttura> strutture= new ArrayList<ModelUtenteElencoStruttura>();
		
		if(elencoStrutture !=null && !elencoStrutture.isEmpty()) {
			
			for (Struttura struttura: elencoStrutture) {
				
				ModelUtenteElencoStruttura mstruttura = new ModelUtenteElencoStruttura();
				mstruttura.setIdStruttura(struttura.getIdStruttura()!=null ?struttura.getIdStruttura(): "" );
				mstruttura.setIdEnte(struttura.getIdEnte()!=null ? struttura.getIdEnte():0);
				mstruttura.setNome(struttura.getNome()!=null ?struttura.getNome(): "" );
				mstruttura.setNatura(struttura.getNatura()!=null ?struttura.getNatura(): "" );
				strutture.add(mstruttura);
			}
		}
		utente.setElencoStruttura(strutture);

		return utente;
		
	}

	
}
