package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.uscammgapi.dto.ModelEnte;

public class ModelEnteEnteMapping extends BaseMapper<ModelEnte, Ente> {

	@Override
	public Ente to(ModelEnte source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelEnte from(Ente dest) {
		if(dest == null) {
			return null;
		}
		ModelEnte source = new ModelEnte();
		source.setId(dest.getIdEnte());
		source.setNome(dest.getNome());
		return source;
		
	}

}
