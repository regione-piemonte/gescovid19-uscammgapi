package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Notifica;
import it.csi.gescovid.uscammgapi.dto.ModelNotifica;

public class ModelNotificaNotifica extends BaseMapper<ModelNotifica, Notifica> {

	@Override
	public Notifica to(ModelNotifica source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelNotifica from(Notifica dest) {

		if (dest == null) {
			return null;
		}
		ModelNotifica source = new ModelNotifica();
		source.setId(dest.getNotId().toString());
		source.setDescrizione(dest.getNotTestoRequest());
		source.setCfUtenteRichiesta(dest.getCfUtenteRichiesta());
		source.setCfUtenteDestinatario(dest.getCfUtenteDest());
		source.setIdSoggetto(dest.getIdSoggetto().toString());
		source.setIdStruttura(dest.getIdStruttura());
		source.setIdEnte(dest.getIdEnte());
		source.setIdTipo(dest.getNotTipoId());
		source.setIdTipoUtente(dest.getNotUtTipoId());
		source.setIdTipoUtenteDest(dest.getNotUtTipoIdDest());
		source.setIdEvento(dest.getNotEvId());
		source.setIdAzione(dest.getNotAzId());
		source.setIdPriorita(dest.getPrioritaId());
		source.setCfUtentePresaVisione(dest.getCfUtentePresaVis());
		source.setTestoRisposta(dest.getNotTestoResponse());
		source.setData(dest.getNotDataNotifica());
		source.setDataPresaVisione(dest.getNotDataPresaVisione());
		
		
		//source.setTipoEvento(notificaEventoMapper.selectByPrimaryKey(dest.getNotEvId()).getNotEvCod());
		return source;
	}
}