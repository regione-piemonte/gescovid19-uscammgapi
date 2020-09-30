package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDOssigenoTerapia;
import it.csi.gescovid.uscammgapi.dto.ModelOssigenoterapia;

public class ModelOssigenoterapiaCovidusDOssigenoTerapiaMapping extends BaseMapper<ModelOssigenoterapia, CovidusDOssigenoTerapia> {

	@Override
	public CovidusDOssigenoTerapia to(ModelOssigenoterapia source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelOssigenoterapia from(CovidusDOssigenoTerapia dest) {
		if(dest == null) {
			return null;
		}
		ModelOssigenoterapia source = new ModelOssigenoterapia();
		source.setId(dest.getOssId().toString());
		source.setNome(dest.getOssNome());
		source.setDescrizione(dest.getOssDesc());
		//source.setConsensoNecessario(dest.get);
		return source;
	}

}
