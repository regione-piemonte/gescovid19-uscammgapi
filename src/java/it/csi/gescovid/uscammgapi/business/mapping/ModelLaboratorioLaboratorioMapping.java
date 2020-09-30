package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Laboratorio;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoLaboratorio;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteLaboratorio;

public class ModelLaboratorioLaboratorioMapping extends BaseMapper<ModelSoggettoLaboratorio, Laboratorio> {

	@Override
	public Laboratorio to(ModelSoggettoLaboratorio source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoLaboratorio from(Laboratorio dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoLaboratorio source = new ModelSoggettoLaboratorio();
		source.setIdLaboratorio(dest.getIdLaboratorio()!=null ? dest.getIdLaboratorio().intValue() : 0);
		source.setDescrizione(dest.getDescrizione()!=null ? dest.getDescrizione(): "" );
		source.setSiglaLaboratorio(dest.getSiglaLaboratorio() != null ? dest.getSiglaLaboratorio() : "");
		source.setCapacitaGiornaliera(dest.getCapacitaGiornaliera()!=null ? dest.getCapacitaGiornaliera() : 0);
		

		return source;
		
	}

}
