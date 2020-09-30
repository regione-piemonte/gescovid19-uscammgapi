package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoMedico;

public class ModelSoggettoMedicoMedicoMapping extends BaseMapper<ModelSoggettoMedico, Medico> {

	@Override
	public Medico to(ModelSoggettoMedico source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoMedico from(Medico dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoMedico source = new ModelSoggettoMedico();
		source.setCfMedico(dest.getCfMedico() != null ? dest.getCfMedico(): "");
		source.setNome(dest.getNome() !=null ? dest.getNome(): "");
		source.setNome(dest.getCognome() !=null ? dest.getCognome(): "");
		source.setCodiceReg(dest.getCodiceReg() !=null ? dest.getCodiceReg(): "");
		
		return source;
		
	}

}
