package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTConsensoFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.dto.ModelConsensoFarmaco;
import it.csi.gescovid.uscammgapi.dto.ModelDocumento;

public class ModelDocumentoCovidusTFileMapping extends BaseMapper<ModelDocumento, CovidusTFile> {

	@Override
	public CovidusTFile to(ModelDocumento source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelDocumento from(CovidusTFile dest) {
		if(dest == null) {
			return null;
		}
		ModelDocumento source = new ModelDocumento();
	
		source.setId(dest.getFileId().toString());
		source.setNome(dest.getFileName());
		source.setDimensione(dest.getFileSize().intValue());
		source.setNote(dest.getFileNote());
		source.setTipoId(dest.getFileTipoId());
		return source;
	}

}
