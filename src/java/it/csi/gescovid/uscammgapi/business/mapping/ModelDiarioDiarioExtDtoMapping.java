package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.DiarioExtDto;
import it.csi.gescovid.uscammgapi.dto.ModelDiario;

public class ModelDiarioDiarioExtDtoMapping extends BaseMapper<ModelDiario, DiarioExtDto> {

	@Override
	public DiarioExtDto to(ModelDiario source) {
		return null;
	}

	@Override
	public ModelDiario from(DiarioExtDto dest) {
		if(dest == null) {
			return null;
		}
		ModelDiario source = new ModelDiario();
		source.setId(dest.getDiaId());
		source.setDataCreazione(dest.getDataCreazione());
		
		return source;
	}

}
