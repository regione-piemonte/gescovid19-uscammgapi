package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Area;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoArea;

public class ModelSoggettoAreaAreaMapping extends BaseMapper<ModelSoggettoArea, Area> {

	@Override
	public Area to(ModelSoggettoArea source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoArea from(Area dest) {
		if(dest == null) {
			return null;
		}
		
		ModelSoggettoArea source = new ModelSoggettoArea();
		
		source.setIdArea(dest.getIdArea()!=null ? dest.getIdArea().intValue() : 0);
		source.setIdStruttura(dest.getIdStruttura()!=null ? dest.getIdStruttura(): "" );
		source.setNome(dest.getNome() != null ? dest.getNome() : "");
		source.setStatoValidita(dest.getStatoValidita()!=null ? dest.getStatoValidita() : "");
		source.setResponsabile(dest.getResponsabile()!=null ? dest.getResponsabile() : "");
		source.setRiferimento( dest.getRiferimento() !=null ? dest.getRiferimento(): "");

		return source;
		
	}

}
