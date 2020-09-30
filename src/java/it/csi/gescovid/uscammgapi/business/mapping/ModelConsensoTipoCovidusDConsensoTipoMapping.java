package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDConsensoTipo;
import it.csi.gescovid.uscammgapi.dto.ModelConsensoTipo;

public class ModelConsensoTipoCovidusDConsensoTipoMapping extends BaseMapper<ModelConsensoTipo, CovidusDConsensoTipo> {

	@Override
	public CovidusDConsensoTipo to(ModelConsensoTipo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelConsensoTipo from(CovidusDConsensoTipo dest) {
		if(dest == null) {
			return null;
		}
		ModelConsensoTipo source = new ModelConsensoTipo();
		source.setId(dest.getConsTipoId().toString());
		source.setCodice(dest.getConsTipoCod());
		source.setDescrizione(dest.getConsTipoDesc());
		return source;
	}

}
