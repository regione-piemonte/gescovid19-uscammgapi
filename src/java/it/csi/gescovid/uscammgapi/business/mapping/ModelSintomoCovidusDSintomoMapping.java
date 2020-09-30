package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.SintomoExtDto;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioSintomo;

public class ModelSintomoCovidusDSintomoMapping extends BaseMapper<ModelDiarioDettaglioSintomo, SintomoExtDto> {

	@Override
	public SintomoExtDto to(ModelDiarioDettaglioSintomo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelDiarioDettaglioSintomo from(SintomoExtDto dest) {
		if(dest == null) {
			return null;
		}
		ModelDiarioDettaglioSintomo source = new ModelDiarioDettaglioSintomo();
		source.setCodice(dest.getSinCod());
		source.setId(dest.getSinId());
		source.setNome(dest.getSinDesc());
		//source.setMisurabile(misurabile); FIXME - da aggiungere
		//source.setUnitaMisura(unitaMisura); FIXME - da aggiungere
		//source.setNote(note); FIXME - da aggiungere
		//source.setValore(valore); FIXME - da aggiungere
		return source;
	}

}
