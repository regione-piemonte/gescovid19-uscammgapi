package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSchedaStato;
import it.csi.gescovid.uscammgapi.dto.ModelSchedaStato;

public class ModelSchedaStatoCovidusDSchedaStatoMapping extends BaseMapper<ModelSchedaStato, CovidusDSchedaStato> {

	@Override
	public CovidusDSchedaStato to(ModelSchedaStato source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSchedaStato from(CovidusDSchedaStato dest) {
		if(dest == null) {
			return null;
		}
		ModelSchedaStato source = new ModelSchedaStato();
		source.setCodice(dest.getSchStatoCod());
		source.setNome(dest.getSchStatoDesc());
		return source;
	}

}
