package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioAutore;

public class ModelDettagioAutoreUtenteContattoMapping extends BaseMapper<ModelDiarioDettaglioAutore, UtenteContatto> {

	@Override
	public UtenteContatto to(ModelDiarioDettaglioAutore source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelDiarioDettaglioAutore from(UtenteContatto dest) {
		if(dest == null) {
			return null;
		}
		ModelDiarioDettaglioAutore source = new ModelDiarioDettaglioAutore();
		source.setCodiceFiscale(dest.getCfUtente());
		source.setCognome(dest.getCognome());
		source.setMail(dest.getEmail());
		source.setNome(dest.getNome());
		source.setTelefono(dest.getTelefono());
		return source;
	}

}
