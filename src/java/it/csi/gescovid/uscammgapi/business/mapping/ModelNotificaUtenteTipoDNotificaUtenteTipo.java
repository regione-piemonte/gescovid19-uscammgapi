package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaUtenteTipo;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaUtenteTipo;

public class ModelNotificaUtenteTipoDNotificaUtenteTipo
		extends BaseMapper<ModelNotificaUtenteTipo, DNotificaUtenteTipo> {

	@Override
	public DNotificaUtenteTipo to(ModelNotificaUtenteTipo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelNotificaUtenteTipo from(DNotificaUtenteTipo dest) {

		if (dest == null) {
			return null;
		}
		ModelNotificaUtenteTipo source = new ModelNotificaUtenteTipo();
		source.setId(dest.getNotUtTipoId().toString());
		source.setNome(dest.getNotUtTipoCod());
		source.setDescrizione(dest.getNotUtTipoDesc());
		return source;
	}

}
