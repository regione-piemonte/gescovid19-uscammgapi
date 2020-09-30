package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Struttura;

import it.csi.gescovid.uscammgapi.dto.ModelUtenteElencoStruttura;

public class ModelUtenteElencoStrutturaStrutturaMapping extends BaseMapper<ModelUtenteElencoStruttura, Struttura> {

	@Override
	public Struttura to(ModelUtenteElencoStruttura source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelUtenteElencoStruttura from(Struttura dest) {
		if(dest == null) {
			return null;
		}
		
		ModelUtenteElencoStruttura source = new ModelUtenteElencoStruttura();
		source.setIdStruttura(dest.getIdStruttura()!=null ? dest.getIdStruttura(): "");
		source.setNome(dest.getNome()!=null ? dest.getNome() : "");
		source.setNatura(dest.getNatura()!=null ? dest.getNatura(): "");
		source.setIdEnte(dest.getIdEnte()!=null ? dest.getIdEnte(): 0);

		return source;
	}

}
