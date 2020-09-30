package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.extended.NotificaExt;
import it.csi.gescovid.uscammgapi.dto.ModelNotifica;
import it.csi.gescovid.uscammgapi.dto.ModelSoggetto;
import it.csi.gescovid.uscammgapi.dto.ModelUtente;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteMedico;

public class ModelNotificaNotificaExt extends BaseMapper<ModelNotifica, NotificaExt> {

	@Override
	public NotificaExt to(ModelNotifica source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelNotifica from(NotificaExt dest) {

		if (dest == null) {
			return null;
		}
		ModelNotifica source = new ModelNotifica();
		source.setId(dest.getNotId().toString());
		source.setDescrizione(dest.getNotTestoRequest());
		source.setCfUtenteRichiesta(dest.getCfUtenteRichiesta());
		source.setCfUtenteDestinatario(dest.getCfUtenteDest());
		
		// aggiungo i contatti del medico
		if (dest.getCfUtenteRichiesta() != null) {

			if(dest.getUtenteContatto() !=null) {
				ModelUtente utenteRitorno = new ModelUtente();
				utenteRitorno.setCfUtente(dest.getUtenteContatto().getCfUtente());
				utenteRitorno.setNome(dest.getUtenteContatto().getNome());
				utenteRitorno.setCognome(dest.getUtenteContatto().getCognome());
				utenteRitorno.setEmail(dest.getUtenteContatto().getEmail());
				utenteRitorno.setTelefono(dest.getUtenteContatto().getTelefono());

				source.setMedico(utenteRitorno);
			}
		}
		
		if(dest.getMedico()!=null) {
			ModelUtenteMedico medicoTitolato = new ModelUtenteMedico();
			medicoTitolato.setIdMedico(dest.getMedico().getIdMedico()!=null ? dest.getMedico().getIdMedico().intValue(): null);
			medicoTitolato.setCfMedico(dest.getMedico().getCfMedico()!=null ? dest.getMedico().getCfMedico(): null);
			medicoTitolato.setCodiceReg(dest.getMedico().getCodiceReg()!=null ? dest.getMedico().getCodiceReg(): null);
			medicoTitolato.setCognome(dest.getMedico().getCognome()!=null ? dest.getMedico().getCognome(): null);
			medicoTitolato.setNome(dest.getMedico().getNome()!=null ? dest.getMedico().getNome() : null);
			
			source.setMedicoTitolato(medicoTitolato);
		}
		
		if (dest.getSoggetto() != null) {
			
			source.setIdSoggetto(dest.getIdSoggetto().toString());
			
			ModelSoggetto soggettoRitorno = new ModelSoggetto();
			soggettoRitorno.setIdSoggetto(dest.getIdSoggetto());
			soggettoRitorno.setCodiceFiscale(dest.getSoggetto().getCodiceFiscale()!=null ? dest.getSoggetto().getCodiceFiscale() : "");
			soggettoRitorno.setNome(dest.getSoggetto().getNome() !=null ? dest.getSoggetto().getNome() : "");
			soggettoRitorno.setCognome(dest.getSoggetto().getCognome()!=null ? dest.getSoggetto().getCognome() : "");

			source.setSoggetto(soggettoRitorno);
		}
		
		source.setIdStruttura(dest.getIdStruttura());
		source.setIdEnte(dest.getIdEnte());
		
		
		if (dest.getdNotificaTipo() != null) {
			
			source.setIdTipo(dest.getdNotificaTipo().getNotTipoId());
			source.setCodTipo(dest.getdNotificaTipo().getNotTipoCod());
			source.setDescrTipo(dest.getdNotificaTipo().getNotTipoDesc());
		}
		
		if (dest.getdNotificaEvento() != null) {			
			source.setIdEvento(dest.getdNotificaEvento().getNotEvId());
			source.setTipoEvento(dest.getdNotificaEvento().getNotEvCod());
			source.setTipoDescEvento(dest.getdNotificaEvento().getNotEvDesc());
		}
		
				
		if (dest.getdNotificaUtenteTipo() != null) {
			source.setIdTipoUtente(dest.getdNotificaUtenteTipo().getNotUtTipoId());
			source.setCodTipoUtente(dest.getdNotificaUtenteTipo().getNotUtTipoCod());
			source.setDescrTipoUtente(dest.getdNotificaUtenteTipo().getNotUtTipoDesc());
		}
				
		if (dest.getdNotificaUtenteTipoDest() != null) {
			source.setIdTipoUtenteDest(dest.getdNotificaUtenteTipoDest().getNotUtTipoId());
			source.setCodTipoUtenteDest(dest.getdNotificaUtenteTipoDest().getNotUtTipoCod());
			source.setDescrTipoUtenteDest(dest.getdNotificaUtenteTipoDest().getNotUtTipoDesc());
		}
		
		
		if (dest.getdNotificaAzione() != null) {
			source.setIdAzione(dest.getdNotificaAzione().getNotAzId());			
			source.setCodAzione(dest.getdNotificaAzione().getNotAzCod());
			source.setDescrAzione(dest.getdNotificaAzione().getNotAzDesc());
		}
		
		if (dest.getdNotificaPriorita() != null) {
			source.setIdPriorita(dest.getdNotificaPriorita().getPrioritaId());
			source.setCodPriorita(dest.getdNotificaPriorita().getPrioritaCod());
			source.setDescrPriorita(dest.getdNotificaPriorita().getPrioritaDesc());
		}
		
		source.setCfUtentePresaVisione(dest.getCfUtentePresaVis());
		source.setTestoRisposta(dest.getNotTestoResponse());
		source.setData(dest.getNotDataNotifica());
		source.setDataPresaVisione(dest.getNotDataPresaVisione());
		
		
		return source;
	}
}