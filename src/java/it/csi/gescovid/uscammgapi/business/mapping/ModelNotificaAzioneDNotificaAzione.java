package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaAzione;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaAzione;

public class ModelNotificaAzioneDNotificaAzione extends BaseMapper<ModelNotificaAzione, DNotificaAzione> {

	@Override
	public DNotificaAzione to(ModelNotificaAzione source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelNotificaAzione from(DNotificaAzione dest) {

		if (dest == null) {
			return null;
		}
		ModelNotificaAzione source = new ModelNotificaAzione();
		source.setId(dest.getNotAzId().toString());
		source.setNome(dest.getNotAzCod());
		source.setDescrizione(dest.getNotAzDesc());
		return source;
	}
}
