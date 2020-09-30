package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovidDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Notifica;
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovidDettaglio;
import it.csi.gescovid.uscammgapi.dto.ModelNotifica;

public class ModelAdiCovidDetCovidusTAdiCovidDetMapping extends BaseMapper<ModelAdiCovidDettaglio, CovidusTAdiCovidDet>{

	@Override
	public CovidusTAdiCovidDet to(ModelAdiCovidDettaglio source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAdiCovidDettaglio from(CovidusTAdiCovidDet dest) {
	

		if (dest == null) {
			return null;
		}
		
		ModelAdiCovidDettaglio source = new ModelAdiCovidDettaglio();
		source.setAdicovidDettaglioData(dest.getAdicovidDetData());
		source.setAdiCovidDettaglioId(dest.getAdicovidDetId());
		source.setAdiCovidDettaglioNote(dest.getAdicovidDetNote());
		source.setAdiCovidId(dest.getAdicovidId());
		source.setDataCreazione(dest.getDataCreazione());
		source.setDataModifica(dest.getDataModifica());
		
		return source;
		
	}

}
