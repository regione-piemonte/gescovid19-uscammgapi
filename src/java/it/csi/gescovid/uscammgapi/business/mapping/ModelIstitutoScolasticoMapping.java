package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.IstitutoScolastico;
import it.csi.gescovid.uscammgapi.dto.ModelDocumento;
import it.csi.gescovid.uscammgapi.dto.ModelIstitutoScolastico;

public class ModelIstitutoScolasticoMapping extends BaseMapper<ModelIstitutoScolastico, IstitutoScolastico> {

	@Override
	public IstitutoScolastico to(ModelIstitutoScolastico source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelIstitutoScolastico from(IstitutoScolastico dest) {
		if(dest == null) {
			return null;
		}
		ModelIstitutoScolastico source = new ModelIstitutoScolastico();
	
		source.setIdIstituto(dest.getIdIstituto());
		source.setCodiceIstituto(dest.getCodiceIstituto());
		source.setDenominazioneIstituto(dest.getDenominazioneIstituto());
		source.setIndirizzoIstituto(dest.getIndirizzoIstituto());
		source.setComuneIstituto(dest.getComuneIstituto());
		source.setProvinciaIstituto(dest.getProvinciaIstituto());
		source.setTelIstituto(dest.getTelIstituto());
		source.setOrdineIstituto(dest.getOrdineIstituto());
		return source;
	}

}
