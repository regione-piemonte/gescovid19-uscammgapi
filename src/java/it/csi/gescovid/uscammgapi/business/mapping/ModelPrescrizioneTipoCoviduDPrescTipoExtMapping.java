package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDPrescTipo;
import it.csi.gescovid.uscammgapi.dto.ModelPrescrizioneTipo;

public class ModelPrescrizioneTipoCoviduDPrescTipoExtMapping extends BaseMapper<ModelPrescrizioneTipo, CovidusDPrescTipo> {

	@Override
	public CovidusDPrescTipo to(ModelPrescrizioneTipo source) {
		return null;
	}

	@Override
	public ModelPrescrizioneTipo from(CovidusDPrescTipo dest) {
		if(dest == null) {
			return null;
		}
		ModelPrescrizioneTipo source = new ModelPrescrizioneTipo();
		source.setId(dest.getPrescTipoId().toString());
		source.setCodice(dest.getPrescTipoCod());
		source.setNome(dest.getPrescTipoDesc());
		return source;
	}

}
