package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaPriorita;
import it.csi.gescovid.uscammgapi.dto.ModelNotificaPriorita;

public class ModelNotificaPrioritaDNotificaPriorita extends BaseMapper<ModelNotificaPriorita, DNotificaPriorita> {

	@Override
	public DNotificaPriorita to(ModelNotificaPriorita source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelNotificaPriorita from(DNotificaPriorita dest) {

		if (dest == null) {
			return null;
		}
		ModelNotificaPriorita source = new ModelNotificaPriorita();
		source.setId(dest.getPrioritaId().toString());
		source.setNome(dest.getPrioritaCod());
		source.setDescrizione(dest.getPrioritaDesc());
		return source;
	}
}