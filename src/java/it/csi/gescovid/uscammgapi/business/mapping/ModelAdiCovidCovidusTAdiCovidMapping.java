package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovid;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovid;

public class ModelAdiCovidCovidusTAdiCovidMapping extends BaseMapper<ModelAdiCovid, CovidusTAdiCovid> {

	@Override
	public CovidusTAdiCovid to(ModelAdiCovid source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAdiCovid from(CovidusTAdiCovid dest) {
		if(dest == null)
			return null;
		
		ModelAdiCovid source = new ModelAdiCovid();
		source.setAdiCovidId(dest.getAdicovidId());
		source.setDataAdiCovidInizio(dest.getAdicovidDataStart());
		source.setDataAdiCovidFine(dest.getAdicovidDataEnd());
		source.setNoteAdiCovid(dest.getAdicovidNote());
		source.setDataCreazione(dest.getDataCreazione());
		source.setDataModifica(dest.getDataModifica());
		
		return source;
		
	}

}
