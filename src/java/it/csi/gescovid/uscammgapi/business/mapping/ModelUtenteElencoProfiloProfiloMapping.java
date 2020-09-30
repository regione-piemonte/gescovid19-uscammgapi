package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.uscammgapi.dto.ModelProfilo;

public class ModelUtenteElencoProfiloProfiloMapping extends BaseMapper<ModelProfilo, Profilo> {

	@Override
	public Profilo to(ModelProfilo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelProfilo from(Profilo dest) {
		if(dest == null) {
			return null;
		}
		
		ModelProfilo source = new ModelProfilo();
		source.setIdProfilo(dest.getIdProfilo()!=null ? dest.getIdProfilo(): 0);
		source.setNomeProfilo(dest.getNomeProfilo()!=null ? dest.getNomeProfilo() : "");
		
		return source;
	}

}
