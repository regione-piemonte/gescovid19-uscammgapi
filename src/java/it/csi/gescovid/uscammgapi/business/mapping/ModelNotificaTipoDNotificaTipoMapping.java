package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaTipo;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaTipo;

public class ModelNotificaTipoDNotificaTipoMapping extends BaseMapper<ModelNotificaTipo, DNotificaTipo>{

	@Override
	public DNotificaTipo to(ModelNotificaTipo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelNotificaTipo from(DNotificaTipo dest) {
		if(dest == null) {
			return null;
		}
		ModelNotificaTipo source = new ModelNotificaTipo();
		source.setId(dest.getNotTipoId().toString());
		source.setNome(dest.getNotTipoCod());
		source.setDescrizione(dest.getNotTipoDesc());
		return source;
	}

}
