package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.DiarioDetExtDto;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglio;

public class ModelDiarioDettaglioDiarioDetExtDtoMapping extends BaseMapper<ModelDiarioDettaglio, DiarioDetExtDto> {

	@Override
	public DiarioDetExtDto to(ModelDiarioDettaglio source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelDiarioDettaglio from(DiarioDetExtDto dest) {
		if(dest == null) {
			return null;
		}
		ModelDiarioDettaglio source = new ModelDiarioDettaglio();
		source.setData(dest.getDiadetData());
		source.setDataCreazione(dest.getDataCreazione());
		source.setDataModifica(dest.getDataModifica());
		source.setDiarioId(dest.getDiaId());
		source.setId(dest.getDiadetId());
		source.setInterventoId(dest.getIntId());
		source.setNote(dest.getDiadetNote());
		if(dest.getUtenteContatto() != null) {
			source.setAutore(new ModelDettagioAutoreUtenteContattoMapping().from(dest.getUtenteContatto()));
		}
		return source;
	}

}
