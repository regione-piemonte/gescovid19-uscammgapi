package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDFarmaco;
import it.csi.gescovid.uscammgapi.dto.ModelFarmaco;

public class ModelFarmacoCovidusDFarmacoMapping extends BaseMapper<ModelFarmaco, CovidusDFarmaco> {

	@Override
	public CovidusDFarmaco to(ModelFarmaco source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelFarmaco from(CovidusDFarmaco dest) {
		if(dest == null) {
			return null;
		}
		ModelFarmaco source = new ModelFarmaco();
		source.setId(dest.getFarmId().toString());
		source.setNome(dest.getFarmNome());
		source.setDescrizione(dest.getFarmDesc()!=null ? dest.getFarmDesc(): "" );
		source.setConsensoNecessario(dest.getFarmConsensoNecessario());
		source.setPrescrizioneTipoId(dest.getPrescTipoId()!=null ? dest.getPrescTipoId() :0);
		
		return source;
	}

}
