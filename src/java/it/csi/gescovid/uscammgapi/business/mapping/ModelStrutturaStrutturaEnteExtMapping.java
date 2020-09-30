package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.StrutturaEnteExtDto;
import it.csi.gescovid.uscammgapi.dto.ModelEnte;
import it.csi.gescovid.uscammgapi.dto.ModelStruttura;

public class ModelStrutturaStrutturaEnteExtMapping extends BaseMapper<ModelStruttura, StrutturaEnteExtDto> {

	@Override
	public StrutturaEnteExtDto to(ModelStruttura source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelStruttura from(StrutturaEnteExtDto dest) {
		if(dest == null) {
			return null;
		}
		ModelStruttura source = new ModelStruttura();
		source.setId(dest.getIdStruttura());
		source.setNome(dest.getNome());
		source.setNatura(dest.getNatura());
		source.setEnte(new ModelEnteEnteMapping().from(dest.getEnte())); 
		/*if(dest.getIdEnte() != null) {
			ModelEnte ente = new ModelEnte();
			ente.setNome(dest.getNomeEnte());
			source.setEnte(ente);
		}*/
		return source;
	}

}
