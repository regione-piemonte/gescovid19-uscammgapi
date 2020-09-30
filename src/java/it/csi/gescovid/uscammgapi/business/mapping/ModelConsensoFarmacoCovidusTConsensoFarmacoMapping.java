package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTConsensoFarmaco;
import it.csi.gescovid.uscammgapi.dto.ModelConsensoFarmaco;

public class ModelConsensoFarmacoCovidusTConsensoFarmacoMapping extends BaseMapper<ModelConsensoFarmaco, CovidusTConsensoFarmaco> {

	@Override
	public CovidusTConsensoFarmaco to(ModelConsensoFarmaco source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelConsensoFarmaco from(CovidusTConsensoFarmaco dest) {
		if(dest == null) {
			return null;
		}
		ModelConsensoFarmaco source = new ModelConsensoFarmaco();
		
		source.setId(dest.getConsfarmId().toString());
		source.setData(dest.getConsfarmData());
		source.setSoggettoId(dest.getIdSoggetto().intValue());
		source.setFarmacoId(dest.getFarmId());
		source.setTipoId(dest.getConsTipoId());
		return source;
	}

}
