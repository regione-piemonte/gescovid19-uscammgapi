package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDMonitoraggioTipo;
import it.csi.gescovid.uscammgapi.dto.ModelMonitoraggioTipo;

public class ModelMonitoraggioTipiCovidusDMonitoraggioTipiMapping extends BaseMapper<ModelMonitoraggioTipo, CovidusDMonitoraggioTipo> {

	@Override
	public CovidusDMonitoraggioTipo to(ModelMonitoraggioTipo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelMonitoraggioTipo from(CovidusDMonitoraggioTipo dest) {

		if (dest == null) {
			return null;
		}
		ModelMonitoraggioTipo source = new ModelMonitoraggioTipo();
		source.setId(dest.getMonitoraggioTipoId().toString());
		source.setCodice(dest.getMonitoraggioTipoCod());
		source.setDescrizione(dest.getMonitoraggioTipoDesc());
		return source;
	}
}
