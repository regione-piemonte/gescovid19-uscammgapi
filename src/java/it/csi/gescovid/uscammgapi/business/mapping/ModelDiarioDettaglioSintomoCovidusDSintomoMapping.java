package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioSintomo;

public class ModelDiarioDettaglioSintomoCovidusDSintomoMapping extends BaseMapper<ModelDiarioDettaglioSintomo, CovidusDSintomo> {

	@Override
	public CovidusDSintomo to(ModelDiarioDettaglioSintomo source) {
		return null;
	}

	@Override
	public ModelDiarioDettaglioSintomo from(CovidusDSintomo dest) {
		if(dest == null) {
			return null;
		}
		ModelDiarioDettaglioSintomo source = new ModelDiarioDettaglioSintomo();
		source.setId(dest.getSinId());
		source.setCodice(dest.getSinCod());
		source.setNome(dest.getSinDesc());
		source.setMisurabile(dest.getSinMisurabile());
		source.setUnitaMisura(dest.getSinUnitaMisura());
		return source;
	}

}
