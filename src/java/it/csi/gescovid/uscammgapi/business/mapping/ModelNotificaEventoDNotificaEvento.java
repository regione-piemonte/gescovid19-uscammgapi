package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaEvento;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaEvento;

public class ModelNotificaEventoDNotificaEvento extends BaseMapper<ModelNotificaEvento, DNotificaEvento> {

	@Override
	public DNotificaEvento to(ModelNotificaEvento source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelNotificaEvento from(DNotificaEvento dest) {

		if (dest == null) {
			return null;
		}
		ModelNotificaEvento source = new ModelNotificaEvento();
		source.setId(dest.getNotEvId().toString());
		source.setNome(dest.getNotEvCod());
		source.setDescrizione(dest.getNotEvDesc());
		return source;
	}
}