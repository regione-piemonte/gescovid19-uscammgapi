package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DecodeTipoEvento;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoDecodeTipoEvento;

public class ModelSoggettoDecodeTipoEventoDecodeTipoEventoMapping extends BaseMapper<ModelSoggettoDecodeTipoEvento, DecodeTipoEvento> {

	@Override
	public DecodeTipoEvento to(ModelSoggettoDecodeTipoEvento source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoDecodeTipoEvento from(DecodeTipoEvento dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoDecodeTipoEvento source = new ModelSoggettoDecodeTipoEvento();
		source.setIdTipoEvento(dest.getIdTipoEvento()!=null ? dest.getIdTipoEvento(): 0);
		source.setDescTipoEvento(dest.getDescTipoEvento() !=null ? dest.getDescTipoEvento() : "");
		source.setSegno(dest.getSegno() !=null ? dest.getSegno() : "" );
		return source;
		
	}

}
